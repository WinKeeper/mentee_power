package ru.mentee.power.devtools.student;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentListTest {

  @Test
  void addStudent_shouldAddStudent_whenNotNull() {
    StudentList studentList = new StudentList();
    Student student = new Student("John", "Berlin");

    studentList.addStudent(student);

    List<Student> result = studentList.getStudentFromSpecificCity("Berlin");
    assertEquals(1, result.size());
    assertEquals(student, result.get(0));
  }

  @Test
  void addStudent_shouldNotAddStudent_whenNull() {
    StudentList studentList = new StudentList();

    studentList.addStudent(null);

    assertTrue(studentList.getStudentFromSpecificCity("Berlin").isEmpty());
  }

  @Test
  void getStudentFromSpecificCity_shouldReturnCorrectStudents() {
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
  void getStudentFromSpecificCity_shouldReturnEmpty_whenNoMatches() {
    StudentList studentList = new StudentList();
    studentList.addStudent(new Student("Alice", "Berlin"));

    List<Student> result = studentList.getStudentFromSpecificCity("Paris");

    assertTrue(result.isEmpty());
  }

  @Test
  void getStudentFromSpecificCity_shouldReturnEmpty_whenListIsEmpty() {
    StudentList studentList = new StudentList();

    assertTrue(studentList.getStudentFromSpecificCity("Berlin").isEmpty());
  }

  @Test
  void getStudentFromSpecificCity_shouldBeCaseSensitive() {
    StudentList studentList = new StudentList();
    studentList.addStudent(new Student("Alice", "Berlin"));

    List<Student> result = studentList.getStudentFromSpecificCity("berlin");

    assertTrue(result.isEmpty());
  }
}