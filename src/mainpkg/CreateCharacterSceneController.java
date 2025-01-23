package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CreateCharacterSceneController implements Initializable {
//Character
    @FXML
    private TextField characterNameTextField;
    @FXML
    private ComboBox<String> characterTypeComboBox;
    @FXML
    private TableView<CharacterD> characterTableView;
    @FXML
    private TableColumn<CharacterD, String> characterNameTableColumn;
    @FXML
    private TableColumn<CharacterD, String> characterTypeTableColumn;

    public ObservableList<CharacterD> charList = FXCollections.observableArrayList();
    //private static final String FILE_PATH = "characters.bin"; // Specify the file path
    private static String FILE_PATH;
    private static String CHARACTERS_TEXT_FILE_PATH;

    @FXML
    private TableView<CharacterD> characterTableView1;
    @FXML
    private TableColumn<CharacterD, String> characterNameTableColumn1;
    @FXML
    private TableColumn<CharacterD, String> characterTypeTableColumn1;

    private String desig;
    private String name;
    //private User user;
    //User scriptwriter;
    MovieProject movie;
    private String selectedMovieName;

    public void initData(String desig, String name, String selectedMovieName) {
        // Initialize other data if needed
        this.selectedMovieName = selectedMovieName;

        // Update the file path for characters.bin
        FILE_PATH = selectedMovieName + "Characters.bin";
        // Update the file path for characters.txt
        CHARACTERS_TEXT_FILE_PATH = selectedMovieName + "Characters.txt";
        // Force capitalization for "Characters"
        FILE_PATH = FILE_PATH.replace("characters", "Characters");
        CHARACTERS_TEXT_FILE_PATH = CHARACTERS_TEXT_FILE_PATH.replace("characters", "Characters");

    }

    //private static final String CHARACTERS_FILE_PATH = "characters.bin";
    //private List<Character> characters = new ArrayList<>();
    /**
     *
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //ComboBox
        String[] items = {"Protagonist", "Antagonist", "Love Interest", "Sidekick", "Comic Relief", "Mentor", "Underdog", "Supporting Character"};
        characterTypeComboBox.getItems().addAll(items);

        //connect TableColumns with Product Class
        characterNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("characterName"));
        characterTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("characterType"));
        characterNameTableColumn1.setCellValueFactory(new PropertyValueFactory<>("characterName"));
        characterTypeTableColumn1.setCellValueFactory(new PropertyValueFactory<>("characterType"));
        characterTableView.setItems(charList);
        //data to be diplayed on the TableView 'tableView' will be taken from the ObservableList "observableList"
        // Load characters from file on application startup
        loadCharactersFromFile();
        loadCharactersFromDataHolder();

    }

    private void loadCharactersFromDataHolder() {
        charList.setAll(CharacterDataHolder.getInstance().getCharacters());
    }

    public ObservableList<CharacterD> getCharList() {
        return charList;
    }

    public void setCharList(ObservableList<CharacterD> charList) {
        this.charList = charList;
        characterTableView.setItems(charList);
    }

    @FXML
    private void createCharacterButtonOnClicked(ActionEvent event) {
        String characterName = characterNameTextField.getText();
        String characterType = characterTypeComboBox.getValue();

        if (characterName.isEmpty() || characterType == null) {
            return;
        }

        CharacterD newCharacter = new CharacterD(characterName, characterType);
        addNewCharacter(newCharacter);

        characterNameTextField.clear();
        characterTypeComboBox.getSelectionModel().clearSelection();

    }

    private void saveCharactersToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(new ArrayList<>(charList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addNewCharacter(CharacterD newCharacter) {
        charList.add(newCharacter);
        CharacterDataHolder.getInstance().getCharacters().setAll(charList);
        // Save characters to both binary and text files
        saveCharactersToFile();
        saveCharactersToTextFile(newCharacter);
    }

    private void saveCharactersToTextFile(CharacterD newCharacter) {
        try (PrintWriter writer = new PrintWriter(CHARACTERS_TEXT_FILE_PATH)) {
            // Write the new character's information to the text file
            writer.println(newCharacter.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadCharactersFromFile() {
        if (FILE_PATH == null) {
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            List<CharacterD> loadedCharacters = (List<CharacterD>) ois.readObject();
            charList.setAll(loadedCharacters);
        } catch (FileNotFoundException e) {
            createDefaultCharacters();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void createDefaultCharacters() {

    }

    private void toWriteDialogueSceneButtonOnClicked(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/DialogueScene.fxml"));
        root = (Parent) (someLoader.load());
        Scene someScene = new Scene(root);

        //data passing code here
        DialogueSceneController x = someLoader.getController();
        x.setCharList(charList);
        //data passing code here
        DialogueSceneController dialogueSceneController = someLoader.getController();

        // Pass the necessary data to CraftStorySceneController
        dialogueSceneController.initData(desig, name, selectedMovieName);

        Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();
    }

    @FXML
    private void clearCharTableViewButtonOnClicked(ActionEvent event) {
        charList.clear();
        characterTableView.getItems().clear();
        clearCharacterDataFile();
    }

    private void clearCharacterDataFile() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }

    @FXML
    private void backToScriptwriterDashboardButtonOnClicked(ActionEvent event) throws IOException {

    }

    @FXML
    private void goToCharacterButtonOnClick(ActionEvent event) {
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

            //data passing code here
            DialogueSceneController dialogueSceneController = someLoader.getController();

            // Pass the necessary data to CraftStorySceneController
            dialogueSceneController.initData(desig, name, selectedMovieName);
            DialogueSceneController x = someLoader.getController();
            x.setCharList(charList);

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

            //data passing code here
            CharacterDepthSceneController characterDepthSceneController = someLoader.getController();
            // Pass the necessary data to CraftStorySceneController
            characterDepthSceneController.initData(desig, name, selectedMovieName);
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

            //data passing code here
            WriteScriptSceneController writeScriptSceneController = someLoader.getController();
            // Pass the necessary data to CraftStorySceneController
            writeScriptSceneController.initData(desig, name, selectedMovieName);
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
    private void loadCharacterButtonOnClicked(ActionEvent event) {
        // Load assigned equipment from file
        List<CharacterD> loadedCharacter = loadAssignedCharacterFromFile();

        // Display the loaded equipment in the second TableView
        characterTableView1.setItems(FXCollections.observableArrayList(loadedCharacter));
    }

    private List<CharacterD> loadAssignedCharacterFromFile() {
        List<CharacterD> loadedCharacter = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            // Read the list of assigned equipment from the file
            loadedCharacter = (List<CharacterD>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Handle the case when the file is not found
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            // Handle other exceptions
            e.printStackTrace();
        }
        return loadedCharacter;
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
