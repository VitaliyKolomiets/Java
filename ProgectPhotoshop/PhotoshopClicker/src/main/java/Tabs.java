import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Vetal_den on 30.01.2018.
 */
public class Tabs extends JFrame {



        private String WAY_TO_FOLDER1;
        private String WAY_TO_FOLDER2;
        private String WAY_TO_FOLDER3;
        private String WAY_TO_FOLDER4;
        private String EMAIL1;
        private String EMAIL2;
        private String EMAIL3;
        private String EMAIL4;
        private boolean BOOL;



        Tabs(String WAY_TO_FOLDER1,String WAY_TO_FOLDER2,String WAY_TO_FOLDER3,String WAY_TO_FOLDER4,String EMAIL1,String EMAIL2,String EMAIL3,String EMAIL4) {

            this.WAY_TO_FOLDER1 = WAY_TO_FOLDER1;
            this.WAY_TO_FOLDER2 = WAY_TO_FOLDER2;
            this.WAY_TO_FOLDER3 = WAY_TO_FOLDER3;
            this.WAY_TO_FOLDER4 = WAY_TO_FOLDER4;
            this.EMAIL1=EMAIL1;
            this.EMAIL2=EMAIL2;
            this.EMAIL3=EMAIL3;
            this.EMAIL4=EMAIL4;
        }


