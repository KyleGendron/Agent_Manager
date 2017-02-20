package com.voice.app.Agent_Manager;

import java.awt.EventQueue;

import com.voice.app.Agent_Manager.controller.MainMenuController;

/**
 *Top level application class that coordinates the calls to view and Controller
 *@version 0.1
 *@author Kyle Gendron
 */
public class App 
{
    public static void main( String[] args )
    {
        MainMenuController controller = new MainMenuController();
        EventQueue.invokeLater(controller::initializeGUI);
    }
}
