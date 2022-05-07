package io.slimmens.entregafinal.utils;

import org.apache.commons.lang3.StringUtils;

public class ValidationUtils {

	public static <T> T isNotNull(T value, String message) {
		if (value == null) {
			throw new IllegalArgumentException(message);
		}

		return value;
	}

	public static String isNotBlank(String value, String message) {
		if (StringUtils.isBlank(value)) {
			throw new IllegalArgumentException(message);
		}

		return value;
	}

	public static Integer isGreaterThan(Integer value, int reference, String message) {
		if (value == null) {
			throw new IllegalArgumentException(message);
		}

		if (value < reference) {
			throw new IllegalArgumentException(message);
		}

		return value;
	}

	public static Double isGreaterThan(Double value, int reference, String message) {
		if (value == null) {
			throw new IllegalArgumentException(message);
		}

		if (value < reference) {
			throw new IllegalArgumentException(message);
		}

		return value;
	}

	public static Integer isPositive(Integer value, String message) {
		return isGreaterThan(value, 0, message);
	}

	public static Double isPositive(Double value, String message) {
		return isGreaterThan(value, 0, message);
	}
}
