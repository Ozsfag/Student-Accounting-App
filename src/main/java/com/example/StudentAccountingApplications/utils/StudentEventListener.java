package com.example.StudentAccountingApplications.utils;

import com.example.StudentAccountingApplications.events.StudentCreatedEvent;
import com.example.StudentAccountingApplications.events.StudentDeletedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StudentEventListener {
  @EventListener
  public void handleStudentCreatedEvent(StudentCreatedEvent event) {
    log.info("New student created: {}", event.getStudent());
  }

  @EventListener
  public void handleStudentDeletedEvent(StudentDeletedEvent event) {
    log.info("Deleted student with ID: {}", event.getStudentId());
  }
}
