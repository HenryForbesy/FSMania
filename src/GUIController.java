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
	
	//private DFSPanel dfsPanel = new DFSPanel();


	public GUIController(boolean showFrame) {
		createSwingElements();
		if (showFrame) {
			theFrame.setVisible(true);
		}
		addElementsToTheFrame();
		hideElementsOnTheFrame();
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
	
	//public DFSFrame getDFSPanel() {
		//return dfsFrame;
	//}
	
	
	public void changePanel(String panelToShow) {
		theFrame.showPanel(panelToShow);
	}
	
	private void createSwingElements() {	
		theFrame = new TheFrame(controller);
		mainPanel = new MainPanel(controller, (int) theFrame.getBounds().getWidth(), (int) theFrame.getBounds().getHeight());
		selectionPanel = new FSMSelectionPanel(controller);
	}
	
	private void addElementsToTheFrame() {
		theFrame.add(mainPanel, "mainPanel");
		theFrame.add(selectionPanel, "selectionPanel");
	}
	
	private void hideElementsOnTheFrame() {
			theFrame.hidePanel(selectionPanel);
	}

}
