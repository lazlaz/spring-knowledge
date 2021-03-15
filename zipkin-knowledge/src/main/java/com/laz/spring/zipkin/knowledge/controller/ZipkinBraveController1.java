package com.laz.spring.zipkin.knowledge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@RestController
@RequestMapping("server1")
public class ZipkinBraveController1 {


    @Autowired
    private OkHttpClient client;

    /**
    * @Description: 第一步调用
    * @Param:
    * @return:  字符串
    * @Author: Mr.Yang
    * @Date: 2018/7/3
    */
    @RequestMapping("/zipkin")
    public String service1() throws Exception {
        Thread.sleep(100);
        Request request = new Request.Builder().url("http://localhost:9000/zipkinTest/server2/zipkin").build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

}
