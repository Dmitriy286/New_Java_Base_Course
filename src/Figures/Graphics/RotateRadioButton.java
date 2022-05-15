package Figures.Graphics;

import Figures.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RotateRadioButton extends JPanel implements ActionListener {
    static String leftString = "<-";
    static String rightString = "->";

    ButtonGroup group;
    JRadioButton leftButton;
    JRadioButton rightButton;

    boolean settedVector;

    public RotateRadioButton() {
        super();

        JPanel tempPanel = new JPanel();
        tempPanel.setBackground(Color.CYAN);
        GridBagLayout gbl = new GridBagLayout();
        tempPanel.setLayout(gbl);
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.gridx = 0;
        constraints.gridy = 0;

        JLabel label1 = new JLabel("");
        constraints.weightx = 1;
        gbl.setConstraints(label1, constraints);
        tempPanel.add(label1);
        JLabel label2 = new JLabel("");
        constraints.weightx = 1;
        gbl.setConstraints(label2, constraints);
        tempPanel.add(label2);
//        constraints.gridwidth = GridBagConstraints.REMAINDER;

        leftButton = new JRadioButton(leftString);
        leftButton.setBackground(Color.CYAN);
        leftButton.setActionCommand(leftString);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;

        gbl.setConstraints(leftButton, constraints);
        tempPanel.add(leftButton);

        rightButton = new JRadioButton(rightString);
        rightButton.setBackground(Color.CYAN);
        rightButton.setActionCommand(rightString);
        rightButton.setSelected(true);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;

        gbl.setConstraints(rightButton, constraints);
        tempPanel.add(rightButton);


        group = new ButtonGroup();
        group.add(leftButton);
        group.add(rightButton);

        add(tempPanel, BorderLayout.LINE_START);

        leftButton.addActionListener(this);
        rightButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(leftString)) {
            settedVector = false;
            System.out.println(settedVector);
        }

        else if (e.getActionCommand().equals(rightString)) {
            settedVector = true;
            System.out.println(settedVector);
        }
    }

}
