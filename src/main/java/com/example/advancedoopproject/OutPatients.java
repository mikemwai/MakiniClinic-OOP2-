package com.example.advancedoopproject;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.sql.*;

import java.io.IOException;


public class OutPatients extends Application
{
    static Stage register1stage=new Stage();

    @Override
    public void start(Stage stage) throws IOException
    {
        //Node
        Text Patientid_label=new Text("National Id No:");
        Text FName_label=new Text("First Name:");
        Text LName_label=new Text("Last Name:");
        Text Sex_label=new Text("Gender:");
        Text PhoneNo_label=new Text("Illness:");
        Text pass_label=new Text("Doctor Id:");
        Text pass1_label=new Text("Discharged(Yes or No):");

        Button register_button=new Button("Update");

        TextField patientid=new TextField();
        TextField fName=new TextField();
        TextField lName=new TextField();
        TextField sex=new TextField();
        TextField phoneNo=new TextField();
        TextField pass=new TextField();
        TextField pass1=new TextField();

        //Container
        GridPane gridpane=new GridPane();
        gridpane.setMinSize(800,400);
        gridpane.setVgap(20);
        gridpane.setHgap(40);
        gridpane.setAlignment(Pos.CENTER);

        gridpane.add(Patientid_label, 1,1);
        gridpane.add(FName_label, 1,2);
        gridpane.add(LName_label, 1,3);
        gridpane.add(Sex_label, 1,4);
        gridpane.add(PhoneNo_label, 1,5);
        gridpane.add(pass_label,1,6);
        gridpane.add(pass1_label,1,7);
        gridpane.add(register_button,1,8);

        gridpane.add(patientid,2,1);
        gridpane.add(fName,2,2);
        gridpane.add(lName,2,3);
        gridpane.add(sex,2,4);
        gridpane.add(phoneNo,2,5);
        gridpane.add(pass,2,6);
        gridpane.add(pass1,2,7);

        register_button.setOnMouseClicked((new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent event)
            {
                String Patientid = patientid.getText();
                String FName = fName.getText();
                String LName = lName.getText();
                String Sex = sex.getText();
                String PhoneNo = phoneNo.getText();
                String password = pass.getText();
                String password1 = pass1.getText();


                try
                {

                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/makiniclinic?","root","");

                    Statement st= con.createStatement();

                    String query2 = "INSERT INTO out_patients (Patient_id,FName,LName,Sex,Illness,Doctor_id,Discharged) " +
                            "VALUES('"+Patientid+"','"+FName+"','"+LName+"','"+Sex+"','"+PhoneNo+"','"+password+"','"+password1+"')";
                    st.executeUpdate(query2);

                    /*String query3="DELETE appointments WHERE Doctor_id='password'";
                    st.executeUpdate(query3);*/

                    //DELETE FROM `appointment` WHERE `appointment`.`Appointment_id` = 1;

                    System.out.println("Connected Successfully");

                    register1stage.close();
                    Alert al = new Alert(Alert.AlertType.CONFIRMATION);
                    al.setContentText("Successful Update!");
                    al.show();

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
        register1stage.setScene(scene);
        register1stage.show();
        register1stage.setTitle("Makini Clinic: OutPatients Page");
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

