package out.service;

import entity.TaskAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import out.repositories.TaskRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class SaveLoadTaskTest {

    @Mock
    private TaskRepo taskRepo;
    private TaskAccount taskAccount;


    @InjectMocks
    private SaveTask saveTask;


    @BeforeEach
    public void setUp() {

        ArrayList<TaskAccount> taskAccounts1 = new ArrayList<>();

        taskAccount = new TaskAccount(1,"newName1", "new task1",true,new Date(),"owner1");
        taskAccounts1.add(taskAccount);
        taskRepo = new TaskRepo(taskAccounts1);

    }

    @Test
    public void testSaveTask() throws IOException {

        saveTask = new SaveTask(taskRepo);
        String filePath = "tempFile";

        LoadTask loadTask = new LoadTask(filePath);

        saveTask.save(taskRepo,filePath);

        TaskRepo loadRepo = loadTask.load();

        Assertions.assertEquals(loadRepo.getTaskAccountById(1), taskAccount);

    }



}
