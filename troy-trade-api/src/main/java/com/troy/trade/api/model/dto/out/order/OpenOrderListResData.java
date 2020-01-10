package com.troy.trade.api.model.dto.out.order;

import com.troy.commons.dto.out.ResData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Han
 */
@Setter
@Getter
public class OpenOrderListResData extends ResData {

    private static final long serialVersionUID = 2996290991512350161L;

    List<OrderDetails> historyList = new ArrayList<>(); // 历史委托  50条
    List<OrderDetails> tradeList = new ArrayList<>();// 成交记录 50条

    public OpenOrderListResData() {

    }

    public OpenOrderListResData(List<OrderDetails> historyList,List<OrderDetails> tradeList) {
        this.historyList = historyList;
        this.tradeList = tradeList;
    }
}
