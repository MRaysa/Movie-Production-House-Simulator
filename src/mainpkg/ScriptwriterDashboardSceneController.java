package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ScriptwriterDashboardSceneController implements Initializable {

    private String desig;
    private String name;
    MovieProject movie;
    private String selectedMovieName;

    public void initData(String desig, String name, String selectedMovieName) {
        // Initialize other data if needed
        this.selectedMovieName = selectedMovieName;

    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void goToCharacterButtonOnClick(ActionEvent event) throws IOException {
//        Parent root = null;
//        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/CreateCharacterScene.fxml"));
//        root = (Parent) (someLoader.load());
//        Scene someScene = new Scene(root);
//
//        //data passing code here
//        CreateCharacterSceneController createCharacterSceneController = someLoader.getController();
//        // Pass the necessary data to CraftStorySceneController
//        createCharacterSceneController.initData(desig, name, selectedMovieName);
//
//        Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        someStage.setScene(someScene);
//        someStage.show();


        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/ActorCharacterInputs.fxml"));
        root = (Parent) (someLoader.load());
        Scene someScene = new Scene(root);

        //data passing code here
        ActorCharacterInputsController createCharacterSceneController = someLoader.getController();
        // Pass the necessary data to CraftStorySceneController
        createCharacterSceneController.initData(selectedMovieName);

        Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();
          
    }

    @FXML
    private void goToStoryButtonOnClick(ActionEvent event) throws IOException {
        // Load the CraftStoryScene FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainpkg/CraftStoryScene.fxml"));
        AnchorPane root = loader.load();

        // Create a new stage for the CraftStoryScene window
        Stage craftStoryStage = new Stage();
        craftStoryStage.setTitle("Craft Story");
        craftStoryStage.initModality(Modality.APPLICATION_MODAL); // Block interactions with other windows
        craftStoryStage.setScene(new Scene(root, 400, 500));

        // Set up the controller for the CraftStoryScene window
        CraftStorySceneController craftStoryController = loader.getController();

        // Pass the necessary data to CraftStorySceneController
        craftStoryController.initData(desig, name, selectedMovieName);

        // Show the CraftStoryScene window and wait for it to be closed
        craftStoryStage.showAndWait();

    }

    @FXML
    private void goToDialogueButtonOnClick(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/DialogueScene.fxml"));
        root = (Parent) (someLoader.load());
        Scene someScene = new Scene(root);

        //data passing code here
        DialogueSceneController dialogueSceneController = someLoader.getController();
        dialogueSceneController.initData(desig, name, selectedMovieName);

        Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();
    }

    @FXML
    private void goToSceneDescriptionButtonOnClick(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/SceneDescriptionScene.fxml"));
        root = (Parent) (someLoader.load());
        Scene someScene = new Scene(root);

        //data passing code here
        Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();
    }

    @FXML
    private void goToCharacterDepthButtonOnClick(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/CharacterDepthScene.fxml"));
        root = (Parent) (someLoader.load());
        Scene someScene = new Scene(root);

        //data passing code here
        Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();
    }

    @FXML
    private void goToMaintainFormatButtonOnClick(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/MaintainFormatScene.fxml"));
        root = (Parent) (someLoader.load());
        Scene someScene = new Scene(root);

        //data passing code here
        Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();
    }

    @FXML
    private void goToReviseScriptButtonOnClick(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/WriteScriptScene.fxml"));
        root = (Parent) (someLoader.load());
        Scene someScene = new Scene(root);

        //data passing code here
        WriteScriptSceneController writeScriptSceneController = someLoader.getController();
        // Pass the necessary data to CraftStorySceneController
        writeScriptSceneController.initData(desig, name, selectedMovieName);
        Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();
    }

    @FXML
    private void goToWriteScriptButtonOnClick(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/WriteScriptScene.fxml"));
        root = (Parent) (someLoader.load());
        Scene someScene = new Scene(root);

        //data passing code here
        WriteScriptSceneController writeScriptSceneController = someLoader.getController();
        // Pass the necessary data to CraftStorySceneController
        writeScriptSceneController.initData(desig, name, selectedMovieName);
        Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();
    }

    @FXML
    private void logOutButtonOnClick(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/FXMLDocument.fxml"));
        root = (Parent) (someLoader.load());
        Scene someScene = new Scene(root);

        //data passing code here
        //WriteScriptSceneController writeScriptSceneController = someLoader.getController();
        // Pass the necessary data to CraftStorySceneController
        // writeScriptSceneController.initData(desig, name, selectedMovieName);
        Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();

    }

}
