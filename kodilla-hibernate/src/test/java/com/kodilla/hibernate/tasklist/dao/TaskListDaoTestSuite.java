package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    private static final String LISTNAME = "Test: List name, Task 17.2";
    private static final String DESCRIPTION = "Test: Learn Hibernate, Task 17.2";

    @Test
    public void testFindByListName() {
        //Given
        TaskList taskList = new TaskList(LISTNAME,DESCRIPTION);
        taskListDao.save(taskList);
        String listName = taskList.getListName();

        //When
        List<TaskList> readTaskLists = taskListDao.findByListName(listName);

        //Then
        Assert.assertEquals("Test: List name, Task 17.2",readTaskLists.get(0).getListName());
//        Assert.assertEquals(1,readTaskLists.size());

        //CleanUp
        int id = readTaskLists.get(0).getId();
        taskListDao.deleteById(id);
    }
    @Test
    public void testTaskListDaoSaveWithTasks() {
        //Given
        Task task = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);
        TaskList taskList = new TaskList(LISTNAME, "ToDo tasks");
        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);
        task.setTaskList(taskList);
        task2.setTaskList(taskList);

        //When
        //wykonujemy właściwy test, czyli zapisujemy do bazy danych encję taskList przy pomocy kontrolera repozytorium
        taskListDao.save(taskList);
        //Zapamiętujemy id jakie zostało mu nadane przez Hibernate
        int id = taskList.getId();

        //Then
        //sprawdzamy czy id zostało nadane
        Assert.assertNotEquals(0, id);

        //CleanUp
        //taskListDao.deleteById(id);
    }
}