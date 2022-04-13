package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        /*
        JFrame frame = new JFrame("test");
        frame.setVisible(true);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel jPanel = new JPanel();
        Canvas canvas = new Canvas();


        JButton button = new JButton("idk");
        button.setVisible(true);
        button.setSize(50, 30);
        canvas.setBounds(100, 100, 400, 400);
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //vykreslime maze ig
                System.out.println("adfasdfsf");
            }
        });
        frame.add(jPanel);
        frame.add(button);
        frame.add(canvas);
        button.setVisible(true);

         */


        JFrame f=new JFrame("Button Example");
        final Canvas tf =new Canvas();
        tf.setBounds(50,50, 400,400);//150 20
        JButton b=new JButton("Click Here");
        b.setBounds(500,500,95,30);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //tf.setText("Welcome to Javatpoint.");
                System.out.println("dfasf");
            }
        });
        f.add(b);f.add(tf);
        f.setSize(600,600);
        f.setLayout(null);
        f.setVisible(true);
    }
}
