package ru.mentee.power.devtools.progress;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProgressLoopTest {

  @Test
  void calculateTotalProgress_shouldReturnMessage_whenArrayIsNull() {
    ProgressTracker tracker = new ProgressTracker();

    String result = tracker.calculateTotalProgress(null);

    assertEquals("Array is empty or NULL", result);
  }

  @Test
  void calculateTotalProgress_shouldReturnMessage_whenArrayIsEmpty() {
    ProgressTracker tracker = new ProgressTracker();

    String result = tracker.calculateTotalProgress(new Mentee[]{});

    assertEquals("Array is empty or NULL", result);
  }

  @Test
  void calculateTotalProgress_shouldCalculateCorrectly_forSingleMentee() {
    ProgressTracker tracker = new ProgressTracker();

    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend разработчик", 5, 12)
    };

    String result = tracker.calculateTotalProgress(mentees);

    assertEquals(
        "Total finished 5 from 12 lessons, left 7 lessons.",
        result
    );
  }

  @Test
  void calculateTotalProgress_shouldCalculateCorrectly_forMultipleMentees() {
    ProgressTracker tracker = new ProgressTracker();

    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend разработчик", 5, 12),
        new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
        new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
    };

    String result = tracker.calculateTotalProgress(mentees);

    assertEquals(
        "Total finished 25 from 36 lessons, left 11 lessons.",
        result
    );
  }

  @Test
  void calculateTotalProgress_shouldHandleZeroProgress() {
    ProgressTracker tracker = new ProgressTracker();

    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend разработчик", 0, 12)
    };

    String result = tracker.calculateTotalProgress(mentees);

    assertEquals(
        "Total finished 0 from 12 lessons, left 12 lessons.",
        result
    );
  }

  @Test
  void calculateTotalProgress_shouldHandleAllCompleted() {
    ProgressTracker tracker = new ProgressTracker();

    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend разработчик", 12, 12)
    };

    String result = tracker.calculateTotalProgress(mentees);

    assertEquals(
        "Total finished 12 from 12 lessons, left 0 lessons.",
        result
    );
  }

  @Test
  void main_shouldRunWithoutErrors() {
    ProgressTracker.main(new String[]{});
  }
}