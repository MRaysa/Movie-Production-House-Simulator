package mainpkg;

import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;

public class VisualizeSceneController implements Initializable {

    @FXML
    private TextArea interpretScriptTextArea;

    //private Visualize director;  // Assuming you have a Director instance
    @FXML
    private TextArea scriptTextArea;
    @FXML
    private TextArea visualizeFilmTextArea;
    @FXML
    private TextArea visualizeFilmTextArea1;

    private String desig;
    private String name;
    private User user;
    User director;
    MovieProject movie;
    private String selectedMovieName;

    public void initData(String desig, String name, String movieName) {
        this.desig = desig;
        this.name = name;
        this.selectedMovieName = movieName;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize your controller
    }

    @FXML
    private void visualizeFilmButtonOnClick(ActionEvent event) {
        // Assuming Visualize has a method to visualize the film
        //director.visualizeFilm();

        // Add logic to update the UI or perform other actions related to visualizing the film
        // For demonstration purposes, let's append some example visualization details to the visualizeFilmTextArea
        visualizeFilmTextArea.appendText("Visualization Details:\n");
        visualizeFilmTextArea.appendText("- Plan dynamic camera movements for the action sequence.\n");
        visualizeFilmTextArea.appendText("- Experiment with different lighting setups to convey the desired mood.\n");
        visualizeFilmTextArea.appendText("- Use visual effects to enhance the fantasy elements in the climax.\n");
    }

    @FXML
    private void setPaceAndTimingButtonOnClick(ActionEvent event) {
        // Implement pacing and timing logic
        // Assuming Visualize has a method to set pace and timing
        //dirctor.setPaceAndTiming();

        // Add logic to update the UI or perform other actions related to setting pace and timing
        // For demonstration purposes, let's append some example details to the visualizeFilmTextArea
        visualizeFilmTextArea1.appendText("Pace and Timing Details:\n");
        visualizeFilmTextArea1.appendText("- Adjust pacing to build tension in the middle of the film.\n");
        visualizeFilmTextArea1.appendText("- Fine-tune timing for key emotional scenes.\n");
        visualizeFilmTextArea1.appendText("- Ensure a smooth transition between different sequences.\n");
    }

    @FXML
    private void interpretSciptButtonOnClick(ActionEvent event) {
        String scriptContent = scriptTextArea.getText();

        // Assuming Visualize has a method to interpret the script
        //director.interpretScript(scriptContent);
        // Set the movie name in the interpretScriptTextArea
        interpretScriptTextArea.setText(scriptContent + "\n");
        // Add some descriptive dummy interpretation findings
        interpretScriptTextArea.appendText("Interpretation Findings:\n");
        interpretScriptTextArea.appendText("- In the opening scene, establish a mysterious atmosphere to captivate the audience.\n");
        interpretScriptTextArea.appendText("- Explore the protagonist's internal conflict during the emotional confrontation scene.\n");
        interpretScriptTextArea.appendText("- Use lighting to symbolize hope and despair in the climactic sequence.\n");

    }

    @FXML
    private void getSciptFromScriptwriterButtonOnClick(ActionEvent event) {
        // Retrieve the script file based on the movie name
        String scriptFileName = selectedMovieName + "Script.txt";
        File scriptFile = new File(scriptFileName);

        if (scriptFile.exists()) {
            try {
                // Read the contents of the script file
                String scriptContent = new String(Files.readAllBytes(scriptFile.toPath()));

                // Display the script in the TextArea
                scriptTextArea.setText(scriptContent);

                // Show a success alert
                showSuccessAlert("Script Loaded Successfully");
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception appropriately
            }
        } else {
            // Show an error alert if the script file doesn't exist
            showErrorAlert("Script File Not Found");
        }
    }

    // Helper method to show a success alert
    private void showSuccessAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Helper method to show an error alert
    private void showErrorAlert(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }



