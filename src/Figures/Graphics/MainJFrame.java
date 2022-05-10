package Figures.Graphics;

import Figures.Figure;
import Figures.Point;
import Figures.Writer.FigureFileInfo;
import Figures.Writer.JSON_Serialization;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

public class MainJFrame extends JFrame {
    String path;
    JPanel leftBasePanel;

    ArrayList<Point> pointsList;
    ArrayList<Figure> figureJSONList;
    ArrayList<Figure> tempFigureList = new ArrayList<>();
    JSON_Serialization jsn = new JSON_Serialization();
    Figure changedFigure;

    boolean choiceFigureButtonFlag = false;

    MainLeftBox leftBox = new MainLeftBox(BoxLayout.Y_AXIS);
    LeftCreatingBox leftCreatingBox = new LeftCreatingBox(BoxLayout.Y_AXIS, this);
    LeftOperationsBox leftOperationsBox = new LeftOperationsBox(BoxLayout.Y_AXIS);
    LeftScalingBox leftScalingBox = new LeftScalingBox(BoxLayout.Y_AXIS);
    LeftRotatingBox leftRotatingBox = new LeftRotatingBox(BoxLayout.Y_AXIS);
    LeftMovingBox leftMovingBox = new LeftMovingBox(BoxLayout.Y_AXIS);

    JFigureDrawing drawedFigures;

    DefaultListModel listModel;
    Figure newFigure;
    FigureDefining defineFigure;

    JFrame consoleFrame = new JFrame();

    UserConsole uc = new UserConsole();


