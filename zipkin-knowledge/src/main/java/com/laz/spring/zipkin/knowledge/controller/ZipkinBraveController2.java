package com.laz.spring.zipkin.knowledge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@RestController
@RequestMapping("server2")
public class ZipkinBraveController2 {

    @Autowired
    private OkHttpClient client;

    /**
     * @Description: 第二步调用
     * @Param:
     * @return:  字符串
     * @Author: Mr.Yang
     * @Date: 2018/7/3
     */
    @RequestMapping("/zipkin")
    public String service1() throws Exception {
        Thread.sleep(100);
        Request request = new Request.Builder().url("http://localhost:9000/zipkinTest/server3/zipkin").build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

}