    @FXML
    private void goToInterpretScriptButtonOnClick(ActionEvent event) throws IOException {
        // Check if the event source is a MenuItem
        if (event.getSource() instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) event.getSource();

            // Your existing code here
            FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/VisualizeFilm.fxml"));
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
    private void goTovisualizeFilmButtonOnClick(ActionEvent event) throws IOException {
        // Check if the event source is a MenuItem
        if (event.getSource() instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) event.getSource();

            // Your existing code here
            FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/VisualizeFilm.fxml"));
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
    private void goTosetPaceAndTimingButtonOnClick(ActionEvent event) throws IOException {
        // Check if the event source is a MenuItem
        if (event.getSource() instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) event.getSource();

            // Your existing code here
            FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/VisualizeFilm.fxml"));
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
    private void goToDirectActorButtonOnClick(ActionEvent event) throws IOException {
        // Check if the event source is a MenuItem
        if (event.getSource() instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) event.getSource();

            // Your existing code here
            FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/DirectActorScene.fxml"));
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
    private void goToScheduleFilmButtonOnClick(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainpkg/ScheduleFilmDateScene.fxml"));
            Parent root = loader.load();

            // Create a new stage for the Request Product window
            Stage ScheduleFilmDateStage = new Stage();
            ScheduleFilmDateStage.setTitle("Schedule Film Dates Window");
            ScheduleFilmDateStage.setScene(new Scene(root));

            // Set the RequestProductWindowController as the controller for the new stage
            //EquipmentSetupSceneController controller = loader.getController();
            // You can pass any necessary data to the controller here if needed
            // Set the new stage to be modal (blocks interactions with the main window)
            ScheduleFilmDateStage.initModality(Modality.APPLICATION_MODAL);

            // Show the new stage
            ScheduleFilmDateStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception

        }
    }

    @FXML
    private void goToEquipmentSetupButtonOnClick(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainpkg/EquipmentSetupScene.fxml"));
            Parent root = loader.load();

            // Create a new stage for the Request Product window
            Stage EquipmentSetupStage = new Stage();
            EquipmentSetupStage.setTitle("Equipment Setup Window");
            EquipmentSetupStage.setScene(new Scene(root));

            // Set the RequestProductWindowController as the controller for the new stage
            //EquipmentSetupSceneController controller = loader.getController();
            // You can pass any necessary data to the controller here if needed
            // Set the new stage to be modal (blocks interactions with the main window)
            EquipmentSetupStage.initModality(Modality.APPLICATION_MODAL);

            // Show the new stage
            EquipmentSetupStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }

    @FXML
    private void goToRequestProductButtonOnClick(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainpkg/RequestProductScene.fxml"));
            Parent root = loader.load();

            // Create a new stage for the Request Product window
            Stage requestProductStage = new Stage();
            requestProductStage.setTitle("Request Product Window");
            requestProductStage.setScene(new Scene(root));

            // Set the RequestProductWindowController as the controller for the new stage
            RequestProductSceneController controller = loader.getController();
            // You can pass any necessary data to the controller here if needed

            // Set the new stage to be modal (blocks interactions with the main window)
            requestProductStage.initModality(Modality.APPLICATION_MODAL);

            // Show the new stage
            requestProductStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }

    }

    @FXML
    private void goToLocationButtonOnClick(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainpkg/AddLocationScene.fxml"));
            Parent root = loader.load();

            // Create a new stage for the Request Product window
            Stage AddLocationStage = new Stage();
            AddLocationStage.setTitle("Add Location Window");
            AddLocationStage.setScene(new Scene(root));

            // Set the RequestProductWindowController as the controller for the new stage
            //EquipmentSetupSceneController controller = loader.getController();
            // You can pass any necessary data to the controller here if needed
            // Set the new stage to be modal (blocks interactions with the main window)
            AddLocationStage.initModality(Modality.APPLICATION_MODAL);

            // Show the new stage
            AddLocationStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }

    }

    @FXML
    private void toDirectorDashboardButtonOnClicked(ActionEvent event) throws IOException {


    }

    @FXML
    private void directorDashboardButtonOnClicked(ActionEvent event) throws IOException {
                Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/DirectorDashboardScene.fxml"));
        root = (Parent) (someLoader.load());
        Scene someScene = new Scene(root);

        //data passing code here
        //CreateCharacterSceneController createCharacterSceneController = someLoader.getController();
        // Pass the necessary data to CraftStorySceneController
        //createCharacterSceneController.initData(desig, name, selectedMovieName);

        Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();
    }
}
