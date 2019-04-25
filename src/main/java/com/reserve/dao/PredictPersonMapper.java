package com.reserve.dao;

import com.reserve.bean.PredictPerson;
import com.reserve.bean.PredictPersonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PredictPersonMapper {
    long countByExample(PredictPersonExample example);

    int deleteByExample(PredictPersonExample example);

    int deleteByPrimaryKey(String id);

    int insert(PredictPerson record);

    int insertSelective(PredictPerson record);

    List<PredictPerson> selectByExample(PredictPersonExample example);

    PredictPerson selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PredictPerson record, @Param("example") PredictPersonExample example);

    int updateByExample(@Param("record") PredictPerson record, @Param("example") PredictPersonExample example);

    int updateByPrimaryKeySelective(PredictPerson record);

    int updateByPrimaryKey(PredictPerson record);

	public void update(PredictPerson predictPerson);
}