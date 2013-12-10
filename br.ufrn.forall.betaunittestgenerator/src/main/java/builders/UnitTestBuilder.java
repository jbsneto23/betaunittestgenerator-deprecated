package builders;

import java.io.FileOutputStream;
import java.io.PrintStream;

import models.OracleStrategy;
import models.TestSuite;
import parser.XMLParser;

public abstract class UnitTestBuilder {

	public abstract String testContent(TestSuite testSuite);
	
	public abstract String testOutputName(TestSuite testSuite);

	public void generateUnitTest(String fileName, String outputPath) {
		TestSuite testSuite = XMLParser.testSuiteFromXML(fileName);
		String content = testContent(testSuite);
		String fileOutputName = testOutputName(testSuite);
		try {
			FileOutputStream f;
			f = new FileOutputStream(outputPath + fileOutputName);
			PrintStream ps = new PrintStream(f);
			ps.println(content);
			f.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public void generateUnitTest(String fileName, String outputPath, OracleStrategy oracleStrategy) {
		TestSuite testSuite = XMLParser.testSuiteFromXML(fileName);
		testSuite.setOracleStrategy(oracleStrategy);
		String content = testContent(testSuite);
		String fileOutputName = testOutputName(testSuite);
		try {
			FileOutputStream f;
			f = new FileOutputStream(outputPath + fileOutputName);
			PrintStream ps = new PrintStream(f);
			ps.println(content);
			f.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	protected String valueType(String formula, String identifier) {
		String[] predicates = formula.split("&");
		for (int i = 0; i < predicates.length; i++) {
			predicates[i] = predicates[i].trim();
		}
		String variableType = ":";
		String variableSet = identifier;
		for (String p : predicates) {
			String[] s = p.split(" ");
			if (s[0].trim().equals(identifier) && (s[1].trim().equals(":") || s[1].trim().equals("<:"))) {
				variableType = s[1];
				variableSet = s[2];
				break;
			}
		}
		return variableSet + " " + variableType;
	}

}
