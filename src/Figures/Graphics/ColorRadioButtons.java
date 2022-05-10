package Figures.Graphics;

import Figures.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorRadioButtons extends JPanel implements ActionListener {
    static String redString = "Красный";
    static String blueString = "Синий";
    static String cyanString = "Голубой";
    static String orangeString = "Оранжевый";
    ButtonGroup group;
    JRadioButton redButton;
    JRadioButton blueButton;
    JRadioButton cyanButton;
    JRadioButton orangeButton;
    Figure figure;

    String setColor;


//    public ColorRadioButtons(MainJFrame parent) {
    public ColorRadioButtons(Figure figure) {
        super();
//        this.parent = parent;
        this.figure = figure;
        redButton = new JRadioButton(redString);
        redButton.setBackground(Color.RED);
        redButton.setActionCommand(redString);
        redButton.setSelected(true);

        blueButton = new JRadioButton(blueString);
        blueButton.setBackground(Color.BLUE);
        blueButton.setActionCommand(blueString);

        cyanButton = new JRadioButton(cyanString);
        cyanButton.setBackground(Color.CYAN);
        cyanButton.setActionCommand(cyanString);

        orangeButton = new JRadioButton(orangeString);
        orangeButton.setBackground(Color.ORANGE);
        orangeButton.setActionCommand(orangeString);

        group = new ButtonGroup();
        group.add(redButton);
        group.add(blueButton);
        group.add(cyanButton);
        group.add(orangeButton);

        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.add(redButton);
        radioPanel.add(blueButton);
        radioPanel.add(cyanButton);
        radioPanel.add(orangeButton);

        add(radioPanel, BorderLayout.LINE_START);

        redButton.addActionListener(this);
        blueButton.addActionListener(this);
        cyanButton.addActionListener(this);
        orangeButton.addActionListener(this);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals(redString)) {
            setColor = redString;
            System.out.println(redString);
        }

        else if (e.getActionCommand().equals(blueString)) {
            setColor = blueString;
            System.out.println(blueString);
        }

        else if (e.getActionCommand().equals(cyanString)) {
            setColor = cyanString;
            System.out.println(cyanString);
        }

        else if (e.getActionCommand().equals(orangeString)) {
            setColor = orangeString;
            System.out.println(orangeString);
        }
        System.out.println(setColor);
    }
}
