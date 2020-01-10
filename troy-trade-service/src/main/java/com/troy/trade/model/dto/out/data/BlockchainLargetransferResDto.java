package com.troy.trade.model.dto.out.data;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

/**
 * 脸上转账返回实体DTO
 *
 * @author yanping
 */
@Getter
@Setter
public class BlockchainLargetransferResDto extends ResData {

    /**
     * 币种名称
     */
    private String coin;

    /**
     * 币种数量
     */
    private String amount;

    /**
     * 转账发起方
     */
    private String fromSource;

    /**
     * 大额转移从地址
     */
    private String fromAddress;

    /**
     * 转账接收方
     */
    private String toSource;

    /**
     * 大额转移到地址
     */
    private String toAddress;

    /**
     * 转账时间
     */
    private String blockTime;
}
