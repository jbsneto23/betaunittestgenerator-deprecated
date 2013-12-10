package models;

public enum OracleStrategy {

	STATE_INVARIANT("Check the state invariants"),
	RETURN_VALUES("Check return values"),
	STATE_VARIABLES("Check the state variables"),
	EXCEPTION("Check for exceptions"),
	STATE_INVARIANT_RETURN_VALUES("Check the state invariants and return values"),
	STATE_INVARIANT_VARIABLES("Check the state invariants and the state variables"),
	STATE_VARIABLES_RETURN_VALUES("Check the state variables and return values"),
	ALL("Check the state invariants, state variables and return values");
	
	private OracleStrategy(String strategy){
		this.strategy = strategy;
	}
	
	private String strategy;
	
	public String getStrategy() {
		return strategy;
	}
}
