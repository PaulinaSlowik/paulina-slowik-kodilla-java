package com.kodilla.stream.portfolio;

import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class BoardTestSuite {
    public Board prepareTestData() {
        //users
        User user1 = new User("developer1", "John Smith");
        User user2 = new User("projectmanager1", "Nina White");
        User user3 = new User("developer2", "Emilia Stephanson");
        User user4 = new User("developer3", "Konrad Bridge");
        //tasks
        Task task1 = new Task("Microservice for taking temperature",
                "Write and test the microservice taking\n" +
                        "the temperaure from external service",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(30));
        Task task2 = new Task("HQLs for analysis",
                "Prepare some HQL queries for analysis",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().minusDays(5));
        Task task3 = new Task("Temperatures entity",
                "Prepare entity for temperatures",
                user3,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(15));
        Task task4 = new Task("Own logger",
                "Refactor company logger to meet our needs",
                user3,
                user2,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(25));
        Task task5 = new Task("Optimize searching",
                "Archive data searching has to be optimized",
                user4,
                user2,
                LocalDate.now(),
                LocalDate.now().plusDays(5));
        Task task6 = new Task("Use Streams",
                "use Streams rather than for-loops in predictions",
                user4,
                user2,
                LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(2));
        //taskLists
        TaskList taskListToDo = new TaskList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);
        TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);
        //board
        Board project = new Board("Project Weather Prediction");
        project.addTaskList(taskListToDo);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);
        return project;
    }

    @Test
    // test - sprawdza czy w tablicy project typu Board zostały zdefiniowane trzy listy zadań
    public void testAddTaskList() {
        //Given
        Board project = prepareTestData();
        //When

        //Then
        Assert.assertEquals(3, project.getTaskLists().size());
    }
    //test wyszukujący zadania przypisane do użytkownika "developer1" znajdujący się na wszystkich listach zadań
    //wyszukiwanie zadań użytkownika
    @Test
    public void testAddTaskListFindUsersTasks(){
        //Given
        Board project = prepareTestData();
        //When
        //tworzymy obiekt klasy User, który będzie posiadał pole username wypełnione tekstem "developer1" -
        //metoda equals(Object o) porównuje właśnie to pole, więc taki użytkownik testowy jest nam potrzebny, aby go odnaleźć w zadaniach
        User user = new User("developer1", "John Smith");
        //uruchamiamy strumień na kolekcji getTaskLists() obiektu Board.
        //Wynik działania strumienia, po jego zakończeniu, zostanie przypisany do kolekcji tasks,
        //będącej listą zadań typu Task
        List<Task> tasks = project.getTaskLists().stream()
                //spłaszczamy strumień - na wejściu mamy strumień list zadań, chcemy uzyskać strumień zadań (a nie list zadań),
                //wobec czego do strumienia wyjściowego przekazujemy listy zadań z poszczególnych list, spłaszczając strumień przy pomocy flatMap()
                .flatMap(l -> l.getTasks().stream())
                //filtrujemy strumień (w strumieniu wejściowym są zadania typu Task) przy pomocy wyrażenia lambda t -> t.getAssignedUser().equals(user),
                //zwracającego true lub false w zależności od tego czy użytkownicy są sobie równi (w sensie równości pola username - bo tak sprawdza to metoda equals(Object o),
                //klasy User). Do strumienia wyjściowego trafią więc tylko te zadania, które mają przypisanego użytkownika "developer1"
                .filter(t -> t.getAssignedUser().equals(user))
                //tworzymy kolekcję wynikową przy pomocy kolektora collect(), kolekcja ta przypisywana jest do zmiennej tasks
                .collect(toList());
        //Then
        //Asercja sprawdza czy znaleziono dokładnie dwa takie zadania
        Assert.assertEquals(2, tasks.size());
        //Asercje sprawdzają czy na pewno w obu tych zadaniach przypisanym użytkownikiem jest "developer1".
        Assert.assertEquals(user, tasks.get(0).getAssignedUser());
        Assert.assertEquals(user, tasks.get(1).getAssignedUser());
    }

    //wyszukiwanie przeterminowanych zadań
    //przeterminowane zadania mogą być jedynie na listach  "To Do" oraz "In Progress"
    //porównywanie daty getDeadline() z aktualną datą systemową
    @Test
    public void testAddTaskListFindOutdatedTasks(){
        //Given
        Board project = prepareTestData();

        //When
        //tworzymy roboczą listę "list zadań" o nazwie undoneTasks - przypisujemy do niej dwie puste listy zadań o nazwach zgodnych z nazwami list, w których przechowujemy niewykonane zadania.
        //Metoda equals(Object o) klasy TaskList porównuje właśnie nazwy list aby stwierdzić czy to ta sama lista.
        List<TaskList> undoneTasks = new ArrayList<>();
        undoneTasks.add(new TaskList("To do"));
        undoneTasks.add(new TaskList("In progress"));
        //tworzymy i uruchamiamy strumień na kolekcji getTaskLists() klasy Board. Po zakończeniu działania strumienia, jego kolekcja wynikowa zostanie przypisana do zmiennej tasks.
        List<Task> tasks = project.getTaskLists().stream()
                //dokonujemy odfiltrowania tylko tych list zadań, które zawierają niewykonane zadania. Wiemy, że są to listy "To Do" oraz "In Progress".
                //Mamy takie listy zapisane w kolekcji undoneTasks. Wskazujemy więc referencję do metody undoneTasks::contains -
                //jako parametr zostanie przekazana każda kolejna lista zadań zwracana przez metodę getTaskLists klasy Board.
                //Do strumienia wyjściowego trafią jedynie te listy, które zapisane są w roboczej liście undoneTasks.
                .filter(undoneTasks::contains)
                //dokonujemy spłaszczenia strumienia w taki sposób, że do strumienia wyjściowego trafią już konkretne zadania z lista zadań, zamiast obiektów reprezentujących te listy.
                .flatMap(tl -> tl.getTasks().stream())
                //sprawdzamy dla każdego zadania czy jego data pobrana metodą getDeadline() nie jest wcześniejsza niż bieżąca data systemowa.
                //Do tego celu wykorzystujemy metodę isBefore(LocalDate date) klasy LocalDate - zwraca ona true gdy data zapisana w obiekcie,
                //którego metodę wywołujemy jest wcześniejsza niż data zapisana w obiekcie podanym jako argument. Do strumienia wyjściowego trafią jedynie te zadania, których data realizacji upłynęła.
                .filter(t -> t.getDeadline().isBefore(LocalDate.now()))
                //generujemy kolekcję wynikową przy pomocy kolektora collect() - kolekcja ta zawiera przeterminowane zadania i jest wstawiana do zmiennej tasks.
                .collect(toList());

        //Then
        //Asercja sprawdza czy znaleziono dokładnie jedno przeterminowane zadanie
        Assert.assertEquals(1, tasks.size());
        //Asercja porównuje, czy znalezione zadanie jest rzeczywiście tym przeterminowanym
        Assert.assertEquals("HQLs for analysis", tasks.get(0).getTitle());
    }
    @Test
        public void testAddTaskListFindLongTasks(){
        //Given
        Board project = prepareTestData();

        //When
        //tworzona jest robocza lista inProgressTasks, zawierająca listy zadań, które są w trakcie realizacji (tu: jedna lista o nazwie "In Progress")
        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        //uruchamiany jest strumień na kolekcji getTaskLists() klasy Board. Wynik jego realizacji będzie po wykonaniu przypisany do skalarnej zmiennej longTasks typu long
        long longTasks = project.getTaskLists().stream()
                //odfiltrowywana jest lista zawierająca zadania w trakcie realizacji
                .filter(inProgressTasks::contains)
                //dokonujemy spłaszczenia strumienia - z list zadań przechodzimy na konkretne zadania zawarte w listach
                .flatMap(tl -> tl.getTasks().stream())
                //wykonujemy transformację strumienia - z wejściowego strumienia zadań, przekształcamy go w strumień dat typu LocalDate mówiących o tym, kiedy zadanie zostało utworzone.
                .map(t -> t.getCreated())
                //wykorzystujemy metodę compareTo(LocalDate date) klasy LocalDate, aby sprawdzić czy różnica pomiędzy datą utworzenia zadania,
                //a bieżącą datą systemową (pomniejszoną o 10 dni przy pomocy metody minusDays(long days) jest mniejsza od zera, równa zeru lub większa od zera (metoda compareTo(LocalDate date)
                //zwraca wartości: -1 gdy data jest mniejsza, 0 gdy daty są równelub 1 gdy data jest większa).
                //Do strumienia wyjściowego trafią tylko te daty, które są starsze (lub równe) niż 10 dni wcześniej - przed bieżącą datą
                .filter(d -> d.compareTo(LocalDate.now().minusDays(10)) <= 0)
                //zliczamy ilość elementów w strumieniu przy pomocy kolektora skalarnego count(), który zwraca ilość elementów w strumieniu
                .count();

        //Then
        //Asercja sprawdza czy znaleziono dokładnie dwa takie zadania
        Assert.assertEquals(2, longTasks);
    }
}