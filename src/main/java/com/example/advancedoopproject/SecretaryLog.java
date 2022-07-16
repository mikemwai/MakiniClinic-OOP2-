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

/**
 *
 * @author User
 */
public class SecretaryLog extends Application
{
    static Stage SecretaryStage = new Stage();

    @Override
    public void start(Stage primaryStage)
    {
        //Nodes
        Text ID_label=new Text(" Staff ID:");
        Text first_label=new Text("First Name:");
        Text sec_lbl=new Text("Last name:");
        Text pass_lbl=new Text("Password:");
        
        
        Button log_btn=new Button("Login");
        Button back_button=new Button("Go Back!");
        
        TextField ID_num=new TextField();
        TextField first_name=new TextField();
        TextField sec_name = new TextField();
        PasswordField password=new PasswordField();
        
        GridPane gPane=new GridPane();
        gPane.setMinSize(300,400);
        gPane.setVgap(20);
        gPane.setHgap(40);
        gPane.setAlignment(Pos.CENTER);
        
        gPane.add(ID_label,1,1);
        gPane.add(first_label,1,2);
        gPane.add(sec_lbl, 1, 3);
        gPane.add(pass_lbl,1,4);
        //gPane.add(back_button,2,5);
        
        //horizontal button layout
        HBox vbButtons = new HBox();
        vbButtons.setSpacing(10);
        vbButtons.setPadding(new Insets(0,0,0,0));
        vbButtons.getChildren().addAll(log_btn,back_button);
        
        gPane.add(vbButtons,2,5,4,3);

        HBox hbox = new HBox(gPane);

        // create a background fill
        BackgroundFill background_fill = new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY);

        // create Background
        Background background = new Background(background_fill);

        // set background
        hbox.setBackground(background);

        back_button.setOnMouseClicked((new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent event)
            {
                //String PhoneNo = phoneNo.getText();

                try
                {
                    SecretaryStage.close();

                    System.out.println("Connected Successfully");

                }
                catch(Exception ee){System.out.println(ee);System.out.println("Connection error");}
                {
                }
            }
        }));
        
        
        log_btn.setOnMouseClicked((new EventHandler<MouseEvent>() {
         public void handle(MouseEvent event) {
                //String ID_num=idnum.getText();
                //String first_name=fname.getText();
               // String sec_name=sname.getText();
                //String password = pass.getText();;
                
             
             try{
              Class.forName("com.mysql.cj.jdbc.Driver"); 
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost/makiniclinic?","root","");
              Statement st=con.createStatement();
              String query="SELECT * FROM staff Where FName='"+first_name.getText()+"'AND Password='"+password.getText()+"'  ";
              ResultSet rs = st.executeQuery(query);

               if(rs.next())
                {
                     // Alert al = new Alert(Alert.AlertType.CONFIRMATION);
                      //al.setContentText("Successful Login");
                      //al.show();
                    SecretaryHome s =new SecretaryHome();
                    s.start(SecretaryHome.homeStage);
                    SecretaryStage.close();
                }
                else
                {
                    Alert al = new Alert(Alert.AlertType.WARNING);
                    al.setContentText("Invalid Credentials!");
                    al.show();
                }
               con.close();
             }
             catch(Exception ee){
                 System.out.println(ee);
                 System.out.println("Connection error");
             }
         }
         }));

        /*back_btn.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent event)
            {
                try
                {
                    splashScreen1 s = new splashScreen1();
                    //s.start(splashScreen1.welcomestage1);
                    SecretaryStage.close();
                    //welcomeStage.close();

                }
                catch(Exception ee){System.out.println(ee);System.out.println("Connection error");}
                {
                }
            }
        });*/

        gPane.add(ID_num,2, 1);
        gPane.add(first_name,2, 2);
        gPane.add(sec_name,2,3);
        gPane.add(password,2,4);
    
        primaryStage.setTitle("Makini Clinic: Staff/Secretary Log in");

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