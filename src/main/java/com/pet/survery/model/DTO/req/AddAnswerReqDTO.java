package com.pet.survery.model.DTO.req;

import com.pet.survery.model.VO.req.OptionVO;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class AddAnswerReqDTO {
    @NotNull(message = "年龄不能为空")
    @Min(message = "年龄不能小于0",value = 0)
    @Max(message = "年龄不能大于150",value =150)
    private Integer age;
    @NotNull(message = "目前身份不能为空")
    @Min(message = "目前身份不能小于1",value = 1)
    @Max(message = "目前身份不能大于7",value =7)
    private Integer identity;
    @NotNull(message = "目前年收入不能为空")
    @Min(message = "目前年收入不能小于1",value = 1)
    @Max(message = "目前年收入不能大于4",value =4)
    private Integer annualIncome;
    @NotNull(message = "性别不能为空")
    @Min(message = "性别不能小于0",value = 1)
    @Max(message = "性别不能大于2",value =2)
    private Integer sex;
    @NotNull(message = "手机号不能为空")
    private String phoneNumber;
    /**
     * 调查问题选项
     */
    private List<OptionVO> option;
}
