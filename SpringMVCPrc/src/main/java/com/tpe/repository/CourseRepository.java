package com.tpe.repository;

import com.tpe.domain.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {

    void save(Course course);

    List<Course> getAll();

    Optional<Course> findById(Long id);
    //avantajı null değeri döndüğünde NullPointerException gibi hataların önüne geçer
    //kodun daha güvenli olmasını sağlar

    void delete(Long id);
}
