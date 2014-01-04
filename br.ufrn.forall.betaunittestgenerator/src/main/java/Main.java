import models.OracleStrategy;
import builders.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UnitTestBuilder builder = new CppUnitBuilder();
		builder.generateUnitTest(
				"/Users/joaosouza/Downloads/examples/report_for_substitute_from_Player.xml",
				"/Users/joaosouza/Downloads/examples/Codigos/",
				OracleStrategy.ALL);
		System.out.println("Arquivo criado! ");
	}

}
