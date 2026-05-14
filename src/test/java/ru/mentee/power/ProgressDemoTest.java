package ru.mentee.power;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ProgressDemoTest {

  @Test
  void testSummary() {
    MenteeProgress progress = new MenteeProgress("Nikita", 1, 6);
    assertEquals("Sprint 1 -> Nikita: planned 6 h", progress.summary());
  }

  @Test
  void testReadyForSprint() {
    MenteeProgress ready = new MenteeProgress("Ready", 1, 3);
    MenteeProgress notReady = new MenteeProgress("NotReady", 1, 2);

    assertTrue(ready.readyForSprint());
    assertFalse(notReady.readyForSprint());
  }
}