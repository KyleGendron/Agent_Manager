package com.voice.app.Agent_Manager.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.voice.app.Agent_Manager.dao.factory.DAOFactory;
import com.voice.app.Agent_Manager.view.DisplayAllStatsView;

public class DisplayAllStatsController implements ActionListener{
	DisplayAllStatsView view;
	MainMenuController controller;
	DAOFactory factory;
	
	/**
	 * 2-Param Constructor
	 * @param controller the controller above this controller
	 * @param factory the overarching application factory
	 */
	public DisplayAllStatsController(MainMenuController controller, DAOFactory factory){
		this.controller = controller;
		this.factory = factory;
		view = new DisplayAllStatsView(factory.getStatsDAO().list(), this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "Close":
			controller.getView().removeTab();
		}
	}
	
	/**
	 * Returns the view associated with this controller
	 * @return view the DisplayAllLeadsView associated with this controller
	 */
	public DisplayAllStatsView getView(){
		return view;
	}
}
