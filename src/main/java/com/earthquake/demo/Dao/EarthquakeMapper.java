package com.earthquake.demo.Dao;

import com.earthquake.demo.Enity.Earthquake;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author PA
 * @version 2021.2.1
 */

@Mapper
public interface EarthquakeMapper {
    //按地震级查询地震信息
    List<Earthquake> selectMagnitude(double magnitude);//已测试

    //提供最大地震值
    Earthquake selectMax();//已测试

    //提供目标级数，求大于目标级数数据
    List<Earthquake> selectTargetMag(double num);//已测试

    //插入数据Earthquake
    void insertEarthquake(double magnitude,
            double latitude, double longitude,
             String ob_earth);                //已测试
}
