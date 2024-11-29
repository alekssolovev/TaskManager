package out.service;

import entity.TaskAccount;
import in.InputDate;
import in.ReadString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import out.repositories.TaskRepo;

import java.io.IOException;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class CreateTaskTest {
    @Mock
    private TaskRepo taskRepo;
    private TaskAccount taskAccount ;
    private Scanner scanner;
    private InputDate inputDate;
    private ReadString readString;
    private String filePath;

    @InjectMocks
    public CreateTask createTask;

    @BeforeEach
    public void setUp() {
        taskRepo = mock(TaskRepo.class);
        inputDate = mock(InputDate.class);
        readString = mock(ReadString.class);
        taskAccount = mock(TaskAccount.class);
        scanner = new Scanner(System.in);
        filePath = "tempFile";

        // Инициализация объекта CreateTask с замокированными объектами
        createTask = new CreateTask(taskRepo, inputDate, readString, scanner,filePath);
    }

    @Test
    public void testCreate() throws ParseException, IOException {
        // Подготовка данных для теста
        when(inputDate.inputDateFromUser(any(Scanner.class))).thenReturn(new SimpleDateFormat("yyyy-MM-dd").parse("2023-01-01"));
        when(readString.readStringFromUser()).thenReturn("Task Name", "Owner Name");

        // Создадим список для имитации задач в репозитории
        List<TaskAccount> taskAccounts = new ArrayList<>();
        when(taskRepo.getTaskAccounts()).thenReturn((ArrayList<TaskAccount>) taskAccounts);

        // Вызовите метод create
        createTask.create(scanner);


        // Проверьте, что задача была добавлена в репозиторий
        assertEquals(1, taskAccounts.size());
        TaskAccount createdTaskAccount = taskAccounts.get(0);
        assertEquals("Task Name", createdTaskAccount.getName());
        assertEquals("Owner Name", createdTaskAccount.getOwner());
        assertNotNull(createdTaskAccount.getDateOfExec());



        System.out.println("Был создан task id: " + taskAccount.getId()+ " и c именем: "+ taskAccount.getName());

    }

}
