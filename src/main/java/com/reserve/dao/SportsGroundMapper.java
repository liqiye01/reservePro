package com.reserve.dao;

import com.reserve.bean.SportsGround;
import com.reserve.bean.SportsGroundExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SportsGroundMapper {
    long countByExample(SportsGroundExample example);

    int deleteByExample(SportsGroundExample example);

    int deleteByPrimaryKey(String id);

    int insert(SportsGround record);

    int insertSelective(SportsGround record);

    List<SportsGround> selectByExample(SportsGroundExample example);

    SportsGround selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SportsGround record, @Param("example") SportsGroundExample example);

    int updateByExample(@Param("record") SportsGround record, @Param("example") SportsGroundExample example);

    int updateByPrimaryKeySelective(SportsGround record);

    int updateByPrimaryKey(SportsGround record);

	List<SportsGround> findListByArea(String areaNum);
	
	public SportsGround getDetailsById(String id);
}