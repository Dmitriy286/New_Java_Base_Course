package Figures.Graphics;

import javax.swing.*;
import java.awt.*;

public class LeftMovingBox extends Box {
    JLabel movingLabel;
    JButton moveUpButton;
    JButton moveRightButton;
    JButton moveDownButton;
    JButton moveLeftButton;
    JButton saveChangesButton;
    JButton stepBackButton;

    int betweenSpace = 10;

    public LeftMovingBox(int axis) {
        super(axis);
        createVerticalBox();

        movingLabel = new JLabel("<html>Переместите<br>фигуру<br>стрелками");
        stepBackButton = new JButton("Назад");
//
//        add(Box.createVerticalStrut(betweenSpace));
//        movingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//        add(movingLabel);

        JPanel tempPanel = new JPanel();
        tempPanel.setBackground(Color.GREEN);
        GridBagLayout gbl = new GridBagLayout();
        tempPanel.setLayout(gbl);
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridwidth = 3;
        constraints.gridheight = 3;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.gridx = 0;
        constraints.gridy = 0;

        moveUpButton = new JButton("<html>^");

        constraints.gridx = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weighty = 1;

        gbl.setConstraints(moveUpButton, constraints);
        tempPanel.add(moveUpButton);

        moveLeftButton = new JButton("<html>&lt");

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;

        gbl.setConstraints(moveLeftButton, constraints);
        tempPanel.add(moveLeftButton);

        saveChangesButton = new JButton("<html>+");

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;

        gbl.setConstraints(saveChangesButton, constraints);
        tempPanel.add(saveChangesButton);

        moveRightButton = new JButton("<html>>");

        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;

        gbl.setConstraints(moveRightButton, constraints);
        tempPanel.add(moveRightButton);

        moveDownButton = new JButton("<html>v</html>");
//        moveDownButton = new JButton("<html><center>v</center></html>");
//        moveDownButton.setHorizontalTextPosition(SwingConstants.CENTER);
//        moveDownButton.setIconTextGap(-1);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weighty = 1;

        gbl.setConstraints(moveDownButton, constraints);
        tempPanel.add(moveDownButton);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(tempPanel);
        add(tempPanel);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(stepBackButton);
        add(stepBackButton);
    }

    public void setSizeAndFormatMethod(JComponent component) {
        int width = 120;
        int height = 100;
        Dimension dimension = new Dimension(width, height);
        component.setMinimumSize(dimension);
        component.setPreferredSize(dimension);
        component.setMaximumSize(dimension);
        component.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
}
