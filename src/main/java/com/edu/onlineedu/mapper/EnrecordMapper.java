package com.edu.onlineedu.mapper;

import com.edu.onlineedu.pojo.Enrecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EnrecordMapper {
    List<Enrecord> getAllEnercord();
}
