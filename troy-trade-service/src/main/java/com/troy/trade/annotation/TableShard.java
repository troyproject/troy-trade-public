package com.troy.trade.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * MyBatis分表Annotation
 *
 * @author zhangchengjie
 * @data 2019/8/23
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Deprecated
public @interface TableShard {
    // 表名
    String tableName() default "" ;

    // 分表方式
    String shardType() default "";

    // 分表依据
    String shardBy() default "";
}
