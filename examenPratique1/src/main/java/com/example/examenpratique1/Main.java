package com.example.examenpratique1;

import com.example.examenpratique1.Examen;
import javafx.application.Application;
import javafx.stage.Stage;
import java.util.Arrays;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Examen examen = new Examen();
        System.out.println("Résultat question 1:");
        System.out.println(examen.question1());
        System.out.println("");

        System.out.println("Résultat question 2:");
        System.out.println(examen.question2(Arrays.asList(
           "password:yeah!",
           "lasdjkasdhcNULL",
           "pasNULLsword:tNULLest",
           "the nullpassnullword is 1null234",
           "nickname:passwordnull"
        )));
        System.out.println("");

        System.out.println("Résultat question 3:");
        System.out.println(examen.question3());
        System.out.println("");

        System.out.println("Résultat question 4:");
        examen.question4(primaryStage);
        System.out.println("");

        System.out.println("Résultat question 5:");
        examen.question5(new Stage());
        System.out.println("");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
