package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task{
    String taskName;
    String color;
    String whatToPaint;
    boolean taskExecuted;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public void executeTask() {
        if (!(taskExecuted)) {
            System.out.println("Task " + taskName + " accepted for execution.");
        } else if (taskExecuted) {
            System.out.println("Task done.");
        } else {
            System.out.println("Task is invalid.");
        }
    }

    @Override
    public String getTaskName() {
        return "Painting Task";
    }

    @Override
    public boolean isTaskExecuted() {
        return taskExecuted;
    }
}
