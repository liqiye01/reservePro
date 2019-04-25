package com.reserve.dao;

import com.reserve.bean.LaboratoryBuilding;
import com.reserve.bean.LaboratoryBuildingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LaboratoryBuildingMapper {
    long countByExample(LaboratoryBuildingExample example);

    int deleteByExample(LaboratoryBuildingExample example);

    int deleteByPrimaryKey(String id);

    int insert(LaboratoryBuilding record);

    int insertSelective(LaboratoryBuilding record);

    List<LaboratoryBuilding> selectByExample(LaboratoryBuildingExample example);

    LaboratoryBuilding selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LaboratoryBuilding record, @Param("example") LaboratoryBuildingExample example);

    int updateByExample(@Param("record") LaboratoryBuilding record, @Param("example") LaboratoryBuildingExample example);

    int updateByPrimaryKeySelective(LaboratoryBuilding record);

    int updateByPrimaryKey(LaboratoryBuilding record);
    
    public List<String> findBuildingnum(); 

	List<LaboratoryBuilding> findLaboratoryByBuildingNum(int buildingNum);
	
	public LaboratoryBuilding getDetailsById(String id);
    
}