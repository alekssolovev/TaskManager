package out.repositories;


/**
 *  Интерфейс содержит переопределяемый метод для редактирования задачи
 * @author Sani4
 * @version 1.0
 */
public interface EditInterface {

    public void editTaskById(TaskRepo taskRepo, int id);
}
