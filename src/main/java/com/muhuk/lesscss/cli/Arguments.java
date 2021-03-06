package com.muhuk.lesscss.cli;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class Arguments {
	public static Arguments parse(String[] args) {
		Arguments bean = new Arguments();
		CmdLineParser parser = new CmdLineParser(bean);
		try {
			parser.parseArgument(args);
		} catch (CmdLineException e) {
			System.err.println(e.getMessage());
			System.err.println("Usage: java -jar lesscss-cli.jar inputFilename [outputFilename]");
			parser.printUsage(System.err);
			throw new RuntimeException(e);
		}
		return bean;
	}

	@Argument(metaVar="inputFilename", index=0, required=true, usage="LESS file to process")
	private String inputFilename;

	@Argument(metaVar="outputFilename", index=1, required=false, usage="(Optional) CSS output file")
	private String outputFilename;

	public String getInputFilename() {
		return inputFilename;
	}

	public String getOutputFilename() {
		return outputFilename;
	}

	public void setInputFilename(String inputFilename) {
		this.inputFilename = inputFilename;
	}

	public void setOutputFilename(String outputFilename) {
		this.outputFilename = outputFilename;
	}
}
