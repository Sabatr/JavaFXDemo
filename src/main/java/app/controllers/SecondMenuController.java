package app.controllers;

import app.views.SceneBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * This class focuses on the functionality of the components
 * of the second menu view.
 *
 * @author Brian Nguyen
 */
public class SecondMenuController extends ParentController {
    @FXML
    private ListView<String> _listView;
    @FXML
    private TextField _inputField;
    private ObservableList<String> _items;

    /**
     * This method retrieves the current list in the list view
     */
    private void getList() {
        _items = _listView.getItems();
    }

    /**
     * Adds the text onto the current list. Doesn't do anything
     * if the input is empty.
     */
    private void add() {
        if (_inputField.getText().isEmpty()) {}
        else {
            _items.add(_inputField.getText());
        }
    }

    /**
     * This method updates the list to the viewer.
     */
    @FXML
    private void updateList() {
        getList();
        add();
        _listView.setItems(FXCollections.observableArrayList(_items));
    }

    /**
     * This method allows the user to return to the main menu.
     * @throws IOException
     */
    @FXML
    private void goBack() throws IOException {
        new SceneBuilder(_stage).load("MainMenu.fxml");
    }
}
