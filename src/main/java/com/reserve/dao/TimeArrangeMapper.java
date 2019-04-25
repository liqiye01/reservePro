package com.reserve.dao;

import com.reserve.bean.TimeArrange;
import com.reserve.bean.TimeArrangeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TimeArrangeMapper {
    long countByExample(TimeArrangeExample example);

    int deleteByExample(TimeArrangeExample example);

    int deleteByPrimaryKey(String id);

    int insert(TimeArrange record);

    int insertSelective(TimeArrange record);

    List<TimeArrange> selectByExample(TimeArrangeExample example);

    TimeArrange selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TimeArrange record, @Param("example") TimeArrangeExample example);

    int updateByExample(@Param("record") TimeArrange record, @Param("example") TimeArrangeExample example);

    int updateByPrimaryKeySelective(TimeArrange record);

    int updateByPrimaryKey(TimeArrange record);
    
    public void update(TimeArrange timeArrange); 
}