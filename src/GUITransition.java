import javax.swing.*;
import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.BasicStroke;

public class GUITransition extends JComponent{
	
	private GUIState originState;
	private GUIState ancestorState;
	private String input;
	private GUIController controller;
	
	private int startX, startY, endX, endY;
	
	private Shape line;
	
	public GUITransition(GUIController controllerRef, GUIState startState, String in, GUIState endState) {
		originState = startState;
		input = in;
		ancestorState = endState;
		controller = controllerRef;
		
		setLayout(null);
		
		startX = originState.getX() + 50;	//plus 50 as half the size of the state component
 		startY = originState.getY() + 50;
		endX = ancestorState.getX() + 50;
		endY = ancestorState.getY() + 50;
		
		//direction = calculateDirection();
		//addEventListeners();
		//setProperties();
		
	}
	
	public int getStartX() {
		return startX;
	}
	
	public int getStartY() {
		return startY;
	}
	
	public int getEndX() {
		return endX;
	}
	
	public int getEndY() {
		return endY;
	}
	
	public GUIState getOrigin() {
		return originState;
	}
	
	public GUIState getAncestor() {
		return ancestorState;
	}
	
	//Redundant code//----------------------------------------------------------------------------------------------
	
	/**
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(10));
		if(direction == 0) {
			line = new Line2D.Double(0, 0, endX, endY);
		}
		else if(direction == 1) {
			setSize(endX, endY);
			setLocation(startX, startY - (endY - startY));
		}
		else if(direction == 2) {
			setSize(endX + (startX - endX), startY + (endY - startY));
		}
		else if(direction == 3) {
			setSize(endX + (startX - endX), endY + (startY - endY));
		}
		g2d.draw(line);
		g2d.fill(line);
		
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
			setSize(endX, endY);
			setLocation(startX, startY);
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
			public void mouseMoved(MouseEvent e) {
				if(line.contains(e.getX(), e.getY())){
					System.out.println("Mouse Entered Line Component");
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(line.contains(e.getPoint())){
					System.out.println("Mouse Entered Line Component");
				}
				else {
					System.out.println("Didn't click on the fucking thing mate");
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("Mouse exited Line Component");
			}
		});
	}
	
	**/
	
}