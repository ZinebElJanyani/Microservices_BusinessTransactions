package com.example.demo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RefreshScope
@RestController
public class EntrepriseRestService {
    @Value("${xParam}")
    private int xParam;
    @Value("${yParam}")
    private int yParam;
    @Value("${me}")
    private String me;

    @GetMapping("/myConfig")
    public Map<String,Object> myConfig(){
        Map<String,Object> maps = new HashMap<>();
        maps.put("xParam",xParam);
        maps.put("yParam",yParam);
        maps.put("me",me);
        maps.put("Threadname",Thread.currentThread().getName());
        return maps;
    }

}
