package mainpkg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DirectActorSceneController implements Initializable {

    @FXML
    private ComboBox<String> selectActorComboBox;
    @FXML
    private TableView<Actor> actorTableView;
    @FXML
    private TableColumn<Actor, String> actorTableColumn;
    @FXML
    private TableColumn<Actor, String> actorGenderTableView;
    private List<Actor> actors;
    @FXML
    private ComboBox<String> assignCharacterComboBox;

    private String desig;
    private String name;
    MovieProject movie;
    public String selectedMovieName;

    public void initData(String desig, String name, String movieName) {
        this.desig = desig;
        this.name = name;
        this.selectedMovieName = movieName;
        System.out.println("Selected Movie Name in DirectActorSceneController: " + selectedMovieName);
    
        initializeAssignCharacterComboBox();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        actors = Arrays.asList(
                new Actor("Sylvester Stallone", "Male"),
                new Actor("Monica Bellucci", "Female"),
                new Actor("Asaduzzaman Nur", "Male"),
                new Actor("Johnny Depp", "Male"),
                new Actor("Salman Shah", "Male"),
                new Actor("Anne Hathaway", "Female"),
                new Actor("Sophia Loren", "Female"),
                new Actor("Subarna Mustafa", "Female"),
                new Actor("Aly Zaker", "Male")
        );

        // Populate ComboBox
        populateComboBox();
        // Initialize TableView
        initializeTableView();
    }

    private void populateComboBox() {
        // Populate ComboBox with actor names
        for (Actor actor : actors) {
            selectActorComboBox.getItems().add(actor.getName());
        }
    }

    private void initializeTableView() {
        // Set up columns
        actorTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        actorGenderTableView.setCellValueFactory(new PropertyValueFactory<>("gender"));

        // Populate TableView with dummy data
        actorTableView.getItems().addAll(actors);

    }

    public void initializeAssignCharacterComboBox() {
        // Load characters from the binary file
        List<CharacterD> characters = loadCharactersFromBinaryFile();
        System.out.println("Characters loaded: " + characters.size());  // Add this line to check if characters are loaded

        // Populate ComboBox with character names
        for (CharacterD character : characters) {
            assignCharacterComboBox.getItems().add(character.getCharacterName());
        }
    }

    private List<CharacterD> loadCharactersFromBinaryFile() {
        String fileName = selectedMovieName + "Characters.bin";
        System.out.println("Attempting to load characters from file: " + fileName);
        // Use try-with-resources to automatically close the stream
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {

            // Read the list of characters from the binary file
            return (List<CharacterD>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            showAlert("Error", "Could not load characters from file.");
            return Collections.emptyList(); // Return an empty list in case of an exception
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void directActorButtonOnClick(ActionEvent event) {
        // Get selected actor from ComboBox
        String selectedActorName = selectActorComboBox.getValue();

        // Get selected character from ComboBox
        String selectedCharacter = assignCharacterComboBox.getValue();

        // Find the selected actor from the list
        Actor selectedActor = actors.stream()
                .filter(actor -> actor.getName().equals(selectedActorName))
                .findFirst()
                .orElse(null);

        // Add logic for directing the actor and assigning the character
        if (selectedActor != null && selectedCharacter != null) {
            System.out.println("Directing actor: " + selectedActor);
            System.out.println("Assigning character: " + selectedCharacter);
        }
    }

    @FXML
    private void goToInterpretScriptButtonOnClick(ActionEvent event) throws IOException {
        // Check if the event source is a MenuItem
        if (event.getSource() instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) event.getSource();

            // Your existing code here
            FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/VisualizeScene.fxml"));
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
            FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/VisualizeScene.fxml"));
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
            FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/VisualizeScene.fxml"));
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
    private void goToDirectorDashboardButtonOnClicked(ActionEvent event) throws IOException {
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

    @FXML
    private void Das(ActionEvent event) {
    }

    @FXML
    private void loadCharactersButtonOnClick(ActionEvent event) {
    }

}
