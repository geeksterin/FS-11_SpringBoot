package com.geekster.mmbidirectional;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {


    @Id
    private Integer studentId;

    private String studentName;



    @ManyToMany
    @JoinTable(name = "student_Course_mapping", joinColumns = @JoinColumn(name = "fk_student_id"),inverseJoinColumns = @JoinColumn(name = "fk_course_id"))
    List<Course> courses;
}
