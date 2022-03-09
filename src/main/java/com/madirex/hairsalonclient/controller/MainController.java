package com.madirex.hairsalonclient.controller;

import com.madirex.hairsalonclient.model.UserConfiguration;
import com.madirex.hairsalonclient.utils.Util;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.util.Objects;

public class MainController implements BaseController {
    private TranslateTransition toggleTranlate;
    @FXML
    private BorderPane mainPane;
    @FXML
    private StackPane includedViewAppointments, includedViewUsers, includedViewServices, includedViewReports, includedViewSettings;
    @FXML
    private ToggleButton mainViewSideMenuButtonAppointments, mainViewSideMenuButtonUsers, mainViewSideMenuButtonServices, mainViewSideMenuButtonReports, mainViewSideMenuButtonSettings;
    @FXML
    private HBox searchBox;
    @FXML
    private TextField searchField;
    @FXML
    private AppointmentController includedViewAppointmentsController;
    @FXML
    private UsersController includedViewUsersController;
    @FXML
    private ServiceController includedViewServicesController;

    public void initialize() {
        mainPane.getStylesheets().add(Objects.requireNonNull(this.getClass()
                .getResource(Util.PACKAGE_DIR + "themes/style_" +
                        UserConfiguration.getInstance().getActualTheme().toLowerCase() + ".css")).toExternalForm());

        searchField.setOnKeyPressed(k -> refreshSearch());
    }

    @FXML
    public void onMenuItemSelected() {
        selectedConfig(mainViewSideMenuButtonAppointments, includedViewAppointments);
        selectedConfig(mainViewSideMenuButtonUsers, includedViewUsers);
        selectedConfig(mainViewSideMenuButtonServices, includedViewServices);
        selectedConfig(mainViewSideMenuButtonReports, includedViewReports);
        selectedConfig(mainViewSideMenuButtonSettings, includedViewSettings);
    }

    private void selectedConfig(ToggleButton mainViewSideMenuButtonServices, StackPane includedViewServices) {
        if (mainViewSideMenuButtonServices.isSelected()) {
            includedViewServices.setVisible(true);
            includedViewServices.setDisable(false);
            searchBox.setVisible(true);
            mainViewSideMenuButtonServices.setDisable(true);
            animateToggleButton(mainViewSideMenuButtonServices);
        } else {
            includedViewServices.setVisible(false);
            includedViewServices.setDisable(true);
            mainViewSideMenuButtonServices.setDisable(false);
            animateToggleButton(mainViewSideMenuButtonServices);
        }
    }

    public void animateToggleButton(ToggleButton toggleButton) {
        toggleTranlate = new TranslateTransition(Duration.millis(100), toggleButton);
        if (toggleButton.isSelected()) {
            toggleTranlate.setFromX(toggleButton.getTranslateX());
            toggleTranlate.setToX(toggleButton.getTranslateX() + 25);
        } else {
            toggleTranlate.setFromX(toggleButton.getLayoutX());
            toggleTranlate.setToX(toggleButton.getLayoutX());
        }
        toggleTranlate.play();
    }

    @FXML
    public void refreshSearch() {
        includedViewAppointmentsController.setSearchQuery(searchField.getText());
        includedViewServicesController.setSearchQuery(searchField.getText());
        includedViewUsersController.setSearchQuery(searchField.getText());
    }
}
