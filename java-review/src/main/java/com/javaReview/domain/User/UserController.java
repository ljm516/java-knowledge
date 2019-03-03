package com.javaReview.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangmingli on 2017/10/15.
 */

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User u = new User();
            u.setName("ljm" + i);
            u.setAge(20 + i);
            u.setAddress("beijing");
            userList.add(u);
        }
        return userList;
    }

    @RequestMapping(value = "/doc", method = RequestMethod.GET)
    public String dc() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

}
