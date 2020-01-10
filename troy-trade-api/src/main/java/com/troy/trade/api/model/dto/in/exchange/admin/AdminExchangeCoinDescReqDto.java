package com.troy.trade.api.model.dto.in.exchange.admin;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 币种描述修改字段返回
 *
 * @author yanping
 */
@Setter
@Getter
public class AdminExchangeCoinDescReqDto extends ReqData {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String exchangeCoinId;

    /**
     * 中文描述
     */
    private String chinese;

    /**
     * 英文描述
     */
    private String english;

    /**
     * 充币中文描述
     */
    private String depositChinese;

    /**
     * 充币英文描述
     */
    private String depositEnglish;

    /**
     * 转币中文描述
     */
    private String turnChinese;

    /**
     * 转币英文描述
     */
    private String turnEnglish;


    /**
     * 最后操作时间
     */
    private Date updateTime;

    /**
     * 最后操作人
     */
    private String updateBy;

    /**
     * 最后修改人IP
     */
    private String lastUpdateFromIp;

    public AdminExchangeCoinDescReqDto() {
        super();
    }

    public AdminExchangeCoinDescReqDto(String exchangeCoinId, String chinese, String english,
                                       Date updateTime, String updateBy, String lastUpdateFromIp,
                                       String depositChinese, String depositEnglish,
                                       String turnChinese, String turnEnglish) {
        this.exchangeCoinId = exchangeCoinId;
        this.chinese = chinese;
        this.english = english;
        this.updateTime = updateTime;
        this.updateBy = updateBy;
        this.lastUpdateFromIp = lastUpdateFromIp;
        this.depositChinese = depositChinese;
        this.depositEnglish = depositEnglish;
        this.turnChinese = turnChinese;
        this.turnEnglish = turnEnglish;
    }

    public static AdminExchangeCoinDescReqDto getInstance(String exchangeCoinId, String chinese, String english,
                                                          Date updateTime, String updateBy, String lastUpdateFromIp,
                                                          String depositChinese, String depositEnglish,
                                                          String turnChinese, String turnEnglish){
        AdminExchangeCoinDescReqDto exchangeCoinModel = new AdminExchangeCoinDescReqDto( exchangeCoinId, chinese, english,
                updateTime, updateBy, lastUpdateFromIp, depositChinese, depositEnglish, turnChinese, turnEnglish);
        return exchangeCoinModel;
    }

}
