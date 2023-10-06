package com.geekster.mmbidirectional;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {

    @Id
    private Integer courseId;

    private String courseName;

    @ManyToMany(mappedBy = "courses")
    List<Student> students;
}
