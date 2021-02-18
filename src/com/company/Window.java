package com.company;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Window extends JFrame {

    JTextField linetf;

    public Window(){
        setBounds(20,21,800,600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("GUI");
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);
        addVidgets(panel);
    }
    void addVidgets(JPanel panel) {
        JLabel firstlbl = new JLabel("Just Text");
        firstlbl.setBounds(60, 40, 189, 50);
        Font lblFont = new Font(Font.SERIF, 2, 50);
        firstlbl.setHorizontalAlignment(SwingConstants.CENTER);
        firstlbl.setFont(lblFont);
        panel.add(firstlbl);

        linetf = new JTextField();
        linetf.setFont(lblFont);
        linetf.setBounds(350,510,100, 50);
        panel.add(linetf);

        JSlider slider = new JSlider(0,50,25);
        slider.setBounds(90,150,250,50);
        slider.setPaintTicks(true); //включить деления
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(10);

        slider.setSnapToTicks(true); //перемещаться по делениям
        slider.setPaintLabels(true); //показывать значения (10)
        slider.putClientProperty("JSlider.isFilled", Boolean.TRUE); //заполнить между началом и положение ползунка
        //slider.setInverted(true); ползунок наоборот
        slider.addChangeListener(new ChangeListener() {

                                     @Override
                                     public void stateChanged(ChangeEvent event) {
                                         firstlbl.setFont(firstlbl.getFont().deriveFont(2, slider.getValue()));
                                     }
                                 }
        );
        panel.add(slider);
    }
}
