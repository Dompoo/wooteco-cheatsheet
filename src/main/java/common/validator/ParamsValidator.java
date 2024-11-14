package common.validator;


import common.exception.MyExceptions;

import java.util.Objects;

public class ParamsValidator {
	
	public static void validateParamsNotNull(final Object... params) {
		for (Object obj : params) {
			if (Objects.isNull(obj)) {
				throw MyExceptions.ILLEGAL_ARGUMENT.get();
			}
		}
	}
}
