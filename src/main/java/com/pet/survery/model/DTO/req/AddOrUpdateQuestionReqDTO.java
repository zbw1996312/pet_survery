package com.pet.survery.model.DTO.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddOrUpdateQuestionReqDTO {
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
    private String petSurveryQuestionNumber;

    /**
     * 问题分类
     * 小宠有佳问卷调查问题类型(1.填空题2.单选题3.多选题4.判断题)
     */
    @NotNull(message = "问题分类不能为空")
    private String petSurveryQuestionType;

    /**
     * 小宠有佳问卷调查问题类目(1.会员资料信息2.问卷调查问题)
     */
    @NotNull(message = "问题类目不能为空")
    private String petSurveryQuestionMold;
}
