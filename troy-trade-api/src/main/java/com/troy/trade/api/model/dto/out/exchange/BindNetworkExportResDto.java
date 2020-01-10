package com.troy.trade.api.model.dto.out.exchange;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class BindNetworkExportResDto extends ResData {


    /**
     * 绑定账户获取可以填写的ip
     */
    private List<String> exportIps;

}
