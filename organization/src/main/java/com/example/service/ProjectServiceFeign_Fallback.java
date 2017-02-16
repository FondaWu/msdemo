package com.example.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Administrator on 2017/2/13.
 */
@Component
public class ProjectServiceFeign_Fallback implements ProjectService_Feign {
    @Override
    public String getPrjLocation(@PathVariable("projectId") long projectId){
        return "error to getPrjLocation";
    }
}
