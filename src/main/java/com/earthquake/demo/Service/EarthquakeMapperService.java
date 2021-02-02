package com.earthquake.demo.Service;

import com.earthquake.demo.Dao.EarthquakeMapper;
import com.earthquake.demo.Enity.Earthquake;
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
public class EarthquakeMapperService {

    @Autowired
    private EarthquakeMapper earthquakeMapper;

    public EarthquakeMapperService(){
        System.out.println("<----------------------------------启动service---------------------------------->");
    }

    public List<Earthquake> findselectMagnitude(int magnitude){
        return  earthquakeMapper.selectMagnitude(magnitude);
    }

    public Earthquake findMaxMagnitude(){
        return earthquakeMapper.selectMax();
    }

    public List<Earthquake> findTargetMag(Double num){
        if(num==null){
            throw new IllegalArgumentException("参数不能为空");
        }
        return earthquakeMapper.selectTargetMag(num);
    }

    public Map<String,Object> insertEarthquake(Double magnitude,
                                               Double latitude, Double longitude,
                                               String ob_earth){
        Map<String,Object> map=new HashMap<>();
        if(magnitude==null){
            throw new IllegalArgumentException("参数不能为空");
        }
        if(latitude==null){
            throw new IllegalArgumentException("参数不能为空");
        }
        if(longitude==null){
            throw new IllegalArgumentException("参数不能为空");
        }
        if(ob_earth==null){
            throw new IllegalArgumentException("参数不能为空");
        }

        earthquakeMapper.insertEarthquake(magnitude, latitude, longitude, ob_earth);
        return map;
    }
}
