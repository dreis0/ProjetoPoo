package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import exceptions.NotFoundException;

public interface IRepository<T> extends AutoCloseable {

	public T getById(int id) throws IOException, FileNotFoundException, NotFoundException, ParseException;

	public ArrayList<T> get() throws IOException, FileNotFoundException, ParseException;

	public T insert(T model) throws IOException, FileNotFoundException;

	public T update(T model) throws IOException, FileNotFoundException, ParseException;

	public void deleteById(int id) throws IOException, ParseException;
}
