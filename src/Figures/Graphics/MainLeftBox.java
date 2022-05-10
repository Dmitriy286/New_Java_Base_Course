package Figures.Graphics;

import javax.swing.*;
import java.awt.*;

///**
// * Creates a <code>Box</code> that displays its components
// * along the specified axis.
// *
//// * @param axis can be {@link BoxLayout#X_AXIS},
// *             {@link BoxLayout#Y_AXIS},
// *             {@link BoxLayout#LINE_AXIS} or
// *             {@link BoxLayout#PAGE_AXIS}.
//// * @throws AWTError if the <code>axis</code> is invalid
// * @see #createHorizontalBox
// * @see #createVerticalBox
// */

public class MainLeftBox extends Box {
    JButton createFigureButton = new JButton("<html>Создать<br>фигуру");
    JButton showAllFigures = new JButton("<html>Показать<br>все<br>фигуры");
    JButton deleteAllFiguresButton = new JButton("<html>Удалить<br>все<br>фигуры");
    JButton chooseFiguresButton = new JButton("<html>Выбрать<br>фигуру");

    public MainLeftBox(int axis) {
        super(axis);
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
//    button.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
}

}
