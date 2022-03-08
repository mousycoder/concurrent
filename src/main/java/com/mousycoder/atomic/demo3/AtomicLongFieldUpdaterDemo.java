package com.mousycoder.atomic.demo3;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/7 2:57 PM
 */
public class AtomicLongFieldUpdaterDemo {


    public static void main(String[] args) {

        AtomicLongFieldUpdater<Student> longFieldUpdater = AtomicLongFieldUpdater.newUpdater(Student.class, "id");

        Student student = new Student(1L, "huhao");

        longFieldUpdater.compareAndSet(student, 1L, 100L);
        System.out.println(student.getId());


        AtomicReferenceFieldUpdater<Student, String> ref = AtomicReferenceFieldUpdater.newUpdater(Student.class, String.class, "name");
        ref.compareAndSet(student,"huhao","test");
        System.out.println(student.getName());


    }
}


class Student {
    volatile long id;
    volatile String name;

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
