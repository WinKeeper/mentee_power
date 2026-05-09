package ru.mentee.power;

// Для PR
public class ProgressDemo {

    public static void main(String[] args) {

        MenteeProgress progress =
                new MenteeProgress("Nikita", 1, 6);

        System.out.println(progress.summary());

        if (progress.readyForSprint()) {
            System.out.println("Status: sprint ready");
        } else {
            System.out.println("Status: backlog first");
        }

        System.out.println("Ветка feature/DVT-3");
    }
}