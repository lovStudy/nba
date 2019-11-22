package com.cn.nba.service.impl;

import com.cn.nba.common.BizException;
import com.cn.nba.dao.TeamDao;
import com.cn.nba.entity.Team;
import com.cn.nba.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;


@Service
public class TeamServiceImpl implements TeamService {


    @Resource
    private TeamDao teamDao;


    @Override
    public List<Team> getAllTeam() {

        List<Team> list = teamDao.getAllTeam();

        return list;
    }

    @Override
    public void saveTeam() {
        teamDao.saveTeam();
    }


}
