package io.output;

import io.writer.Writer;

public class OutputHandler {
	
	private final Writer writer;
	private final OutputParser outputParser;
	
	public OutputHandler(
            final Writer writer,
            final OutputParser outputParser
    ) {
		this.writer = writer;
		this.outputParser = outputParser;
	}
}
