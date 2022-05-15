package Figures.Graphics;

import javax.swing.*;
import java.awt.*;

public class UserConsole extends Box {
    JTextArea textArea;
    Font font;
    Color color;

    public UserConsole (int axis) {
        super(axis);
        textArea = new JTextArea();
        font = new Font("Serif", Font.BOLD, 12);
        color = new Color(254, 238, 202);

        testAreaFormat();

        add(Box.createVerticalStrut(5));
        add(textArea);
        add(Box.createVerticalStrut(5));
    }

    public void consolePrinting(String message) {
        System.out.println(message);
        textArea.append(message);
    }

    public void clearConsole() {
        textArea.setText("");
    }

    public void testAreaFormat() {
        int width = 100;
        int height = 100;
        Dimension dimension = new Dimension(width, height);

        textArea.setEditable(false);
        textArea.setFont(font);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setForeground(Color.BLACK);
        textArea.setBackground(color);

        textArea.setMinimumSize(dimension);
        textArea.setPreferredSize(dimension);
        textArea.setMaximumSize(dimension);
    }

}
