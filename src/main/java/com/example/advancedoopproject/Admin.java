package com.example.advancedoopproject;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Admin extends Application
{
    static Stage adminStage=new Stage();

    @Override
    public void start(Stage adminStage) throws Exception
    {
        //Node
        Text PhoneNo_label=new Text("PhoneNo");
        Text pass_label=new Text("Password");

        Button login_button=new Button("Log In");

        TextField phoneNo=new TextField();
        PasswordField pass=new PasswordField();

        //Container
        GridPane gridpane=new GridPane();
        gridpane.setMinSize(800,400);
        gridpane.setVgap(20);
        gridpane.setHgap(40);
        gridpane.setAlignment(Pos.CENTER);

        gridpane.add(PhoneNo_label, 1,1);
        gridpane.add(pass_label,1,2);
        gridpane.add(login_button,1,3);
        gridpane.add(phoneNo,2,1);
        gridpane.add(pass,2,2);

        //Scene
        Scene scene=new Scene(gridpane);

        //Stage
        adminStage.setScene(scene);
        adminStage.show();
        adminStage.setTitle("Makini Clinic: Admin Page");
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}

