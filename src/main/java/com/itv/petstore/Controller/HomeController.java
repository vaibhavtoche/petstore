package com.itv.petstore.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String getName()
    {
        return "My Name is vaibhav";
    }
    @RequestMapping("/score")
    public int getscore()
    {
        return 90;
}

}