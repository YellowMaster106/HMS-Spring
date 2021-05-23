package com.health.mapper;

import com.health.pojo.TbResident;
import com.health.pojo.TbResidentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbResidentMapper {
    long countByExample(TbResidentExample example);

    int deleteByExample(TbResidentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbResident record);

    int insertSelective(TbResident record);

    List<TbResident> selectByExample(TbResidentExample example);

    TbResident selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbResident record, @Param("example") TbResidentExample example);

    int updateByExample(@Param("record") TbResident record, @Param("example") TbResidentExample example);

    int updateByPrimaryKeySelective(TbResident record);

    int updateByPrimaryKey(TbResident record);
}