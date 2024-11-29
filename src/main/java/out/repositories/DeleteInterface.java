package out.repositories;


import java.io.IOException;

/**
 *  Интерфейс содержит переопределяемый метод для удаления задачи
 * @author Sani4
 * @version 1.0
 */
public interface DeleteInterface {

    public void delete(int id) throws IOException;
}
