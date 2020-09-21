package com.pet.survery.model.mapper;


import com.pet.survery.model.DTO.req.AddAnswerReqDTO;
import com.pet.survery.model.VO.req.AddAnswerReqVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddAnswerMapper {
    AddAnswerMapper INSTANCE = Mappers.getMapper(AddAnswerMapper.class);
    AddAnswerReqDTO to(AddAnswerReqVo addAnswerReqVo);
}
