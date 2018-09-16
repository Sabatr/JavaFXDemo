package app.controllers;

import app.views.SceneBuilder;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;


import java.io.IOException;

/**
 * This class focuses on the functionality of the components
 * of the first menu view.
 *
 * @author Brian Nguyen
 */
public class FirstMenuController extends ParentController {
    //Setting up component bindings
    @FXML
    private Text _timerText;
    @FXML
    private Button _timerButton;
    @FXML
    private Button _backButton;


    /**
     * When the start button is clicked the timer starts
     * on a separate thread. The buttons are disabled during this process.
     */
    @FXML
    private void startTimer() {
        Thread thread = new Thread(new Timer());
        thread.start();
    }

    /**
     * This method acts as a listener to when the
     * back button is pressed. This causes the view to
     * switch to the main menu.
     * @throws IOException
     */
    @FXML
    private void goBack() throws IOException {
        new SceneBuilder(_stage).load("MainMenu.fxml");
    }

    /**
     * A private class which allows concurrency.
     */
    private class Timer extends Task<Void> {

        /**
         * This method does the counting
         * @throws InterruptedException
         */
        private void count() throws InterruptedException{
            _timerButton.setDisable(true);
            int i=0;
            //This allows the counter to set the text up each time.
            while (i<100) {
                if (i<10) {
                    _timerText.setText("00:00:0" + i);
                } else {
                    _timerText.setText("00:00:" + i);
                }
                Thread.sleep(10);
                i++;
            }
        }

        /**
         * This method is invoked when Thread.start() is called.
         * @throws Exception
         */
        @Override
        protected Void call() throws Exception {
            count();
            return null;
        }

        /**
         * When the call() method is finished, this method is called.
         * When finished, the buttons are renabled and the text is reset.
         */
        @Override
        protected void done() {
            Platform.runLater(
                    new Runnable() {
                        @Override
                        public void run() {
                            _timerText.setText("00:00:00");
                            _timerButton.setDisable(false);
                        }
                    }
            );
        }
    }
}
