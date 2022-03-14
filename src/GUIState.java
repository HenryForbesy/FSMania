
import javax.swing.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.BasicStroke;
import java.awt.Color;

import java.util.*;

public class GUIState extends JComponent{
	
	private GUIController controller;
	private String name;
	private int x;
	private int y;
	private List<GUITransition> guiTransitions = new ArrayList<GUITransition>();
	private boolean accepting;
	private boolean isInitialState;
	private boolean mouseOnState = true;
	
	
	Shape circle;
	Shape acceptingCircle;
	
	public GUIState(GUIController controllerRef, String tempName, int xCoord, int yCoord) {
		name = tempName;
		x = xCoord;
		y = yCoord;
		controller = controllerRef;
		
		setSize(100, 100);
		setLocation(x - 50, y - 50);
		
		circle = new Ellipse2D.Double(5, 5, 90, 90);
		acceptingCircle = new Ellipse2D.Double(10, 10, 80, 80);
		
		addEventListeners();
	}
	
	public GUITransition addTransition(String tempInput, GUIState tempAncestor) {
		GUITransition guiTransitionToAdd = new GUITransition(controller, this, tempInput, tempAncestor);
		guiTransitions.add(guiTransitionToAdd);
		return guiTransitionToAdd;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean getAccepting() {
		return accepting;
	}
	
	public Shape getShape() {
		return circle;
	}
	
	public boolean getIsInitialState() {
		return isInitialState;
	}
	
	public List<GUITransition> getTransitions(){
		return guiTransitions;
	}
	
	public void setAccepting() {
		accepting = true;
		System.out.println("Hello");
		repaint();
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
		repaint();
	}
	
	public void toggleInitialState() {
		if(isInitialState == true) {
			isInitialState = false;
		}
		else {
			isInitialState = true;
		}
		controller.changeInitialGUIState(this);
		repaint();
	}
	
	private void mouseOnState() {
		controller.setMouseOnState(this);
		mouseOnState = true;
		repaint();
	}
	
	private void mouseOffState() {
		controller.setMouseOffState();
		mouseOnState = false;
		repaint();
	}
	
	private void beginDrawingLine() {
		controller.addOriginGUIState();
	}
	
	private void finishDrawingLine() {
		controller.addAncestorGUIState();
		if(controller.getAncestorGUIState() != null) {
			controller.addGUITransition();
		}
	}
	
	private void removeThis() {
		controller.removeGUIState(this);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		if(!accepting && !mouseOnState) { //regular state. Just a black circle
			g2d.setPaint(Color.black);
			g2d.setStroke(new BasicStroke(10));
			
			g2d.draw(circle);
			g2d.fill(circle);
		}
		else if(!accepting && mouseOnState) { //regular state with mouse on. White circle with black outline
			g2d.setPaint(Color.black);
			g2d.setStroke(new BasicStroke(10));
			
			g2d.draw(circle);
			
			g2d.setPaint(Color.gray);
			g2d.fill(circle);
		}
		else if(accepting && !mouseOnState) { //regular accepting state
			g2d.setPaint(Color.black);
			g2d.setStroke(new BasicStroke(10));
			
			g2d.draw(circle);
			g2d.fill(circle);
			
			g2d.setPaint(Color.gray);
			g2d.setStroke(new BasicStroke(5));
			
			g2d.draw(acceptingCircle);
		}
		else if(accepting && mouseOnState) { //regular accepting state with mouse on
			g2d.setPaint(Color.gray);
			g2d.setStroke(new BasicStroke(10));
			
			g2d.draw(circle);
			g2d.fill(circle);
			
			g2d.setPaint(Color.black);
			g2d.setStroke(new BasicStroke(5));
			
			g2d.draw(acceptingCircle);
		}
	}
	
	private void addEventListeners() {
		addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)) {
					removeThis();
				}
				else if(SwingUtilities.isMiddleMouseButton(e)) {
					toggleInitialState();
				}
				else if(e.getClickCount() == 2) {
					toggleAccepting();
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				beginDrawingLine();
				if(controller.getOriginGUIState() != null) {
					//System.out.println("Origin added");
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)) {
					removeThis();
				}
				else {
					finishDrawingLine();
					if(controller.getAncestorGUIState() != null) {
						//System.out.println("Ancestor added");
					}
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				mouseOnState();
				}
			@Override
			public void mouseExited(MouseEvent e) {
				mouseOffState();
			}
		});
	}
}