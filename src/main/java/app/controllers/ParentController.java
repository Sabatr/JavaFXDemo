package app.controllers;

import javafx.stage.Stage;

/**
 * This class acts as the parent of all controllers.
 * This class contains all the necessary methods and fields all
 * other controllers need.
 *
 * @author Brian Nguyen
 */
public abstract class ParentController {
    protected Stage _stage;

    /**
     * This method allows the child controllers to change the scene.
     * @param stage
     */
    public void setStage(Stage stage) {
        _stage = stage;
    }
}
