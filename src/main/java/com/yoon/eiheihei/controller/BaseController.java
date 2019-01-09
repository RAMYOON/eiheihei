package com.yoon.eiheihei.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public interface BaseController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    Object Get(Object... params);

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    Object Post(Object... params);

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    Object Put(Object... params);

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    Object Delete(Object... params);
}
