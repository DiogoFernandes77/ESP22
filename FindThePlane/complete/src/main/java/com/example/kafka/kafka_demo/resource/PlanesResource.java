package com.example.kafka.kafka_demo.resource;

import com.example.kafka.kafka_demo.model.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/planes")
public class PlanesResource {



//    @GetMapping(value = "/all")
//    public List<Plane> getAll() {
//        return planesRepository.findAll();
//    }
//
//    @PostMapping(value = "/load")
//    public List<Plane> persist(@RequestBody final Plane planes) {
//        planesRepository.save(planes);
//        return planesRepository.findAll();
//    }
}
