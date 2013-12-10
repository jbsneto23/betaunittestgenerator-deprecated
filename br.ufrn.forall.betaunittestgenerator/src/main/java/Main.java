import models.OracleStrategy;
import builders.JUnitBuilder;
import builders.UnitTestBuilder;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		UnitTestBuilder builder = new JUnitBuilder();
		builder.generateUnitTest("/Users/joaosouza/Downloads/examples/report_for_substitute_from_Player.xml", "/Users/joaosouza/Downloads/examples/Codigos/", OracleStrategy.STATE_VARIABLES);
		System.out.println("Arquivo criado! ");
	}

}
