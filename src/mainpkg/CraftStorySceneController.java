package mainpkg;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class CraftStorySceneController implements Initializable {

    @FXML
    private TextArea scriptTextArea;
    MovieProject movie;
    String desig;
    String name;
    String selectedMovieName;

    public void initData(String desig, String name, String movieName) {
        this.desig = desig;
        this.name = name;
        this.selectedMovieName = movieName;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void newFileButtonOnClicked(ActionEvent event) {
        scriptTextArea.clear();
    }

    @FXML
    private void openFileButtonOnClicked(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            try {
                String content = new String(Files.readAllBytes(selectedFile.toPath()));
                scriptTextArea.setText(content);
            } catch (IOException e) {
                e.printStackTrace();
                // Show a pop-up using Alert
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("File cannot be opened");

                alert.showAndWait();
            }
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void saveFileButtonOnClicked(ActionEvent event) {
        try {
            // Assuming you have a TextArea for entering the story content with the fx:id "storyTextArea"
            String storyContent = scriptTextArea.getText();

            // Combine the scriptwriter name and selected movie name to form the file name
            String fileName = selectedMovieName + "Story.txt";

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

    @FXML
    private void closeFileButtonOnClicked(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/ScriptwriterDashboardScene.fxml"));
        root = (Parent) (someLoader.load());
        Scene someScene = new Scene(root);

        //data passing code here
        Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();
    }

}
