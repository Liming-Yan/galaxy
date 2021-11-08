package com.ming.galaxy.mapper;


import com.ming.galaxy.entity.StarType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StarTypeMapper {
    List<StarType> getAllStarType();

    void addStarType(StarType type);

    void deleteStarType(StarType type);
}
