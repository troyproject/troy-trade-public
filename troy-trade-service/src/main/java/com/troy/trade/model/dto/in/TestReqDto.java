package com.troy.trade.model.dto.in;

import com.troy.commons.dto.in.ReqData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 */
@Setter
@Getter
public class TestReqDto extends ReqData {

    @NotBlank
    private String key;

}
