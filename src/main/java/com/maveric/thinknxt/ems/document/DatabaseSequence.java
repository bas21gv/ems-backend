package com.maveric.thinknxt.ems.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("database_sequence")
public class DatabaseSequence {
    @Id
    private String id;
    private Long seq;
}
