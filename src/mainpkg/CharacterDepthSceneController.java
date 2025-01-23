package mainpkg;
//Character

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CharacterDepthSceneController implements Initializable {
//Character

    @FXML
    private TableView<CharacterD> characterTableView;
    @FXML
    private ComboBox<String> selectCharacterComboBox;
    @FXML
    private CheckBox moreComplexRB;
    @FXML
    private CheckBox moreRealisticRB;
    @FXML
    private CheckBox multidimensionalRB;

    private ObservableList<CharacterD> characterData;
    @FXML
    private TableColumn<CharacterD, String> characterNameTableColumn;
    @FXML
    private TableColumn<CharacterD, String> characterTypeTableColumn;
    // Add the selectedMovieName field

    private String desig;
    private String name;

    MovieProject movie;
    private String selectedMovieName;

    public void initData(String desig, String name, String movieName) {
        this.desig = desig;
        this.name = name;
        this.selectedMovieName = movieName;
        loadCharactersFromFile();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize characterData
        characterData = FXCollections.observableArrayList();

        // Load characters from characters.bin file
        initializeTableView();
        // Initialize the TableView
        // Populate the ComboBox with character names
        updateComboBox();

    }

    private void loadCharactersFromFile() {
        System.out.println("Loading characters from file: " + selectedMovieName + "Characters.bin");

        // Load characters from characters.bin file
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(selectedMovieName + "Characters.bin"));
            List<CharacterD> loadedCharacters = (List<CharacterD>) ois.readObject();
            ois.close();

            // Clear the existing data and add the loaded characters
            characterData.clear();
            characterData.addAll(loadedCharacters);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }

    private void initializeTableView() {
        // Set up the TableView columns
        characterNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("characterName"));
        characterTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("characterType"));

        // Set the items in the TableView
        characterTableView.setItems(characterData);
    }

    private void updateComboBox() {
        // Update ComboBox with character names
        ObservableList<String> characterNames = FXCollections.observableArrayList();
        for (CharacterD character : characterData) {
            characterNames.add(character.getCharacterName());
        }
        selectCharacterComboBox.setItems(characterNames);
    }

    @FXML
    private void enhnaceCharacterDepthButtonOnClick(ActionEvent event) {
        // Get the selected character name
        String selectedCharacterName = selectCharacterComboBox.getValue();

        // Find the corresponding character instance
        CharacterD selectedCharacter = null;

        for (CharacterD character : characterData) {
            if (character.getCharacterName().equals(selectedCharacterName)) {
                selectedCharacter = character;
                break;
            }
        }

        // Apply enhancements based on CheckBox selections
        if (moreComplexRB.isSelected()) {
            enhanceComplexity(selectedCharacter);
        }

        if (moreRealisticRB.isSelected()) {
            enhanceRealism(selectedCharacter);
        }

        if (multidimensionalRB.isSelected()) {
            enhanceMultidimensionality(selectedCharacter);
        }

        // Refresh TableView with the latest data
        refreshTableView();
    }

    private void enhanceComplexity(CharacterD character) {
        // Implement enhancement for complexity
        // Example: character.setComplexity(true);
    }

    private void enhanceRealism(CharacterD character) {
        // Implement enhancement for realism
        // Example: character.setRealistic(true);
    }

    private void enhanceMultidimensionality(CharacterD character) {
        // Implement enhancement for multidimensionality
        // Example: character.setMultidimensional(true);
    }

    private void refreshTableView() {
        // Refresh TableView with the latest data from CharacterDataHolder
        characterData.setAll(CharacterDataHolder.getInstance().getCharacters());
    }

    @FXML
    private void backToScriptwriterDashboardButtonOnClicked(ActionEvent event) throws IOException {

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
