package com.rup.pokescape.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/")
public class IndexController {


    @GetMapping("")
    public @ResponseBody
    String index() {
        return "<h1>Welcome to the Pokescape Homepage!</h1>";
    }

}
