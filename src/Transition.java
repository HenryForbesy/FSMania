public class Transition{

	private State originState;
	private String input;
	private State ancestorState;
	
	public Transition(State startState, String in, State endState){
		input = in;
		ancestorState = endState;
		originState = startState;
	}
	
	public State getOrigin() {
		return originState;
	}
	
	public State getAncestor() {
		return ancestorState;
	}
	
	public String getInput() {
		return input;
	}
	
	
}