package com.voice.app.Agent_Manager.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.voice.app.Agent_Manager.controller.MainMenuController;

@SuppressWarnings("serial")
public class MainMenuView extends JFrame{
	private MainMenuController controller;
	private JMenuItem addLeadsFromFile, addStatsFromFile;
	private JTabbedPane tabbedPane;
	
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
		setLayout(new GridLayout(1,1));
		
		//create menu bar
		JMenuBar menuBar = new JMenuBar();
		
		//create menu
		JMenu menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		
		//create menu items top to bottom
		
		//create add leads submenu
		JMenu addLeadsSubMenu = new JMenu("Add Leads");
		addLeadsSubMenu.setMnemonic(KeyEvent.VK_L);
		
		//create add leads submenu items and add them
		addLeadsFromFile = new JMenuItem("Add Leads From File");
		addLeadsFromFile.addActionListener(controller);
		JMenuItem addLeadsIndividually = new JMenuItem("Add Leads Manually");
		addLeadsIndividually.addActionListener(controller);
		addLeadsSubMenu.add(addLeadsFromFile);
		addLeadsSubMenu.add(addLeadsIndividually);
		
		//create add stats submenu
		JMenu addStatsSubMenu = new JMenu("Add Stats");
		addStatsSubMenu.setMnemonic(KeyEvent.VK_R);
		
		//create add stats submenu items and add them
		addStatsFromFile = new JMenuItem("Add Stats From File");
		addStatsFromFile.addActionListener(controller);
		JMenuItem addStatsIndividually = new JMenuItem("Add Stats Manually");
		addStatsIndividually.addActionListener(controller);
		addStatsSubMenu.add(addStatsFromFile);
		addStatsSubMenu.add(addStatsIndividually);
		
		JMenuItem displayAllLeads = 
				new JMenuItem("Display All Lead Records");
		displayAllLeads.addActionListener(controller);
		JMenuItem displayAllStats = 
				new JMenuItem("Display All Stats Records");
		displayAllStats.addActionListener(controller);
		
		//create search submenu
		JMenu searchMenu = new JMenu("Search");
		searchMenu.setMnemonic(KeyEvent.VK_S);
		
		//create search submenu items and add them
		JMenuItem searchLeads = 
				new JMenuItem("Search All Lead Records");
		searchLeads.addActionListener(controller);
		JMenuItem searchStats = 
				new JMenuItem("Search All Stats Records");
		searchStats.addActionListener(controller);
		searchMenu.add(searchLeads);
		searchMenu.add(searchStats);
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(controller);
		
		//add all menu items
		menu.add(addLeadsSubMenu);
		menu.add(addStatsSubMenu);
		menu.addSeparator();
		menu.add(displayAllLeads);
		menu.add(displayAllStats);
		menu.addSeparator();
		menu.add(exit);
		
		//set this menu to the menubar
		menuBar.add(menu);
		menuBar.add(searchMenu);
		this.setJMenuBar(menuBar);
		
		//add tabbed frame
		tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
		add(tabbedPane);
		
		//final frame settings to adjust
		setTitle("Agent Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(600,400));
		setVisible(true);
	}
	
	/**
	 * Returns the Menu Item corresponding to the Add Leads From File
	 * entry in the main menu.
	 * @return addLeadsFromFile the menu item
	 */
	public JMenuItem getAddLeadsFromFileItem(){
		return addLeadsFromFile;
	}
	
	/**
	 * Returns the Menu Item corresponding to the Add Stats from File
	 * entry in the main menu.
	 * @return addStatsFromFile the menu item
	 */
	public JMenuItem getAddStatsFromFileItem(){
		return addStatsFromFile;
	}
	
	/**
	 * Adds panel into a new tab in the main frame.
	 * @param panel the panel to be added
	 */
	public void addTab(String title, JPanel panel){
		tabbedPane.addTab(title, panel);
		repaint();
	}
	
	/**
	 * Removes currently-selected tab in the main frame and its contents.
	 */
	public void removeTab(){
		tabbedPane.remove(tabbedPane.getSelectedIndex());
		repaint();
	}
}
