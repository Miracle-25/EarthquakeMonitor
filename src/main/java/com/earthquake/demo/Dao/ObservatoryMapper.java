package com.earthquake.demo.Dao;

import com.earthquake.demo.Enity.Observatory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author PA
 * @version 2021.2.1
 */

@Mapper
public interface ObservatoryMapper {
    List<Observatory> selectId(int id_o);//已测试

    //提供平均地震值
    double countAvg();//已测试

    //插入数据Earthquake
    void insertObservatory(String name, String country,String year);//已测试
}
