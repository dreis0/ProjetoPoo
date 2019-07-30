package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import exceptions.NotFoundException;

public interface ITxtRepository<T> extends AutoCloseable {

	public T getById(int id) throws IOException, FileNotFoundException, NotFoundException;

	public ArrayList<T> get() throws IOException, FileNotFoundException;

	public T insert(T model) throws IOException, FileNotFoundException;

	public T update(T model) throws IOException, FileNotFoundException;

	public void deleteById(int id) throws IOException;
}
