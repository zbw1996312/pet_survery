package com.pet.survery.model.DTO.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PetSurveryQuestionOptionDto {
    private String questionId;
    private Integer optionNumber;
    private String optionTitle;
}
