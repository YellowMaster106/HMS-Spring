package com.health.mapper;

import com.health.pojo.TbDoctor;
import com.health.pojo.TbDoctorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDoctorMapper {
    long countByExample(TbDoctorExample example);

    int deleteByExample(TbDoctorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbDoctor record);

    int insertSelective(TbDoctor record);

    List<TbDoctor> selectByExample(TbDoctorExample example);

    TbDoctor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbDoctor record, @Param("example") TbDoctorExample example);

    int updateByExample(@Param("record") TbDoctor record, @Param("example") TbDoctorExample example);

    int updateByPrimaryKeySelective(TbDoctor record);

    int updateByPrimaryKey(TbDoctor record);
}