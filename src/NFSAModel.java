import java.util.*;
public class NFSAModel{
	
	
	private List<State> states = new ArrayList<State>();	//states represented by input and transition
	private State initialState;
	
	
	public NFSAModel(){
		 //createModelUsingConsole();
		 createModelDebug();
		 printModel();
		 NFSASimulator simulator = new NFSASimulator(states, initialState);
	}
	
	public void createModelDebug() {
		State q0 = new State("q0");
		State q1 = new State("q1");
		State q2 = new State("q2");
		State q3 = new State("q3");
		q3.setAccepting();
		
		initialState = q0;
		
		q0.addTransition("x", q1);
		q0.addTransition("y", q1);
		q1.addTransition("x", q1);
		q1.addTransition("y", q2);
		q2.addTransition("x", q0);
		q2.addTransition("y", q3);
		
		states.add(q0);
		states.add(q1);
		states.add(q2);
		states.add(q3);
	
	}
	
	private void printModel() {
		System.out.println("\nStates:");
		for(int i = 0; i < states.size(); i++) {
			System.out.println(states.get(i).getName());
		}
		
		System.out.println("\nTransitions:");
		for(int i = 0; i < states.size(); i++) {
			for(int j = 0; j < states.get(i).getTransitions().size(); j++) {
				String nameOrigin = states.get(i).getTransitions().get(j).getOrigin().getName();
				String input = states.get(i).getTransitions().get(j).getInput();
				String nameAncestor = states.get(i).getTransitions().get(j).getAncestor().getName();
				System.out.println("(" + nameOrigin + " " + input + " " + nameAncestor + ")");
			}
		}
		
		System.out.println("\nInitial State:");
		System.out.println(initialState.getName());
		
		System.out.println("\nAccepting States");
		for(int i = 0; i < states.size(); i++) {
			if(states.get(i).getAccepting() == true) {
				System.out.println(states.get(i).getName());
			}
		}
	}
	
	public void createModelUsingConsole() {
		Scanner userInput = new Scanner(System.in);
		
		String stateInput = inputStates(userInput);
		
		states = seperateStates(stateInput.replaceAll("\\s+",""));
		
		inputTransitions(userInput);
		
		initialState = inputInitialState(userInput);
		
		String acceptInput = inputStates(userInput);
		
		initialiseAcceptingStates(acceptInput.replaceAll("\\s+",""));
		
	}
	
	private List<State> seperateStates(String stateInput){
		String stateConstructor = "";
		List<State> tempStates =  new ArrayList<State>();
		for(int i = 0; i < stateInput.length(); i++) {
			if(stateInput.charAt(i) != ',') {
				stateConstructor =  stateConstructor + stateInput.charAt(i);
			}
			else {
				State stateToAdd = new State(stateConstructor);
				tempStates.add(stateToAdd);
				stateConstructor = "";
			}
		}
		if(stateConstructor != "") {
			State stateToAdd = new State(stateConstructor);
			tempStates.add(stateToAdd);
		}
		return tempStates;
	}
	
	private void initialiseAcceptingStates(String acceptInput) {
		String stateConstructor = "";
		for(int i = 0; i < acceptInput.length(); i++) {
			if(acceptInput.charAt(i) != ',') {
				stateConstructor =  stateConstructor + acceptInput.charAt(i);
			}
			else {
				for(int j = 0; j < states.size(); j++) {
					if(stateConstructor.equals(states.get(j).getName())) {
						states.get(j).setAccepting();
					}
				}
				stateConstructor = "";
			}
		}
		if(stateConstructor != "") {
			for(int j = 0; j < states.size(); j++) {
				if(stateConstructor.equals(states.get(j).getName())) {
					states.get(j).setAccepting();
				}
			}
		}
	}
	
	private State inputInitialState(Scanner userInput) {
		boolean validState = false;
		String input = "";
		State tempState = null;
		
		while(validState == false) {
			System.out.println("Input initial state");
			input = userInput.nextLine();
			
			boolean found = false;
			int count = 0;
			
			while(found == false && count < states.size()) {
				if(input.equals(states.get(count).getName())) {
					tempState = states.get(count);
					found = true;
				}
				count++;
			}
			if(found == false) {
				System.out.println("Input was not a state");
			}
			else {
				return tempState;
			}
		}
		return null;
	}
	
	private String inputStates(Scanner userInput) {
		System.out.println("Input states. Input state names seperated with a ',' ");
		String input = userInput.nextLine().strip();
		return input;
	}
	
	private void processTransition(String transitionInput) {
		
		String originStateConstructor = "";
		String destinationStateConstructor = "";
		String inputConstructor = "";
		
		
		int i = 0;
		while(transitionInput.charAt(i) != ',') {
			originStateConstructor = originStateConstructor + transitionInput.charAt(i);
			i++;
		}
		i++;
		while(transitionInput.charAt(i) != ',') {
			destinationStateConstructor = destinationStateConstructor + transitionInput.charAt(i);
			i++;
		}
		i++;
		while(i < transitionInput.length()) {
			if(transitionInput.charAt(i) != ',') {
				inputConstructor = inputConstructor + transitionInput.charAt(i);
			}
			i++;
		}
		
		State originState = convertStringToState(originStateConstructor);
		State destinationState = convertStringToState(destinationStateConstructor);
		
		addTransitionToState(originState, inputConstructor, destinationState);
		
	}
	
	private void addTransitionToState(State tempOrigin, String input, State tempDestination) {
		tempOrigin.addTransition(input, tempDestination);
		updateListWithState(tempOrigin);
	}
	
	private void updateListWithState(State stateToUpdate){
		for(int i = 0; i < states.size(); i++) {
			if(stateToUpdate.getName() == states.get(i).getName()) {
				states.set(i, stateToUpdate);
			}
		}
	}
	
	private State convertStringToState(String constructor) {
		
		boolean found = false;
		int count = 0;
		
		while(found == false && count < states.size()) {
			String tempStateName = states.get(count).getName();
			if(constructor.equals(tempStateName)) {
				found = true;
				return states.get(count);
			}
			count++;
		}
		if(found == false) {
			System.out.println("Not a valid state");
		}
		return null;
	}
	
	private void inputTransitions(Scanner userInput) {
		boolean terminateInput = false;
		String input = "";
		
		while(terminateInput == false) {
			System.out.println("Input transition. q0, q1, x where x is an input");
			input = userInput.nextLine().replaceAll("\\s+", "");
			
			processTransition(input);
			
			System.out.println("Finished with transitions <y/n>");
			String terminateTransition = userInput.nextLine().strip();
			
			boolean inputValid = false;
			
			while(inputValid == false) {
				if(terminateTransition.equals("y")) {
					terminateInput = true;
					inputValid = true;
				}
				else if(terminateTransition.equals("n")) {
					inputValid = true;
				}
				else {
					System.out.println("<y/n>");
				}
			}
		}
	}
}