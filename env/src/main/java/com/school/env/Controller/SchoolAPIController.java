package com.school.env.Controller;

import com.school.env.Entity.StudentDetaiils;
import com.school.env.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import  org.springframework.http.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("school")
public class SchoolAPIController {

    @Autowired
    private SchoolService ss;

    @PostMapping
    public ResponseEntity<StudentDetaiils> saveDetails( @RequestBody StudentDetaiils sd){
        ss.setStudentDetails(sd);
        return new ResponseEntity<>(sd, HttpStatus.CREATED);
    }

    @GetMapping
    public List<StudentDetaiils> getAll(){
        return ss.getAll();
    }

    @GetMapping("name")
    public ResponseEntity<StudentDetaiils> getByName(@RequestParam String name){
        Optional<StudentDetaiils> sd = Optional.ofNullable(ss.findbyName(name));
        if(sd.isPresent()){
            return new ResponseEntity<>(sd.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }
    @GetMapping("id")
    public ResponseEntity<StudentDetaiils> getByID(@RequestParam String id){
        Optional<StudentDetaiils> sd = Optional.ofNullable(ss.findbyId(id));
        if(sd.isPresent()){
            return new ResponseEntity<>(sd.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }


    @GetMapping("id/{id}")
    public ResponseEntity<StudentDetaiils> getDetials(@PathVariable String id){
        Optional<StudentDetaiils> sd = Optional.ofNullable(ss.findbyId(id));
        if(sd.isPresent()){
            return new ResponseEntity<>(sd.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("name")
    public ResponseEntity<StudentDetaiils> delbyName(@RequestParam String name){
        Optional<StudentDetaiils> sd = Optional.ofNullable(ss.findbyName(name));
        if(sd.isPresent()){
            ss.delbyName(name);
            return new ResponseEntity<>(sd.get(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("id/{id}")
    public ResponseEntity<StudentDetaiils> delbyID(@PathVariable String id){
        Optional<StudentDetaiils> sd = Optional.ofNullable(ss.findbyId(id));
        if(sd.isPresent()){
            ss.delbyId(id);
            return new ResponseEntity<>(sd.get(), HttpStatus.valueOf(204));
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("id")
    public ResponseEntity<StudentDetaiils> delbyID2(@RequestParam String id){
        Optional<StudentDetaiils> sd = Optional.ofNullable(ss.findbyId(id));
        if(sd.isPresent()){
            ss.delbyId(id);
            return new ResponseEntity<>(sd.get(), HttpStatus.valueOf(204));
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

}
