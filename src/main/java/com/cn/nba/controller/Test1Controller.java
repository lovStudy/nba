package com.cn.nba.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cn.nba.entity.Team;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

@Controller
@RequestMapping("/test1")
public class Test1Controller {



    @GetMapping(value = "/test1")
    public void test1(){

        List<Team> list = new ArrayList<>();
        Team team1 = new Team();
        team1.setName("cc");
        Team team2 = new Team();
        team2.setName("bb");
        list.add(team1);
        list.add(team2);
        Collections.sort(list,(Team t1,Team t2)->(t1.getName().compareTo(t2.getName())));


        list.forEach((o)->
        {
            System.out.println(o.getName());
        });



    }

    @PostMapping(value = "/test2")
    public void test2(@RequestBody Team team){

      /*Team t = new Team();
      t.setDate(new Date());*/
        System.out.println(team.getDate());


    }

}
