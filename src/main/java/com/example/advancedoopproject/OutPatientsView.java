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

public class OutPatientsView extends Application
{

    static Stage view1stage=new Stage();

    TableView<OutPatientRecords> view = new TableView<>();

    @Override
    public void start(Stage stage) throws Exception
    {
        addcolumns("Patient Number", "Patient_No");
        addcolumns("Patient Id", "Patient_id");
        addcolumns("First Name", "FName");
        addcolumns("Last Name", "LName");
        addcolumns("Sex", "Sex");
        addcolumns("Illness", "Illness");
        addcolumns("Doctor Id", "Doctor_id");
        addcolumns("Discharged", "Discharged");

        try
        {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/makiniclinic?","root","");

            Statement st= con.createStatement();

            String query = "SELECT * FROM makiniclinic.out_patients";
            ResultSet rs = st.executeQuery(query);

            while (rs.next())
            {
                int Patient_No = rs.getInt(1);
                String Patient_id = rs.getString(2);
                String FName = rs.getString(3);
                String LName = rs.getString(4);
                String Sex = rs.getString(5);
                String Illness = rs.getString(6);
                String Doctor_id = rs.getString(7);
                String Discharged = rs.getString(8);

                OutPatientRecords outpatientRecords = new OutPatientRecords();

                outpatientRecords.Patient_No.setValue(String.valueOf(Patient_No));
                outpatientRecords.Patient_id.setValue(Patient_id);
                outpatientRecords.FName.setValue(FName);
                outpatientRecords.LName.setValue(LName);
                outpatientRecords.Sex.setValue(Sex);
                outpatientRecords.Illness.setValue(Illness);
                outpatientRecords.Doctor_id.setValue(Doctor_id);
                outpatientRecords.Discharged.setValue(Discharged);

                view.getItems().add(outpatientRecords);

            }


            System.out.println("Connected Successfully");

            con.close();

        }
        catch(Exception ee){System.out.println(ee);System.out.println("Connection error");}
        {
        }


        Scene  scene =  new Scene(view);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Total OutPatients Report");

    }

    void addcolumns(String columnName, String accessModifier)
    {

        TableColumn<OutPatientRecords, String> columns = new TableColumn<>(columnName);
        //TableColumn<PatientRecords> columns = new TableColumn<>(columnName);

        columns.setCellValueFactory(new PropertyValueFactory<OutPatientRecords, String>(accessModifier));
        view.getColumns().add(columns);
    }

}
