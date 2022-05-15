package Figures.Graphics;

import Figures.Figure;

import javax.swing.*;
import java.awt.*;

public class LeftCreatingBox extends Box {
    JLabel coordinateXLabel;
    JTextField coordinateXTextField;
    JLabel coordinateYLabel;
    JTextField coordinateYTextField;
    JLabel pointsListLabel;
    JList pointList;
    ColorRadioButtons colorRadioButtons;

    JButton plusButton;
    JButton minusButton;
    JButton createButton;
    JButton saveButton;
    JButton stepBackButton;

    JScrollPane listScroller;

    int betweenSpace = 5;

    MainJFrame parent;
    Figure parentFigure;

    public LeftCreatingBox(int axis, MainJFrame parent) {
        super(axis);
        this.parent = parent;
        this.parentFigure = parent.getNewFigure();

        createVerticalBox();

        coordinateXLabel = new JLabel("Координата X:");
        coordinateXTextField = new JTextField();
        coordinateYLabel = new JLabel("Координата Y:");
        coordinateYTextField = new JTextField();
        pointsListLabel = new JLabel("Список точек:");
        pointList = new JList();

        plusButton = new JButton("+");
        minusButton = new JButton("-");
        createButton = new JButton("Создать");
        saveButton = new JButton("Сохранить");
        stepBackButton = new JButton("Назад");

        listScroller = new JScrollPane(pointList);

//        setAlignmentX(Component.CENTER_ALIGNMENT);
//        setAlignmentX(Component.TOP_ALIGNMENT);

        setSizeAndFormatMethod(coordinateXLabel);
        add(coordinateXLabel);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(coordinateXTextField);
        add(coordinateXTextField);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(coordinateYLabel);
        add(coordinateYLabel);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(coordinateYTextField);
        add(coordinateYTextField);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(pointsListLabel);
        add(pointsListLabel);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(listScroller);
        add(listScroller);

        colorRadioButtons = new ColorRadioButtons(parentFigure);
        colorRadioButtons.setBackground(Color.GREEN);
        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(colorRadioButtons);
        add(colorRadioButtons);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(plusButton);
        add(plusButton);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(minusButton);
        add(minusButton);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(createButton);
        add(createButton);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(saveButton);
        add(saveButton);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(stepBackButton);
        add(stepBackButton);
    }

    public void setSizeAndFormatMethod(JComponent component) {
        int width = 100;
        int height = 60;
        if (component.getClass().equals(JTextField.class)) {
            width = 100;
            height = 20;
        }
        if (component.getClass().equals(JLabel.class)) {
            width = 100;
            height = 20;
        }
        if (component.getClass().equals(ColorRadioButtons.class)) {
            width = 100;
            height = 100;
        }
        Dimension dimension = new Dimension(width, height);
        component.setMinimumSize(dimension);
        component.setPreferredSize(dimension);
        component.setMaximumSize(dimension);
        component.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

}
