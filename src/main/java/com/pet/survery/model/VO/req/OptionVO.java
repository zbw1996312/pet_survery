package com.pet.survery.model.VO.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OptionVO {
    @NotNull(message = "问题编号不能为空")
    private String questionNumber;
    @NotNull(message = "问题回答不能为空")
    private String answer;
    private String choiceCommon;
}
