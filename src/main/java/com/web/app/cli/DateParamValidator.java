package com.web.app.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateParamValidator implements IParameterValidator  {

	@Override
	public void validate(String name, String value) throws ParameterException {
		if (!value.isEmpty()) {
			try {
				LocalDate.parse(value, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
			} catch (DateTimeParseException e) {
				throw new ParameterException(String.format("\"%s\" is not a Invalid value for param \"%s\"", value, name));
			}
		}
	}
}
