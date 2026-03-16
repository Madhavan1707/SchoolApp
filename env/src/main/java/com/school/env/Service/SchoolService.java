package com.school.env.Service;


import com.school.env.Entity.StudentDetaiils;
import com.school.env.Repository.schoolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SchoolService {

    @Autowired
    private schoolRepo sr;

    public void setStudentDetails(StudentDetaiils sd){
        sr.save(sd);
    }

    public List<StudentDetaiils> getAll(){
        return sr.findAll();
    }
    public StudentDetaiils findbyId(String id){
        return sr.findById(id).orElse(null);
    }

    public StudentDetaiils findbyName(String name){
        return sr.findByName(name);
    }

    public void delbyId(String id){

            sr.deleteById(id);

    }

    public void delbyName(String name){
        sr.deleteByName(name);
    }
}
