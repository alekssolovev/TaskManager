package out.service;

import entity.TaskAccount;
import in.InputDate;
import in.ReadString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import out.repositories.TaskRepo;

import java.util.*;

import static org.mockito.Mockito.mock;


public class EditTaskTest {

    @Mock
    private TaskRepo taskRepo;
    private TaskAccount taskAccount;
    private InputDate inputDate;
    private ReadString readString;
    private Scanner scanner;
    private String filePath;

    @InjectMocks
    private EditTask editTask;

    @BeforeEach
    public void setUp() {

        inputDate = mock(InputDate.class);
        readString = mock(ReadString.class);
        taskAccount = mock(TaskAccount.class);
        scanner = mock(Scanner.class);
    }

    @Test
    public void editTask() {

        ArrayList<TaskAccount> taskAccounts = new ArrayList<>();
        taskAccounts.add(taskAccount);
        taskRepo = new TaskRepo(taskAccounts);
        filePath = "tempFile";
        editTask = new EditTask(taskRepo,inputDate,readString,scanner);

        Assertions.assertThrows(NullPointerException.class, () -> editTask.editTask("name",2,filePath));
        Assertions.assertThrows(NullPointerException.class, () -> editTask.editTask("date",1,filePath));
        Assertions.assertThrows(NullPointerException.class, () -> editTask.editTask("description",1,filePath));
        Assertions.assertThrows(NullPointerException.class, () -> editTask.editTask("name",1,filePath));
        Assertions.assertThrows(NullPointerException.class, () -> editTask.editTask("status",1,filePath));

    }



}
