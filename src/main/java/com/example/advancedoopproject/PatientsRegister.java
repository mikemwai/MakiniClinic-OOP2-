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


public class PatientsRegister extends Application
{
    static Stage registerstage=new Stage();

    @Override
    public void start(Stage stage) throws IOException
    {
        //Node
        Text Patientid_label=new Text("National Id No:");
        Text FName_label=new Text("First Name:");
        Text LName_label=new Text("Last Name:");
        Text Sex_label=new Text("Gender:");
        Text PhoneNo_label=new Text("PhoneNo:");
        Text pass_label=new Text("Password:");

        Button register_button=new Button("Register");
        Button back_button=new Button("Go Back!");

        TextField patientid=new TextField();
        TextField fName=new TextField();
        TextField lName=new TextField();
        TextField sex=new TextField();
        TextField phoneNo=new TextField();
        PasswordField pass=new PasswordField();

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
        gridpane.add(register_button,1,7);
        gridpane.add(back_button,2,7);

        gridpane.add(patientid,2,1);
        gridpane.add(fName,2,2);
        gridpane.add(lName,2,3);
        gridpane.add(sex,2,4);
        gridpane.add(phoneNo,2,5);
        gridpane.add(pass,2,6);

        back_button.setOnMouseClicked((new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent event)
            {
                //String PhoneNo = phoneNo.getText();

                try
                {
                    registerstage.close();

                    System.out.println("Connected Successfully");

                }
                catch(Exception ee){System.out.println(ee);System.out.println("Connection error");}
                {
                }
            }
        }));

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


                try
                {

                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/makiniclinic?","root","");

                    Statement st= con.createStatement();

                    String query = "INSERT INTO patients (Patient_id,FName,LName,Sex,PhoneNo,password) VALUES('"+Patientid+"','"+FName+"','"+LName+"','"+Sex+"','"+PhoneNo+"','"+password+"')";
                    st.executeUpdate(query);

                    //String query2 = "INSERT INTO out_patients (Patient_id,FName,LName,PhoneNo) VALUES('"+Patientid+"','"+FName+"','"+LName+"','"+PhoneNo+"')";
                    //st.executeUpdate(query2);

                    System.out.println("Connected Successfully");

                    Alert al = new Alert(Alert.AlertType.CONFIRMATION);
                    al.setContentText("Successful Registration!");
                    al.show();

                    //PatientsView v = new PatientsView();
                    //v.start(PatientsView.viewstage);
                    registerstage.close();

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
        registerstage.setScene(scene);
        registerstage.show();
        registerstage.setTitle("Makini Clinic: PatientsRegister Page");
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

