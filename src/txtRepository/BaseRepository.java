package txtRepository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import exceptions.NotFoundException;
import interfaces.IRepository;
import model.Queryable;
import utils.Strings;

public abstract class BaseRepository<T> implements IRepository<T>, AutoCloseable {

	protected BufferedWriter writer;
	protected BufferedReader reader;
	protected String fileName;

	protected BaseRepository(String fileName) throws FileNotFoundException, IOException {
		this.fileName = fileName;
		this.writer = new BufferedWriter(new FileWriter(fileName, true));
		this.reader = new BufferedReader(new FileReader(fileName));
	}

	protected abstract int id() throws IOException, FileNotFoundException;

	protected abstract String mapToFieldsString(T model) throws IOException, FileNotFoundException;

	protected abstract T mapToModel(String fieldsString) throws IOException, FileNotFoundException, ParseException;

	protected void insertAll(ArrayList<T> list) throws IOException, FileNotFoundException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

		for (T item : list)
			writer.append(mapToFieldsString(item));

		writer.close();
	}

	@Override
	public T getById(int id) throws IOException, FileNotFoundException, NotFoundException, ParseException {
		ArrayList<T> list = get();

		for (T item : list) {
			if (((Queryable) item).getId() == id)
				return item;
		}

		throw new NotFoundException("Usuário");
	}

	@Override
	public ArrayList<T> get() throws IOException, FileNotFoundException, ParseException {
		ArrayList<T> list = new ArrayList<T>();

		reader = new BufferedReader(new FileReader(fileName));

		String currentLine;
		while ((currentLine = reader.readLine()) != null) {
			list.add(mapToModel(currentLine));
		}

		return list;
	}

	@Override
	public T insert(T model) throws IOException, FileNotFoundException {
		BufferedWriter buffWriter = new BufferedWriter(new FileWriter(fileName, true));

		buffWriter.append(mapToFieldsString(model));
		buffWriter.close();
		return model;
	}

	@Override
	public T update(T model) throws IOException, FileNotFoundException, ParseException {
		ArrayList<T> updated = new ArrayList<T>();
		ArrayList<T> itens = get();

		for (T item : itens) {

			if (((Queryable) item).getId() != ((Queryable) model).getId()) {
				updated.add(item);
			} else {
				updated.add(model);
			}
		}

		insertAll(updated);
		return model;
	}

	@Override
	public void deleteById(int id) throws IOException, ParseException {
		BufferedReader buffReader = new BufferedReader(new FileReader(fileName));
		ArrayList<T> list = new ArrayList<T>();

		String currentLine;

		while ((currentLine = buffReader.readLine()) != null) {
			String[] fields = currentLine.split(Strings.DELIMITADOR);

			if (Integer.parseInt(fields[0]) != id)
				list.add(mapToModel(currentLine));
		}

		insertAll(list);
	}

	@Override
	public void close() throws Exception {
		writer.close();
		reader.close();
	}
}
