
import javax.swing.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

public class GUIState extends JComponent{
	
	private GUIController controller;
	private String name;
	private int x;
	private int y;
	private List<GUITransition> guiTransitions = new ArrayList<GUITransition>();
	private boolean accepting;
	private boolean pressed = false;
	private boolean released = false;
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
	
	public void addTransition(String tempInput, GUIState tempAncestor) {
		//GUITransition guiTransitionToAdd = new GUITransition(this, tempInput, tempAncestor);
		//guiTransitions.add(guiTransitionToAdd);
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
	
	private void removeState() {
		controller.getDFSPanel().removeState(this);
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
				if(SwingUtilities.isRightMouseButton(e)) {
					removeState();
					System.out.println("Right click");
				}
				else {
					pressed = true;
					System.out.println("Left click");
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("Mouse entered");
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				released = true;
				if(pressed != true) {
					System.out.println("In the right one mate wayyy");
				}
				else {
					System.out.println("Pressed and released");
				}
				pressed = false;
				released = false;
			}
		});
	}
	
}