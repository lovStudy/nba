package com.cn.nba.service;

import com.cn.nba.entity.Team;

import java.util.List;

public interface TeamService<T> {

    List<T> getAllTeam();

    void saveTeam();


}
