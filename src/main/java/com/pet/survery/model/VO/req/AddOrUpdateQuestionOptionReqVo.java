package com.pet.survery.model.VO.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddOrUpdateQuestionOptionReqVo {
    private String questionId;
    @NotNull(message = "选项编号不能为空")
    private Integer optionNumber;

    @NotNull(message = "选项描述")
    private String optionTitle;

}
