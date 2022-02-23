import javax.swing.*;
import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class GUITransition extends JComponent{
	
	private GUIState originState;
	private GUIState ancestorState;
	private String input;
	
	private int startX, startY, endX, endY;
	
	public GUITransition(GUIState startState, String in, GUIState endState, int firstX, int firstY, int lastX, int lastY) {
		originState = startState;
		input = in;
		ancestorState = endState;
	}
	
	public GUITransition(int firstX, int firstY, int lastX, int lastY) {
		startX = firstX;
		startY = firstY;
		endX = lastX;
		endY = lastY;
		
		setSize(startX + endX, startY + endY);
		setLocation(startX, startY);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawLine(0, 0, endX, endY);
		
	}
	
	
	
}