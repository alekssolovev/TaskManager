package out.repositories;

import entity.TaskAccount;

import java.io.IOException;
import java.util.ArrayList;

public interface LoadTaskInterface {

    public TaskRepo load() throws IOException;
}
