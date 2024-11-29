package out.repositories;

import entity.TaskAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Date;

public class TaskRepoTest {

    @Mock
    private ArrayList<TaskAccount> tasks;
    private TaskAccount taskAccount1;
    private TaskAccount taskAccount2;

    @InjectMocks
    private TaskRepo taskRepo;

    @BeforeEach
    public void setUp() {
        tasks = new ArrayList<>();
        taskAccount1 = new TaskAccount(1,"newName1", "new task1",true,new Date(),"owner1");
        taskAccount2 = new TaskAccount(2,"newName2", "new task2",false,new Date(),"owner2");
        tasks.add(taskAccount1);
        tasks.add(taskAccount2);

        taskRepo = new TaskRepo(tasks);
    }

    @Test
    public void getTaskAccountById() {
        TaskAccount taskAccount = taskRepo.getTaskAccountById(1);
        Assertions.assertEquals(taskAccount.getId(),taskAccount1.getId());

    }

}
