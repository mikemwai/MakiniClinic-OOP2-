package com.example.advancedoopproject;

/**
 *
 * @author User
 */
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.input.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

public class SplashScreen extends Application{
    @Override
    public void start(Stage stage){
        Label lbl = new Label("Clinic management App");
        lbl.setFont(new Font("Quanelas Soft DEMO",25));
        
        //stage.setTitle("Clinic Management app");
        
        Text log_as=new Text("Log in as:");
        
        Button doc=new Button("Doctor");
        Button pat=new Button("Patient");
        Button staf=new Button("Staff");
        
        GridPane gPane=new GridPane();
        gPane.setMinSize(300,400);
        gPane.setVgap(20);
        gPane.setHgap(40);
        gPane.setAlignment(Pos.CENTER);
        
        gPane.add(lbl,1,1);
        gPane.add(log_as,1,3);
        
        
        HBox vbButtons = new HBox();
        vbButtons.setSpacing(5);
        vbButtons.setPadding(new Insets(0,0,0,0));
        vbButtons.getChildren().addAll(doc,pat,staf);
        
        gPane.add(vbButtons,1,4);
        
        staf.setOnMouseClicked((new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
                SecretaryLog secr =new SecretaryLog();
                
               secr.start(SecretaryLog.SecretaryStage);
            }
        }));
        
        Scene myScene=new Scene(gPane);
        stage.setScene(myScene);
        stage.show();
        stage.setTitle("Makini Clinic Management app");
        
    }
   
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
