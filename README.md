<h1> JavaFXDemo </h1>
<p> This project focuses on learning the skills needed for basic gui design. JavaFX is used due to the usefulness
of SceneBuilder. </p> 

<h2> Previews </h2>
<h5> A demonstration of switching scenes.</h5>

<p align="center">
<img src="https://thumbs.gfycat.com/FelineBlondBoubou-size_restricted.gif" height="450px" width="600px"/>
  </p>

| Concurrency   | Listing |
| ------------- | ------------- |
| <img src="https://thumbs.gfycat.com/KindDeadAsiandamselfly-size_restricted.gif" height="350px" width="500px"/>|<img src="https://thumbs.gfycat.com/ShallowShamelessHuia-size_restricted.gif" height="350px" width="500px"/> |

<h2> How it works </h2>
<h4> Switching scenes </h4>
<p>The main goal in this is to somehow change the gui upon button click. To do this we have to retreive the stage and pass it to the
controllers. </p>

<p> Here is my approach. First we have a method to set the stage in the class that loads the scene. </p>

```
    public void setStage(ParentController controller) {
        controller.setStage(_stage);
    }
```

<p> Notice that the parameter for the above signature parameter is a <em>ParentController </em>. This is an abstract class
  and the parent of all other controllers. This is done because every controller needs to set the stage, therefore this will reduce code. Here is the code:</p>
  
```
public abstract class ParentController {
    protected Stage _stage;

    public void setStage(Stage stage) {
        _stage = stage;
    }
}
```

<p>Note: The protected visibility is done so that all the children of the ParentController class can access the stage.
<p> Now we need to somehow get the controller itself. We can make use of the parent FXMLLoader class. </p>

```
    setStage(getController());
```

<p> Then we can simply assign a handler to a button and make it load a new scene: </p>

```
    @FXML
    private void moveToFirst() throws IOException {
        new SceneBuilder(_stage).load("FirstMenu.fxml");
    }
```

<h4> Concurrency </h4>
<p> Concurrency is important for every gui application. It prevents your gui from freezing due to extensive computation tasks. We
  can make use of concurrency using multithreading and the <em>Task</em> class.</p>
  
<p> In our example, we used a private class for the long running tasks. </p>

```
private class Timer extends Task<Void> {}
```

<p> Note: the Void is used because we do not want to return anything useful. </p>

<p> Extending the Task class causes us to implement the abstract method <em>call()</em>. The call() method what gets called to run
  in the background. This is where our long running tasks should go </p>

```
    @Override
    protected Void call() throws Exception {
        //Long running tasks go here.
        return null;
    }
```

<p> Sometimes we want something to happen when the background task finishes executing. This is where the <em>done()</em> method comes
  in handy. </p>
  
  ```
  @Override
  protected void done() {
      Platform.runLater(
              new Runnable() {
                  @Override
                  public void run() {
                      //Ending tasks go here.
                  }
              }
      );
  }
  ```
  
  <h4> List </h4>
  
<p> The purpose of this task was to demonstrate the ListView component of JavaFX. </p>

<p> This is the method that handles the button click. First we retreive the current list (if there is any), then
we add onto it. Finally, we update list for the user. </p>

```
  @FXML
  private void updateList() {
      getList();
      add();
      _listView.setItems(FXCollections.observableArrayList(_items));
  }
  
  private void getList() {
      _items = _listView.getItems();
  }

  private void add() {
      if (_inputField.getText().isEmpty()) {}
      else {
          _items.add(_inputField.getText());
      }
  }
```

<h4> Styling </h4>
<p> I used simple css styling to demonstrate how to style different scenes. </p>
<p> Here is a bit of code so the application knows which styling sheet to pick for which view.
Note: This is assuming your style sheets are in a directory in the views package. </p>

```
   String css = this.getClass().getResource("styles/"+url.substring(0,url.length()-4)+"css").toExternalForm();
    scene.getStylesheets().add(css);
```

<p> From here, we just have to add the specific stylesheets to the scenebuilder and the corresponding id to it. </p>
<img src="https://i.imgur.com/Tg7jZGC.png" />
<img src="https://i.imgur.com/jM2yALn.png" />
