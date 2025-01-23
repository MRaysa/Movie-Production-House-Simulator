package mainpkg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class WriteScriptSceneController implements Initializable {

    @FXML
    private TextArea standardScriptFormatTextArea;
    @FXML
    private TextArea writeScriptTextArea;

    private String desig;
    private String name;
    private User user;
    User scriptwriter;
    MovieProject movie;
    private String selectedMovieName; // Add this line

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
        loadContentFromFile();
    }

    private void loadContentFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("standardFormat.txt"))) {
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            standardScriptFormatTextArea.setText(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (show an error message, log, etc.) based on your application's needs.
        }
    }

    private void loadContentFromFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            standardScriptFormatTextArea.setText(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (show an error message, log, etc.) based on your application's needs.
        }
    }

    @FXML
    private void backToScriptwriterDashboardButtonOnClicked(ActionEvent event) {
    }

    @FXML
    private void goToCharacterButtonOnClick(ActionEvent event) throws IOException {
        // Check if the event source is a MenuItem
        if (event.getSource() instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) event.getSource();

            // Your existing code here
            FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/CreateCharacterScene.fxml"));
            Parent root = someLoader.load();
            Scene someScene = new Scene(root);

            // Data passing code here
            //DialogueSceneController x = someLoader.getController();
            //x.setCharList(charList);
            // Get the current stage
            Stage currentStage = (Stage) menuItem.getParentPopup().getOwnerWindow();

            // Set the new scene to the stage
            currentStage.setScene(someScene);
            currentStage.show();
        }
    }

    @FXML
    private void goToStoryButtonOnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainpkg/CraftStoryScene.fxml"));
            AnchorPane root = loader.load();

            // Create a new stage for the text editor window
            Stage textEditorStage = new Stage();
            textEditorStage.setTitle("Story Editor");
            textEditorStage.initModality(Modality.APPLICATION_MODAL); // Block interactions with other windows
            textEditorStage.setScene(new Scene(root, 400, 500));

            // Set up the controller for the text editor window
            CraftStorySceneController craftStorySceneController = loader.getController();
            // You can pass data or perform other initialization if needed

            textEditorStage.showAndWait(); // Show the text editor window and wait for it to be closed
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }

    @FXML
    private void goToDialogueButtonOnClick(ActionEvent event) throws IOException {
        // Check if the event source is a MenuItem
        if (event.getSource() instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) event.getSource();

            // Your existing code here
            FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/DialogueScene.fxml"));
            Parent root = someLoader.load();
            Scene someScene = new Scene(root);

            // Data passing code here
            //DialogueSceneController x = someLoader.getController();
            //x.setCharList(charList);
            // Get the current stage
            Stage currentStage = (Stage) menuItem.getParentPopup().getOwnerWindow();

            // Set the new scene to the stage
            currentStage.setScene(someScene);
            currentStage.show();
        }
    }

    @FXML
    private void goToSceneDescriptionButtonOnClick(ActionEvent event) throws IOException {
        // Check if the event source is a MenuItem
        if (event.getSource() instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) event.getSource();

            // Your existing code here
            FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/SceneDescriptionScene.fxml"));
            Parent root = someLoader.load();
            Scene someScene = new Scene(root);

            // Data passing code here
            //DialogueSceneController x = someLoader.getController();
            //x.setCharList(charList);
            // Get the current stage
            Stage currentStage = (Stage) menuItem.getParentPopup().getOwnerWindow();

            // Set the new scene to the stage
            currentStage.setScene(someScene);
            currentStage.show();
        }
    }

    @FXML
    private void goToCharacterDepthButtonOnClick(ActionEvent event) throws IOException {
        // Check if the event source is a MenuItem
        if (event.getSource() instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) event.getSource();

            // Your existing code here
            FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/CharacterDepthScene.fxml"));
            Parent root = someLoader.load();
            Scene someScene = new Scene(root);

            // Data passing code here
            //DialogueSceneController x = someLoader.getController();
            //x.setCharList(charList);
            // Get the current stage
            Stage currentStage = (Stage) menuItem.getParentPopup().getOwnerWindow();

            // Set the new scene to the stage
            currentStage.setScene(someScene);
            currentStage.show();
        }
    }

    @FXML
    private void goToMaintainFormatButtonOnClick(ActionEvent event) throws IOException {
        // Check if the event source is a MenuItem
        if (event.getSource() instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) event.getSource();

            // Your existing code here
            FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/MaintainFormatScene.fxml"));
            Parent root = someLoader.load();
            Scene someScene = new Scene(root);

            // Data passing code here
            //DialogueSceneController x = someLoader.getController();
            //x.setCharList(charList);
            // Get the current stage
            Stage currentStage = (Stage) menuItem.getParentPopup().getOwnerWindow();

            // Set the new scene to the stage
            currentStage.setScene(someScene);
            currentStage.show();
        }
    }

    @FXML
    private void saveScriptButtonOnClick(ActionEvent event) {
        try {
            // Assuming you have a TextArea for entering the story content with the fx:id "storyTextArea"
            String storyContent = writeScriptTextArea.getText();

            // Combine the scriptwriter name and selected movie name to form the file name
            String fileName = selectedMovieName + "Script.txt";

            // Get the current working directory
            String currentDirectory = System.getProperty("user.dir");

            // Create a File object representing the destination file in the current working directory
            File file = new File(currentDirectory + File.separator + fileName);

            // Save the story content to the file
            try (PrintWriter writer = new PrintWriter(file)) {
                writer.println(storyContent);
            }

            // Show a success message using an Alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("File saved successfully!");
            alert.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions appropriately

            // Show an error message using an Alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error saving the file.");
            alert.showAndWait();
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void goToWriteScriptButtonOnClick(ActionEvent event) throws IOException {
        // Check if the event source is a MenuItem
        if (event.getSource() instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) event.getSource();

            // Your existing code here
            FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/WriteScriptScene.fxml"));
            Parent root = someLoader.load();
            Scene someScene = new Scene(root);

            // Data passing code here
            //DialogueSceneController x = someLoader.getController();
            //x.setCharList(charList);
            // Get the current stage
            Stage currentStage = (Stage) menuItem.getParentPopup().getOwnerWindow();

            // Set the new scene to the stage
            currentStage.setScene(someScene);
            currentStage.show();
        }
    }

    @FXML
    private void loadScriptButtonOnClick(ActionEvent event) {
        // Construct the file name based on the selected movie name
        String fileName = selectedMovieName + "Script.txt";

        // Get the file path
        Path filePath = Paths.get(fileName);

        // Load the content from the file
        loadScriptFromFile(filePath.toFile());
    }

    private void loadScriptFromFile(File file) {
        try {
            // Read content from the file
            String content = new String(Files.readAllBytes(file.toPath()));

            // Set the content to the writeScriptTextArea
            writeScriptTextArea.setText(content);
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Could not load file.");
        }
    }

    @FXML
    private void toScriptwriterDashboardButtonOnClicked(ActionEvent event) throws IOException {
                               // Check if the event source is a MenuItem
        if (event.getSource() instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) event.getSource();

            // Your existing code here
            FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/ScriptwriterDashboardScene.fxml"));
            Parent root = someLoader.load();
            Scene someScene = new Scene(root);

            // Data passing code here
            //DialogueSceneController x = someLoader.getController();
            //x.setCharList(charList);
            // Get the current stage
            Stage currentStage = (Stage) menuItem.getParentPopup().getOwnerWindow();

            // Set the new scene to the stage
            currentStage.setScene(someScene);
            currentStage.show();
        }
    }

}
