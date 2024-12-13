package com.example.StudentAccountingApplications.utils;

import com.example.StudentAccountingApplications.events.StudentCreatedEvent;
import com.example.StudentAccountingApplications.events.StudentDeletedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/** Listener for student-related events. */
@Component
@Slf4j
public class StudentEventListener {

  /**
   * Handles the event when a new student is created.
   *
   * @param event the event containing the created student
   */
  @EventListener
  public void handleStudentCreatedEvent(StudentCreatedEvent event) {
    log.info("New student created: {}", event.getStudent());
  }

  /**
   * Handles the event when a student is deleted.
   *
   * @param event the event containing the ID of the deleted student
   */
  @EventListener
  public void handleStudentDeletedEvent(StudentDeletedEvent event) {
    log.info("Deleted student with ID: {}", event.getStudentId());
  }
}
