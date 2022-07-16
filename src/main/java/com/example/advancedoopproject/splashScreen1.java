package com.example.advancedoopproject;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class splashScreen1 extends Application
{
    //static Stage welcomestage1 = new Stage();

    @Override
    public void start(Stage welcomeStage) throws Exception
    {
        //Node
        Text lbl = new Text("Makini Clinic");
        //lbl.setFont(new Font("Quanelas Soft DEMO",25));
        Font font = Font.font("Brush Script MT", FontWeight.BOLD, FontPosture.REGULAR, 65);
        lbl.setFont(font);
        lbl.setFill(Color.DARKCYAN);
        lbl.setUnderline(true);

        Text log_as=new Text("Log in as:");
        log_as.setFont(new Font("Quanelas Soft DEMO",25));
        Text register=new Text("Register Patient:");
        register.setFont(new Font("Quanelas Soft DEMO",25));

        //Button patient_button=new Button("Patient Login");
        Button patient1_button=new Button("Patient Register");
        Button doctor_button=new Button("Doctor");
        Button staff=new Button("Staff");
        //Button graph=new Button("Graph");

        //Container
        GridPane gridpane=new GridPane();
        gridpane.setMinSize(800,400);
        gridpane.setVgap(20);
        gridpane.setHgap(40);
        gridpane.setAlignment(Pos.CENTER);

        gridpane.add(lbl,1,1);
        gridpane.add(log_as,1,2);
        gridpane.add(register,1,4);
        //gridpane.add(graph,2,5);
        //gridpane.add(patient_button,1,1);
        gridpane.add(patient1_button,1,5);
        gridpane.add(doctor_button,1,3);
        gridpane.add(staff,2,3);

        HBox hbox = new HBox(gridpane);

        // create a background fill
        BackgroundFill background_fill = new BackgroundFill(Color.LIGHTGRAY,CornerRadii.EMPTY, Insets.EMPTY);

        // create Background
        Background background = new Background(background_fill);

        // set background
        hbox.setBackground(background);

        //gridpane.add(hbox, 280, 280);

        patient1_button.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent event)
            {
                try
                {
                    PatientsRegister r = new PatientsRegister();
                    r.start(PatientsRegister.registerstage);
                    //welcomeStage.close();

                }
                catch(Exception ee){System.out.println(ee);System.out.println("Connection error");}
                {
                }
            }
        });

        doctor_button.setOnMouseClicked((new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent event)
            {
                try
                {
                    DoctorLogin d = new DoctorLogin();
                    d.start(DoctorLogin.login1stage);
                    //welcomeStage.close();

                }
                catch(Exception ee){System.out.println(ee);System.out.println("Connection error");}
                {
                }
            }
        }));

        staff.setOnMouseClicked((new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent event)
            {
                try
                {
                    SecretaryLog secr =new SecretaryLog();
                    secr.start(SecretaryLog.SecretaryStage);
                    //welcomeStage.close();

                }
                catch(Exception ee){System.out.println(ee);System.out.println("Connection error");}
                {
                }
            }
        }));

        /*graph.setOnMouseClicked((new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent event)
            {
                try
                {
                    Graph g =new Graph();
                    g.start(Graph.viewStage);
                    //welcomeStage.close();

                }
                catch(Exception ee){System.out.println(ee);System.out.println("Connection error");}
                {
                }
            }
        }));*/

        //Scene
        Scene scene=new Scene(hbox, 800, 400);

        //Stage
        welcomeStage.setScene(scene);
        welcomeStage.show();
        welcomeStage.setTitle("Welcome Page");
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}

