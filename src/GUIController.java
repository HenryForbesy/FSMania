import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUIController {
	
	public static GUIController controller = new GUIController(false);
	
	private TheFrame theFrame;
	private MainPanel mainPanel;
	private FSMSelectionPanel selectionPanel;
	private DFSFrame dfsPanel;


	public GUIController(boolean showFrame) {
		createSwingElements();
		if (showFrame) {
			theFrame.setVisible(true);
		}
		addElementsToTheFrame();
	}
	
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
	
	public void removeGUIState(GUIState stateToRemove) {
		dfsPanel.removeState(stateToRemove);
	}
	
	private void createSwingElements() {
		theFrame = new TheFrame(controller);
		int width = (int) theFrame.getBounds().getWidth();
		int height = (int) theFrame.getBounds().getHeight();
		
		mainPanel = new MainPanel(controller, width, height);
		selectionPanel = new FSMSelectionPanel(controller);
		dfsPanel = new DFSFrame(controller);
		
		theFrame.showPanel("mainPanel");
	}
	
	private void addElementsToTheFrame() {
		theFrame.addPanel(dfsPanel, "dfsPanel");
		theFrame.addPanel(selectionPanel, "selectionPanel");
		theFrame.addPanel(mainPanel, "mainPanel");
	}
}
