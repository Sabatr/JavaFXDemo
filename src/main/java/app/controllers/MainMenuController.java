package app.controllers;

import app.views.SceneBuilder;
import javafx.fxml.FXML;

import java.io.IOException;

/**
 * This class focuses on the functionality of the components in the
 * MainMenu view.
 *
 * @author Brian Nguyen
 */
public class MainMenuController extends ParentController{

    /**
     * This function acts as a listener to change to the
     * second menu.
     * @throws IOException
     */
    @FXML
    private void nextMenu() throws IOException {
        new SceneBuilder(_stage).load("SecondMenu.fxml");
    }
}
