package ru.mentee.power;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MenteeProgressTest {

  @Test
  void summaryReturnsFormattedString() {
    MenteeProgress progress = new MenteeProgress("Nikita", 1, 6);
    assertEquals("Sprint 1 -> Nikita: planned 6 h", progress.summary());
  }

  @ParameterizedTest
  @CsvSource({
      "0, false",
      "2, false",
      "3, true",
      "5, true"
  })
  void readyForSprintDependsOnHours(int hours, boolean expected) {
    MenteeProgress progress = new MenteeProgress("Test", 1, hours);
    assertEquals(expected, progress.readyForSprint());
  }

  @Test
  void recordsWithSameValuesAreEqual() {
    MenteeProgress p1 = new MenteeProgress("Nikita", 1, 6);
    MenteeProgress p2 = new MenteeProgress("Nikita", 1, 6);

    assertEquals(p1, p2);
  }
}