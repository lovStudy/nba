package com.cn.nba.exception;


import com.cn.nba.common.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerController {

    private Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler
    @ResponseBody
    public Map<String, Object> exceptionHandler(BizException e) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", false);
        map.put("msg", e.getMessage());
        logger.info(e.getMessage());
        logger.info("1111333");
        return map;
    }







}
