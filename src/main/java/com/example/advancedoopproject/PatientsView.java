package com.example.advancedoopproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PatientsView extends Application
{

    static Stage viewstage=new Stage();

    TableView<PatientRecords> view = new TableView<>();

    @Override
    public void start(Stage stage) throws Exception
    {
        addcolumns("Patient Number", "Patient_No");
        addcolumns("Patient Id", "Patient_id");
        addcolumns("First Name", "FName");
        addcolumns("Last Name", "LName");
        addcolumns("Sex", "Sex");
        addcolumns("Phone Number", "PhoneNo");
        //addcolumns("Password", "password");

        try
        {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/makiniclinic?","root","");

            Statement st= con.createStatement();

            String query = "SELECT * FROM makiniclinic.patients";
            ResultSet rs = st.executeQuery(query);

            while (rs.next())
            {
                int Patient_No = rs.getInt(1);
                String Patient_id = rs.getString(2);
                String FName = rs.getString(3);
                String LName = rs.getString(4);
                String Sex = rs.getString(5);
                String PhoneNo = rs.getString(6);
                //String password = rs.getString(7);

                PatientRecords patientRecords = new PatientRecords();

                patientRecords.Patient_No.setValue(String.valueOf(Patient_No));
                patientRecords.Patient_id.setValue(Patient_id);
                patientRecords.FName.setValue(FName);
                patientRecords.LName.setValue(LName);
                patientRecords.Sex.setValue(Sex);
                patientRecords.PhoneNo.setValue(PhoneNo);
                //patientRecords.password.setValue(password);

                view.getItems().add(patientRecords);

            }


            System.out.println("Connected Successfully");

            con.close();

        }
        catch(Exception ee){System.out.println(ee);System.out.println("Connection error");}
        {
        }


        Scene  scene =  new Scene(view,800,400);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Total Patients Report");
        
    }

     void addcolumns(String columnName, String accessModifier)
    {

        TableColumn<PatientRecords, String> columns = new TableColumn<>(columnName);
        //TableColumn<PatientRecords> columns = new TableColumn<>(columnName);

        columns.setCellValueFactory(new PropertyValueFactory<PatientRecords, String>(accessModifier));
        view.getColumns().add(columns);
    }

}
