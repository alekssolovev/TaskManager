package out.service;

import entity.TaskAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import out.repositories.TaskRepo;

import java.util.ArrayList;
import java.util.Date;

public class SearchTaskTest {

    @Mock
    private TaskRepo taskRepo;
    private TaskAccount taskAccount;
    private TaskAccount taskAccount2;

    @InjectMocks
    private SearchTask searchTask;

    @BeforeEach
    public void setUp() {

        taskAccount = new TaskAccount(1,"Name1", "Task1",true,new Date(),"owner1");
        taskAccount2 = new TaskAccount(2,"Name2", "Task2",true,new Date(),"owner2");

        ArrayList<TaskAccount> taskAccounts = new ArrayList<>();
        taskAccounts.add(taskAccount);
        taskAccounts.add(taskAccount2);
        taskRepo = new TaskRepo(taskAccounts);

        searchTask = new SearchTask(taskRepo);


    }

    @Test
    public void searchByPattern(){
        String pattern1 = "Name1";
        searchTask.searchByPattern(pattern1);
        Assertions.assertEquals(taskAccount.getName(), pattern1);


        String pattern2 = "Task2";
        searchTask.searchByPattern("Task2");
        Assertions.assertEquals(taskAccount2.getDescription(), pattern2);

    }

}
