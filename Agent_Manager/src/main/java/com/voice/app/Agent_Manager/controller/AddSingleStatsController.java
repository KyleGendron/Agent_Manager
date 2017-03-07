package com.voice.app.Agent_Manager.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import com.voice.app.Agent_Manager.dao.factory.DAOFactory;
import com.voice.app.Agent_Manager.domain.concrete.StatsRecord;
import com.voice.app.Agent_Manager.view.AddSingleStatsView;
import com.voice.app.Agent_Manager.view.StatsForm;

public class AddSingleStatsController implements ActionListener{
	MainMenuController controller;
	DAOFactory daoFactory;
	AddSingleStatsView view;
	
	/**
	 * 1-Param Constructor
	 * @param controller the controller above this controller
	 */
	public AddSingleStatsController(MainMenuController controller, DAOFactory daoFactory){
		this.controller = controller;
		this.daoFactory = daoFactory;
		view = new AddSingleStatsView(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "Cancel":
			controller.getView().removeTab();
			break;
		case "Submit":
			view.getForm().unHighlightErrors(); //refresh error highlights
			String response = validate(view.getForm());
			if(response == null){
				int reply = JOptionPane.showConfirmDialog(view, 
						"Submission Valid!  Is this info correct?\n\n" +
						view.getForm().toString() + 
						"\n\nClick Yes to add to database or No to "
						+ "continue to edit this record.",
						"Confirm Submission",
						JOptionPane.YES_NO_OPTION);
				if(reply == JOptionPane.YES_OPTION){
					StatsRecord stats = new StatsRecord(view.getForm());
					daoFactory.getStatsDAO().add(0, stats);
					controller.getView().removeTab();
				}
			}else
				JOptionPane.showMessageDialog(view, response);
			break;
		}
	}
	
	/**
	 * Returns the view associated with this controller.
	 * @return view the view associated with this controller
	 */
	public AddSingleStatsView getView(){
		return view;
	}
	
	/**
	 * Helper method that validates whether a 
	 * given form conforms to the needed
	 * @param form
	 * @return
	 */
	public static String validate(StatsForm form){
		boolean result = true;
		StringBuilder response = new StringBuilder();
		response.append("There were some issues with your submission: \n");
		
		//check date
		if(form.getDatePicker().getDate() == null){
			form.highlightError(form.getDateLabel());
			response.append("-No Date was provided.\n");
			result = false;
		}else{
			if(form.getDatePicker().getDate().after(new Date())){
				form.highlightError(form.getDateLabel());
				response.append("-Future Date Provided.\n");
				result = false;
			}
		}
		
		//check agent
		if(form.getAgentField().getText().isEmpty()){
			form.highlightError(form.getAgentLabel());
			response.append("-No Agent name was provided.\n");
			result = false;
		}else{
			if(form.getAgentField().getText().length() > 100){
				form.highlightError(form.getAgentLabel());
				response.append("-Provided Agent name too long.\n");
				result = false;
			}
		}
		
		//check campaign
		if(form.getCampaignField().getText().isEmpty()){
			form.highlightError(form.getCampaignLabel());
			response.append("-No Campaign was provided.\n");
			result = false;
		}else{
			if(form.getCampaignField().getText().length() > 100){
				form.highlightError(form.getCampaignLabel());
				response.append("-Provided Campaign name too long.\n");
				result = false;
			}
		}
		
		if(result)
			return null;
		else
			return response.toString();
	}

}
