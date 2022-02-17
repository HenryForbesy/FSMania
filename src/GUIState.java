
import javax.swing.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.*;

public class GUIState extends JComponent{
	
	private String name;
	private int xCoord;
	private int yCoord;
	private List<GUITransition> guiTransitions = new ArrayList<GUITransition>();
	private boolean accepting;
	
	public GUIState(String tempName, int x, int y) {
		name = tempName;
		xCoord = x;
		yCoord = y;
	}
	
	public void addTransition(String tempInput, GUIState tempAncestor) {
		GUITransition guiTransitionToAdd = new GUITransition(this, tempInput, tempAncestor);
		guiTransitions.add(guiTransitionToAdd);
	}
	
	public String getName() {
		return name;
	}
	
	public boolean getAccepting() {
		return accepting;
	}
	
	public List<GUITransition> getTransitions(){
		return guiTransitions;
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
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawOval(xCoord, yCoord, 100, 100);
	}
	
}