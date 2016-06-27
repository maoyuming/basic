package com.duantuke.basic.mappers;

import com.duantuke.basic.po.PersonalTailor;
import com.duantuke.basic.po.PersonalTailorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonalTailorMapper {
    int countByExample(PersonalTailorExample example);

    int deleteByExample(PersonalTailorExample example);

    int deleteByPrimaryKey(Long personalTailorId);

    int insert(PersonalTailor record);

    int insertSelective(PersonalTailor record);

    List<PersonalTailor> selectByExample(PersonalTailorExample example);

    PersonalTailor selectByPrimaryKey(Long personalTailorId);

    int updateByExampleSelective(@Param("record") PersonalTailor record, @Param("example") PersonalTailorExample example);

    int updateByExample(@Param("record") PersonalTailor record, @Param("example") PersonalTailorExample example);

    int updateByPrimaryKeySelective(PersonalTailor record);

    int updateByPrimaryKey(PersonalTailor record);
}