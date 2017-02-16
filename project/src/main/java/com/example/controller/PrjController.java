package com.example.controller;

/**
 * Created by Administrator on 2017/2/7.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.*;

@RefreshScope
@RestController
public class PrjController {

    @Value("${project-name}")
    public String projectName;
    @Autowired
    private EurekaDiscoveryClient client;

    @RequestMapping("/moudlename")
    public String GetMoudleName(){ return projectName; }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public String setProjectName() {
        return projectName;
    }

    @RequestMapping(value = "/prjname/{projectId}", method = RequestMethod.GET)
    public String GetPrjName(@PathVariable Long projectId) {
        int port = client.getLocalServiceInstance().getPort();
        if (projectId == 1){
            return "香樟雅苑" + port;
        }else if (projectId == 2){
            return "绿城百合" + port;
        }else{
            return "未知项目" + port;
        }
    }

    @RequestMapping(value = "/prjlocation/{projectId}", method = RequestMethod.GET)
    public String GetPrjLocation(@PathVariable Long projectId) {
        int port = client.getLocalServiceInstance().getPort();
        if (projectId == 1){
            return "东至路8号" + port;
        }else if (projectId == 2){
            return "东至路6号" + port;
        }else{
            return "未知项目" + port;
        }
    }
}
