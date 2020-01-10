package com.troy.trade.api.model.dto.out.exchange;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * USDT转CNY实体
 */
@Setter
@Getter
public class UsdtToCnyResDto extends ResData {

    private BigDecimal usdtToCny;

    public UsdtToCnyResDto() {
        super();
    }

    public UsdtToCnyResDto(BigDecimal usdtToCny) {
        this.usdtToCny = usdtToCny;
    }

    public static UsdtToCnyResDto getInstance(BigDecimal usdtToCny){
        return new UsdtToCnyResDto(usdtToCny);
    }
}
