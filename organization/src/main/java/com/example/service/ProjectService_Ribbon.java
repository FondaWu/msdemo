package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * Created by Administrator on 2017/2/13.
 */
@Service
public class ProjectService_Ribbon {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getPrjNameFallback")
    public String getPrjName(Long projectId) {
        return restTemplate.getForEntity("http://PROJECT/prjname/"+projectId, String.class).getBody();
    }

    public String getPrjNameFallback(Long projectId) {
        return "error";
    }
}
