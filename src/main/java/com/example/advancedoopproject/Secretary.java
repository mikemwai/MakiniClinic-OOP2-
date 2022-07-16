package com.example.advancedoopproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;
/**
 *
 * @author User
 */
public class Secretary extends Application {
    
    static Stage SecretaryStage = new Stage();
    
    @Override
    public void start(Stage primaryStage) {
        
        Text pat_lbl=new Text("Patient No:");
        Text phon_lbl=new Text("Phone No:");
        Text doc_lbl=new Text("Doctor ID :");
        Text date_lbl=new Text("Appointment Date(Y-M-D):");
        Text time_lbl=new Text ("Appointment time(H:M):");
        
        
        
        Button set_btn=new Button("Set Appointment");
        //Button back_btn=new Button("Go Back");
        
        
        TextField pat_id=new TextField();
        TextField phon=new TextField();
        TextField doc_id = new TextField();
        TextField app_date=new TextField();
        TextField time=new TextField();
        
        
        GridPane gPane=new GridPane();
        gPane.setMinSize(300,400);
        gPane.setVgap(20);
        gPane.setHgap(40);
        gPane.setAlignment(Pos.CENTER);
        
        
        gPane.add(pat_lbl,1,1);
        gPane.add(phon_lbl,1,2);
        gPane.add(doc_lbl, 1,3);
        gPane.add(date_lbl,1,4);
        gPane.add(time_lbl,1,5);

        HBox hbox = new HBox(gPane);

        // create a background fill
        BackgroundFill background_fill = new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY);

        // create Background
        Background background = new Background(background_fill);

        // set background
        hbox.setBackground(background);
        
        set_btn.setOnMouseClicked((new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent event){
                
                String patid=pat_id.getText();
                String phonno=phon.getText();
                String docid=doc_id.getText();
                String appDate=app_date.getText();
                String apptime=time.getText();
                
                
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    
                    Connection con =DriverManager.getConnection("jdbc:mysql://localhost/makiniclinic?","root","");
                    
                    Statement st=con.createStatement();
                    
                    String query = " INSERT INTO appointment(Patient_id,PhoneNo,Doctor_id,Appointment_date,Appointment_time) VALUES('"+patid+"','"+phonno+"','"+docid+"','"+appDate+"','"+apptime+"')";
                    st.executeUpdate(query);
                    System.out.println("connection successful");

                    SecretaryStage.close();

                    Alert al = new Alert(Alert.AlertType.CONFIRMATION);
                    al.setContentText("Successful Scheduled Appointment!");
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
        
        
        
        //horizontal button layout
        HBox vbButtons = new HBox();
        vbButtons.setSpacing(10);
        vbButtons.setPadding(new Insets(0,0,0,0));
        vbButtons.getChildren().addAll(set_btn);
        
        gPane.add(vbButtons,2,6,4,3);
        //gPane.add(sum_btn,1,4);
        //gPane.add(diff_btn,1,5);
        //gPane.add(div_btn,1,6);
        //gPane.add(ave_btn,1,7);
        
        
        gPane.add(pat_id,2, 1);
        gPane.add(phon,2, 2);
        gPane.add(doc_id,2,3);
        gPane.add(app_date,2,4);
        gPane.add(time,2, 5);
        
    
        primaryStage.setTitle("Makini Clinic: Appointments");

        Scene scene=new Scene(hbox, 800, 400);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
