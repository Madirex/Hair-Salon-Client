package com.madirex.hairsalonclient;

import com.madirex.hairsalonclient.model.UserConfiguration;
import com.madirex.hairsalonclient.restcontroller.APIRestConfig;
import com.madirex.hairsalonclient.utils.Util;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private static Stage stage;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        App.stage = Util.getStageWithIcon(stage);
        startStage();
    }

    public void startStage() throws IOException {
        APIRestConfig.loginSetToken(); //Set login token
        UserConfiguration.loadData(); //Load admin config (local)
        Parent root = Util.getParentRoot("main_view");
        Scene scene = new Scene(root, 1280, 800);
        stage.setTitle(Util.getString("title.appName"));
        stage.setScene(scene);
        stage.show();
    }

    public void reloadStage() throws IOException {
        stage.close();
        startStage();
    }
}