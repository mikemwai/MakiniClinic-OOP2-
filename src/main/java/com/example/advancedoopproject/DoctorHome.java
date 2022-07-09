package com.example.advancedoopproject;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DoctorHome extends Application
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
        Button history1_button=new Button("Total OutPatient Report");

        Text patients_label=new Text("Update Patient Details:");
        patients_label.setFont(new Font("Quanelas Soft DEMO",25));

        Button patients_button=new Button("OutPatient Form");
        Button back_button=new Button("Go Back!");
        //TextField phoneNo=new TextField();

        //Container
        GridPane gridpane=new GridPane();
        gridpane.setMinSize(800,400);
        gridpane.setVgap(20);
        gridpane.setHgap(40);
        gridpane.setAlignment(Pos.CENTER);

        gridpane.add(PhoneNo_label, 1,1);
        gridpane.add(patients_label, 1,5);
        //gridpane.add(phoneNo,2,1);
        gridpane.add(appointments_button,1,2);
        gridpane.add(history_button,1,3);
        gridpane.add(history1_button,1,4);
        gridpane.add(patients_button, 1,6);
        gridpane.add(back_button,2,6);

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

        history1_button.setOnMouseClicked((new EventHandler<MouseEvent>()
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

                    OutPatientsView v = new OutPatientsView();
                    v.start(OutPatientsView.view1stage);

                    System.out.println("Connected Successfully");

                    con.close();

                }
                catch(Exception ee){System.out.println(ee);System.out.println("Connection error");}
                {
                }
            }
        }));

        patients_button.setOnMouseClicked((new EventHandler<MouseEvent>()
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

                    OutPatients v = new OutPatients();
                    v.start(OutPatients.register1stage);

                    System.out.println("Connected Successfully");

                    con.close();

                }
                catch(Exception ee){System.out.println(ee);System.out.println("Connection error");}
                {
                }
            }
        }));

        //Scene
        Scene scene=new Scene(gridpane);

        //Stage
        homeStage.setScene(scene);
        homeStage.show();
        homeStage.setTitle("Makini Clinic: DoctorHome Page");
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}
