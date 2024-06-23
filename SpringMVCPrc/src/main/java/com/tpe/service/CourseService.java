package com.tpe.service;

import com.tpe.domain.Course;

import java.util.List;

public interface CourseService {
    void saveCourse(Course course);

    List<Course> getAllCourse();

    Course findCourseById(Long id);

    void deleteCourse(Long id);
}
