package com.voice.app.Agent_Manager.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.voice.app.Agent_Manager.view.AddSingleLeadView;
import com.voice.app.Agent_Manager.view.MainMenuView;

/**
 * Controller class that handles the application logic of
 * the Add Lead Manually use case.
 * @author Kyle Gendron
 *
 */
public class AddSingleLeadController implements ActionListener{
	private MainMenuView mainView;
	private AddSingleLeadView view;
	
	/**
	 * Default Constructor
	 */
	public AddSingleLeadController(MainMenuView mainView){
		view = new AddSingleLeadView(this);
		this.mainView = mainView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "Cancel":
			mainView.removeTab();
			break;
		case "Submit":
			System.out.println("Submit");
			break;
		}
		
	}

	/**
	 * Returns the view associated with this controller.
	 * @return view the view associated with this controller
	 */
	public AddSingleLeadView getView(){
		return view;
	}
}
