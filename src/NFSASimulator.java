import java.util.*;

public class NFSASimulator{

	public NFSASimulator(List<State> listOfStates, State firstState) {
		List<State> states = listOfStates;
		State initialState = firstState;
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Input string to test validity");
		
		String stringToValidate = userInput.next();
		
		boolean valid = runSimulation(states, initialState, stringToValidate);
	}
	
	private boolean runSimulation(List<State> states,  State initialState, String stringToValidate) {
		State currentState = initialState;
		int posInString = 0;
		while(posInString < stringToValidate.length()) {
			if(currentState == null) {
				System.out.println("String not accepted");
				return false;
			}
			if(posInString == stringToValidate.length()) {
				if(currentState.getAccepting() == true) {
					System.out.println("String accepted");
				}
				else {
					System.out.println("String not accepted");
				}
			}
		}
		return false;
	}
	
	private void runNextStep() {
		String transitionInput = getNextChar(stringToValidate, posInString);
		posInString++;
		currentState = getNextState(currentState, transitionInput); //Call for updating gui
	}
	
	private State getNextState(State currentState, String input) {
		for(int i = 0; i < currentState.getTransitions().size(); i++) {
			if(currentState.getTransitions().get(i).getInput().equals(input)) {
				return currentState.getTransitions().get(i).getAncestor();
			}
		}
		return null;
	}
	
	private String getNextChar(String stringToValidate, int pos) {
		return "" + stringToValidate.charAt(pos);	//concatenate to string
	}
	
}