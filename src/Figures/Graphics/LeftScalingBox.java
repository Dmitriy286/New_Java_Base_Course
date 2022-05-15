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

public class LeftScalingBox extends Box {
    JLabel scaleFactorLabel = new JLabel("Коэффициент:");
    JTextField scaleFactorTextField = new JTextField();
    JLabel enteredScaleFactorLabel = new JLabel("Вы ввели:");
    JList scaleFactorJList = new JList();
    JButton scaleButton = new JButton("<html>Увеличить<br>/уменьшить");
    JButton saveChangesButton = new JButton("<html>Сохранить<br>изменения");
    JButton stepBackButton = new JButton("Назад");

    int betweenSpace = 10;

    public LeftScalingBox(int axis) {
        super(axis);
        createVerticalBox();

        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(scaleFactorLabel);
        add(scaleFactorLabel);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(scaleFactorTextField);
        add(scaleFactorTextField);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(enteredScaleFactorLabel);
        add(enteredScaleFactorLabel);

        add(Box.createVerticalStrut(betweenSpace));
//        setSizeAndFormatMethod(pointList);
//        pointList.setVisibleRowCount(7);
        setSizeAndFormatMethod(scaleFactorJList);
        add(scaleFactorJList);

        add(Box.createVerticalStrut(betweenSpace));
        setSizeAndFormatMethod(scaleButton);
        add(scaleButton);

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
        Dimension dimension = new Dimension(width, height);
        component.setMinimumSize(dimension);
        component.setPreferredSize(dimension);
        component.setMaximumSize(dimension);
        component.setAlignmentX(Component.CENTER_ALIGNMENT);

    }

}
