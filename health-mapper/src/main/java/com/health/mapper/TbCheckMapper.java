package com.health.mapper;

import com.health.pojo.TbCheck;
import com.health.pojo.TbCheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCheckMapper {
    long countByExample(TbCheckExample example);

    int deleteByExample(TbCheckExample example);

    int deleteByPrimaryKey(Integer idDoctor);

    int insert(TbCheck record);

    int insertSelective(TbCheck record);

    List<TbCheck> selectByExample(TbCheckExample example);

    int updateByExampleSelective(@Param("record") TbCheck record, @Param("example") TbCheckExample example);

    int updateByExample(@Param("record") TbCheck record, @Param("example") TbCheckExample example);
}