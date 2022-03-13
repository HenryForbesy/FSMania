import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class DesignPanel extends JPanel{
	
	private GUIController controller;
	private List<GUITransition> guiTransitions = new ArrayList<GUITransition>();
	private List<Shape> transitionLines = new ArrayList<Shape>();
	
	DesignPanel(GUIController controllerRef){
		setLayout(null);
		controller = controllerRef;
		setProperties();
		addEventListeners();
		setBackground(Color.white);
		setVisible(true);
	}
	
	//method creates a state and adds it to DesignPanel. DesignPanel then repainted
	
	public void addState(int x, int y) {
		GUIState guiStateToAdd = new GUIState(controller, "Test", x, y);
		add(guiStateToAdd);
		revalidate();
		repaint();
	}
	
	public void removeState(GUIState stateToRemove) {
		Component[] componentList = getComponents();
		
		for(Component c : componentList) {
			if(c == stateToRemove) {
				controller.removeGUITransitions(stateToRemove);
				remove(c);
				c = null;
			}
		}
		
		revalidate();
		repaint();
	}
	
	//method adds a the transition to the designPanel. designPanel is then repainted
	
	public void addTransition(GUITransition transitionToAdd) {
		
		
		int x1 = transitionToAdd.getOrigin().getX() + 50;
		int y1 = transitionToAdd.getOrigin().getY() + 50;
		int x2 = transitionToAdd.getAncestor().getX() + 50;
		int y2 = transitionToAdd.getAncestor().getY() + 50;
		
		
		Shape lineToAdd = new Line2D.Double(x1, y1, x2, y2);
		
		guiTransitions.add(transitionToAdd); //These 2 are related. Every guiTransition is in the same place as its associated graphics object. 
		transitionLines.add(lineToAdd);
		
		revalidate();
		repaint();
	}
	
	public void removeTransitions(GUIState stateRemoved) {
		for(int i = 0; i < guiTransitions.size(); i++) {
			if(stateRemoved == guiTransitions.get(i).getOrigin() || stateRemoved == guiTransitions.get(i).getAncestor()) {
				guiTransitions.remove(i);
				transitionLines.remove(i);
				i = i - 1; //arrayList has shrunk with removal. reduce i by 1 to not skip 
			}
		}
	}
	
	private void setProperties() {
		setBounds(212, 0, 819, 714);
		setLayout(null);
	}
	
	private void addEventListeners() {
		addMouseListener(new MouseAdapter(){
			
			@Override
			public void mousePressed(MouseEvent e) {
				//Nothing (yet)
			}
				
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("Here");
				int x = e.getX();
				int y = e.getY();
				addState(x, y);
				System.out.println();
			}
		});
		
		addMouseMotionListener(new MouseAdapter() { 
			@Override
			public void mouseMoved(MouseEvent e) {
				for(int i = 0; i < guiTransitions.size(); i++) {
					GUITransition transitionToCheck = guiTransitions.get(i);
					if(controller.distanceFromPoint(e.getX(), e.getY(), transitionToCheck.getStartX(), transitionToCheck.getStartY(), transitionToCheck.getEndX(), transitionToCheck.getEndY()) == 0){
						System.out.println("WOW");
					}
					//System.out.println("Hello bitch");
				}
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				
			}
		});
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(Color.black);
		for(Shape line : transitionLines) {
			g2d.draw(line);
			g2d.fill(line);
		}
		
	}
	
}