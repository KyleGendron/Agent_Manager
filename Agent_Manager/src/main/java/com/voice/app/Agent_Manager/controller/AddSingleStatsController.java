package com.voice.app.Agent_Manager.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.voice.app.Agent_Manager.domain.concrete.StatsRecord;
import com.voice.app.Agent_Manager.view.AddSingleStatsView;

public class AddSingleStatsController implements ActionListener{
	MainMenuController controller;
	AddSingleStatsView view;
	
	/**
	 * 1-Param Constructor
	 * @param controller the controller above this controller
	 */
	public AddSingleStatsController(MainMenuController controller){
		this.controller = controller;
		view = new AddSingleStatsView(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "Cancel":
			controller.getView().removeTab();
			break;
		case "Submit":
			System.out.println("Submit.");
//			view.getForm().unHighlightErrors(); //refresh error highlights
//			String response = validate(view.getForm());
//			if(response == null){
//				int reply = JOptionPane.showConfirmDialog(view, 
//						"Submission Valid!  Is this info correct?\n\n" +
//						view.getForm().toString() + 
//						"\n\nClick Yes to add to database or No to "
//						+ "continue to edit this record.",
//						"Confirm Submission",
//						JOptionPane.YES_NO_OPTION);
//				if(reply == JOptionPane.YES_OPTION){
//					LeadRecord lead = new LeadRecord(view.getForm());
//					daoFactory.getLeadDAO().add(0, lead);
//					controller.getView().removeTab();
//				}
//			}else
//				JOptionPane.showMessageDialog(view, response);
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

}
