package com.example.gamemarketplace;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.gamemarketplace.GMarketplace.primaryStage;

public class MenuController {


    public Game game;
    public VBox boxy;
    public Label description;


    public interface MenuControllerDelegate {
        void showNewGame();
    }

    public MenuControllerDelegate delegate = null;


    public VBox myVBox = new VBox();
    public HBox aHBox = new HBox();

    ScrollPane scrollPane = new ScrollPane(myVBox);





    @FXML
    protected void buttonClicked() {
        delegate.showNewGame();
    }


    protected void showGames(List<Game> games) {
        String image;
        myVBox.getChildren().clear();
        myVBox.setSpacing(25);




        int k = 0;
        Rectangle r = new Rectangle();
        r.setX(-100);
        r.setY(-410);
        r.setWidth(1500);
        r.setHeight(310);
        r.setArcWidth(20);
        r.setArcHeight(20);
        r.setFill(Paint.valueOf("#5f9ea0"));
        r.setManaged(false);
        r.setEffect(new DropShadow());
        aHBox.getChildren().add(r);

        while (k < games.size()) {
            HBox box = new HBox();
            box.setSpacing(5);

            for (int i = 0; i < 3; i++) {

                if (k >= games.size()) {
                    break;
                }
                Label description = new Label(games.get(k).getDescription());
                TextArea descriptionBox = new TextArea();
                descriptionBox.setVisible(true);


                String tagLine = "";

                if (games.get(k).getImageID() == 1) {
                    image = "shooter.png";
                } else if (games.get(k).getImageID() == 2) {
                    image = "rpg.png";
                } else {
                    image = "driving.png";
                }

                Image imageOk = new Image(getClass().getResourceAsStream(image));
                Button gameImage = new Button(" ", new ImageView(imageOk));

                gameImage.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                    }
                });

                if(!games.get(k).getTags().isEmpty()) {
                    for (int j = 0; j < games.get(k).getTags().size() - 1; j++) {

                        tagLine = tagLine + games.get(k).getTags().get(j) + ", ";

                    }
                    tagLine = tagLine + games.get(k).getTags().get(games.get(k).getTags().size() - 1);

                }

                Text releaseDate = new Text((games.get(k).getReleaseDate()) + "\n");

                Text gameName = new Text((games.get(k).getGameName()) + "\n");

                Text price = new Text("$" + (games.get(k).getPrice()) + "\n");

                Text tags = new Text(tagLine);

                gameName.setStyle("-fx-font: 25 Dosis;");
                releaseDate.setStyle("-fx-font: 18 Dosis;");


                TextFlow textFlow = new TextFlow(gameName, releaseDate,
                        price, tags);

                Box normalBox = new Box(250, 50, 50);
                normalBox.setVisible(false);
                textFlow.setMinWidth(225);
                textFlow.setMaxWidth(225);

                box.getChildren().addAll(gameImage, textFlow);


                k++;

            }


            myVBox.getChildren().add(box);

        }


    }

}
