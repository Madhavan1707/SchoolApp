package com.school.env.Controller;

import com.school.env.Entity.StudentDetaiils;
import com.school.env.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("school")
public class SchoolAPIController {

    @Autowired
    private SchoolService ss;

    @PostMapping
    public boolean saveDetails( @RequestBody StudentDetaiils sd){
        ss.setStudentDetails(sd);
        return true;
    }

    @GetMapping
    public List<StudentDetaiils> getAll(){
        return ss.getAll();
    }

    @GetMapping("name")
    public StudentDetaiils getByName(@RequestParam String name){
        return ss.findbyName(name);
    }
    @GetMapping("id")
    public StudentDetaiils getByID(@RequestParam String id){
        return ss.findbyId(id);
    }


    @GetMapping("id/{id}")
    public StudentDetaiils getDetials(@PathVariable String id){
        return ss.findbyId(id);
    }


}
