
import javax.swing.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

public class GUIState extends JComponent{
	
	private GUIController controller;
	private String name;
	private int x;
	private int y;
	private List<GUITransition> guiTransitions = new ArrayList<GUITransition>();
	private boolean accepting;
	Shape circle;
	
	public GUIState(GUIController controllerRef, String tempName, int xCoord, int yCoord) {
		name = tempName;
		x = xCoord;
		y = yCoord;
		controller = controllerRef;
		
		setSize(100, 100);
		setLocation(x - 50, y - 50);
		
		circle = new Ellipse2D.Double(0, 0, 100, 100);
		
		addEventListeners();
	}
	
	public GUITransition addTransition(String tempInput, GUIState tempAncestor) {
		GUITransition guiTransitionToAdd = new GUITransition(this, tempInput, tempAncestor);
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
	
	private void mouseOnState() {
		controller.setMouseOnState(this);
	}
	
	private void mouseOffState() {
		controller.setMouseOffState();
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
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.draw(circle);
		g2d.fill(circle);
	}
	
	private void addEventListeners() {
		addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				beginDrawingLine();
				if(controller.getOriginGUIState() != null) {
					System.out.println("Origin added");
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				finishDrawingLine();
				if(controller.getAncestorGUIState() != null) {
					System.out.println("Ancestor added");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				mouseOnState();
				System.out.println("Mouse Entered");
				}
			@Override
			public void mouseExited(MouseEvent e) {
				mouseOffState();
				System.out.println("Mouse exited");
			}
		});
	}
}