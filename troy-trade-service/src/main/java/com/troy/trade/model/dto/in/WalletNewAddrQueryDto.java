package com.troy.trade.model.dto.in;

import com.troy.trade.model.domain.account.AccountCoinModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhangchengjie
 * @date 2019/09/05
 */
@Setter
@Getter
public class WalletNewAddrQueryDto implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 币种名称
     */
    private String coinName;

    /**
     * 业务标识码,
     * 关联{@link AccountCoinModel#accountCoinId}和{@link AccountCoinModel#addr}
     */
    private String unid;

    /**
     * 业务名称,
     * 关联{@link AccountCoinModel#accountId}和{@link AccountCoinModel#addr}
     */
    private String bname;

}
