package com.web.app.cli;

import com.beust.jcommander.IStringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateParamConverter implements IStringConverter<LocalDate>{

	@Override
	public LocalDate convert(String value) {
		return LocalDate.parse(value, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
	}
}
