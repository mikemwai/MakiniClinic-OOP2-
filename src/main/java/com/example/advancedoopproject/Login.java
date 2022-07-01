package com.example.advancedoopproject;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.sql.*;
import java.sql.Statement;

import java.io.IOException;


public class Login extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        //Node
        Text name_label=new Text("UserName");  //Name label
        Text pass_label=new Text("Password");   //Password label

        Button login_button=new Button("Log In"); //Login Button

        TextField user_name=new TextField();  //Username textfield
        PasswordField pass=new PasswordField(); //Password field

        GridPane gridpane=new GridPane();   //Container
        gridpane.setMinSize(800,400);
        gridpane.setVgap(20);
        gridpane.setHgap(40);
        gridpane.setAlignment(Pos.CENTER);

        gridpane.add(name_label, 1,1);
        gridpane.add(pass_label,1,2);
        gridpane.add(login_button,1,3);
        gridpane.add(user_name,2,1);
        gridpane.add(pass,2,2);

        login_button.setOnMouseClicked((new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent event)
            {
                //String uname = "jane";
                //String pass_ = "12345" ;
                String username = user_name.getText();
                String password = pass.getText();


                try
                {
                    //Step One - Register the driver
                    //System.out.println("0");
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    //System.out.println("1");

                    //Step Two - Creating the connection
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/makiniclinic?","root","");
                    //System.out.println("2");

                    //Step Three - Create the statement object
                    Statement st= con.createStatement();
                    //System.out.println("3");

                    //Step Four
                    String query = "SELECT * FROM makiniclinic.users Where username = '"+username+"' AND password = '"+password+"' ";
                    ResultSet rs = st.executeQuery(query);
                    System.out.println("Connected Successfully");

                    if(rs.next())
                    {
                        //You can replace this code with ANY code to be executed after a successfull login
                        Alert al = new Alert(Alert.AlertType.CONFIRMATION);
                        al.setContentText("Successful Login");
                        al.show();
                        Home h = new Home();
                        h.start(Home.homeStage);
                    }

                    else
                    {
                        Alert al = new Alert(Alert.AlertType.WARNING);
                        al.setContentText("Invalid Credentials");
                        al.show();

                    }

                    //Step five - Closing the connection
                    con.close();

                }
                catch(Exception ee){System.out.println(ee);System.out.println("Connection error");}
                {
                }
            }
        }));

        //Scene
        Scene scene=new Scene(gridpane);  //This is the scene

        //Stage
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Makini Clinic: Login Page");

        /*
        FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setScene(scene);
        stage.show();*/
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
