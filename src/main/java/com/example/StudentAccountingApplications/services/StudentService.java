package com.example.StudentAccountingApplications.services;

import com.example.StudentAccountingApplications.dto.Student;
import com.example.StudentAccountingApplications.events.StudentCreatedEvent;
import com.example.StudentAccountingApplications.events.StudentDeletedEvent;
import com.example.StudentAccountingApplications.factories.StudentsFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Service for managing students.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {
  private final Map<Long, Student> students = new ConcurrentHashMap<>();
  private final ApplicationEventPublisher applicationEventPublisher;
  private final StudentsFactory studentsFactory;

  /**
   * Adds a new student.
   *
   * @param firstName the first name of the student
   * @param lastName  the last name of the student
   * @param age       the age of the student
   * @return the created student
   */
  public Student addStudent(String firstName, String lastName, int age) {
    Student student = studentsFactory.create(firstName, lastName, age);
    students.put(student.getId(), student);
    applicationEventPublisher.publishEvent(new StudentCreatedEvent(student));
    log.info("Added student: {}", student);
    return student;
  }

  /**
   * Deletes a student by ID.
   *
   * @param id the ID of the student to delete
   * @return the deleted student, if found
   */
  public Optional<Student> deleteStudent(Long id) {
    Optional<Student> student = Optional.ofNullable(students.remove(id));
    student.ifPresent(s -> {
      applicationEventPublisher.publishEvent(new StudentDeletedEvent(id));
      log.info("Deleted student: {}", s);
    });
    return student;
  }

  /**
   * Retrieves all students.
   *
   * @return a collection of all students
   */
  public Collection<Student> getAllStudents() {
    return students.values();
  }

  /**
   * Clears all students.
   */
  public void clearAll() {
    students.clear();
    log.info("All students have been removed.");
  }
}
