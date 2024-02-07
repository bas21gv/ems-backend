package com.maveric.thinknxt.ems.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employees")
public class Employee {

    @Transient
    public static final String EMPLOYEES_SEQUENCE = "employees_sequence";
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @DocumentReference(lazy = true)
    private Department department;
}
