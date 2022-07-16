/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.advancedoopproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Graph extends Application {

    static Stage viewStage = new Stage();

    @Override
    public void start(Stage viewStage) {
        try {
            //Step One - Register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Step Two - Creating the connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/makiniclinic?","root","");

            //Step Three - Create the statement object
            Statement st = conn.createStatement();

            //Step Four: create the query
            String query = "select product_type,sum(product_quantity) from makiniclinic.pharmacy group by product_type";

            //step five: process the results
            ResultSet rs=  st.executeQuery(query);

            ArrayList<String> prodTypes=new ArrayList<String>(); //holds the product types
            ArrayList<Integer> qtys=new ArrayList<Integer>(); //holds numeric values of the product type

            while(rs.next())
            {
                prodTypes.add(rs.getString(1));
                qtys.add(rs.getInt(2));
            }
            rs.close(); //to avoid throwing maximum open cursors exception & release resources back to the db

            //create axes of the bar chart
            CategoryAxis x=new CategoryAxis();
            x.setLabel("Product Type");

            NumberAxis y= new NumberAxis();
            y.setLabel("Quantity in arbitrary units");

            //create a bar chart
            BarChart bar =new BarChart(x,y);
            XYChart.Series dataseries=new XYChart.Series();

            dataseries.setName("Quantity per stock type");

            for(int i=0;i<prodTypes.size();i++)
            {
                dataseries.getData().add(new XYChart.Data(prodTypes.get(i),qtys.get(i))); //get the quantity for each product type from the array list
            }

            bar.getData().add(dataseries); //put the name of the data series on the chart

            VBox v =new VBox(bar);

            // create a background fill
            BackgroundFill background_fill = new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY);

            // create Background
            Background background = new Background(background_fill);

            // set background
            v.setBackground(background);

            //NOW WE CREATE THE SCENE
            Scene my_scene = new Scene(v,800,400); //put the bar chart onto the scene

            //THE SCENE IS SUPPOSED TO HAVE ALL OF THESE AND WE COME UP WITH THE STAGE
            //CREATING THE STAGE TO DISPLAY THE SCENE
            viewStage.setScene(my_scene);
            viewStage.setTitle("Makini Clinic: View Stock");
            viewStage.setResizable(true);

            viewStage.show();

            //Step six - Closing the connection
            conn.close();

        } catch (Exception ee) {
            System.out.println(ee);
            System.out.println("Connection error");
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