    public MainJFrame () throws IOException {
        super("Как тебе такое, Илон Маск?");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
//        setLocation(400,100);
//        setVisible(true);
        consoleFrame.setSize(100,100);
        consoleFrame.setTitle("Пользовательская консоль");
        consoleFrame.setVisible(true);
        consoleFrame.add(uc);

        listModel = new DefaultListModel();


        GridBagLayout gbl = new GridBagLayout();
        this.setLayout(gbl);
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.gridx = 0;
        constraints.gridy = 0;

        JLabel label1 = new JLabel("");
        gbl.setConstraints(label1, constraints);
        getContentPane().add(label1);
        JLabel label2 = new JLabel("");
        gbl.setConstraints(label2, constraints);
        getContentPane().add(label2);
        JLabel label3 = new JLabel("");
        gbl.setConstraints(label3, constraints);
        getContentPane().add(label3);
        JLabel label4 = new JLabel("");
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        gbl.setConstraints(label4, constraints);
        getContentPane().add(label4);

        leftBasePanel = new JPanel();
        leftBasePanel.setBackground(Color.GREEN);
        leftBasePanel.setMinimumSize(new Dimension(getContentPane().getWidth()/8, getContentPane().getHeight()));
        leftBasePanel.setPreferredSize(new Dimension(getContentPane().getWidth()/8, getContentPane().getHeight()));
        leftBasePanel.setMaximumSize(new Dimension(getContentPane().getWidth()/6, getContentPane().getHeight()));

        constraints.gridwidth = 1;
        constraints.gridheight = 3;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;

        gbl.setConstraints(leftBasePanel, constraints);
        getContentPane().add(leftBasePanel);
        leftBasePanel.add(leftBox, BorderLayout.CENTER);

        path = "Figure JSON file.json";
        figureJSONList = new ArrayList<>();
        FigureFileInfo info = new FigureFileInfo();
        if (info.isFileEmpty()) {
            System.out.println("Фигур пока нет, создаю тестовую фигуру");
            figureJSONList.add(new FigureList().triangle1);
            jsn.serializeWithJSON(figureJSONList, path);
        }
        else {
            figureJSONList = jsn.deserializeWithJSON(path);
        }
        drawedFigures = new JFigureDrawing(figureJSONList);

        constraints.gridwidth = 3;
        constraints.gridheight = 3;
        constraints.weightx = 5;
        constraints.weighty = 0;
        constraints.gridx = 1;
        constraints.gridy = 0;

        gbl.setConstraints(drawedFigures, constraints);
        getContentPane().add(drawedFigures);

//кнопки на основной левой панели:

        leftBox.createFigureButton.addActionListener(e -> {
            leftBasePanel.remove(leftBox);
            leftBasePanel.add(leftCreatingBox, BorderLayout.WEST);

            revalidate();
            repaint();
        });

        leftBox.showAllFigures.addActionListener(e -> {
            FigureFileInfo info1 = new FigureFileInfo();
            if (info1.isFileEmpty()) {
                for (var figure: tempFigureList) {
                    figureJSONList.add(figure);
                }
                tempFigureList.clear();
                try {
                    jsn.serializeWithJSON(figureJSONList, path);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println(figureJSONList);
            System.out.println(figureJSONList.size());
            String str = Integer.toString(figureJSONList.size());
            uc.consolePrinting(str);
            uc.consolePrinting("Тест консоли");
            drawedFigures.repaintFigures(figureJSONList);
            revalidate();
            repaint();
        });

        leftBox.deleteAllFiguresButton.addActionListener(e -> {
            DeleteFigures terminator = new DeleteFigures(path);
            try {
                terminator.deleteInfoInJSONFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            for (var figure: figureJSONList) {
                tempFigureList.add(figure);
            }
            figureJSONList.clear();
            drawedFigures.repaintFigures(figureJSONList);
            drawedFigures.revalidate();
            drawedFigures.repaint();
            revalidate();
            repaint();
        });

        leftBox.chooseFiguresButton.addActionListener(e -> {
            choiceFigureButtonFlag = true;
            leftBasePanel.remove(leftBox);
            leftBasePanel.add(leftOperationsBox, BorderLayout.WEST);
//правильное обновление:
            revalidate();
            repaint();
        });


//кнопки на панели создания фигур:
        leftCreatingBox.plusButton.addActionListener(e -> {
            String point = leftCreatingBox.coordinateXTextField.getText()
                    + ";" + leftCreatingBox.coordinateYTextField.getText();
            listModel.add(listModel.getSize(), point);

            leftCreatingBox.pointList.setModel(listModel);
            leftCreatingBox.coordinateXTextField.setText("");
            leftCreatingBox.coordinateYTextField.setText("");
        });

        leftCreatingBox.minusButton.addActionListener(e -> {
            int index = leftCreatingBox.pointList.getSelectedIndex();
            listModel.remove(index);
        });

        leftCreatingBox.createButton.addActionListener(e -> {
            newFigure = new CreateFigure(creatingPointsList(listModel)).newFigure();
            ArrayList<Figure> tempArrayList = new ArrayList<>();
            newFigure.setColor(leftCreatingBox.colorRadioButtons.setColor);
            System.out.println("По идее присвоился цвет и этот цвет: " + leftCreatingBox.colorRadioButtons.setColor);
            tempArrayList.add(newFigure);
            drawedFigures.repaintFigures(tempArrayList);
            listModel.removeAllElements();

            revalidate();
            repaint();
        });

        leftCreatingBox.saveButton.addActionListener(e -> {
            figureJSONList.add(newFigure);
            try {
                jsn.serializeWithJSON(figureJSONList, path);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        leftCreatingBox.stepBackButton.addActionListener(e -> {
            leftBasePanel.remove(leftCreatingBox);
            leftBasePanel.add(leftBox, BorderLayout.WEST);

            revalidate();
            repaint();
        });

        //клик мышкой после нажатия кнопки "выбор фигуры"

        drawedFigures.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e){
                if (choiceFigureButtonFlag) {
                    int x = e.getX() - drawedFigures.getWidth() / 2; //328 656
                    int y = drawedFigures.getHeight() / 2 - e.getY();
                    System.out.println("Координаты: " + x + "," + y);
                    Point point = new Point(x, y);
                    defineFigure = new FigureDefining(figureJSONList, point);
                    defineFigure.scanningFigures();
                    if (defineFigure.foundFigure.size() > 0) {
                        drawedFigures.repaintFigures(defineFigure.foundFigure);
                        System.out.println("В указанной точке находится фигура: " +
                                defineFigure.foundFigure.get(0));

                        revalidate();
                        repaint();
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });

        //кнопки на панели операций с фигурами:

        leftOperationsBox.scaleFigureButton.addActionListener(e -> {
            System.out.println("Тест кнопки масштабирование" + defineFigure.foundFigure);
            System.out.println("Выбранная фигура: " + figureJSONList.get(defineFigure.index));
            leftBasePanel.remove(leftOperationsBox);
            leftBasePanel.add(leftScalingBox, BorderLayout.WEST);

            revalidate();
            repaint();
        });

        leftScalingBox.scaleButton.addActionListener(e -> {
            DefaultListModel listModel1 = new DefaultListModel();
            ArrayList<Figure> tempFigureList = new ArrayList();
            double scaleFactor = Double.parseDouble(leftScalingBox.scaleFactorTextField.getText());
            listModel1.add(0, scaleFactor);
            leftScalingBox.scaleFactorJList.setModel(listModel1);
            changedFigure = figureJSONList.get(defineFigure.index).scale(scaleFactor);
            tempFigureList.add(changedFigure);
            drawedFigures.repaintFigures(tempFigureList);
            leftScalingBox.scaleFactorTextField.setText("");
            listModel.removeAllElements();
            revalidate();
            repaint();
        });

        leftScalingBox.saveChangesButton.addActionListener(e -> {
            figureJSONList.remove(defineFigure.index);
            figureJSONList.add(changedFigure);
            try {
                jsn.serializeWithJSON(figureJSONList, path);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            drawedFigures.repaintFigures(figureJSONList);

            revalidate();
            repaint();
        });

        leftScalingBox.stepBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leftBasePanel.remove(leftScalingBox);
                leftBasePanel.add(leftOperationsBox, BorderLayout.WEST);

                revalidate();
                repaint();
            }
        });

        leftOperationsBox.rotateFigureButton.addActionListener(e -> {
            System.out.println("Тест кнопки поворот" + defineFigure.foundFigure);
            System.out.println("Выбранная фигура: " + figureJSONList.get(defineFigure.index));
            leftBasePanel.remove(leftOperationsBox);
            leftBasePanel.add(leftRotatingBox, BorderLayout.WEST);

            revalidate();
            repaint();
        });

        leftRotatingBox.rotateButton.addActionListener(e -> {
            DefaultListModel listModel1 = new DefaultListModel();
            ArrayList<Figure> tempFigureList = new ArrayList();
            double angle = Double.parseDouble(leftRotatingBox.rotateAngleTextField.getText());
            listModel1.add(0, angle);
            leftRotatingBox.rotateAngleJList.setModel(listModel1);
            changedFigure = figureJSONList.get(defineFigure.index).rotate(angle, leftRotatingBox.rotateRadioButtons.settedVector);
            tempFigureList.add(changedFigure);
            drawedFigures.repaintFigures(tempFigureList);
            leftRotatingBox.rotateAngleTextField.setText("");
            listModel.removeAllElements();

            revalidate();
            repaint();
        });

        leftRotatingBox.saveChangesButton.addActionListener(e -> {
            figureJSONList.remove(defineFigure.index);
            figureJSONList.add(changedFigure);
            try {
                jsn.serializeWithJSON(figureJSONList, path);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            drawedFigures.repaintFigures(figureJSONList);

            revalidate();
            repaint();
        });

        leftRotatingBox.stepBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leftBasePanel.remove(leftRotatingBox);
                leftBasePanel.add(leftOperationsBox, BorderLayout.WEST);

                revalidate();
                repaint();
            }
        });

        leftOperationsBox.moveFigureButton.addActionListener(e -> {
            System.out.println("Тест кнопки перемещение" + defineFigure.foundFigure);
            System.out.println("Выбранная фигура: " + figureJSONList.get(defineFigure.index));
            leftBasePanel.remove(leftOperationsBox);
            leftBasePanel.add(leftMovingBox, BorderLayout.WEST);

            revalidate();
            repaint();
        });

        leftMovingBox.moveUpButton.addActionListener(e -> {

            ArrayList<Figure> tempFigureList = new ArrayList();
            changedFigure = figureJSONList.get(defineFigure.index).move(5, 1);

            tempFigureList.add(changedFigure);
            drawedFigures.repaintFigures(tempFigureList);

            revalidate();
            repaint();

        });

        leftMovingBox.moveDownButton.addActionListener(e -> {
            ArrayList<Figure> tempFigureList = new ArrayList();
            changedFigure = figureJSONList.get(defineFigure.index).move(5, 2);
            tempFigureList.add(changedFigure);
            drawedFigures.repaintFigures(tempFigureList);

            revalidate();
            repaint();
        });

        leftMovingBox.moveLeftButton.addActionListener(e -> {
            ArrayList<Figure> tempFigureList = new ArrayList();
            changedFigure = figureJSONList.get(defineFigure.index).move(5, 3);
            tempFigureList.add(changedFigure);
            drawedFigures.repaintFigures(tempFigureList);

            revalidate();
            repaint();
        });

        leftMovingBox.moveRightButton.addActionListener(e -> {
            ArrayList<Figure> tempFigureList = new ArrayList();
            changedFigure = figureJSONList.get(defineFigure.index).move(5, 4);
            tempFigureList.add(changedFigure);
            drawedFigures.repaintFigures(tempFigureList);

            revalidate();
            repaint();
        });

        leftMovingBox.saveChangesButton.addActionListener(e -> {
            figureJSONList.remove(defineFigure.index);
            figureJSONList.add(changedFigure);
            try {
                jsn.serializeWithJSON(figureJSONList, path);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            drawedFigures.repaintFigures(figureJSONList);

            revalidate();
            repaint();
        });

        leftMovingBox.stepBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leftBasePanel.remove(leftMovingBox);
                leftBasePanel.add(leftOperationsBox, BorderLayout.WEST);

                revalidate();
                repaint();
            }
        });

        leftOperationsBox.deleteFigureButton.addActionListener(e -> {
            figureJSONList.remove(defineFigure.index);
            try {
                jsn.serializeWithJSON(figureJSONList, path);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            drawedFigures.repaintFigures(figureJSONList);

            revalidate();
            repaint();
        });

        leftOperationsBox.cancellChoice.addActionListener(e -> {
        drawedFigures.repaintFigures(figureJSONList);
        defineFigure = null;
//        defineFigure.foundFigure.clear();
        revalidate();
        repaint();
        });

        leftOperationsBox.stepBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choiceFigureButtonFlag = false;
                leftBasePanel.remove(leftOperationsBox);
                leftBasePanel.add(leftBox, BorderLayout.WEST);

                revalidate();
                repaint();
            }
        });


        setLocation(400,0);
//        pack();
        setVisible(true);
    }


    public ArrayList<Point> creatingPointsList(DefaultListModel listModel) {
        pointsList = new ArrayList<>(0);
        String [] pointsArray;
        for (int i = 0; i < listModel.getSize(); i++) {
            pointsArray = listModel.getElementAt(i).toString().split(";");
            pointsList.add(new Point(Double.parseDouble(pointsArray[0]),Double.parseDouble(pointsArray[1])));
        }
        return pointsList;
    }

    public Figure getNewFigure() {
        return this.newFigure;
    }

//    public void frameRepaint() {
//        this.repaint();
//    }

}
