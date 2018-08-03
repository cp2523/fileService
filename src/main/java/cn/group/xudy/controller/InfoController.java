package cn.group.xudy.controller;


import cn.group.xudy.bean.Info;
import cn.group.xudy.service.serviceImpl.InfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户基础信息表 前端控制器
 * </p>
 *
 * @author chen123
 * @since 2018-07-31
 */
@RestController
@RequestMapping("/fileUploads")
public class InfoController {

    @Autowired
    private InfoServiceImpl infoService;

    @RequestMapping("/searchOne")
    public Info test1(){
        Info result = new Info();
        Map<String,Object> map = new HashMap();
        map.put("uid","1");
        map.put("name","小五");

        try {
            result = infoService.selectUserByMap(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

