package app.controllers;

import app.views.SceneBuilder;
import javafx.fxml.FXML;

import java.io.IOException;

/**
 * This class focuses on the functionality of the components
 * of the second menu view.
 *
 * @author Brian Nguyen
 */
public class SecondMenuController extends ParentController {

    @FXML
    private void goBack() throws IOException {
        new SceneBuilder(_stage).load("MainMenu.fxml");
    }
}
