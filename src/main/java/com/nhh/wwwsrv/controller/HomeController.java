package com.nhh.wwwsrv.controller;

import com.nhh.wwwsrv.service.DataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileNotFoundException;
import java.util.concurrent.Callable;

@Controller
public class HomeController {

    private final DataService dataService;

    public HomeController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/home/{number}")
    public Callable<ModelAndView> home(
        ModelAndView model,
        @PathVariable Integer number
    ) {
        return () -> {
            var data = dataService
                .loadData("home")
                .orElseThrow(FileNotFoundException::new);

            model.addObject("data", data);
            model.addObject("pageNumber", number);
            model.setViewName("home");
            return model;
        };
    }

}
