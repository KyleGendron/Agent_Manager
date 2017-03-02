package com.voice.app.Agent_Manager.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import com.voice.app.Agent_Manager.view.AddSingleLeadView;
import com.voice.app.Agent_Manager.view.LeadForm;
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
			view.getForm().unHighlightErrors(); //refresh error highlights
			String response = validate(view.getForm());
			if(response == null)
				JOptionPane.showMessageDialog(view, "Submission Valid!");
			else
				JOptionPane.showMessageDialog(view, response);
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

	/**
	 * Validates the given form based on 
	 * the displayed parameters for each
	 * entry.  Either returns a null String
	 * if valid or a String containing
	 * an itinerary of the errors in the
	 * form.
	 * @param form the form to be validated
	 * @return String containing the errors in form
	 */
	public static String validate(LeadForm form){
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

		//check dialer
		if(form.getDialerField().getText().isEmpty()){
			form.highlightError(form.getDialerLabel());
			response.append("-No Dialer was provided.\n");
			result = false;
		}else{
			if(form.getDialerField().getText().length() > 1){
				form.highlightError(form.getDialerLabel());
				response.append("-Dialer was more than one character.\n");
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

		//check COID
		if(form.getcOIDField().getText().length() > 100){
			form.highlightError(form.getcOIDLabel());
			response.append("-Provided COID too long.\n");
			result = false;
		}

		//check AID
		if(form.getaIDField().getText().length() > 100){
			form.highlightError(form.getaIDLabel());
			response.append("-Provided AID too long.\n");
			result = false;
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

		//check company
		if(form.getCompanyField().getText().isEmpty()){
			form.highlightError(form.getCompanyLabel());
			response.append("-No Company was provided.\n");
			result = false;
		}else{
			if(form.getCompanyField().getText().length() > 100){
				form.highlightError(form.getCompanyLabel());
				response.append("-Provided Company name too long.\n");
				result = false;
			}
		}

		//check phone
		if(form.getPhoneField().getText().isEmpty()){
			form.highlightError(form.getPhoneLabel());
			response.append("-No Phone number was provided.\n");
			result = false;
		}else{
			if(form.getPhoneField().getText().length() > 10){
				form.highlightError(form.getPhoneLabel());
				response.append("-Provided Phone number too long.\n");
				result = false;
			}
		}

		//check submitted as
		if(form.getSubmittedAsField().getText().isEmpty()){
			form.highlightError(form.getSubmittedAsLabel());
			response.append("-No Submitted As lead type was provided.\n");
			result = false;
		}else{
			if(form.getSubmittedAsField().getText().length() > 100){
				form.highlightError(form.getSubmittedAsLabel());
				response.append("-Provided Submitted As lead type too long.\n");
				result = false;
			}
		}

		//check passed type
		if(form.getPassedTypeField().getText().isEmpty()){
			form.highlightError(form.getPassedTypeLabel());
			response.append("-No Passed Type for lead was provided.\n");
			result = false;
		}else{
			if(form.getPassedTypeField().getText().length() > 100){
				form.highlightError(form.getPassedTypeLabel());
				response.append("-Provided Passed Type for lead too long.\n");
				result = false;
			}
		}

		//check coaching notes
		if(form.getCoachingNotesField().getText().length() > 200){
			form.highlightError(form.getCoachingNotesLabel());
			response.append("-Provided Coaching Notes too long.\n");
			result = false;
		}

		if(result)
			return null;
		else
			return response.toString();
	}
}
