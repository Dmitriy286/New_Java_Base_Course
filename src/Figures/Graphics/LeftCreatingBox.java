package Figures.Graphics;

import Figures.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


public class LeftCreatingBox extends Box implements ActionListener {
    JLabel coordinateXLabel = new JLabel("Координата X:");
    JTextField coordinateXTextField = new JTextField();
    JLabel coordinateYLabel = new JLabel("Координата Y:");
    JTextField coordinateYTextField = new JTextField();
    JLabel pointsListLabel = new JLabel("Список точек:");
    JList pointList = new JList();
    ColorRadioButtons colorRadioButtons;

    static String redString = "Красный";

    JButton plusButton = new JButton("+");
    JButton minusButton = new JButton("-");
    JButton createButton = new JButton("Создать");
    JButton saveButton = new JButton("Сохранить");
    JButton stepBackButton = new JButton("Назад");

    JScrollPane listScroller = new JScrollPane(pointList);

    int betweenSpace = 5;

    MainJFrame parent;
    Figure parentFigure;

    public LeftCreatingBox(int axis, MainJFrame parent) {
        super(axis);
        this.parent = parent;
        this.parentFigure = parent.getNewFigure();
        createVerticalBox();

//
//        coordinateXLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
//        coordinateXTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
//        coordinateYLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
//        coordinateYTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
//        pointsListLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
//        pointList.setAlignmentX(Component.LEFT_ALIGNMENT);
//        plusButton.setAlignmentX(Component.LEFT_ALIGNMENT);
//        createButton.setAlignmentX(Component.LEFT_ALIGNMENT);
//        saveButton.setAlignmentX(Component.LEFT_ALIGNMENT);
//        stepBackButton.setAlignmentX(Component.LEFT_ALIGNMENT);

//        add(Box.createVerticalStrut(betweenSpace));

//        coordinateXLabel.setMinimumSize(new Dimension(100, 30));
//        coordinateXLabel.setPreferredSize(new Dimension(100, 30));
//        coordinateXLabel.setMaximumSize(new Dimension(100, 30));
        add(coordinateXLabel);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(coordinateXTextField);
//        coordinateXTextField.setMinimumSize(new Dimension(100, 30));
//        coordinateXTextField.setPreferredSize(new Dimension(100, 30));
//        coordinateXTextField.setMaximumSize(new Dimension(100, 30));
        add(coordinateXTextField);

        add(Box.createVerticalStrut(betweenSpace));
        add(coordinateYLabel);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(coordinateYTextField);
//        coordinateYTextField.setMinimumSize(new Dimension(100, 30));
//        coordinateYTextField.setPreferredSize(new Dimension(100, 30));
//        coordinateYTextField.setMaximumSize(new Dimension(100, 30));
        add(coordinateYTextField);

        add(Box.createVerticalStrut(betweenSpace));
        add(pointsListLabel);

        add(Box.createVerticalStrut(betweenSpace));
//        setSizeAndFormatMethod(pointList);
//        pointList.setVisibleRowCount(7);
        setSizeAndFormatMethod(listScroller);
//        listScroller.setPreferredSize(new Dimension(100, 80));
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

//        add(Box.createVerticalStrut(betweenSpace));
    }

    public void setSizeAndFormatMethod(JComponent component) {
        int width = 100;
        int height = 60;
        if (component.getClass().equals(JTextField.class)) {
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
        component.setAlignmentX(Component.LEFT_ALIGNMENT);

//        if (component.getClass().equals(JList.class)) {
//            JList jlist = (JList)component;
//            component.setVisibleRowCount(7);
//        }
//    button.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
