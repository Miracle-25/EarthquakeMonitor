package com.earthquake.demo.Controller;

import com.earthquake.demo.Enity.Earthquake;
import com.earthquake.demo.Service.EarthquakeMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author PA
 * @version 2021.2.1
 */

@Controller
public class EarthquekeController {
    @Autowired
    private EarthquakeMapperService earthquakeMapperService;

    @GetMapping(path="/getInsert")
    public String getInsertPage(){
        return "/site/index";
    }


    @PostMapping(path = "/getInsert")
    public String getInsert(Model model,Double magnitude,
                            Double latitude,
                            Double longitude,
                            String ob_earth){
        Map<String,Object> map=
                earthquakeMapperService.insertEarthquake(magnitude, latitude, longitude, ob_earth);
        if(map==null || map.isEmpty()){
            return "/site/index";
        }else {
            model.addAttribute("magnitude",map.get("magnitude"));
            model.addAttribute("latitude",map.get("latitude"));
            model.addAttribute("longitude",map.get("longitude"));
            model.addAttribute("ob_earth",map.get("ob_earth"));
            return "/site/index";
        }
    }
    @PostMapping(path="/getNum")
    public String getNum(Model model,Double num){
        model.addAttribute("num",num);
        return getTargetMag(model,num);
    }


    @GetMapping("/getTargetMag")
    public String getTargetMag(Model model,
                               @RequestParam(value = "num",required = false) Double num){
        List<Earthquake> list=earthquakeMapperService.findTargetMag(num);
        List<Map<String,Object>> earthquakeT = new ArrayList<>();
        if(earthquakeT!=null){
            for(Earthquake earthquake : list){
                Map<String,Object> map=new HashMap<>();
                map.put("Earthquake",earthquake);
                earthquakeT.add(map);
            }
        }
        model.addAttribute("earthquake",earthquakeT);
        return "/site/index";
    }

    @GetMapping(path = "/getMaxMagnitude")
    public String getMaxMagnitude(Model model){
        //Map<String ,Object> map=new HashMap<>();
        Earthquake max=earthquakeMapperService.findMaxMagnitude();
        if(max==null){
            //map.put("max",max);
            return "/site/index";
        }else{
            model.addAttribute("max",max);
            return "/site/index";
        }
    }

//    @RequestMapping(path="/index_mag",method = RequestMethod.GET)
//    public String getMagnitude(Model model){
//        List<Earthquake> list=earthquakeMapperService.findselectMagnitude(5);
//        List<Map<String,Object>> earthquake = new ArrayList<>();
//        if(earthquake!=null){
//            for(Earthquake post : list){
//                Map<String,Object> map=new HashMap<>();
//                map.put("Earthquake",post);
//
//                earthquake.add(map);
//            }
//        }
//        model.addAttribute("Earthquake",earthquake);
//        return "/index";
//    }



}
