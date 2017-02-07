package com.voice.app.Agent_Manager.view;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.voice.app.Agent_Manager.controller.MainMenuController;

@SuppressWarnings("serial")
public class MainMenuView extends JFrame{
	MainMenuController controller;
	JMenuItem addFromFile;
	
	/**
	 * Default, 1-param constructor.
	 * @param controller the controller associated with this view
	 */
	public MainMenuView(MainMenuController controller){
		this.controller = controller;
	}
	
	/**
	 * Helper method that initializes the base GUI.
	 */
	public void initialize(){
		
		//create menu bar
		JMenuBar menuBar = new JMenuBar();
		
		//create menu
		JMenu menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		
		//create menu items top to bottom
		JMenu addLeadsSubMenu = new JMenu("Add Leads");
		addLeadsSubMenu.setMnemonic(KeyEvent.VK_A);
		
		JMenuItem addLeadsFromFile = new JMenuItem("Add From File");
		JMenuItem addLeadsIndividually = new JMenuItem("Add Manually");
		
		JMenuItem displayAllLeads = 
				new JMenuItem("Display All Lead Records");
		JMenuItem displayAllStats = 
				new JMenuItem("Display All Stats Records");
		JMenuItem exit = new JMenuItem("Exit");
		//add all menu items
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}
}
