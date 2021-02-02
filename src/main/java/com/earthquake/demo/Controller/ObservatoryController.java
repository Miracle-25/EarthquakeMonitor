package com.earthquake.demo.Controller;

import com.earthquake.demo.Enity.Earthquake;
import com.earthquake.demo.Enity.Observatory;
import com.earthquake.demo.Service.ObservatoryMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author PA
 * @version 2021.2.1
 */

@Controller
public class ObservatoryController {

    @Autowired
    private ObservatoryMapperService observatoryMapperService;

    @GetMapping(path = "/getInsertOb")
    public String getInsertPage() {
        return "/site/index";
    }


//    @RequestMapping(path="/index_ob",method = RequestMethod.GET)
//    public String getId(Model model){
//        List<Observatory> list=observatoryMapperService.findselectId(1);
//        List<Map<String,Object>> observatory = new ArrayList<>();
//        if(observatory!=null){
//            for(Observatory post : list){
//                Map<String,Object> map=new HashMap<>();
//                map.put("Observatory",post);
//
//                observatory.add(map);
//            }
//        }
//        model.addAttribute("Observatory",observatory);
//        return "/index_ob";
//    }
//
    @GetMapping(path="/getavg")
    public String getavg(Model model){
        Double avg=observatoryMapperService.findCountavg();
        //Map<String,Object> map=new HashMap<>();
        //map.put("avg",res);
        if(avg==null){
            return "/site/index";
        }else {
        model.addAttribute("avg",avg);
        return "/site/index";
        }
    }

//    @GetMapping(path = "/getMaxMagnitude")
//    public String getMaxMagnitude(Model model){
//        //Map<String ,Object> map=new HashMap<>();
//        Earthquake max=earthquakeMapperService.findMaxMagnitude();
//        if(max==null){
//            //map.put("max",max);
//            return "/site/index";
//        }else{
//            model.addAttribute("max",max);
//            return "/site/index";
//        }
//    }

    @PostMapping(path = "/getInsertOb")
    public String getInsertOb(Model model, String name, String country, String year) {
        Map<String, Object> map = observatoryMapperService.insertObservatory(name, country, year);
        if (map == null || map.isEmpty()) {
            return "/site/index";
        } else {
            model.addAttribute("name", map.get("name"));
            model.addAttribute("country", map.get("country"));
            model.addAttribute("year", map.get("country"));
            return "/site/index";
        }
    }

}


