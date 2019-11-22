package com.cn.nba.dao;

import com.cn.nba.entity.Team;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeamDao {

    List<Team> getAllTeam();

    void updateTeam();

    void updateTeam1();

    void saveTeam();
}

