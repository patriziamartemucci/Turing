/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turing;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author IP5 PRO 16ACH6
 */
public class MainFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("TuringFX.fxml"));
        primaryStage.setTitle("Simulatore MACCHINA DI TURING");
        primaryStage.setScene(new Scene(root));
        System.out.println("Avvia app");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}