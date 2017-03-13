package com.voice.app.Agent_Manager.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.voice.app.Agent_Manager.dao.factory.DAOFactory;
import com.voice.app.Agent_Manager.view.SearchLeadsView;

/**
 * Controller accompanying the search leads by 
 * criteria use case.
 * @author Kyle Gendron
 *
 */
public class SearchLeadsController implements ActionListener{
	MainMenuController controller;
	SearchLeadsView view;
	DAOFactory daoFactory;
	
	public SearchLeadsController(MainMenuController controller, DAOFactory daoFactory){
		this.controller = controller;
		this.daoFactory = daoFactory;
		//TODO:
		//-load up search criteria from DB into string arrays
		//-construct view using these arrays.
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
