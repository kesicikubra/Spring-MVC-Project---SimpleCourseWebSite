package com.tpe.repository;

import com.tpe.domain.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepositoryImpl implements CourseRepository {
    @Autowired
    private SessionFactory sessionFactory; //db ile ilişki kurmak için sessiona ihtyaç giderildi

    @Override
    public void save(Course course) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(course); //daha önce db de varsa update yoksa save işlemi yapar
        tx.commit();
        session.close();
    }

    @Override
    public List<Course> getAll() {
        Session session = sessionFactory.openSession();
        List<Course> courseList = session.createQuery("FROM Course", Course.class).getResultList();
        session.close();
        return courseList;
    }

    @Override
    public Optional<Course> findById(Long id) {
        Session session = sessionFactory.openSession();
        Course course = session.get(Course.class, id);
        Optional<Course> optCourse = Optional.ofNullable(course);//ofNullable course ı sarmalar
        //eğer null değer alırsa exception fırlatmaz null yerine boş bir optional döner

        session.close();
        return optCourse;
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Course course = session.load(Course.class, id);
        session.delete(course);

        tx.commit();
        session.close();

    }
}
