package com.maveric.thinknxt.ems.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "department")
public class Department {
    @Transient
    public static final String DEPARTMENT_SEQUENCE = "department_sequence";
    @Id
    private Long id;
    private String departmentName;
    private String departmentDescription;
}
