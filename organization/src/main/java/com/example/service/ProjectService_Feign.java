package com.example.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/2/13.
 */
@FeignClient(value = "PROJECT", fallback = ProjectServiceFeign_Fallback.class)
public interface ProjectService_Feign {
    @RequestMapping(value = "/prjlocation/{projectId}", method = RequestMethod.GET)
    public String getPrjLocation(@PathVariable("projectId") long projectId);
}
