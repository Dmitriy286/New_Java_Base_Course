package Figures.Graphics;

import javax.swing.*;
import java.awt.*;

///**
// * Creates a <code>Box</code> that displays its components
// * along the specified axis.
// *
// * @param axis can be {@link BoxLayout#X_AXIS},
// *             {@link BoxLayout#Y_AXIS},
// *             {@link BoxLayout#LINE_AXIS} or
// *             {@link BoxLayout#PAGE_AXIS}.
// * @throws AWTError if the <code>axis</code> is invalid
// * @see #createHorizontalBox
// * @see #createVerticalBox
// */

public class LeftMovingBox extends Box {

    JLabel movingLabel = new JLabel("<html>Переместите<br>фигуру<br>стрелками");

    Box box = new Box(BoxLayout.Y_AXIS);

//    JButton moveUpButton = new JButton("Вверх");
//    JButton moveDownButton = new JButton("Вниз");
//    JButton moveRightButton = new JButton("Вправо");
//    JButton moveLeftButton = new JButton("Влево");

    JButton moveUpButton;
    JButton moveRightButton;
    JButton moveDownButton;
    JButton moveLeftButton;
    JButton saveChangesButton;

    JButton stepBackButton = new JButton("Назад");

    int betweenSpace = 10;

    public LeftMovingBox(int axis) {
        super(axis);
        createVerticalBox();

        add(Box.createVerticalStrut(betweenSpace));
        add(movingLabel);

//        add(Box.createVerticalStrut(betweenSpace));
//        setSizeAndFormatMethod(box);
//        add(box);

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

//        JLabel label1 = new JLabel("");
//        constraints.weightx = 1;
//        gbl.setConstraints(label1, constraints);
//        tempPanel.add(label1);
//        JLabel label2 = new JLabel("");
//        constraints.weightx = 1;
//        gbl.setConstraints(label2, constraints);
//        tempPanel.add(label2);
//        JLabel label3 = new JLabel("");
//        constraints.weightx = 1;
//        gbl.setConstraints(label3, constraints);
//        tempPanel.add(label3);
//        constraints.gridwidth = GridBagConstraints.REMAINDER;

        moveUpButton = new JButton("<html>^");

        constraints.gridx = 1;
        constraints.gridy = 0;
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
//        saveChangesButton.setMinimumSize(new Dimension(tempPanel.getWidth()/3, tempPanel.getHeight()/3));
//        saveChangesButton.setPreferredSize(new Dimension(tempPanel.getWidth()/3, tempPanel.getHeight()/3));
//        saveChangesButton.setMaximumSize(new Dimension(tempPanel.getWidth()/3, tempPanel.getHeight()/3));

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

        moveDownButton = new JButton("<html>v");

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weighty = 1;

        gbl.setConstraints(moveDownButton, constraints);
        tempPanel.add(moveDownButton);

//        leftBasePanel = new JPanel();
//        leftBasePanel.setBackground(Color.GREEN);
//        leftBasePanel.setMinimumSize(new Dimension(getContentPane().getWidth()/8, getContentPane().getHeight()));
////        leftBasePanel.setPreferredSize(new Dimension(getContentPane().getWidth()/8, getContentPane().getHeight()));
////        leftBasePanel.setMaximumSize(new Dimension(getContentPane().getWidth()/6, getContentPane().getHeight()));
//        constraints.gridwidth = 1;
//        constraints.gridheight = 3;
//        constraints.weightx = 1;
//        constraints.weighty = 1;
//        constraints.gridx = 0;
//        constraints.gridy = 0;

        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(tempPanel);
        add(tempPanel);

//        add(Box.createVerticalStrut(betweenSpace));
//        setSizeAndFormatMethod(moveUpButton);
//        add(moveUpButton);
//
//        add(Box.createVerticalStrut(betweenSpace));
//        setSizeAndFormatMethod(moveDownButton);
//        add(moveDownButton);
//
//        add(Box.createVerticalStrut(betweenSpace));
//        setSizeAndFormatMethod(moveRightButton);
//        add(moveRightButton);
//
//        add(Box.createVerticalStrut(betweenSpace));
//        setSizeAndFormatMethod(moveLeftButton);
//        add(moveLeftButton);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(stepBackButton);
        add(stepBackButton);


    }

    public void setSizeAndFormatMethod(JComponent component) {
        int width = 120;
        int height = 100;
//        if (component.getClass().equals(JTextField.class)) {
//            width = 100;
//            height = 30;
//        }

//        if (component.equals(moveUpButton) || component.equals(moveDownButton) ||
//            component.equals(moveLeftButton) ||   component.equals(moveRightButton))
//        {
//            width = 100;
//            height = 20;
//        }
        Dimension dimension = new Dimension(width, height);
        component.setMinimumSize(dimension);
        component.setPreferredSize(dimension);
        component.setMaximumSize(dimension);
        component.setAlignmentX(Component.LEFT_ALIGNMENT);

    }
}
