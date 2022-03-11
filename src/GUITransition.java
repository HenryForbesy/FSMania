import javax.swing.*;
import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

public class GUITransition extends JComponent{
	
	private GUIState originState;
	private GUIState ancestorState;
	private String input;
	
	private int startX, startY, endX, endY;
	private int direction;
	
	public GUITransition(GUIState startState, String in, GUIState endState) {
		originState = startState;
		input = in;
		ancestorState = endState;
		
		startX = originState.getX();
		startY = originState.getY();
		endX = ancestorState.getX();
		endY = ancestorState.getY();
		
		direction = calculateDirection();
		//setProperties();
		setSize(100, 100);
		setLocation(0, 0);
		setBackground(Color.blue);
		addEventListeners();
		setVisible(true);
		setLayout(null);
		
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
	
	private int calculateDirection() {
		
		if(startX < endX) {
			if(startY < endY) {
				return 0; //right and down
			}
			else {
				return 1; //right and up or right and horizontal
			}
		}
		else if(startX >= endX) {
			if(startY < endY) {
				return 2; //left and down
			} 
			else {
				return 3; //left and up or left and horizontal
			}
		}
		
		return 99;
	}
	
	private void setProperties() {
		if(direction == 0) {
			setSize(startX + (endX - startX), startY + (endY - startY));
			setLocation(0, 0);
		}
		else if(direction == 1) {
			setSize(startX + (endX - startX), endY + (startY - endY));
			setLocation(startX, startY - (endY - startY));
		}
		else if(direction == 2) {
			setSize(endX + (startX - endX), startY + (endY - startY));
		}
		else if(direction == 3) {
			setSize(endX + (startX - endX), endY + (startY - endY));
		}
		setBackground(Color.blue);
	}
	
	private void addEventListeners() {
		addMouseListener(new MouseAdapter(){
			@Override
			
			public void mouseEntered(MouseEvent e) {
				System.out.println("Mouse Entered");
				}
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("Mouse exited");
			}
		});
	}
	
	
	
}