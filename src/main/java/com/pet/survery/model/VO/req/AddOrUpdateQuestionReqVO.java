package com.pet.survery.model.VO.req;

import com.pet.survery.investigate.entity.PetSurveryQuestionOption;
import com.pet.survery.model.DTO.req.PetSurveryQuestionOptionDto;
import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class AddOrUpdateQuestionReqVO {
    /**
     * 问题主键Id
     * 如果有则更新，没有则是添加操作
     */
    private String questionId;

    /**
     * 问题名称
     */
    @NotNull(message = "问题名称不能为空")
    private String petSurveryQuestion;

    /**
     * 问题编号
     */
    @NotNull(message = "问题编号不能为空")
    @Min(message = "请输入数字最少为1的编号", value = 1)
    private String petSurveryQuestionNumber;

    /**
     * 问题分类
     * 小宠有佳问卷调查问题类型(1.填空题2.单选题3.多选题4.判断题)
     */
    @NotNull(message = "问题分类不能为空")
    @Min(message = "请输入数字最少为1的分类", value = 1)
    private String petSurveryQuestionType;

    /**
     * 小宠有佳问卷调查问题类目(1.会员资料信息2.问卷调查问题)
     */
    @NotNull(message = "问题类目不能为空")
    @Min(message = "请输入数字最少为1的类目", value = 1)
    private String petSurveryQuestionMold;

    /**
     * 小宠有佳问题选项
     */
    private PetSurveryQuestionOptionDto petSurveryQuestionOptionDto;
}
