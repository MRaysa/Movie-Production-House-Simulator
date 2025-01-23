package mainpkg;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class ScheduleFilmDateSceneController implements Initializable {

    @FXML
    private DatePicker scheduleDatePicker;
    @FXML
    private RadioButton dayRB;
    @FXML
    private RadioButton nightRB;
    @FXML
    private ToggleGroup shiftTG;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void makeScheduleButtonOnClick(ActionEvent event) {
        // Get user inputs
        LocalDate selectedDate = scheduleDatePicker.getValue();
        String selectedShift = dayRB.isSelected() ? "Day" : "Night";

        // Validate user inputs
        if (selectedDate == null) {
            showErrorAlert("Please select a date.");
            return;
        }

        // Create a FilmDate instance
        FilmDate filmDate = new FilmDate(selectedDate, selectedShift);

        // Write the FilmDate instance to a text file
        writeFilmDateToFile(filmDate);

        // Show a success alert
        showSuccessAlert("Film Date Scheduled Successfully");
    }

    // Helper method to write FilmDate to a text file
    private void writeFilmDateToFile(FilmDate filmDate) {
        // Construct the file name based on the selected movie name
        String fileName = selectedMovieName + "FilmDate.txt";

        // Get the file path
        Path filePath = Paths.get(fileName);

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath.toFile(), true))) {
            // Append the FilmDate details to the file
            writer.println(filmDate.toString());
        } catch (IOException e) {
            showErrorAlert("Error writing to file.");
            e.printStackTrace(); // Handle the exception appropriately
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

    // Helper method to show an alert
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
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
    private void goToScheduleFilmButtonOnClick(ActionEvent event) {
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
    private void goToEquipmentSetupButtonOnClick(ActionEvent event) {
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
    private void goToRequestProductButtonOnClick(ActionEvent event) {
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
    private void goToLocationButtonOnClick(ActionEvent event) {
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
        // Check if the event source is a MenuItem
        if (event.getSource() instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) event.getSource();

            // Your existing code here
            FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/DirectorDashboardScene.fxml"));
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
