package io.input;

import io.reader.Reader;
import io.writer.Writer;

public class InputHandler {
	
	private final Reader reader;
	private final Writer writer;
	private final InputParser inputParser;
	private final InputValidator inputValidator;
	
	public InputHandler(
			final Reader reader,
			final Writer writer,
			final InputParser inputParser,
			final InputValidator inputValidator
	) {
		this.reader = reader;
		this.writer = writer;
		this.inputParser = inputParser;
		this.inputValidator = inputValidator;
	}
	
}
