package com.cyx.web;

import com.cyx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@EnableAutoConfiguration
public class SampleController {
    @Autowired
    public UserService userService;
    @RequestMapping("/")
    List home() {
        return userService.userList();
    }

//    public static void main(String[] args) throws Exception {
//        SpringApplication.run(SampleController.class, args);
//    }

//	@Override
//	public void customize(ConfigurableEmbeddedServletContainer container) {
//		container.setPort(8899);
//		container.setPort(8799);
//	}
}