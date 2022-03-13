import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUIController {
	
	public static GUIController controller = new GUIController(true);
	
	private TheFrame theFrame;
	private MainPanel mainPanel;
	private FSMSelectionPanel selectionPanel;
	private DFSFrame dfsPanel;
	
	private GUIState stateWithMouse, originGUIState, ancestorGUIState;

	public GUIController(boolean showFrame) {
		if (!showFrame) {
			createSwingElements();
			addElementsToTheFrame();
			theFrame.setVisible(true);
		}
	}
	
	
	//=============================================================================================Panel Control=============================================================================================//
	public TheFrame getTheFrame() {
		return theFrame;
	}
	
	public MainPanel getMainPanel() {
		return mainPanel;
	}
	
	public FSMSelectionPanel getSelectionPanel() {
		return selectionPanel;
	}
	
	public DFSFrame getDFSPanel() {
		return dfsPanel;
	}
	
	public void changePanel(String panelToShow) {
		theFrame.showPanel(panelToShow);
	}
	
	//============================================================================================Drawing Control===========================================================================================//
	
	public GUIState getStateWithMouse() {
		return stateWithMouse;
	}
	
	public void setMouseOnState(GUIState stateToAdd) {
		stateWithMouse = stateToAdd;
	}
	
	public void setMouseOffState() {
		stateWithMouse = null;
	}
	
	public boolean mouseOnState() {
		if(stateWithMouse == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void addOriginGUIState(){  //for the origin node of a transition
		originGUIState = stateWithMouse;
	}
	
	public void addAncestorGUIState() {
		ancestorGUIState = stateWithMouse;
	}
	
	public void removeGUIState(GUIState stateToRemove) {
		dfsPanel.getDesignPanel().removeState(stateToRemove);
	}
	
	public void addGUITransition() {
		if(!checkIfTransitionExists()) {
			GUITransition transitionToAdd = originGUIState.addTransition("", ancestorGUIState);
			dfsPanel.getDesignPanel().addTransition(transitionToAdd);
		}
		emptyGUIStates();
	}
	
	public GUIState getOriginGUIState() {
		return originGUIState;
	}
	
	public GUIState getAncestorGUIState() {
		return ancestorGUIState;
	}
	
	public void removeGUITransitions(GUIState stateRemoved) {
		dfsPanel.getDesignPanel().removeTransitions(stateRemoved);
	}
	
	public void emptyGUIStates() {
		originGUIState = null;
		ancestorGUIState = null;
	}
	
	public float distanceFromPoint(float x, float y, float x1, float y1, float x2, float y2) {

        float A = x - x1;
        float B = y - y1;
        float C = x2 - x1;
        float D = y2 - y1;

        float dot = A * C + B * D;
        float len_sq = C * C + D * D;
        float param = -1;
        if (len_sq != 0) //in case of 0 length line
            param = dot / len_sq;

        float xx, yy;

        if (param < 0) {
          xx = x1;
          yy = y1;
        }
        else if (param > 1) {
          xx = x2;
          yy = y2;
        }
        else {
          xx = x1 + param * C;
          yy = y1 + param * D;
        }

        float dx = x - xx;
        float dy = y - yy;
        return (float) Math.sqrt(dx * dx + dy * dy);
      }
	
	private boolean checkIfTransitionExists() {
		for(int i = 0; i < originGUIState.getTransitions().size(); i++) {
			if(originGUIState.getTransitions().get(i).getAncestor() == ancestorGUIState) {
				System.out.println("1");
				return true;
			}
		}
		return false;
	}
	
	//==============================================================================CREATING ELEMENTS================================================================================================//
	
	private void createSwingElements() {
		theFrame = new TheFrame(this);
		int width = (int) theFrame.getBounds().getWidth();
		int height = (int) theFrame.getBounds().getHeight();
		
		mainPanel = new MainPanel(this, width, height);
		selectionPanel = new FSMSelectionPanel(this);
		dfsPanel = new DFSFrame(this);
		
		theFrame.showPanel("mainPanel");
	}
	
	private void addElementsToTheFrame() {
		theFrame.addPanel(dfsPanel, "dfsPanel");
		theFrame.addPanel(selectionPanel, "selectionPanel");
		theFrame.addPanel(mainPanel, "mainPanel");
	}
	
	
}
