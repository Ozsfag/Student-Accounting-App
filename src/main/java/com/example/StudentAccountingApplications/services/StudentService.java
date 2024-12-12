package com.example.StudentAccountingApplications.services;

import com.example.StudentAccountingApplications.dto.Student;
import com.example.StudentAccountingApplications.events.StudentCreatedEvent;
import com.example.StudentAccountingApplications.events.StudentDeletedEvent;
import com.example.StudentAccountingApplications.factories.StudentsFactory;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {
  private final Map<Long, Student> students = new ConcurrentHashMap<>();
  private final ApplicationEventPublisher applicationEventPublisher;
  private final StudentsFactory studentsFactory;

  public Student addStudent(String firstName, String lastName, int age) {
    Student student = studentsFactory.create(firstName, lastName, age);
    students.put(student.getId(), student);
    applicationEventPublisher.publishEvent(new StudentCreatedEvent(student));
    return student;
  }

  public Student deleteStudent(Long id) {
    Student student = students.remove(id);
    if (Objects.nonNull(student))
      applicationEventPublisher.publishEvent(new StudentDeletedEvent(id));
    return student;
  }

  public Collection<Student> getAllStudents() {
    return students.values();
  }

  public void clearAll() {
    students.clear();
  }
}
