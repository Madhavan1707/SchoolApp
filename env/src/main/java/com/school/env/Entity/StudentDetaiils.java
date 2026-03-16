package com.school.env.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "student_details")
@Data
public class StudentDetaiils {

    @Id
    String id;
    String name;
    String standard;
}
