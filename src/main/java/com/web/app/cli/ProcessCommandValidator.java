package com.web.app.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

import java.util.Arrays;

public class ProcessCommandValidator implements IParameterValidator  {

	@Override
	public void validate(String name, String value) throws ParameterException {
		if (!Arrays.asList(
				"download-data",
				"load-data-to-database")
				.contains(value))
			throw new ParameterException("Invalid --process parameter value, run with --help option to see valid values");
		
	}
	
	

}
