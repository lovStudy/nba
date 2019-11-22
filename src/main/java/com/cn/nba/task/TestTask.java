package com.cn.nba.task;


import com.cn.nba.dao.TeamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestTask {

    @Autowired
    private TeamDao teamDao;

    int i = 0;

    //  @Scheduled(fixedDelay=1000)
    @Scheduled(cron = "*/5 * * * * ?")
    @Async
    public void test() {
        i++;
        System.out.println("test-----" + System.currentTimeMillis());
        System.out.println(Thread.currentThread().getName());
        System.out.println(i);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     /*   teamDao.updateTeam();
        teamDao.updateTeam1();*/
    }

    // @Scheduled(fixedDelay=1000)
 /*   public void test1(){
        System.out.println("test1-----"+System.currentTimeMillis());
        System.out.println(Thread.currentThread().getName());
        System.out.println("22");
        teamDao.updateTeam();
        teamDao.updateTeam1();
    }*/


}
