package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task{
    String taskName;
    String where;
    String using;
    boolean taskExecuted;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
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
        return "Driving Task";
    }

    @Override
    public boolean isTaskExecuted() {
        return taskExecuted;
    }
}
