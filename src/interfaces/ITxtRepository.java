package interfaces;

import java.io.IOException;
import java.util.ArrayList;

public interface ITxtRepository<T> {

	public T getById(int id) throws IOException;

	public ArrayList<T> get() throws IOException;

	public T insert(T model) throws IOException;

	public T update(T model) throws IOException;

	public void deleteById(int id) throws IOException;
}
