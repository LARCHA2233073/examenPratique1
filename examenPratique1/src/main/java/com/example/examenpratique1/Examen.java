package com.example.examenpratique1;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Examen {
    public List<Boolean> question1(){
        /*
        Pondération: 15%
        Pour réussir cette question, vous devez retourner le résultat d'un appel à Collider.getColliderList().
        Collider.getColliderList() prend un seul paramètre, une expression lambda, qui prend elle même deux paramètres:
        un Point et un Rect. Référez-vous à ces classes pour connaître leur structure. Notez que les rectangles
        sont définis par le point en haut à gauche et le point en bas à droite, et non par la largeur et la hauteur.

        Votre expression lambda doit déterminer s'il y a collision entre le point et le rectangle qui lui sont passés
        en paramètres, en retournant un booléen.

        Il y a collision si le point respecte toutes les conditions suivantes:
            - Il est sous le côté en haut du rectangle
            - Il est au-dessus du côté en bas du rectangle
            - Il est à droite du côté gauche du rectangle
            - Il est à gauche du côté droit du rectangle
(il est dans le milieu de tout les cotés)***

         Vous pouvez consulter "collision.png" pour vous aider
         */
        return Collider.getColliderList( (p, r) -> (p.getX()) > r.getX1() && p.getX() < r.getX2()
                && p.getY() > r.getY1() && p.getY() < r.getY2()) ;
    }

    public String question2(List<String> contenu){
        /*
        Pondération: 15%
        Pour réussir cette question, vous devez utiliser les streams sur la liste en paramètre (contenu) pour réaliser
        les actions suivantes:
         - Mettre les chaînes de caractères en minuscule
         - Retirer la sous-chaîne "null" de toutes les chaînes
            (indice: utilisez String.replaceAll. Remplacez par la chaîne vide "" pour retirer)
         - Garder seulement les chaînes contenant la chaîne "password" (indice: utilisez String.contains)
         - Retourner une chaîne de caractères avec un élément par ligne
         */
        return contenu.stream().map(s -> s.toLowerCase()).map(s -> s.replaceAll("([null])", "")).
                filter(s -> s.contains("password")).map(x -> x + "\n").collect(Collectors.joining());

    }

    public List<Integer> question3(){
        /*
        Pondération: 15%
        Pour réussir cette question, vous devez utiliser un Infinite Stream pour trouver les 10 premiers cubes
        parfaits pairs.
        Pour rappel, un cube parfait est un entier dont la racine cubique est aussi un entier.
        Indice: Pour générer les cubes parfaits, transformez les nombres de 2 à ... en leur cube
         */

        return IntStream.iterate(1, i -> i + 1).boxed().filter
                (x -> Math.round(Math.cbrt(x)) * Math.round(Math.cbrt(x)) * Math.round(Math.cbrt(x)) == x).limit(10).toList();
    }
    String choix;
    String resultat;
    public void question4(Stage stage){
        /*
        Pondération: 20%
        Pour réussir cette question, vous devez implémenter un "Pile ou Face".
        Le Stage vous est fourni en paramètre. Vous devez afficher un Label et deux boutons.
        Lors du clic sur un bouton, le programme doit piger au hasard si le résultat est pile ou face.
        Le label doit afficher si l'utilisateur a choisi le bon.
        Le Stage vous est passé tel quel et aucune modification n'a été apportée.
         */


        Group root = new Group();

        Button pile = new Button("Pile");
        pile.setTranslateX(100);

        Button face = new Button("Face");
        face.setTranslateX(200);

        Label label = new Label("Pile ou Face?");
        label.setTranslateX(130);
        label.setTranslateY(50);

        pile.setOnAction( e -> {
            choix = "pile";

            if (Math.random() >= 0.5)
                resultat = "pile";
            else resultat = "face";

            if (choix.equals(resultat))
                label.setText("Pile! tu as fait le bon choix");
            else label.setText("Face! tu as fait le mauvais choix");
        });
        face.setOnAction( e -> {
            choix = "face";

            if (Math.random() >= 0.5)
                resultat = "pile";
            else resultat = "face";

            if (choix.equals(resultat))
                label.setText("Face! tu as fait le bon choix");
            else label.setText("Pile! tu as fait le mauvais choix");
        });
        root.getChildren().addAll(label, pile, face);
        stage.setScene(new Scene(root));
        stage.setMinWidth(350);
        stage.setMaxHeight(300);
        //stage.show();
    }

    public void question5(Stage stage){
        /*
        Pondération: 35%
        Pour réussir cette question, vous devez recréer le dessin animé que vous trouverez dans le fichier
        "question5_resultat.PNG" dans le Stage qui vous est fourni en paramètre.
        Voici une liste des couleurs utilisées:
         - BLACK
         - GREY
         - DARKRED
         - DARKCYAN
         - DARKBLUE
         - DARKGREEN
         - DARKORANGE
         - DARKMAGENTA
         - DARKOLIVEGREEN
         */
        //train
        Group root = new Group();

        Rectangle rectangleRouge = new Rectangle(50, 80, 150, 250);
        rectangleRouge.setFill(Color.DARKRED);

        Rectangle fenetre = new Rectangle(75, 100, 100, 80);
        Stop[] stops = new Stop[]{
                new Stop(0, Color.WHITE),
                new Stop(0.33, Color.LIGHTBLUE),
                new Stop(0.66, Color.LIGHTSKYBLUE),
                new Stop(1, Color.DEEPSKYBLUE)
        };

        LinearGradient linearGradient = new LinearGradient(0,0 , 1,1 , true, CycleMethod.NO_CYCLE, stops);
        fenetre.setFill(linearGradient);

        Rectangle rectangleBleu = new Rectangle(150,200, 300, 130);
        rectangleBleu.setFill(Color.DARKBLUE);

        Rectangle rectangleNoir = new Rectangle(50, 300, 400, 80);

        Rectangle rectangleVert = new Rectangle(300, 125, 50, 75);
        rectangleVert.setFill(Color.DARKGREEN);

        Polygon trapezeJaune = new Polygon(0,0, 3,8, 13,8, 16,0, 0,0 );
        trapezeJaune.setFill(Color.DARKORANGE);
        trapezeJaune.setScaleX(5);
        trapezeJaune.setScaleY(5);
        trapezeJaune.setTranslateX(317);
        trapezeJaune.setTranslateY(102);

        Circle cercleVert = new Circle(0, 0, 50, Color.DARKOLIVEGREEN);
        cercleVert.setTranslateX(450);
        cercleVert.setTranslateY(250);

        Polygon triangleRose = new Polygon(0,0, 0,110, 110,110, 0,0);
        triangleRose.setFill(Color.DARKMAGENTA);
        triangleRose.setTranslateX(450);
        triangleRose.setTranslateY(300);

        Ellipse fumeeBasse = new Ellipse(125, 50);
        fumeeBasse.setTranslateX(270);
        fumeeBasse.setTranslateY(40);
        fumeeBasse.setScaleX(0.35);
        fumeeBasse.setScaleY(0.35);
        fumeeBasse.setFill(Color.GREY);

        Ellipse fumeeHaute = new Ellipse(125, 50);
        fumeeHaute.setTranslateY(-35);
        fumeeHaute.setTranslateX(200);
        fumeeHaute.setScaleX(0.7);
        fumeeHaute.setScaleY(0.7);
        fumeeHaute.setFill(Color.GREY);


        Group rayonsGris = new Group();

        Line rayonHaut = new Line(0,0, 50,10);
        rayonHaut.setStroke(Color.GREY);
        rayonHaut.setStrokeWidth(3);

        Line rayonMilieu = new Line(0,0, 50,10);
        rayonMilieu.setTranslateY(50);
        rayonMilieu.setStroke(Color.GREY);
        rayonMilieu.setStrokeWidth(3);

        Line rayonBas = new Line(0,0, 50,10);
        rayonBas.setTranslateY(100);
        rayonBas.setStroke(Color.GREY);
        rayonBas.setStrokeWidth(3);

        rayonsGris.getChildren().addAll(rayonHaut, rayonBas, rayonMilieu);
        rayonsGris.setTranslateY(220);
        rayonsGris.setTranslateX(-30);


        Group roues = new Group();

        Circle roue1 = new Circle(0,0, 30, Color.TRANSPARENT);
        roue1.setStroke(Color.GREY);
        roue1.setStrokeWidth(6);

        Circle roue2 = new Circle(0,0, 30, Color.TRANSPARENT);
        roue2.setStroke(Color.GREY);
        roue2.setStrokeWidth(6);
        roue2.setTranslateX(90);

        Circle roue3 = new Circle(0,0, 30, Color.TRANSPARENT);
        roue3.setStroke(Color.GREY);
        roue3.setStrokeWidth(6);
        roue3.setTranslateX(180);

        Circle roue4 = new Circle(0,0, 30, Color.TRANSPARENT);
        roue4.setStroke(Color.GREY);
        roue4.setStrokeWidth(6);
        roue4.setTranslateX(270);

        roues.getChildren().addAll(roue1, roue2, roue3, roue4);
        roues.setTranslateY(383);
        roues.setTranslateX(110);

        root.getChildren().addAll(cercleVert, rectangleBleu, rectangleRouge, fenetre, rectangleNoir, rectangleVert, trapezeJaune, triangleRose, roues);
        root.setTranslateY(100);
        root.setTranslateX(100);

        //animation
        Timeline temps = new Timeline();

        //fumee scale
        ScaleTransition scaleTransitionFumeeHaute = new ScaleTransition(Duration.seconds(1), fumeeHaute);
        scaleTransitionFumeeHaute.setFromX(0.7);
        scaleTransitionFumeeHaute.setFromY(0.7);
        scaleTransitionFumeeHaute.setToX(0.5);
        scaleTransitionFumeeHaute.setToY(0.5);
        scaleTransitionFumeeHaute.setCycleCount(Animation.INDEFINITE);
        scaleTransitionFumeeHaute.setAutoReverse(true);
        scaleTransitionFumeeHaute.play();


        ScaleTransition scaleTransitionFumeeBasse = new ScaleTransition(Duration.seconds(1.25), fumeeBasse);
        scaleTransitionFumeeBasse.setDelay(Duration.seconds(0.33));
        scaleTransitionFumeeBasse.setFromX(0.35);
        scaleTransitionFumeeBasse.setFromY(0.35);
        scaleTransitionFumeeBasse.setToX(0.45);
        scaleTransitionFumeeBasse.setToY(0.45);
        scaleTransitionFumeeBasse.setCycleCount(Animation.INDEFINITE);
        scaleTransitionFumeeBasse.setAutoReverse(true);
        scaleTransitionFumeeBasse.play();

        //rayon gigote
        temps.getKeyFrames().add(0, new KeyFrame(Duration.seconds(0.01), e -> {
            rayonsGris.rotateProperty().set(5);
            rayonsGris.translateYProperty().add(5);
        }));
        temps.getKeyFrames().add(1, new KeyFrame(Duration.seconds(0.02), e -> {
            rayonsGris.rotateProperty().set(0);
            rayonsGris.translateYProperty().subtract(5);
        }));

        //roues gigote
        temps.getKeyFrames().add(2, new KeyFrame(Duration.seconds(0.01), e -> {
            roues.translateYProperty().set(388);
        }));
        temps.getKeyFrames().add(3, new KeyFrame(Duration.seconds(0.02), e -> {
            roues.translateYProperty().set(383);
        }));

        temps.setAutoReverse(true);
        temps.setCycleCount(Animation.INDEFINITE);
        temps.play();

        //effets
        DropShadow dropShadow = new DropShadow(10 ,10, 10,Color.DARKGREY);
        root.setEffect(dropShadow);

        root.getChildren().addAll(rayonsGris, fumeeBasse, fumeeHaute);

        stage.setScene(new Scene(root));
        stage.setMinWidth(600);
        stage.setMinHeight(600);
        stage.show();
    }
}