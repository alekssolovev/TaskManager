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

public class TaskAnalysisTest {

    @Mock
    private TaskRepo taskRepo;
    private TaskAccount taskAccount;
    private  TaskAccount taskAccount2;
    private TaskAccount taskAccount3;
    private TaskAccount taskAccount4;

    @InjectMocks
    private TaskAnalysis taskAnalysis;


    @BeforeEach
    public void setUp(){

        taskAccount = new TaskAccount(1,"Name1", "Task1",true,new Date(),"owner1");
        taskAccount2 = new TaskAccount(2,"Name2", "Task2",true,new Date(),"owner2");
        taskAccount3 = new TaskAccount(3,"Name3", "Task3",true,new Date(),"owner3");
        taskAccount4 = new TaskAccount(4,"Name4", "Task4",false,new Date(),"owner4");

        ArrayList<TaskAccount> taskAccounts = new ArrayList<>();
        taskAccounts.add(taskAccount);
        taskAccounts.add(taskAccount2);
        taskAccounts.add(taskAccount3);
        taskAccounts.add(taskAccount4);
        taskRepo = new TaskRepo(taskAccounts);

        taskAnalysis = new TaskAnalysis(taskRepo);


    }

    @Test
    public void displayTaskStat(){

        taskAnalysis.displayTaskStat();

        Assertions.assertEquals(taskRepo.getTaskAccounts().size(),4);

    }


}
