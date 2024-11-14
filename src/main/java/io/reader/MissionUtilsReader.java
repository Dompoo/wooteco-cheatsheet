package io.reader;

import camp.nextstep.edu.missionutils.Console;
import common.exception.MyExceptions;

import java.util.Arrays;
import java.util.List;

public class MissionUtilsReader implements Reader {
	
	@Override
	public List<String> readLineAsStrings(final String spliter) {
		try {
			String input = Console.readLine();
			return Arrays.asList(input.split(spliter));
		} catch (IllegalArgumentException e) {
			throw MyExceptions.ILLEGAL_ARGUMENT.get();
		}
	}
	
	@Override
	public String readLineAsString() {
		try {
			return Console.readLine();
		} catch (IllegalArgumentException e) {
			throw MyExceptions.ILLEGAL_ARGUMENT.get();
		}
	}
}
