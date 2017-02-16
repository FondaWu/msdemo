package com.example.controller;

/**
 * Created by Administrator on 2017/2/7.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;

import com.example.service.ProjectService_Ribbon;
import com.example.service.ProjectService_Feign;


@RefreshScope
@RestController
public class OrgController {
    @Value("${service-name}")
    public String serviceName;

    @Autowired
    private ProjectService_Ribbon projectServiceRibbon;

    @Autowired
    private ProjectService_Feign projectServiceFeign;

    @Autowired
    private EurekaDiscoveryClient client;

    @RequestMapping("/moudlename")
    public String GetMoudleName(){
        int port = client.getLocalServiceInstance().getPort();
        System.out.println("GetMoudleName, port = " + port );
        return serviceName + port;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    public String getServiceName() {
        return serviceName;
    }

    @RequestMapping(value = "/prjname/{projectId}", method = RequestMethod.GET)
    public String getPrjName(@PathVariable Long projectId) {
        return projectServiceRibbon.getPrjName(projectId);
    }

    @RequestMapping(value = "/prjlocation/{projectId}", method = RequestMethod.GET)
    public String getPrjLocation(@PathVariable("projectId") Long projectId) {
        System.out.println("Feign call：GetPrjLocation");
        return projectServiceFeign.getPrjLocation(projectId);
    }
}
