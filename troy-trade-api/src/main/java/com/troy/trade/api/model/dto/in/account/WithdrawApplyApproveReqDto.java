package com.troy.trade.api.model.dto.in.account;

import com.troy.commons.dto.in.ReqData;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 提现申请审核入参
 *
 * @author dp
 */
@Setter
@Getter
public class WithdrawApplyApproveReqDto extends ReqData {

    @NotNull(message = "审核成功与否为空")
    private Boolean pass;

    private String remark;

    @NotNull(message = "提现申请ID为空")
    private Long accountCoinApplyId;

    @NotNull(message = "审批人姓名为空")
    private String approver;

    @NotNull(message = "审批人ID为空")
    private String updateBy;

    private String ip;
}
