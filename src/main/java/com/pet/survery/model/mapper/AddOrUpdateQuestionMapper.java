package com.pet.survery.model.mapper;

import com.pet.survery.investigate.entity.PetSurveryQuestion;
import com.pet.survery.model.DTO.req.AddOrUpdateQuestionReqDTO;
import com.pet.survery.model.VO.req.AddOrUpdateQuestionReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddOrUpdateQuestionMapper {
    AddOrUpdateQuestionMapper INSTANCE = Mappers.getMapper(AddOrUpdateQuestionMapper.class);
    AddOrUpdateQuestionReqDTO to(AddOrUpdateQuestionReqVO addOrUpdateQuestionReqVO);
}
