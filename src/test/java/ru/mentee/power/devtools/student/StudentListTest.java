package ru.mentee.power.devtools.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

class StudentListTest {

  @Test
  void addStudentShouldAddStudentWhenNotNull() {
    StudentList studentList = new StudentList();
    Student student = new Student("John", "Berlin");

    studentList.addStudent(student);

    List<Student> result = studentList.getStudentFromSpecificCity("Berlin");
    assertEquals(1, result.size());
    assertEquals(student, result.get(0));
  }

  @Test
  void addStudentShouldNotAddStudentWhenNull() {
    StudentList studentList = new StudentList();

    studentList.addStudent(null);

    assertTrue(studentList.getStudentFromSpecificCity("Berlin").isEmpty());
  }

  @Test
  void getStudentFromSpecificCityShouldReturnCorrectStudents() {
    StudentList studentList = new StudentList();

    Student s1 = new Student("Alice", "Berlin");
    Student s2 = new Student("Bob", "Munich");
    Student s3 = new Student("Charlie", "Berlin");

    studentList.addStudent(s1);
    studentList.addStudent(s2);
    studentList.addStudent(s3);

    List<Student> result = studentList.getStudentFromSpecificCity("Berlin");

    assertEquals(2, result.size());
    assertTrue(result.contains(s1));
    assertTrue(result.contains(s3));
    assertFalse(result.contains(s2));
  }

  @Test
  void getStudentFromSpecificCityShouldReturnEmptyWhenNoMatches() {
    StudentList studentList = new StudentList();
    studentList.addStudent(new Student("Alice", "Berlin"));

    List<Student> result = studentList.getStudentFromSpecificCity("Paris");

    assertTrue(result.isEmpty());
  }

  @Test
  void getStudentFromSpecificCityShouldReturnEmptyWhenListIsEmpty() {
    StudentList studentList = new StudentList();

    assertTrue(studentList.getStudentFromSpecificCity("Berlin").isEmpty());
  }

  @Test
  void getStudentFromSpecificCityShouldBeCaseSensitive() {
    StudentList studentList = new StudentList();
    studentList.addStudent(new Student("Alice", "Berlin"));

    List<Student> result = studentList.getStudentFromSpecificCity("berlin");

    assertTrue(result.isEmpty());
  }
}