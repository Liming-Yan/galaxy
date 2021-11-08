package com.ming.galaxy.controller;

import com.ming.galaxy.entity.RestResult;
import com.ming.galaxy.entity.StarType;
import com.ming.galaxy.mapper.StarTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StarTypeController {
    @Autowired
    private StarTypeMapper starTypeMapper;

    @GetMapping("starType")
    public RestResult selectStarType() {
        List<StarType> allUser = starTypeMapper.getAllStarType();
        return RestResult.success(allUser);
    }

    @PostMapping("addType")
    public RestResult addStarType(@RequestBody StarType starType) {
        starTypeMapper.addStarType(starType);
        return RestResult.success("");
    }

    @PostMapping("deleteType")
    public RestResult deleteStarType(@RequestBody StarType starType) {
        starTypeMapper.deleteStarType(starType);
        return RestResult.success("");
    }
}
