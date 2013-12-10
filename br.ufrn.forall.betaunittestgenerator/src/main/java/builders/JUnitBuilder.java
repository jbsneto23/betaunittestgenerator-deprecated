package builders;

import java.util.List;

import models.Parameter;
import models.TestSuite;

public class JUnitBuilder extends UnitTestBuilder {

	public String variableDeclaration(String formula, String identifier) {
		String type = valueType(formula, identifier);

		String declaration = "";

		String typeSet = type.split(" ")[0];
		boolean isSet = type.split(" ")[1].equals("<:");

		if (typeSet.equals("INT") || typeSet.equals("NAT") || typeSet.equals("NAT1")
				|| typeSet.equals("INTEGER") || typeSet.equals("NATURAL")
				|| typeSet.contains("MAXINT") || typeSet.contains("MININT")
				|| typeSet.contains("..")) {
			declaration = "int";
		} else if (typeSet.equals("BOOL")) {
			declaration = "boolean";
		} else if(typeSet.equals("STRING")) {
			declaration = "String";
		} else {
			declaration = typeSet;
		}

		if (isSet) {
			declaration = declaration + "[]";
		}

		declaration = declaration + " " + identifier;

		return declaration;
	}
	
	public String variableAttribution(String formula, String identifier,
			List<String> values) {
		String type = valueType(formula, identifier);

		String attribution = "";

		boolean isSet = type.split(" ")[1].equals("<:");

		if (isSet) {
			if (values.get(0).equals("{-}")) {
				attribution = attribution + "{}";
			} else {
				attribution = attribution + "{" + values.get(0);
				for (int i = 1; i < values.size(); i++) {
					attribution = attribution + ", " + values.get(i);
				}
				attribution = attribution + "}";
			}
		} else {
			attribution = attribution + values.get(0);
		}

		return attribution;
	}

	public String setCall(String objectName, String identifier) {
		String call = objectName + ".set"
				+ Character.toUpperCase(identifier.charAt(0))
				+ identifier.substring(1) + "(" + identifier + ")";
		return call;
	}

	public String getCall(String objectName, String identifier) {
		String call = objectName + ".get"
				+ Character.toUpperCase(identifier.charAt(0))
				+ identifier.substring(1) + "()";
		return call;
	}
	
	public String operationCall(String objectName, String operation, List<Parameter> parameters){
		String call = objectName + "." + operation + "(";
		if(!parameters.isEmpty()){
			call = call + parameters.get(0).getIdentifier();
			for(int i = 1; i < parameters.size(); i++){
				call = call + ", " + parameters.get(i).getIdentifier();
			}
		}
		call = call + ")";
		return call;
	}

	public String testContent(TestSuite testSuite) {
		String content = templates.txt.JUnitTemplate.render(this, testSuite)
				.toString();
		return content;
	}
	
	public String className(TestSuite testSuite){
		return testSuite.getMachineName()
				+ Character.toUpperCase(testSuite.getOperationUnderTest()
						.charAt(0))
				+ testSuite.getOperationUnderTest().substring(1) + "Test";
	}

	public String testOutputName(TestSuite testSuite) {
		return className(testSuite) + ".java";
	}

}
