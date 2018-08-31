package com.nhh.wwwsrv.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
public class DataService {

    public Optional<Object> loadData(String name) {
        var mapper = new ObjectMapper();
        var file = new File("data/" +name+".json");
        try {
            return Optional.ofNullable(mapper.readValue(file, Object.class));
        } catch (IOException e) {
            return Optional.empty();
        }
    }
}
