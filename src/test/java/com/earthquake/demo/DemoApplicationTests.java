package com.earthquake.demo;

import com.earthquake.demo.Dao.EarthquakeMapper;
import com.earthquake.demo.Dao.ObservatoryMapper;
import com.earthquake.demo.Enity.Earthquake;
import com.earthquake.demo.Enity.Observatory;
import com.earthquake.demo.Service.EarthquakeMapperService;
import com.earthquake.demo.Service.ObservatoryMapperService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
class DemoApplicationTests {

    @Autowired
    private EarthquakeMapper earthquakeMapper;
    @Autowired
    private ObservatoryMapper observatoryMapper;
    @Autowired
    private EarthquakeMapperService earthquakeMapperService;
    @Autowired
    private ObservatoryMapperService observatoryMapperService;

    @Test
    public void testSelect(){
        List<Earthquake> list=earthquakeMapper.selectMagnitude(13);
        System.out.println("Test");
        for(Earthquake post:list){
            System.out.println(post);
        }
    }

    @Test
    public void testMagnitudeMax(){
        //Earthquake res=

        Earthquake res=earthquakeMapperService.findMaxMagnitude();
        System.out.println("Max");
        System.out.println(res);
    }

    @Test
    public void testTarget(){
        List<Earthquake> list=earthquakeMapperService.findTargetMag(5.0);
        System.out.println("Above Target");
        for(Earthquake post:list){
            System.out.println(post);
        }
    }

    @Test
    public void testInsertEarthquake(){
        earthquakeMapper.insertEarthquake(3, 5, 6, "Newcastle");
        System.out.println("insert successful");
    }

    @Test
    public void testSelect_ob(){
        List<Observatory> list=observatoryMapper.selectId(1);
        System.out.println("Test OB select_ID");
        for (Observatory post:list){
            System.out.println(post);
        }
    }

    @Test
    public void testCount_avg(){
        double res=observatoryMapper.countAvg();
        double res_2=observatoryMapperService.findCountavg();
        System.out.println("Average");
        System.out.println(res);
        System.out.println(res_2);
    }

    @Test
    public void testInsertOB(){
        observatoryMapper.insertObservatory("Chicago","USA","2002");
        System.out.println("insert successful");
    }

}
