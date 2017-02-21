package com.voice.app.Agent_Manager.utils;

import java.io.File;
import java.util.ArrayList;

import com.voice.app.Agent_Manager.domain.concrete.LeadRecord;

public class LeadConverterCSV {
	private File file;
	
	/**
	 * 1-Param constructor.
	 * @param file the file to be processed
	 */
	public LeadConverterCSV(File file){
		this.file = file;
	}
	
	/**
	 * Takes the LeadConverterCSV's file and processes it into
	 * an ArrayList of LeadRecords which are returned by this method.
	 * @return result the ArrayList result of the call to process the file
	 */
	public ArrayList<LeadRecord> process(){
		if(file.getName().endsWith(".csv")){
			ArrayList<LeadRecord> result = new ArrayList<LeadRecord>();
			LeadRecord record;
			String input = FileHandler.stringFromFile(file);
			String[] lines = input.split("(\r\n|\r|\n)");
			for(int i = 0; i < lines.length; i++){
				//check format carefully
				if(lines[i].matches("[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4},"
						+ "[A-Z]{1},[a-zA-z\\s]{1,100},[a-zA-Z0-9]{0,100},"
						+ "[a-zA-Z0-9]{0,100},([^,]{1,100}|\\\".*\\\"),"
						+ "([^,]{0,100}|\\\".*\\\"),[0-9]{1,100},[x | N]?,"
						+ "[a-zA-z\\s-]{1,100},[a-zA-z\\s-]{1,100},"
						+ "\\$[0-9]+\\.[0-9]{2}[\\s]?,[^,]{0,200}")){
					record = new LeadRecord(cleanInput(lines[i]).split(","));
					result.add(record);
				}
			}
			if(result.isEmpty()){
				return null;
			}else
				return result;
		}else
			return null;
	}
	
	/**
	 * Helper method that cleans out any csv elements
	 * containing a comma.  This algorithm is based on MS Excel's
	 * tendency to surround strings containing commas with quotes
	 * when saving as a .csv file.  It also relies on that fact that
	 * MS Excel assures that every opening quote has an end quote.
	 * @param input the string to clean
	 * @return result the resulting string without commas in string values
	 */
	public String cleanInput(String input){
		int lastIndex = 0; //lastIndex pushed to StringBuilder
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < input.length(); i++){
			//if we've reached the end of the string,
			if(i == input.length()-1)
				result.append(input.substring(lastIndex, input.length()));
			//look for opening quote
			if(input.charAt(i) == '\"'){
				//grab everything before opening quote
				result.append(input.substring(lastIndex, i)); 
				//look for closing quote
				for(int j = i+1; j < input.length(); j++){
					if(input.charAt(j) == '\"'){
						//add everything in between, but not including, quotes
						result.append(input.substring(i+1, j).replaceAll(",", ""));
						lastIndex = j+1; //again, exclude quotes
					}
				}
				i = lastIndex;
			}
		}
		return result.toString();
	}
}
