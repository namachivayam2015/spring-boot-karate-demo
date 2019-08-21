package com.example.demo.api;


import com.example.demo.model.Names;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SampleApiController {

    private List<Names> nameList = new ArrayList<>();

    @RequestMapping(value = "/findNames",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<List<Names>> fetchNames(){
        return new ResponseEntity<>(nameList, HttpStatus.OK);
    }


    @RequestMapping(value = "/addName/{first}/{last}",
            produces = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity addName(@PathVariable("first") String firstName, @PathVariable("last") String lastName){
        nameList.add(new Names(firstName, lastName));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/deleteName/{first}",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    public ResponseEntity deleteName(@PathVariable("first") String firstName){
        for(Names names:nameList){
            if(names.getFirstName().equalsIgnoreCase(firstName)){
                nameList.remove(names);
            }
        }
        return new ResponseEntity<>(nameList, HttpStatus.NO_CONTENT);
    }

}
