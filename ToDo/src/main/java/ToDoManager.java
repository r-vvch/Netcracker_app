import java.io.*;
import java.util.List;
import java.util.Scanner;

public class ToDoManager {
    /**
     * Записывает существующий список задач в файл
     * @param toDoList - существующий список задач
     * @throws Exception
     */
    public void writeToDoList(ToDoList toDoList) throws Exception {
        FileWriter fw = new FileWriter("to-do.txt");

        // файл начинается с ### <название списка>
        fw.write("### " + toDoList.getName() + "\n");

        List<Task> tasks = toDoList.getTasks();
        for (Task task : tasks) {
            fw.write(task.getName() + "\n" + task.getCompletion() + '\n');
        }

        // файл заканчивается знаком $
        fw.write("$");
        fw.close();
    }

    /**
     * Читает список задач из файла и формирует ToDoList
     * @throws Exception
     */
    public ToDoList readToDoList() throws Exception {
        ToDoList toDoList = new ToDoList();

        FileReader fr = new FileReader("to-do.txt");
        Scanner scan = new Scanner(fr);

        String buf;
        while (scan.hasNextLine()) {
            buf = scan.nextLine();
            if (buf.startsWith("###")) {
                // начало файла --- ### <имя списка>
                toDoList.setName(buf.substring(4));

            } else if (buf.charAt(0) == '$') {
                // конец файла
                fr.close();
                return toDoList;

            } else {
                // новый Task, задаётся id и стандартное имя
                Task newTask = new Task(buf);

                // считывается следующая строчка, где указано выполнение задачи
                String completion = scan.nextLine();
                newTask.setCompletion(Boolean.parseBoolean(completion));

                // добавляется сформированный Task
                toDoList.addTask(newTask);
            }
        }

        fr.close();

        return toDoList;
    }
}
