package Figures.Graphics;

import Figures.Figure;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

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

public class LeftOperationsBox extends Box {
    JButton scaleFigureButton = new JButton("<html>Увеличить<br>фигуру");
    JButton rotateFigureButton = new JButton("<html>Повернуть<br>фигуру");
    JButton moveFigureButton = new JButton("<html>Переместить<br>фигуру");
    JButton deleteFigureButton = new JButton("<html>Удалить<br>фигуру");
    JButton cancellChoice = new JButton("<html>Снять<br>выделение");
    JButton stepBackButton = new JButton("Назад");

    int betweenSpace = 10;

    public LeftOperationsBox(int axis) {
        super(axis);
        createVerticalBox();

        add(Box.createVerticalStrut(betweenSpace));
        setSizeMethod(scaleFigureButton);
        add(scaleFigureButton);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeMethod(rotateFigureButton);
        add(rotateFigureButton);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeMethod(moveFigureButton);
        add(moveFigureButton);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeMethod(deleteFigureButton);
        add(deleteFigureButton);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeMethod(cancellChoice);
        add(cancellChoice);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeMethod(stepBackButton);
        add(stepBackButton);

        add(Box.createVerticalStrut(betweenSpace));
    }
    public void setSizeMethod(JButton button) {
        int width = 100;
        int height = 100;
        Dimension dimension = new Dimension(width, height);
        button.setMinimumSize(dimension);
        button.setPreferredSize(dimension);
        button.setMaximumSize(dimension);
//    button.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
    }

    public void repaintBox() throws IOException {
        this.repaint();
    }
}
