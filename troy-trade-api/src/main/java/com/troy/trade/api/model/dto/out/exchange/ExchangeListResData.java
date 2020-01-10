package com.troy.trade.api.model.dto.out.exchange;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Han
 */
@Setter
@Getter
public class ExchangeListResData extends ResData {

    private static final long serialVersionUID = 299624018144201161L;

    private List<ExchangeDetails> list;

    public ExchangeListResData() {

    }

    public ExchangeListResData(List<ExchangeDetails> list) {
        this.list = list;
    }
}
