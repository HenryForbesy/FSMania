import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUIController2 extends JFrame {
	public static GUIController2 controller = new GUIController2(false);
	private MainFrame mainFrame = new MainFrame(controller);
	private DFSFrame dfsFrame = new DFSFrame();
	private FSMSelectionFrame  selectionFrame = new FSMSelectionFrame();
	JFrame currentFrame = mainFrame;
	
	public GUIController2(boolean firstFrame){
		if(firstFrame == true) {
			mainFrame.setVisible(true);
		}
		
	}
		
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	
	public FSMSelectionFrame getSelectionFrame() {
		return selectionFrame;
	}
	
	public DFSFrame getDFSFrame() {
		return dfsFrame;
	}
	
	public void changeFrame(JFrame frameToShow, JFrame frameToHide) {
		frameToShow.setVisible(true);
		frameToHide.setVisible(false);
	}
	
	
	private void showDFSFrame() {
		dfsFrame.setVisible(true);
	}
	
	private void showMainFrame() {
		mainFrame.setVisible(true);
	}
	
	private void showSelectionFrame() {
		selectionFrame.setVisible(true);
}
