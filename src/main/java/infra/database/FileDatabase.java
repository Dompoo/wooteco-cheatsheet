package infra.database;

import common.exception.MyExceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class FileDatabase<T> implements Database<T> {
	
	private static final String COLUMN_SEPARATOR = ",";
	
	private final String headerLine;
	
	public FileDatabase() {
		try (BufferedReader reader = new BufferedReader(new FileReader(getFilePath()))) {
			headerLine = reader.readLine();
		} catch (IOException e) {
			throw MyExceptions.FILE_NOT_READABLE.get();
		}
	}
	
	@Override
	public List<T> readAll() {
		try (BufferedReader reader = new BufferedReader(new FileReader(getFilePath()))) {
			return buildObjects(reader);
		} catch (IOException e) {
			throw MyExceptions.FILE_NOT_READABLE.get();
		}
	}
	
	private List<T> buildObjects(final BufferedReader reader) throws IOException {
		List<T> objects = new ArrayList<>();
		reader.readLine();
		String line;
		while ((line = reader.readLine()) != null && !line.isBlank()) {
			objects.add(convertLineToObject(mapData(line)));
		}
		return objects;
	}
	
	private Map<String, String> mapData(final String line) {
		String[] datas = line.split(COLUMN_SEPARATOR);
		String[] columns = headerLine.split(COLUMN_SEPARATOR);
		Map<String, String> dataMap = new HashMap<>();
		for (int i = 0; i < columns.length; i++) {
			dataMap.put(columns[i], datas[i]);
		}
		return dataMap;
	}
	
	protected abstract String getFilePath();
	
	protected abstract T convertLineToObject(Map<String, String> dataMap);
}
