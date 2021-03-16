package com.health.mapper;

import com.health.pojo.TbHospital;
import com.health.pojo.TbHospitalExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

public interface TbHospitalMapper {
    long countByExample(TbHospitalExample example);

    int deleteByExample(TbHospitalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbHospital record);

    int insertSelective(TbHospital record);

    List<TbHospital> selectByExample(TbHospitalExample example);

    TbHospital selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbHospital record, @Param("example") TbHospitalExample example);

    int updateByExample(@Param("record") TbHospital record, @Param("example") TbHospitalExample example);

    int updateByPrimaryKeySelective(TbHospital record);

    int updateByPrimaryKey(TbHospital record);
}