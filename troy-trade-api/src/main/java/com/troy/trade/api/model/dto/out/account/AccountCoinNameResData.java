package com.troy.trade.api.model.dto.out.account;

import com.troy.commons.dto.out.ResData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 财务记录
 *
 * @author zhangchengjie
 * @date 2019/08/26
 */
@Setter
@Getter
public class AccountCoinNameResData extends ResData {
     String accountCoinName;
     String exchCode;

     public AccountCoinNameResData(){}
     public AccountCoinNameResData(String accountCoinName,
             String exchCode){
          this.accountCoinName =accountCoinName;
          this.exchCode=exchCode;
     }
}

