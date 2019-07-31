package txtRepository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import interfaces.ITxtRepository;

public abstract class BaseRepository<T> implements ITxtRepository<T>, AutoCloseable {

	protected BufferedWriter writer;
	protected BufferedReader reader;
	
	protected BaseRepository(String fileName) 
			throws FileNotFoundException, IOException {
		this.writer = new BufferedWriter(new FileWriter(fileName, true));
		this.reader = new BufferedReader(new FileReader(fileName));
	}

	protected abstract void insertAll(ArrayList<T> list) throws IOException, FileNotFoundException;
	
	@Override
	public void close() throws Exception {
		writer.close();
		reader.close();
	}
}
