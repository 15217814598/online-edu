package com.edu.onlineedu.mapper;

import com.edu.onlineedu.pojo.Enrecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EnrecordMapper {
    List<Enrecord> getAllEnercord(Map<String, Object> conditions);
}
