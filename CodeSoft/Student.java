package CodeSoft;

import java.io.Serializable;

class Student implements Serializable {
    private String studentID;
    private String name;
    private int age;
    private String course;

    public Student(String studentID, String name, int age, String course) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Getter and Setter Methods
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + ", Name: " + name + ", Age: " + age + ", Course: " + course;
    }
}

