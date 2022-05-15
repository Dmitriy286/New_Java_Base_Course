package Figures.Graphics;

import javax.swing.*;
import java.awt.*;

public class MainLeftBox extends Box {
    JButton createFigureButton;
    JButton showAllFigures;
    JButton deleteAllFiguresButton;
    JButton chooseFiguresButton;

    public MainLeftBox(int axis) {
        super(axis);
        createFigureButton = new JButton("<html>Создать<br>фигуру");
        showAllFigures = new JButton("<html>Показать<br>все<br>фигуры");
        deleteAllFiguresButton = new JButton("<html>Удалить<br>все<br>фигуры");
        chooseFiguresButton = new JButton("<html>Выбрать<br>фигуру");
        createVerticalBox();

        add(Box.createVerticalStrut(20));
        setSizeMethod(createFigureButton);
        add(createFigureButton);

        add(Box.createVerticalStrut(20));
        setSizeMethod(showAllFigures);
        add(showAllFigures);

        add(Box.createVerticalStrut(20));
        setSizeMethod(deleteAllFiguresButton);
        add(deleteAllFiguresButton);

        add(Box.createVerticalStrut(20));
        setSizeMethod(chooseFiguresButton);
        add(chooseFiguresButton);

        add(Box.createVerticalStrut(20));
}

public void setSizeMethod(JButton button) {
    int width = 100;
    int height = 100;
    Dimension dimension = new Dimension(width, height);
    button.setMinimumSize(dimension);
    button.setPreferredSize(dimension);
    button.setMaximumSize(dimension);
    button.setAlignmentX(Component.CENTER_ALIGNMENT);
}

}
