package com.mousycoder.atomic.demo4;

import java.util.concurrent.atomic.AtomicReference;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/7 3:34 PM
 */
public class AtomicReferenceDemo {

    public static void main(String[] args) {
        AtomicReference<Student> studentAtomicReference = new AtomicReference<>();

        Student huhao = new Student(1L, "huhao");
        Student test = new Student(2L, "test");
        studentAtomicReference.set(huhao);

        studentAtomicReference.compareAndSet(huhao,test);

        Student student = studentAtomicReference.get();

        System.out.println(student.getName());
    }

}

class Student{
    private long id;

    private String name;

    public Student(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
