package mainpkg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class EquipmentSetupSceneController implements Initializable, Serializable {

    @FXML
    private CheckBox checkBox1;
    @FXML
    private CheckBox checkBox7;
    @FXML
    private CheckBox checkBox2;
    @FXML
    private CheckBox checkBox8;
    @FXML
    private CheckBox checkBox3;
    @FXML
    private CheckBox checkBox4;
    @FXML
    private CheckBox checkBox9;
    @FXML
    private CheckBox checkBox10;
    @FXML
    private CheckBox checkBox11;
    @FXML
    private CheckBox checkBox5;
    @FXML
    private CheckBox checkBox6;
    @FXML
    private CheckBox checkBox12;
    @FXML
    private CheckBox checkBox13;
    @FXML
    private TableView<Equipment> equipmentListTableView;
    @FXML
    private TableColumn<Equipment, String> equipmentTableColumn;
    @FXML
    private TextArea visualizedScriptTextArea;

    private ObservableList<Equipment> selectedEquipments = FXCollections.observableArrayList();
    @FXML
    private TableView<Equipment> equipmentListTableView1;
    @FXML
    private TableColumn<Equipment, String> equipmentTableColumn1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        equipmentTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        equipmentTableColumn1.setCellValueFactory(new PropertyValueFactory<>("name"));

    }

    @FXML
    private void getVisualizedScript(ActionEvent event) {
        // For demonstration purposes, let's append some example visualization details to the visualizeFilmTextArea
        visualizedScriptTextArea.appendText("Visualization Details:\n");
        visualizedScriptTextArea.appendText("- Plan dynamic camera movements for the action sequence.\n");
        visualizedScriptTextArea.appendText("- Experiment with different lighting setups to convey the desired mood.\n");
        visualizedScriptTextArea.appendText("- Use visual effects to enhance the fantasy elements in the climax.\n");
    }

    @FXML
    private void assignEquipmentButtonOnClick(ActionEvent event) {
        Scene scene = checkBox1.getScene();

        selectedEquipments.clear(); // Clear previous selections
        for (int i = 1; i <= 13; i++) {
            CheckBox checkBox = (CheckBox) scene.lookup("#checkBox" + i);
            if (checkBox.isSelected()) {
                Equipment equipment = new Equipment(checkBox.getText());
                selectedEquipments.add(equipment);
            }
        }
        equipmentListTableView.setItems(selectedEquipments);
        saveAssignedEquipmentToFile(selectedEquipments);
        showSuccessAlert("Equipment Assigned", "Equipment has been successfully assigned.");

    }

    private void showSuccessAlert(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Equipments Assignment");
        alert.setHeaderText("Equipments assigned successfully!");
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void saveAssignedEquipmentToFile(List<Equipment> assignedEquipment) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("assignedEquipment.bin"))) {
            // Save the list of assigned equipment
            oos.writeObject(new ArrayList<>(assignedEquipment));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onClose() {
        saveAssignedEquipmentToFile(selectedEquipments);
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
    private void loadEquipmentButtonOnClick(ActionEvent event) {
        // Load assigned equipment from file
        List<Equipment> loadedEquipment = loadAssignedEquipmentFromFile();

        // Display the loaded equipment in the second TableView
        equipmentListTableView1.setItems(FXCollections.observableArrayList(loadedEquipment));
    }

    private List<Equipment> loadAssignedEquipmentFromFile() {
        List<Equipment> loadedEquipment = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("assignedEquipment.bin"))) {
            // Read the list of assigned equipment from the file
            loadedEquipment = (List<Equipment>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Handle the case when the file is not found
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            // Handle other exceptions
            e.printStackTrace();
        }
        return loadedEquipment;
    }

    @FXML
    private void saveVisualizedScriptButtonOnClick(ActionEvent event) {
        // Get the text from the visualizedScriptTextArea
        String visualizedScriptText = visualizedScriptTextArea.getText();

        // Specify the file name and path
        String fileName = "visualizedScript.txt";
        String filePath = System.getProperty("user.dir") + "\\" + fileName;

        try (FileWriter fileWriter = new FileWriter(filePath)) {
            // Write the text to the file
            fileWriter.write(visualizedScriptText);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception according to your application's needs
        }

        // Optionally, provide feedback to the user or perform additional actions
        System.out.println("Visualized script saved to: " + filePath);
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
