package parser;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import models.Parameter;
import models.TestCase;
import models.TestSuite;
import models.Variable;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;

public class XMLParser {

	public static TestSuite testSuiteFromXML(String fileName) {
		try {
			FileInputStream xmlFile = new FileInputStream(fileName);
			Builder builder = new Builder();
			Document doc = builder.build(xmlFile);
			return testSuiteFromXML(doc);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return null;
	}

	public static TestSuite testSuiteFromXML(Document doc) {
		try {
			Element root = doc.getRootElement();
			String machineName = root.getFirstChildElement("machine-name")
					.getValue();
			String operationUnderTest = root.getFirstChildElement(
					"operation-under-test").getValue();
			String partitionStrategy = root.getFirstChildElement(
					"partition-strategy").getValue();
			String combinatorialCriteria = root.getFirstChildElement(
					"combinatorial-criteria").getValue();

			Elements testCasesXML = root.getFirstChildElement("test-cases")
					.getChildElements("test-case");

			List<TestCase> testCases = new ArrayList<TestCase>();

			for (int i = 0; i < testCasesXML.size(); i++) {
				Element testCaseXML = testCasesXML.get(i);

				int id = Integer.parseInt(testCaseXML
						.getFirstChildElement("id").getValue());
				String formula = testCaseXML.getFirstChildElement("formula")
						.getValue();

				Elements stateVariablesXML = testCaseXML.getFirstChildElement(
						"state-variables").getChildElements("variable");
				List<Variable> stateVariables = new ArrayList<Variable>();

				for (int j = 0; j < stateVariablesXML.size(); j++) {
					Element stateXML = stateVariablesXML.get(j);

					String identifier = stateXML.getFirstChildElement(
							"identifier").getValue();
					Elements valuesXML = stateXML
							.getFirstChildElement("values").getChildElements(
									"value");
					List<String> values = new ArrayList<String>();
					for (int k = 0; k < valuesXML.size(); k++) {
						String value = valuesXML.get(k).getValue();
						values.add(value);
					}
					Variable variable = new Variable(identifier, values);
					stateVariables.add(variable);
				}

				Elements operationParametersXML = testCaseXML
						.getFirstChildElement("operation-parameters")
						.getChildElements("parameter");
				List<Parameter> operationParameters = new ArrayList<Parameter>();

				for (int j = 0; j < operationParametersXML.size(); j++) {
					Element parameterXML = operationParametersXML.get(j);
					String identifier = parameterXML.getFirstChildElement(
							"identifier").getValue();
					Elements valuesXML = parameterXML.getFirstChildElement(
							"values").getChildElements("value");
					List<String> values = new ArrayList<String>();
					for (int k = 0; k < valuesXML.size(); k++) {
						String value = valuesXML.get(k).getValue();
						values.add(value);
					}
					Parameter parameter = new Parameter(identifier, values);
					operationParameters.add(parameter);
				}

				Elements returnVariablesXML = testCaseXML.getFirstChildElement(
						"return-variables").getChildElements("variable");
				List<Variable> returnVariables = null;

				if (returnVariablesXML.size() > 0) {
					returnVariables = new ArrayList<Variable>();
					for (int j = 0; j < stateVariablesXML.size(); j++) {
						Element stateXML = returnVariablesXML.get(j);

						String identifier = stateXML.getFirstChildElement(
								"identifier").getValue();

						Variable variable = new Variable(identifier, null);
						returnVariables.add(variable);
					}
				}

				TestCase testCase = new TestCase(id, formula, stateVariables,
						operationParameters, returnVariables);
				testCases.add(testCase);
			}

			TestSuite testSuite = new TestSuite(machineName,
					operationUnderTest, partitionStrategy,
					combinatorialCriteria, testCases);
			return testSuite;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return null;
	}

}
