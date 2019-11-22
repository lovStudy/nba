package com.cn.nba.controller;

import com.cn.nba.annotation.Testa;
import com.cn.nba.common.BizException;
import com.cn.nba.common.Result;
import com.cn.nba.entity.Team;
import com.cn.nba.feign.FeignTest;
import com.cn.nba.proxy.TestProxy;
import com.cn.nba.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
@RequestMapping("/team")
public class TeamController {

    private Logger logger = LoggerFactory.getLogger(TeamController.class);
    @Autowired
    private TeamService teamService;
    @Autowired
    private TestProxy testProxy;
    @Autowired
    private FeignTest feignTest;

    public ExecutorService executorService = Executors.newFixedThreadPool(10);

    @ResponseBody
    @GetMapping("/getTeam")
    public Result getTeam(HttpServletRequest request){
     /*   Team team = new Team();
        team.test();*/

//try{
       /*  if(1==1){
               throw new BizException("111");
           }*/
    /*   for(int i =0;i<5;i++){
             executorService.execute(new TestTask1(feignTest));
         }*/
  /*      }catch (BizException e){
            System.out.println("111888");
            logger.info(e.getMessage());
            logger.info("7777");
            throw new BizException(e.getMessage());
        }*/
        //   System.out.println(request.getSession().getId());
  /*     TeamService t = (TeamService)Proxy.newProxyInstance(TeamService.class.getClassLoader(), new Class[] {TeamService.class}, testProxy);
        List<Team> list =  t.getAllTeam();*/
        System.out.println(teamService.hashCode());
        teamService.saveTeam();
        List<Team> list = teamService.getAllTeam();


        return new Result(list, 200, "成功");

    }



    @GetMapping("/getAnTest")
    public void getAnTest() {

    /*    Class c = TeamController.class;
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            Testa testa = field.getAnnotation(Testa.class);
            if (testa != null) {
                Object object = field.getAnnotatedType();
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
            }
        }
*/
        feignTest.getTest("11","22");
    }

}
