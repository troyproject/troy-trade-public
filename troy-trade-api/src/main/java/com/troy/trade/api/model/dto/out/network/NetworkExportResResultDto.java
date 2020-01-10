
package com.troy.trade.api.model.dto.out.network;

import com.troy.commons.dto.out.ResData;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NetworkExportResResultDto extends ResData {

        private Long networkExportId;

        private String exportIp;

        private String accountName;

}


