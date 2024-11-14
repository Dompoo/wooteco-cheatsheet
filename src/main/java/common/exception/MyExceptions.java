package common.exception;

public enum MyExceptions {
	
	INVALID_PURCHASE_FORMAT(
			"올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요.",
			IllegalArgumentException.class
	),
	ILLEGAL_ARGUMENT(
			"잘못된 입력입니다. 다시 입력해 주세요.",
			IllegalArgumentException.class
	),
	OVER_MAX_RETRY_ATTEPMT(
			"최대 재시도 회수를 초과했습니다.",
			IllegalStateException.class
	),
	FILE_NOT_READABLE(
			"파일 읽기 중 오류가 발생했습니다.",
			IllegalStateException.class
	),
	;
	
	private final String message;
	private final Class<? extends RuntimeException> exceptionType;
	
	MyExceptions(String message, Class<? extends RuntimeException> exceptionType) {
		this.message = message;
		this.exceptionType = exceptionType;
	}
	
	public RuntimeException get() {
		try {
			return exceptionType.getDeclaredConstructor(String.class).newInstance(message);
		} catch (Exception e) {
			return new RuntimeException(message);
		}
	}
}
