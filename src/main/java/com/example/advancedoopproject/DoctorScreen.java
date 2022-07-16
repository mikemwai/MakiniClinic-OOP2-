/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.advancedoopproject;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;

public class DoctorScreen extends Application
{
    static Stage DoctorStage = new Stage();

    TableView table = new TableView();

    public void setTable() throws SQLException
    {
        String query = "SELECT * FROM appointment INNER JOIN patients ON appointment.Patient_id=patients.Patient_No";
        ArrayList<Doctor> appointments = new ArrayList<>();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/makiniclinic","root","");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while(resultSet.next()){
            int id = resultSet.getInt("Patient_id");
            String phone = resultSet.getString("PhoneNo");
            int doctorId = resultSet.getInt("Doctor_id");
            int appointmentID = resultSet.getInt("Appointment_id");
            String patientName = resultSet.getString("FName");
            Date appointmentDate = resultSet.getDate("Appointment_date");
            Time time = resultSet.getTime("Appointment_time");

            Doctor doc = new Doctor(appointmentDate,id,phone,doctorId,appointmentID,time,patientName);
            appointments.add(doc);

        }
        table.setItems(FXCollections.observableArrayList(appointments));

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws SQLException
    {
        setTable();
        VBox parent = new VBox();
        parent.setPadding(new Insets(20,20,20,20));
        parent.setMinSize(800,400);
        //OB NUMBER FIELDS

        //CRIME DETAILS
        TableColumn<Doctor,String> obNumber = new TableColumn("AppointmentID");
        obNumber.setCellValueFactory(data-> {
            return new SimpleStringProperty(String.valueOf(data.getValue().appointmentID));
        });
        TableColumn<Doctor,String> criminalTable = new TableColumn("Appointment Date");
        criminalTable.setCellValueFactory(data-> {
            return new SimpleStringProperty(data.getValue().appointment.toString());
        });
        criminalTable.setMinWidth(100);
        TableColumn<Doctor,String> nationalIDTable = new TableColumn<>("Patient Name");
        nationalIDTable.setCellValueFactory(data-> {
            return new SimpleStringProperty(data.getValue().patientName);
        });

        TableColumn<Doctor,String> date = new TableColumn("Phone Number");
        date.setCellValueFactory(data-> {
            return new SimpleStringProperty(String.valueOf(data.getValue().phoneNo));
        });
        date.setMinWidth(200);

        TableColumn<Doctor,String> serving = new TableColumn("Appointment Time");
        serving.setCellValueFactory(data-> {
            return new SimpleStringProperty(data.getValue().time.toString());
        });
        table.getColumns().addAll(obNumber,criminalTable,nationalIDTable,date,serving);

        parent.getChildren().addAll(table);
        parent.setSpacing(20);
        primaryStage.setTitle("Total Appointments Report");

        Scene scene = new Scene(parent);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
