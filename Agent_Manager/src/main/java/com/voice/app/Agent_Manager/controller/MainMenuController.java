package com.voice.app.Agent_Manager.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.voice.app.Agent_Manager.dao.factory.DAOFactory;
import com.voice.app.Agent_Manager.dao.factory.DAOFactoryHibernate;
import com.voice.app.Agent_Manager.domain.concrete.LeadRecord;
import com.voice.app.Agent_Manager.utils.LeadConverterCSV;
import com.voice.app.Agent_Manager.view.MainMenuView;

/**
 * Controller for main menu frame
 * @author Kyle Gendron
 *
 */
public class MainMenuController implements ActionListener{
	private MainMenuView view;
	private final JFileChooser fileChooser = new JFileChooser();
	private DAOFactory daoFactory = new DAOFactoryHibernate();
	
	/**
	 * Default constructor
	 */
	public MainMenuController(){
		this.view = new MainMenuView(this);
	}
	
	/**
	 * Helper method used by App to initialize GUI in thread-safe manner.
	 * @see {@link App}, {@link MainMenuView} 
	 */
	public void initializeGUI(){
		this.view.initialize();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "Add Leads From File":
			int returnVal = fileChooser.showOpenDialog(view.getAddLeadsFromFileItem());
			if(returnVal == JFileChooser.APPROVE_OPTION){
				File file = fileChooser.getSelectedFile();
				LeadConverterCSV converter = new LeadConverterCSV(file);
				ArrayList<LeadRecord> result = converter.process();
				if(result != null && !result.isEmpty()){
					for(LeadRecord l: result)
						daoFactory.getLeadDAO().add(0, l);
					JOptionPane.showMessageDialog(view, "Successfully added!");
				}else
					JOptionPane.showMessageDialog(view, "Unable to process "
							+ file.getName() + "!  Only able to convert .csv files.");
			}
			break;
		case "Add Leads Manually":
			System.out.println("Adding Leads manually.");
			//TODO
			break;
		case "Add Stats From File":
			System.out.println("Adding Stats from file.");
			//TODO
			break;
		case "Add Stats Manually":
			System.out.println("Adding Stats manually.");
			//TODO
			break;
		case "Display All Lead Records":
			DisplayAllLeadsController controller = new DisplayAllLeadsController(this, daoFactory);
			view.addTab("All Leads", controller.getView());
			break;
		case "Display All Stats Records":
			System.out.println("Displaying all Stats Records.");
			//TODO
			break;
		case "Search All Lead Records":
			System.out.println("Searching all Leads Records.");
			//TODO
			break;
		case "Search All Stats Records":
			System.out.println("Searching all Stats Records.");
			//TODO
			break;
		case "Exit":
			System.exit(0);
			break;
		}
	}
	
	/**
	 * Returns the main menu view associated with the main controller.
	 * @return view the MainMenuView associated with this controller
	 */
	public MainMenuView getView(){
		return view;
	}
}
