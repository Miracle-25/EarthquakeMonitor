package com.earthquake.demo.Service;

import com.earthquake.demo.Dao.ObservatoryMapper;
import com.earthquake.demo.Enity.Observatory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author PA
 * @version 2021.2.1
 */

@Service
public class ObservatoryMapperService {

    @Autowired
    private ObservatoryMapper observatoryMapper;

    public List<Observatory> findselectId(int id_o){
        return  observatoryMapper.selectId(id_o);
    }

    public double findCountavg(){
        return observatoryMapper.countAvg();
    }

    public Map<String,Object> insertObservatory(String name ,String country,String year){
        Map<String,Object> map=new HashMap<>();
        if(name==null){
            throw new IllegalArgumentException("参数不能为空");
        }
        if(country==null){
            throw new IllegalArgumentException("参数不能为空");
        }
        if(year==null){
            throw new IllegalArgumentException("参数不能为空");
        }
        observatoryMapper.insertObservatory(name,country,year);
        return map;
    }

}
