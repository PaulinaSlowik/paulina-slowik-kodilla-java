package com.kodilla.hibernate.task;

import com.kodilla.hibernate.tasklist.TaskList;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@NamedQueries({
        @NamedQuery(name = "Task.retrieveLongTasks",
                query = "FROM Task WHERE duration >10"),
        @NamedQuery(name = "Task.retrieveShortTasks",
                query = "FROM Task WHERE duration <=10"),
        @NamedQuery(name = "Task.retrieveTasksWithDurationLongerThan",
                query = "FROM Task WHERE duration> :DURATION")
})

@NamedNativeQuery(
        name = "Task.retrieveTasksWithEnoughTime",
        query = "SELECT * FROM TASKS " +
                "WHERE DATEDIFF(DATE_ADD(CREATED, INTERVAL DURATION DAY),NOW())>5",
        resultClass = Task.class
)
@Entity
@Table(name = "TASKS")
public class Task {
    private int id;
    private String description;//opis zadania
    private Date created;//data utworzenia zadania, Utworzenie nowego obiektu klasy Date automatycznie inicjuje go na bieżącą datę
    private int duration;//czas trwania zadania
    private TaskFinancialDetails taskFinancialDetails;
    private TaskList taskList;//informuje do której listy należy zadanie

    public Task() {
    }

    public Task(String description, int duration) {
        this.description = description;
        this.created = new Date();
        this.duration = duration;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name= "ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @NotNull
    @Column(name= "CREATED")
    public Date getCreated() {
        return created;
    }

    @Column (name= "DURATION")
    public int getDuration() {
        return duration;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "TASK_FINANCIALS_ID")
    public TaskFinancialDetails getTaskFinancialDetails() {
        return taskFinancialDetails;
    }

    @ManyToOne
    @JoinColumn(name = "TASKLIST_ID")
    public TaskList getTaskList() {
        return taskList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setTaskFinancialDetails(TaskFinancialDetails taskFinancialDetails) {
        this.taskFinancialDetails = taskFinancialDetails;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }
}