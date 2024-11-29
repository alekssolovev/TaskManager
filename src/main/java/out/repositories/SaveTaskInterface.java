package out.repositories;

import java.io.IOException;

public interface SaveTaskInterface {

    public void save(TaskRepo tasks,String filePath) throws IOException;
}
