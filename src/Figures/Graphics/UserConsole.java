package Figures.Graphics;

import Figures.Figure;

import javax.swing.*;
import java.util.ArrayList;

public class UserConsole extends JPanel {
//    JLabel userConsoleLabel;
//    JLabel userConsoleLabel1;
    JList userConsoleJList;
    DefaultListModel listModel;

    public UserConsole () {
//        userConsoleLabel = new JLabel("Консоль:");
//        userConsoleLabel1 = new JLabel("\n");
        userConsoleJList = new JList();
        listModel = new DefaultListModel();

//        add(userConsoleLabel);
//        add(userConsoleLabel1);
        add(userConsoleJList);

    }

    public void consolePrinting(String message) {
        System.out.println(message);
        userConsoleJList.setModel(listModel);
        listModel.add(0, message);
    }

    public void clearConsole() {
        listModel.removeAllElements();
    }

}
