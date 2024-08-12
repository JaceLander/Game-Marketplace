package com.example.gamemarketplace;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewGameController {

    public interface Delegate {
        void done(Game game);
    }

    Delegate delegate;
    @FXML
    private TextField gameName;
    @FXML
    private TextField releaseDate;
    @FXML
    private TextField price;
    @FXML
    private TextField tag;
    @FXML
    private TextArea description;

    int listIndex = 0;

    int imageID;

    private List<String> tags = new ArrayList<>();

    @FXML
    protected void buttonTagClicked() {
        tags.add(tag.getText());
        tag.clear();
        }

//        public List returnTags(){
//        return tags;
//    }


    @FXML
    protected void buttonDrivingClicked() {

        imageID = 3;

    }

    @FXML
    protected void buttonRPGClicked() {

        imageID = 2;

    }

    @FXML
    protected void buttonShooterClicked() {

        imageID = 1;

    }


    @FXML
    protected void buttonSubmitClicked() {
        if(gameName.getText() == "")
        {
            gameName.setText("Untitled Game");
        }
        if(releaseDate.getText() == "")
        {
            releaseDate.setText("TBD");
        }
        if(price.getText() == "")
        {
            price.setText("N/A");
        }
        delegate.done(new Game(gameName.getText(), releaseDate.getText(), price.getText(), tags, imageID));

    }

    }
