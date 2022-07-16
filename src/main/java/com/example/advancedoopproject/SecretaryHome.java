package com.example.advancedoopproject;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SecretaryHome extends Application
{
    static Stage homeStage=new Stage();

    @Override
    public void start(Stage homeStage) throws Exception
    {
        //Node
        Text PhoneNo_label=new Text("View any of the following:");
        PhoneNo_label.setFont(new Font("Quanelas Soft DEMO",25));

        Button appointments_button=new Button("Total Appointments Report");
        Button history_button=new Button("Total Patients Report");
        Button graph=new Button("Total Medicine Report");

        Text Appointments_label=new Text("Set an appointment:");
        Appointments_label.setFont(new Font("Quanelas Soft DEMO",25));

        Button appointments1_button=new Button("Appointment Form");
        Button back_button=new Button("Go Back!");

        //Container
        GridPane gridpane=new GridPane();
        gridpane.setMinSize(800,400);
        gridpane.setVgap(20);
        gridpane.setHgap(40);
        gridpane.setAlignment(Pos.CENTER);

        gridpane.add(PhoneNo_label, 1,1);
        gridpane.add(Appointments_label, 1,5);
        //gridpane.add(phoneNo,2,1);
        gridpane.add(appointments_button,1,2);
        gridpane.add(history_button,1,3);
        gridpane.add(graph,1,4);
        gridpane.add(appointments1_button,1,6);
        gridpane.add(back_button,2,6);

        HBox hbox = new HBox(gridpane);

        // create a background fill
        BackgroundFill background_fill = new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY);

        // create Background
        Background background = new Background(background_fill);

        // set background
        hbox.setBackground(background);

        appointments_button.setOnMouseClicked((new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent event)
            {
                //String PhoneNo = phoneNo.getText();

                try
                {

                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/makiniclinic?","root","");

                    Statement st= con.createStatement();

                    /*String query = "SELECT * FROM makiniclinic.appointment Where PhoneNo = '"+PhoneNo+"'";
                    ResultSet rs = st.executeQuery(query);*/
                    DoctorScreen d = new DoctorScreen();
                    d.start(DoctorScreen.DoctorStage);

                    System.out.println("Connected Successfully");

                    con.close();

                }
                catch(Exception ee){System.out.println(ee);System.out.println("Connection error");}
                {
                }
            }
        }));

        back_button.setOnMouseClicked((new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent event)
            {
                //String PhoneNo = phoneNo.getText();

                try
                {
                    homeStage.close();

                    System.out.println("Connected Successfully");

                }
                catch(Exception ee){System.out.println(ee);System.out.println("Connection error");}
                {
                }
            }
        }));

        history_button.setOnMouseClicked((new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent event)
            {
                try
                {

                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/makiniclinic?","root","");

                    Statement st= con.createStatement();

                    /*String query = "SELECT * FROM makiniclinic.patients Where PhoneNo = '"+PhoneNo+"'";
                    ResultSet rs = st.executeQuery(query);*/

                    PatientsView v = new PatientsView();
                    v.start(PatientsView.viewstage);

                    System.out.println("Connected Successfully");

                    con.close();

                }
                catch(Exception ee){System.out.println(ee);System.out.println("Connection error");}
                {
                }
            }
        }));


        appointments1_button.setOnMouseClicked((new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent event)
            {
                try
                {

                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/makiniclinic?","root","");

                    Statement st= con.createStatement();

                    /*String query = "SELECT * FROM makiniclinic.patients Where PhoneNo = '"+PhoneNo+"'";
                    ResultSet rs = st.executeQuery(query);*/

                    Secretary secr =new Secretary();
                    secr.start(Secretary.SecretaryStage);

                    System.out.println("Connected Successfully");

                    con.close();

                }
                catch(Exception ee){System.out.println(ee);System.out.println("Connection error");}
                {
                }
            }
        }));

        graph.setOnMouseClicked((new EventHandler<MouseEvent>()
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
        }));

        //Scene
        Scene scene=new Scene(hbox, 800, 400);

        //Stage
        homeStage.setScene(scene);
        homeStage.show();
        homeStage.setTitle("Makini Clinic: SecretaryHome Page");
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}

