package com.troy.trade.model.dto.out;

import com.troy.commons.dto.out.ResData;
import lombok.*;

/**
 *
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TestResDto extends ResData {

    private Long id;

    private String tKey;

    private String tValue;
}
