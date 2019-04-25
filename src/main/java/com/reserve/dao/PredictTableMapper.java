package com.reserve.dao;

import com.reserve.bean.PredictTable;
import com.reserve.bean.PredictTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PredictTableMapper {
    long countByExample(PredictTableExample example);

    int deleteByExample(PredictTableExample example);

    int deleteByPrimaryKey(String id);

    int insert(PredictTable record);

    int insertSelective(PredictTable record);

    List<PredictTable> selectByExample(PredictTableExample example);

    PredictTable selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PredictTable record, @Param("example") PredictTableExample example);

    int updateByExample(@Param("record") PredictTable record, @Param("example") PredictTableExample example);

    int updateByPrimaryKeySelective(PredictTable record);

    int updateByPrimaryKey(PredictTable record);
}