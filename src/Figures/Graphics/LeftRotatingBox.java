package Figures.Graphics;

import javax.swing.*;
import java.awt.*;

public class LeftRotatingBox extends Box {
    JLabel rotateAngleLabel = new JLabel("Угол в радианах:");
    JTextField rotateAngleTextField = new JTextField();
    JLabel enteredRotateAngleLabel = new JLabel("Вы ввели:");
    JList rotateAngleJList = new JList();
    JButton rotateButton = new JButton("Повернуть");
    JButton saveChangesButton = new JButton("<html>Сохранить<br>изменения");
    JButton stepBackButton = new JButton("Назад");
    JLabel rotateVectorLabel = new JLabel("Направление:");
    RotateRadioButton rotateRadioButtons;

    int betweenSpace = 10;

    public LeftRotatingBox(int axis) {
        super(axis);
        createVerticalBox();

        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(rotateAngleLabel);
        add(rotateAngleLabel);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(rotateAngleTextField);
        add(rotateAngleTextField);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(enteredRotateAngleLabel);
        add(enteredRotateAngleLabel);

        add(Box.createVerticalStrut(betweenSpace));
//        setSizeAndFormatMethod(pointList);
//        pointList.setVisibleRowCount(7);
        setSizeAndFormatMethod(rotateAngleJList);
        add(rotateAngleJList);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(rotateVectorLabel);
        add(rotateVectorLabel);

        rotateRadioButtons = new RotateRadioButton();
        rotateRadioButtons.setBackground(Color.CYAN);
        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(rotateRadioButtons);
        add(rotateRadioButtons);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(rotateButton);
        add(rotateButton);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(saveChangesButton);
        add(saveChangesButton);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(stepBackButton);
        add(stepBackButton);
    }

    public void setSizeAndFormatMethod(JComponent component) {
        int width = 100;
        int height = 70;
        if (component.getClass().equals(JTextField.class)) {
            width = 100;
            height = 30;
        }
        if (component.getClass().equals(JLabel.class)) {
            width = 100;
            height = 20;
        }
        if (component.getClass().equals(RotateRadioButton.class)) {
            width = 100;
            height = 40;
        }
        Dimension dimension = new Dimension(width, height);
        component.setMinimumSize(dimension);
        component.setPreferredSize(dimension);
        component.setMaximumSize(dimension);
        component.setAlignmentX(Component.CENTER_ALIGNMENT);

    }

}
