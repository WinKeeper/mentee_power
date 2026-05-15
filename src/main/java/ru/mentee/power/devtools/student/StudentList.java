package ru.mentee.power.devtools.student;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
  private List<Student> studentList;

  public StudentList() {
    studentList = new ArrayList<>();
  }

  public void addStudent(Student student) {
    if (student != null) {
      studentList.add(student);
    }
  }

  public List<Student> getStudentFromSpecificCity(String city) {
    return studentList.stream().filter(s -> s.city().equals(city)).toList();
  }

  public void tryThis() {
  }

  public void pascalCaseMistake() {
  }
}
