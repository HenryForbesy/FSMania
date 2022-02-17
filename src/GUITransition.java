import javax.swing.*;
import java.util.*;

public class GUITransition extends JComponent{
	
	private GUIState originState;
	private GUIState ancestorState;
	private String input;
	
	public GUITransition(GUIState startState, String in, GUIState endState) {
		originState = startState;
		input = in;
		ancestorState = endState;
	}
	
}