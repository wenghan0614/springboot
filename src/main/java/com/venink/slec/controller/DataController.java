package com.venink.slec.controller;

import com.alibaba.fastjson.JSON;
import com.venink.slec.base.utils.ReturnUtils;
import com.venink.slec.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@Controller
@RequestMapping("/data")
public class DataController {

    //Logback
    private static final Logger logger = LoggerFactory.getLogger(PassiveController.class);

    @Autowired
    private DataService dataService;

    //1根据权限名查询权限编号
    @ResponseBody
    @RequestMapping(value = "/groupId",method = RequestMethod.GET)
    public ReturnUtils getGroupId(@RequestParam("groupName")String groupName){
        return dataService.getGroupId(groupName);
    }

    //2向指定群组添加人员
    @ResponseBody
    @RequestMapping(value = "/addPerson",method = RequestMethod.POST)
    public ReturnUtils addPerson(@RequestBody Map<String, String> map){
        logger.info("添加人员："+ JSON.toJSONString(map));
        return dataService.addPerson(map);
    }

    //3修改人员
    @ResponseBody
    @RequestMapping(value = "/updatePerson",method = RequestMethod.POST)
    public ReturnUtils updatePerson(@RequestBody Map<String, String> map){
        logger.info("更新人员："+ JSON.toJSONString(map));
        return dataService.updatePerson(map);
    }
}
