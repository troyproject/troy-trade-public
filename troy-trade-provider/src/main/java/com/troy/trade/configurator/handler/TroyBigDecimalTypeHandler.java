package com.troy.trade.configurator.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.BigDecimalTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * bigdecimal去掉末尾0的处理器
 *
 * @author dp
 */
@Slf4j
@MappedTypes(BigDecimal.class)
public class TroyBigDecimalTypeHandler extends BigDecimalTypeHandler {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, BigDecimal parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setBigDecimal(i, parameter.stripTrailingZeros());
    }

    @Override
    public BigDecimal getNullableResult(ResultSet rs, String columnName) throws SQLException {
        BigDecimal bigDecimal = rs.getBigDecimal(columnName);
        if (bigDecimal != null) {
            return bigDecimal.stripTrailingZeros();
        } else {
            return null;
        }
    }

    @Override
    public BigDecimal getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        BigDecimal bigDecimal = rs.getBigDecimal(columnIndex);
        if (bigDecimal != null) {
            return bigDecimal.stripTrailingZeros();
        } else {
            return null;
        }
    }

    @Override
    public BigDecimal getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        BigDecimal bigDecimal = cs.getBigDecimal(columnIndex);
        if (bigDecimal != null) {
            return bigDecimal.stripTrailingZeros();
        } else {
            return null;
        }
    }
}
