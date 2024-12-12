package com.example.StudentAccountingApplications.factories;

import com.example.StudentAccountingApplications.dto.Student;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Component;

@Component
public class StudentsFactory {
  private AtomicLong id = new AtomicLong(0);

  public Student create(String firstName, String lastName, int age) {
    return Student.builder()
        .id(id.incrementAndGet())
        .firstName(firstName)
        .lastName(lastName)
        .age(age)
        .build();
  }
}
