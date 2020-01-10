package com.troy.trade.configurator.interceptor;

import com.troy.trade.annotation.TableShard;
import com.troy.trade.configurator.TableShardConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.Properties;

/**
 * MyBatis分表拦截器
 *
 * @author zhangchengjie
 * @date 2019/08/23
 */
@Slf4j
//@Intercepts({@Signature(type = StatementHandler.class,
//        method = "prepare",
//        args = {Connection.class, Integer.class})})
@Deprecated
public class ShardTableInterceptor implements Interceptor {

    private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
    private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();

    @Value("${troy.db.share.accountCoin.tableNumber}")
    private Integer accountCoinTableNumber;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaStatementHandler = MetaObject.forObject(statementHandler,
                DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY, new DefaultReflectorFactory());

        MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
        String className = mappedStatement.getId().substring(0, mappedStatement.getId().lastIndexOf("."));
        TableShard tableShard = Class.forName(className).getAnnotation(TableShard.class);
        if (null == tableShard) {
            // this mapper there is not TableShard annotation, so proceed
            return invocation.proceed();
        }

        Object parameterObject = metaStatementHandler.getValue("delegate.boundSql.parameterObject");
        // shard table
        this.doShardTable(metaStatementHandler, parameterObject, tableShard);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {
    }

    private void doShardTable(MetaObject metaStatementHandler, Object param, TableShard tableShard) {
        MapperMethod.ParamMap paramMap = (MapperMethod.ParamMap) param;
        String originalSql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
        if (StringUtils.isNotEmpty(originalSql)) {
            log.info("before shard {} table SQL: \n{}", tableShard.tableName(), originalSql);

            String convertedSql = originalSql.replaceAll(tableShard.tableName(),
                    this.getShardTableName(paramMap, tableShard));
            metaStatementHandler.setValue("delegate.boundSql.sql", convertedSql);

            log.info("after shard {} table SQL: \n{}", tableShard.tableName(), convertedSql);
        }
    }

    private String getShardTableName(MapperMethod.ParamMap paramMap, TableShard tableShard) {
        String shardType = tableShard.shardType();
        if (StringUtils.isEmpty(shardType) || StringUtils.isEmpty(tableShard.shardBy())) {
            return tableShard.tableName();
        }

        Object shardByObject = paramMap.get(tableShard.shardBy());
        if (shardByObject == null) {
            return tableShard.tableName();
        }

        if (shardType.equals(TableShardConstant.AccountCoin.SHARD_TYPE)) {
            // shard account_coin table
            Long shardIndex = ((Long) shardByObject) % accountCoinTableNumber;
            return tableShard.tableName().concat("_").concat(shardIndex.toString());
        }

        return tableShard.tableName();
    }

}
