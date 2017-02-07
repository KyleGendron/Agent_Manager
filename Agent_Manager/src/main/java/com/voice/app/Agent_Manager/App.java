package com.voice.app.Agent_Manager;

import java.awt.EventQueue;

import com.voice.app.Agent_Manager.controller.MainMenuController;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MainMenuController controller = new MainMenuController();
        EventQueue.invokeLater(controller::initializeGUI);
    }
}
