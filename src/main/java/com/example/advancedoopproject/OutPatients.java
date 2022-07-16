package com.example.advancedoopproject;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
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
        Text phoneno_label=new Text("PhoneNo:");
        Text Sex_label=new Text("Gender:");
        Text Illness_label=new Text("Illness:");
        Text pass_label=new Text("Doctor Id:");
        Text pass1_label=new Text("Discharged:");

        Button register_button=new Button("Update");

        TextField patientid=new TextField();
        TextField fName=new TextField();
        TextField lName=new TextField();
        TextField phoneno=new TextField();
        //TextField sex=new TextField();
        ChoiceBox<String> sex= new ChoiceBox<>();
        sex.getItems().addAll("","Male","Female");
        sex.getSelectionModel().select(0);
        TextField illness=new TextField();
        TextField pass=new TextField();
        //TextField pass1=new TextField();
        ChoiceBox<String> pass1= new ChoiceBox<>();
        pass1.getItems().addAll("","Yes","No");

        //Container
        GridPane gridpane=new GridPane();
        gridpane.setMinSize(800,400);
        gridpane.setVgap(20);
        gridpane.setHgap(40);
        gridpane.setAlignment(Pos.CENTER);

        gridpane.add(Patientid_label, 1,1);
        gridpane.add(FName_label, 1,2);
        gridpane.add(LName_label, 1,3);
        gridpane.add(phoneno_label, 1,4);
        gridpane.add(Sex_label, 3,1);
        gridpane.add(Illness_label, 3,2);
        gridpane.add(pass_label,3,3);
        gridpane.add(pass1_label,3,4);
        gridpane.add(register_button,1,5);

        gridpane.add(patientid,2,1);
        gridpane.add(fName,2,2);
        gridpane.add(lName,2,3);
        gridpane.add(phoneno,2,4);
        gridpane.add(sex,4,1);
        gridpane.add(illness,4,2);
        gridpane.add(pass,4,3);
        gridpane.add(pass1,4,4);

        HBox hbox = new HBox(gridpane);

        // create a background fill
        BackgroundFill background_fill = new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY);

        // create Background
        Background background = new Background(background_fill);

        // set background
        hbox.setBackground(background);

        register_button.setOnMouseClicked((new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent event)
            {
                String Patientid = patientid.getText();
                String FName = fName.getText();
                String LName = lName.getText();
                String phone = phoneno.getText();
                String Sex = sex.getValue();
                String Illness = illness.getText();
                String password = pass.getText();
                String password1 = pass1.getValue();


                try
                {

                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/makiniclinic?","root","");

                    Statement st= con.createStatement();

                    String query2 = "INSERT INTO out_patients (Patient_id,FName,LName,PhoneNo,Sex,Illness,Doctor_id,Discharged) " +
                            "VALUES('"+Patientid+"','"+FName+"','"+LName+"','"+phone+"','"+Sex+"','"+Illness+"','"+password+"','"+password1+"')";
                    st.executeUpdate(query2);

                    String query3="DELETE FROM appointment WHERE PhoneNo=phoneno";
                    st.executeUpdate(query3);

                    //DELETE FROM `appointment` WHERE `appointment`.`Appointment_id` = 1;

                    System.out.println("Connected Successfully");

                    register1stage.close();
                    Alert al = new Alert(Alert.AlertType.CONFIRMATION);
                    al.setContentText("Successful Update!");
                    al.show();

                    con.close();

                }
                catch(Exception ee)
                {
                    Alert al = new Alert(Alert.AlertType.WARNING);
                    al.setContentText("Please Fill out all details!");
                    al.show();
                    System.out.println(ee);
                    System.out.println("Connection error");
                }
            }
        }));

        //Scene
        Scene scene=new Scene(hbox, 800, 400);

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

