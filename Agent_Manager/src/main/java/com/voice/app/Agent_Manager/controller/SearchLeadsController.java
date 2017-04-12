package com.voice.app.Agent_Manager.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.voice.app.Agent_Manager.dao.factory.DAOFactory;
import com.voice.app.Agent_Manager.view.SearchLeadsView;

/**
 * Controller accompanying the search leads by 
 * criteria use case.
 * @author Kyle Gendron
 *
 */
public class SearchLeadsController implements ActionListener, ChangeListener{
	MainMenuController controller;
	SearchLeadsView view;
	DAOFactory daoFactory;
	
	public SearchLeadsController(MainMenuController controller, DAOFactory daoFactory){
		this.controller = controller;
		this.daoFactory = daoFactory;
		//TODO:
		//-load up search criteria from DB into string arrays
		//-construct view using these arrays.
		view = new SearchLeadsView(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
			case "Cancel":
				controller.getView().removeTab();
				break;
		}
	}
	
	/**
	 * Returns the view associated with this controller.
	 * @return view the view associated with this controller
	 */
	public SearchLeadsView getView(){
		return view;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if(view.getEnableDateCheckBox().isSelected()){
			view.getStartDatePicker().setEnabled(true);
			view.getEndDatePicker().setEnabled(true);
		}
		if(!view.getEnableDateCheckBox().isSelected()){
			view.getStartDatePicker().setEnabled(false);
			view.getEndDatePicker().setEnabled(false);
		}
		if(view.getEnableIncentiveCheckBox().isSelected()){
			view.getIncentiveLowSpinner().setEnabled(true);
			view.getIncentiveHighSpinner().setEnabled(true);
		}
		if(!view.getEnableIncentiveCheckBox().isSelected()){
			view.getIncentiveLowSpinner().setEnabled(false);
			view.getIncentiveHighSpinner().setEnabled(false);
		}
	}
	
	/**
	 * Acts as view's catalyst for populating a combo box's menus.
	 * Accesses the DAO, pulls all distinct values for a given field,
	 * adds a blank field, and then sorts the List before converting
	 * it into an array and returning that array.
	 * @param fieldName the field to retrieve all distinct values for
	 * @return the array of distinct values for that field name
	 */
	public String[] getComboBoxElements(String fieldName){
		List<String> result = daoFactory.getLeadDAO().getDistinctValues(fieldName);
		result.add("");
		Collections.sort(result);
		return result.toArray(new String[0]);
	}
}
