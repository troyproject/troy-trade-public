package com.troy.trade.model.dto.in.exchange;

import com.troy.commons.dto.in.ReqData;
import com.troy.commons.exchange.model.constant.ExchangeCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 充提记录实体
 */
@Setter
@Getter
public class ExchAcctDeptWdralReqDto extends ReqData {

    private ExchangeCode exchCode;//交易所code，必填

    private Long exchAcctId;//交易所账户ID，必填

    private String coinName;//要查询的币种名称，必填

    private String txId;//提币哈希记录，非必填，如果此字段不为空先根据此字段查找

    private Long applyTime;//申请时间，必填

    private Integer deptWdralType;//充提类型，1-充值、2-提现，必填

    private String id;//要查询的交易所提现ID或充值ID，非必填，如果txid为空，此字段不为空则根据此Id查找。如果txid和id都为空则返回查询结果中的第一条

    public ExchAcctDeptWdralReqDto() {
        super();
    }

    public ExchAcctDeptWdralReqDto(ExchangeCode exchCode, Long exchAcctId, String coinName,
                                   String txId, Long applyTime, Integer deptWdralType) {
        this.exchCode = exchCode;
        this.exchAcctId = exchAcctId;
        this.coinName = coinName;
        this.txId = txId;
        this.applyTime = applyTime;
        this.deptWdralType = deptWdralType;
    }

    public ExchAcctDeptWdralReqDto(ExchangeCode exchCode, Long exchAcctId, String coinName,
                                   Long applyTime, Integer deptWdralType, String id) {
        this.exchCode = exchCode;
        this.exchAcctId = exchAcctId;
        this.coinName = coinName;
        this.applyTime = applyTime;
        this.deptWdralType = deptWdralType;
        this.id = id;
    }

    public static ExchAcctDeptWdralReqDto getInstance(ExchangeCode exchCode, Long exchAcctId, String coinName,
                                                      String txId, Long applyTime, Integer deptWdralType) {
        ExchAcctDeptWdralReqDto exchAcctDeptWdralResDto = new ExchAcctDeptWdralReqDto( exchCode, exchAcctId, coinName,
                txId, applyTime, deptWdralType);
        return exchAcctDeptWdralResDto;
    }

    public static ExchAcctDeptWdralReqDto getIdInstance(ExchangeCode exchCode, Long exchAcctId, String coinName,
                                                        Long applyTime, Integer deptWdralType, String id) {
        ExchAcctDeptWdralReqDto exchAcctDeptWdralResDto = new ExchAcctDeptWdralReqDto( exchCode, exchAcctId, coinName,
                applyTime, deptWdralType, id);
        return exchAcctDeptWdralResDto;
    }

}
