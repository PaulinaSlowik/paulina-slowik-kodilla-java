package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task{
    String taskName;
    String whatToBuy;
    double quantity;
    boolean taskExecuted;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
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
        return "Shopping Task";
    }

    @Override
    public boolean isTaskExecuted() {
        return taskExecuted;
    }
}
