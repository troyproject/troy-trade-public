package com.troy.trade.util;

import java.math.BigDecimal;

/**
 * BigDecimal工具类
 *
 * @author dp
 */
public class BigDecimalUtil {

    /**
     * 校验BigDecimal正负 （null以及正数返回成功）
     *
     * @param bigDecimal
     * @return
     */
    public static boolean isPositive(BigDecimal bigDecimal) {
        if (bigDecimal != null) {
            return bigDecimal.signum() == 1;
        }
        return true;
    }
}
