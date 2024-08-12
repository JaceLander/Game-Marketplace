package com.example.gamemarketplace;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GMarketplace extends Application implements MenuController.MenuControllerDelegate, NewGameController.Delegate{
    static Stage primaryStage = null;


    List<Game> games = new ArrayList<>();
    int listIndex = 0;
    @FXML
    private TextField gameName;
    @FXML
    private TextField releaseDate;
    @FXML
    private TextField price;
    @FXML
    private TextField tag;



    @Override
    public void showNewGame() {
        FXMLLoader fxmlLoader = new FXMLLoader(GMarketplace.class.getResource("new-game.fxml"));
        Parent root = null;
        NewGameController controller;
        try {
            root = fxmlLoader.load();
            controller = fxmlLoader.getController();
            controller.delegate = this;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene scene = new Scene(root, 1350, 750);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
    }

    @Override
    public void done(Game game){
        FXMLLoader fxmlLoader = new FXMLLoader(GMarketplace.class.getResource("menu.fxml"));
        Parent root = null;
        MenuController controller;
        try {
            root = fxmlLoader.load();
            controller = fxmlLoader.getController();
            controller.delegate = this;
            controller.game = game;
            games.add(game);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene scene = new Scene(root, 1350, 750);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        controller.showGames(games);
        listIndex++;

    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GMarketplace.class.getResource("menu.fxml"));


        Scene scene = new Scene(fxmlLoader.load(), 1350, 750);
        MenuController controller = fxmlLoader.getController();
        controller.delegate = this;
        stage.setTitle("Game Marketplace");
        stage.setScene(scene);
        stage.show();
        primaryStage = stage;
        primaryStage.setResizable(false);
        controller.showGames(games);
    }

    public static void main(String[] args) {
        launch();
    }


}