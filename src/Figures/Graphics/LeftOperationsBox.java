package Figures.Graphics;

import javax.swing.*;
import java.awt.*;

public class LeftOperationsBox extends Box {
    JButton scaleFigureButton;
    JButton rotateFigureButton;
    JButton moveFigureButton;
    JButton deleteFigureButton;
    JButton cancellChoice;
    JButton stepBackButton;

    int betweenSpace = 10;

    public LeftOperationsBox(int axis) {
        super(axis);
        scaleFigureButton = new JButton("<html>Изменить<br>размер<br>фигуры");
        rotateFigureButton = new JButton("<html>Повернуть<br>фигуру");
        moveFigureButton = new JButton("<html>Переместить<br>фигуру");
        deleteFigureButton = new JButton("<html>Удалить<br>фигуру");
        cancellChoice = new JButton("<html>Снять<br>выделение");
        stepBackButton = new JButton("Назад");

//        createVerticalBox();

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
        int height = 80;
        Dimension dimension = new Dimension(width, height);
        button.setMinimumSize(dimension);
        button.setPreferredSize(dimension);
        button.setMaximumSize(dimension);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
}
