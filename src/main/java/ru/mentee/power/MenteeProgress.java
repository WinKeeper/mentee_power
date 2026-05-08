package ru.mentee.power;

public record MenteeProgress(
        String menteeName,
        int sprintNumber,
        int plannedHoursPerWeek
) {

    public String summary() {
        return "Sprint %d -> %s: planned %d h"
                .formatted(sprintNumber, menteeName, plannedHoursPerWeek);
    }

    public boolean readyForSprint() {
        return plannedHoursPerWeek >= 3;
    }
}