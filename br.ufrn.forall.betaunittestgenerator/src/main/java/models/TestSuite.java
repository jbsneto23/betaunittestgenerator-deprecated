package models;

import java.util.List;

public class TestSuite {
	
	private String machineName;
	private String operationUnderTest;
	private String partitionStrategy;
	private String combinatorialCriteria;
	private List<TestCase> testCases;
	private OracleStrategy oracleStrategy;
	
	public TestSuite(String machineName, String operationUnderTest,
			String partitionStrategy, String combinatorialCriteria,
			List<TestCase> testCases) {
		this.machineName = machineName;
		this.operationUnderTest = operationUnderTest;
		this.partitionStrategy = partitionStrategy;
		this.combinatorialCriteria = combinatorialCriteria;
		this.testCases = testCases;
		this.oracleStrategy = OracleStrategy.STATE_VARIABLES; // default
	}
	
	public TestSuite(String machineName, String operationUnderTest,
			String partitionStrategy, String combinatorialCriteria,
			List<TestCase> testCases, OracleStrategy strategy) {
		this.machineName = machineName;
		this.operationUnderTest = operationUnderTest;
		this.partitionStrategy = partitionStrategy;
		this.combinatorialCriteria = combinatorialCriteria;
		this.testCases = testCases;
		this.oracleStrategy = strategy;
	}
	
	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}
	public String getOperationUnderTest() {
		return operationUnderTest;
	}
	public void setOperationUnderTest(String operationUnderTest) {
		this.operationUnderTest = operationUnderTest;
	}
	public String getPartitionStrategy() {
		return partitionStrategy;
	}
	public void setPartitionStrategy(String partitionStrategy) {
		this.partitionStrategy = partitionStrategy;
	}
	public String getCombinatorialCriteria() {
		return combinatorialCriteria;
	}
	public void setCombinatorialCriteria(String combinatorialCriteria) {
		this.combinatorialCriteria = combinatorialCriteria;
	}
	public List<TestCase> getTestCases() {
		return testCases;
	}
	public void setTestCases(List<TestCase> testCases) {
		this.testCases = testCases;
	}
	
	public OracleStrategy getOracleStrategy() {
		return oracleStrategy;
	}
	public void setOracleStrategy(OracleStrategy oracleStrategy) {
		this.oracleStrategy = oracleStrategy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((combinatorialCriteria == null) ? 0 : combinatorialCriteria
						.hashCode());
		result = prime * result
				+ ((machineName == null) ? 0 : machineName.hashCode());
		result = prime
				* result
				+ ((operationUnderTest == null) ? 0 : operationUnderTest
						.hashCode());
		result = prime * result
				+ ((oracleStrategy == null) ? 0 : oracleStrategy.hashCode());
		result = prime
				* result
				+ ((partitionStrategy == null) ? 0 : partitionStrategy
						.hashCode());
		result = prime * result
				+ ((testCases == null) ? 0 : testCases.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestSuite other = (TestSuite) obj;
		if (combinatorialCriteria == null) {
			if (other.combinatorialCriteria != null)
				return false;
		} else if (!combinatorialCriteria.equals(other.combinatorialCriteria))
			return false;
		if (machineName == null) {
			if (other.machineName != null)
				return false;
		} else if (!machineName.equals(other.machineName))
			return false;
		if (operationUnderTest == null) {
			if (other.operationUnderTest != null)
				return false;
		} else if (!operationUnderTest.equals(other.operationUnderTest))
			return false;
		if (oracleStrategy != other.oracleStrategy)
			return false;
		if (partitionStrategy == null) {
			if (other.partitionStrategy != null)
				return false;
		} else if (!partitionStrategy.equals(other.partitionStrategy))
			return false;
		if (testCases == null) {
			if (other.testCases != null)
				return false;
		} else if (!testCases.equals(other.testCases))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TestSuite [machineName=" + machineName
				+ ", operationUnderTest=" + operationUnderTest
				+ ", partitionStrategy=" + partitionStrategy
				+ ", combinatorialCriteria=" + combinatorialCriteria
				+ ", testCases=" + testCases + ", oracleStrategy="
				+ oracleStrategy + "]";
	}
		
	
}
