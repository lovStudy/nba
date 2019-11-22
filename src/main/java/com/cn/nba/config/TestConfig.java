package com.cn.nba.config;


import com.cn.nba.common.ConditionTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;


@Component
@Conditional({ConditionTest.class})
public class TestConfig {

    private static final Logger logger = LoggerFactory.getLogger(TestConfig.class);

    static {
        logger.info("加载。。。。a");

    }
}
