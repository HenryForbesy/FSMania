import java.util.*;

public class State{
	
	private String name;
	private List<Transition> transitions = new ArrayList<Transition>();
	private boolean accepting = false;
	
	//Store x and y and go through states and draw them onto the screen
	 
	public State(String tempName) {
		name = tempName;
	}
	
	public void addTransition(String tempInput, State tempAncestor) {
		Transition transitionToAdd = new Transition(this, tempInput, tempAncestor);
		transitions.add(transitionToAdd);
	}
	
	public String getName() {
		return name;
	}
	
	public boolean getAccepting() {
		return accepting;
	}
	
	public List<Transition> getTransitions(){
		return transitions;
	}
	
	public void setAccepting() {
		accepting = true;
	}
	
	public void setNonAccepting() {
		accepting =  false;
	}
	
	public void toggleAccepting() {
		if(accepting == true) {
			accepting = false;
		}
		else {
			accepting = true;
		}
	}

}