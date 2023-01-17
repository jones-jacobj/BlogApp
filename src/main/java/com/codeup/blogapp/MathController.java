package com.codeup.blogapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {
//    @RequestMapping(name="/math/add/{num1}/and/{num2}", method = RequestMethod.GET)
@GetMapping("/math/add/{num1}/and/{num2}")
    @ResponseBody
    public String addition(@PathVariable int num1, @PathVariable int num2){
        return Integer.toString(num1 + num2);
    }

//    @RequestMapping(name="/math/subtract/{num1}/from/{num2}", method = RequestMethod.GET)
@GetMapping("/math/subtract/{num1}/from/{num2}")
    @ResponseBody
    public String subtract(@PathVariable int num1, @PathVariable int num2){
        return Integer.toString(num2 - num1);
    }

    @GetMapping("/math/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiply(@PathVariable int num1, @PathVariable int num2){
        return Integer.toString(num2 * num1);
    }

    @GetMapping("/math/divide/{num1}/by/{num2}")
    @ResponseBody
    public String divide(@PathVariable int num1, @PathVariable int num2){
        return Integer.toString((num1 / num2));
    }
}
