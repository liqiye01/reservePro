package com.reserve.dao;

import com.reserve.bean.RejectTable;
import com.reserve.bean.RejectTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RejectTableMapper {
    long countByExample(RejectTableExample example);

    int deleteByExample(RejectTableExample example);

    int deleteByPrimaryKey(String id);

    int insert(RejectTable record);

    int insertSelective(RejectTable record);

    List<RejectTable> selectByExample(RejectTableExample example);

    RejectTable selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RejectTable record, @Param("example") RejectTableExample example);

    int updateByExample(@Param("record") RejectTable record, @Param("example") RejectTableExample example);

    int updateByPrimaryKeySelective(RejectTable record);

    int updateByPrimaryKey(RejectTable record);
}