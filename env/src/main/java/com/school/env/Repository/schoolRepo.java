package com.school.env.Repository;

import com.school.env.Entity.StudentDetaiils;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface schoolRepo extends MongoRepository<StudentDetaiils, String> {
    StudentDetaiils findByName(String name);
    void deleteByName(String name);
}
