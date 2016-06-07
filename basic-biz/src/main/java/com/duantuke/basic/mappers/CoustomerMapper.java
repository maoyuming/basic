package com.duantuke.basic.mappers;

import com.duantuke.basic.po.Coustomer;
import com.duantuke.basic.po.CoustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CoustomerMapper {
    int countByExample(CoustomerExample example);

    int deleteByExample(CoustomerExample example);

    int deleteByPrimaryKey(Long customerId);

    int insert(Coustomer record);

    int insertSelective(Coustomer record);

    List<Coustomer> selectByExample(CoustomerExample example);

    Coustomer selectByPrimaryKey(Long customerId);

    int updateByExampleSelective(@Param("record") Coustomer record, @Param("example") CoustomerExample example);

    int updateByExample(@Param("record") Coustomer record, @Param("example") CoustomerExample example);

    int updateByPrimaryKeySelective(Coustomer record);

    int updateByPrimaryKey(Coustomer record);
}