package com.kodilla.spring.portfolio;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {
    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When & Then
        board.getToDoList().getTasks().add("task to do");
        board.getInProgressList().getTasks().add("task in progress");
        board.getDoneList().getTasks().add("task done");

        System.out.println(board.getToDoList());
        System.out.println(board.getInProgressList());
        System.out.println(board.getDoneList());


// wyświetlenie wszystkich Beanów
//        System.out.println("===== Beans list: ==== >>");
//        Arrays.stream(context.getBeanDefinitionNames())
//                .forEach(System.out::println);
//        System.out.println("<< ===== Beans list ====");
    }
}
