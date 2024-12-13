package com.example.StudentAccountingApplications.factories;

import com.example.StudentAccountingApplications.dto.Student;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Component;

/** Factory for creating Student instances with unique IDs. */
@Component
public class StudentsFactory {
  private final AtomicLong idCounter = new AtomicLong(0);

  /**
   * Creates a new Student with a unique ID.
   *
   * @param firstName the first name of the student
   * @param lastName the last name of the student
   * @param age the age of the student
   * @return a new Student instance
   */
  public Student create(String firstName, String lastName, int age) {
    return Student.builder()
        .id(idCounter.incrementAndGet())
        .firstName(firstName)
        .lastName(lastName)
        .age(age)
        .build();
  }
}