        public void addComponentToPane(){

            JFrame frame = new JFrame("Clicker");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel tab1 = new JPanel();
            tab1.setLayout(null);


            Font font = new Font("Verdana", Font.BOLD, 14);
            Font font1 = new Font("Verdana", Font.BOLD, 12);

            JLabel label1 = new JLabel("Begin_of_Add");
            label1.setLocation(50,30);
            label1.setSize(150,20);
            label1.setFont(font);
            tab1.add(label1);

            JLabel label2 = new JLabel("Number_of_Add");
            label2.setLocation(200,30);
            label2.setSize(150,20);
            label2.setFont(font);
            tab1.add(label2);

            JTextField jTextField1= new JTextField(10);
            jTextField1.setLocation(50,70);
            jTextField1.setSize(130,20);
            tab1.add(jTextField1);


            JTextField jTextField2= new JTextField(10);
            jTextField2.setLocation(200,70);
            jTextField2.setSize(130,20);
            tab1.add(jTextField2);


            //Account_1
            JLabel label3 = new JLabel("Account_1");
            label3.setLocation(50,160);
            label3.setSize(100,20);
            label3.setFont(font);
            label3.setHorizontalAlignment(0);
            tab1.add(label3);

            JRadioButton radioButton =new JRadioButton();
            radioButton.setLocation(30,160);
            radioButton.setSize(20,20);
            tab1.add(radioButton);


            JLabel label4 = new JLabel("Way_Folder:");
            label4.setLocation(50,190);
            label4.setSize(100,20);
            label4.setFont(font1);
            tab1.add(label4);

            JLabel label11 = new JLabel(WAY_TO_FOLDER1);
            label11.setLocation(170,190);
            label11.setSize(500,20);
            tab1.add(label11);

            JLabel label5 = new JLabel("E-MAIL:");
            label5.setLocation(84,220);
            label5.setSize(100,20);
            label5.setFont(font1);
            tab1.add(label5);

            JLabel label6 = new JLabel(EMAIL1);
            label6.setLocation(170,220);
            label6.setSize(300,20);
            tab1.add(label6);

            //Account_2

            JLabel label7 = new JLabel("Account_2");
            label7.setLocation(50,280);
            label7.setSize(100,20);
            label7.setFont(font);
            label7.setHorizontalAlignment(0);
            tab1.add(label7);

            JRadioButton radioButton1 =new JRadioButton();
            radioButton1.setLocation(30,280);
            radioButton1.setSize(20,20);
            tab1.add(radioButton1);

            JLabel label8 = new JLabel("Way_Folder:");
            label8.setLocation(50,310);
            label8.setSize(100,20);
            label8.setFont(font1);
            tab1.add(label8);

            JLabel label12 = new JLabel(WAY_TO_FOLDER2);
            label12.setLocation(170,310);
            label12.setSize(500,20);
            tab1.add(label12);

            JLabel label9 = new JLabel("E-MAIL:");
            label9.setLocation(84,340);
            label9.setSize(100,20);
            label9.setFont(font1);
            tab1.add(label9);

            JLabel label10 = new JLabel(EMAIL2);
            label10.setLocation(170,340);
            label10.setSize(300,20);
            tab1.add(label10);


            //Account_3

            JLabel label13 = new JLabel("Account_3");
            label13.setLocation(50,400);
            label13.setSize(100,20);
            label13.setFont(font);
            label13.setHorizontalAlignment(0);
            tab1.add(label13);

            JRadioButton radioButton3 =new JRadioButton();
            radioButton3.setLocation(30,400);
            radioButton3.setSize(20,20);
            tab1.add(radioButton3);


            JLabel label14 = new JLabel("Way_Folder:");
            label14.setLocation(50,430);
            label14.setSize(100,20);
            label14.setFont(font1);
            tab1.add(label14);

            JLabel label16 = new JLabel(WAY_TO_FOLDER3);
            label16.setLocation(170,430);
            label16.setSize(500,20);
            tab1.add(label16);

            JLabel label17 = new JLabel("E-MAIL:");
            label17.setLocation(84,460);
            label17.setSize(100,20);
            label17.setFont(font1);
            tab1.add(label17);

            JLabel label18 = new JLabel(EMAIL3);
            label18.setLocation(170,460);
            label18.setSize(300,20);
            tab1.add(label18);


            //Account_4

            JLabel label19 = new JLabel("Account_4");
            label19.setLocation(50,520);
            label19.setSize(100,20);
            label19.setFont(font);
            label19.setHorizontalAlignment(0);
            tab1.add(label19);

            JRadioButton radioButton4 =new JRadioButton();
            radioButton4.setLocation(30,520);
            radioButton4.setSize(20,20);
            tab1.add(radioButton4);


            JLabel label20 = new JLabel("Way_Folder:");
            label20.setLocation(50,550);
            label20.setSize(100,20);
            label20.setFont(font1);
            tab1.add(label20);

            JLabel label21 = new JLabel(WAY_TO_FOLDER4);
            label21.setLocation(170,550);
            label21.setSize(500,20);
            tab1.add(label21);

            JLabel label22 = new JLabel("E-MAIL:");
            label22.setLocation(84,580);
            label22.setSize(100,20);
            label22.setFont(font1);
            tab1.add(label22);

            JLabel label23 = new JLabel(EMAIL4);
            label23.setLocation(170,580);
            label23.setSize(300,20);
            tab1.add(label23);




            ButtonGroup bgrp = new ButtonGroup();
            bgrp.add(radioButton);
            bgrp.add(radioButton1);
            bgrp.add(radioButton3);
            bgrp.add(radioButton4);



            JButton button =new JButton("RUN");
            button.setLocation(400,30);
            button.setSize(100,60);
            button.setFont(font);
            ActionListener actionListener= new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    int number1 = Integer.parseInt(jTextField1.getText());
                    int number2 = Integer.parseInt(jTextField2.getText());

                    if (radioButton.isSelected() == true) {

                        try {
                            new Open_Add_Write(Main.Array_link(WAY_TO_FOLDER1), number1, number2, WAY_TO_FOLDER1, EMAIL1).start();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }

                    }
                    if (radioButton1.isSelected() == true) {

                        try {
                            new Open_Add_Write(Main.Array_link(WAY_TO_FOLDER2), number1, number2, WAY_TO_FOLDER2, EMAIL2).start();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }

                    }
                    if (radioButton3.isSelected() == true) {

                        try {
                            new Open_Add_Write(Main.Array_link(WAY_TO_FOLDER3), number1 , number2, WAY_TO_FOLDER3, EMAIL3).start();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }

                    }
                    if (radioButton4.isSelected() == true) {

                        try {
                            new Open_Add_Write(Main.Array_link(WAY_TO_FOLDER4), number1 , number2, WAY_TO_FOLDER4, EMAIL4).start();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }

                    }
                }


            };
            button.addActionListener(actionListener);
            tab1.add(button);


            JButton button1 =new JButton("Open");
            button1.setLocation(620,190);
            button1.setSize(70,20);
            ActionListener actionListener1= new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Runtime runtime = Runtime.getRuntime();
                        String s="C:\\Program Files (x86)\\Notepad++\\notepad++.exe "+WAY_TO_FOLDER1;
                        Process process = runtime.exec(s);

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            };


            button1.addActionListener(actionListener1);
            tab1.add(button1);

            JButton button2 =new JButton("Open");
            button2.setLocation(620,310);
            button2.setSize(70,20);
            ActionListener actionListener2= new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Runtime runtime = Runtime.getRuntime();
                        String s="C:\\Program Files (x86)\\Notepad++\\notepad++.exe "+WAY_TO_FOLDER2;
                        Process process = runtime.exec(s);

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            };
            button2.addActionListener(actionListener2);
            tab1.add(button2);

            JButton button3 =new JButton("Open");
            button3.setLocation(620,430);
            button3.setSize(70,20);
            ActionListener actionListener3= new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Runtime runtime = Runtime.getRuntime();
                        String s="C:\\Program Files (x86)\\Notepad++\\notepad++.exe "+WAY_TO_FOLDER3;
                        Process process = runtime.exec(s);

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            };
            button3.addActionListener(actionListener3);
            tab1.add(button3);


            JButton button4 =new JButton("Open");
            button4.setLocation(620,550);
            button4.setSize(70,20);
            ActionListener actionListener4= new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Runtime runtime = Runtime.getRuntime();
                        String s="C:\\Program Files (x86)\\Notepad++\\notepad++.exe "+WAY_TO_FOLDER4;
                        Process process = runtime.exec(s);

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            };
            button4.addActionListener(actionListener4);
            tab1.add(button4);


            frame.add(tab1);
            frame.setSize(730, 700);
            frame.setVisible(true);

        }


    }
