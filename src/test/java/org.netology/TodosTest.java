package org.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();

        assertArrayEquals(expected, actual);
    }
    @Test
    public  void shouldFindTaskByQuery(){
        SimpleTask simpleTask = new SimpleTask(5 ,"Купить хлеб");
        String[] subtasks = {"Купить молоко","Купить яйца"};
        Epic epic = new Epic(7, subtasks);

        Meeting meeting = new Meeting(6,
                "Встреча в Москве",
                "Обсуждение проекта",
                "В 12:30");
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        //todos.add(meeting);

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("Купить");

        assertArrayEquals(expected, actual);
    }

}
