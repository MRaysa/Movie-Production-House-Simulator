package mainpkg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DialogueSceneController implements Initializable {

    public ObservableList<CharacterD> charList;
    private String DIALOGUE_FILE_PATH = "dialogues.txt"; // Specify the file path

    private Map<CharacterD, List<Dialogue>> dialogueMap;

    @FXML
    private ComboBox<String> characterComboBox;
    @FXML
    private TextArea dialogueTextArea;
    @FXML
    private TableView<Dialogue> showDialogueTableView;
    @FXML
    private TableColumn<Dialogue, String> characterNameTableColumn;
    @FXML
    private TableColumn<Dialogue, String> characterDialogueTableColumn;

    MovieProject movie;
    String desig;
    String name;
    String selectedMovieName;

    void initData(String desig, String name, String movieName) {
        this.desig = desig;
        this.name = name;
        this.selectedMovieName = movieName;
        // Update the dialogue file path based on the selected movie name
        updateDialogueFilePath(selectedMovieName);
    }

    //CONSTRUCTOR
    public DialogueSceneController() {
        // Initialize dialogueMap with an empty HashMap
        this.dialogueMap = new HashMap<>();
        // Set the initial dialogue file path

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Clear the existing data
        dialogueMap.clear();
        // Load dialogues from file

        // Populate characterComboBox with character names
        updateComboBox();

        // Update TableView with the loaded dialogues
        updateShowDialogueTableView();
        updateDialogueFilePath(selectedMovieName);
    }

    public ObservableList<CharacterD> getCharList() {
        return charList;
    }

    public void setCharList(ObservableList<CharacterD> charList) {
        this.charList = charList;
    }
    // Method to update the dialogue file path when the movie name is known

    public void updateDialogueFilePath(String movieName) {
        this.DIALOGUE_FILE_PATH = String.format("%sDialogues.txt", movieName);
    }

    @FXML
    private void writeDialogueButtonOnClicked(ActionEvent event) {
        String selectedCharacterName = characterComboBox.getValue();
        String dialogueText = dialogueTextArea.getText();

        if (selectedCharacterName == null || dialogueText.isEmpty()) {
            // Handle the case where input is incomplete
            // You might want to show an error message
            return;
        }

        // Find the corresponding character instance
        CharacterD selectedCharacter = getCharacterByName(selectedCharacterName);

        if (selectedCharacter != null) {
            // Clear existing dialogues for the selected character
            dialogueMap.remove(selectedCharacter);

            // Create a new Dialogue instance and add it to the dialogueMap
            Dialogue newDialogue = new Dialogue(selectedCharacter, dialogueText);
            addDialogueToMap(selectedCharacter, newDialogue);
            updateShowDialogueTableView();
            // Clear input fields after adding the dialogue
            dialogueTextArea.clear();

            // Save dialogues to file after adding a new dialogue
            saveDialoguesToTextFile();
        }
    }

    private void addDialogueToMap(CharacterD character, Dialogue dialogue) {
        // Check if the character already has dialogues
        if (dialogueMap.containsKey(character)) {
            dialogueMap.get(character).add(dialogue);
        } else {
            // Create a new list for the character's dialogues
            List<Dialogue> dialogues = new ArrayList<Dialogue>();
            dialogues.add(dialogue);
            dialogueMap.put(character, dialogues);
        }
    }

    private CharacterD getCharacterByName(String characterName) {
        for (CharacterD character : CharacterDataHolder.getInstance().getCharacters()) {
            if (character.getCharacterName().equals(characterName)) {
                return character;
            }
        }
        return null;
    }

    private void saveDialoguesToTextFile() {
        try {
            // Create a File object representing the destination file using the instance variable
            File file = new File(DIALOGUE_FILE_PATH);

            // Save the dialogues to the file
            try (PrintWriter writer = new PrintWriter(file)) {
                for (Map.Entry<CharacterD, List<Dialogue>> entry : dialogueMap.entrySet()) {
                    CharacterD character = entry.getKey();
                    for (Dialogue dialogue : entry.getValue()) {
                        String line = character.getCharacterName() + "\t" + dialogue.getDialogue();
                        writer.println(line);
                    }
                }
            }

            // Show a success message using an Alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Dialogues saved successfully!");
            alert.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions appropriately

            // Show an error message using an Alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error saving the dialogues.");
            alert.showAndWait();
        }
    }

    private void loadDialoguesFromTextFile() {
        // Clear the existing dialogues
        dialogueMap.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(selectedMovieName+DIALOGUE_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t"); // Assuming tab as the delimiter, adjust as needed
                if (parts.length == 2) {
                    String characterName = parts[0];
                    String dialogueText = parts[1];

                    CharacterD character = getCharacterByName(characterName);
                    if (character != null) {
                        Dialogue dialogue = new Dialogue(character, dialogueText);
                        addDialogueToMap(character, dialogue);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception according to your application's needs
        }
    }

    private void updateComboBox() {
        ObservableList<String> characterNames = FXCollections.observableArrayList();
        for (CharacterD character : CharacterDataHolder.getInstance().getCharacters()) {
            characterNames.add(character.getCharacterName());
        }
        characterComboBox.setItems(characterNames);
    }

    private void updateShowDialogueTableView() {
        // Clear the existing items in the TableView
        showDialogueTableView.getItems().clear();

        // Set up the TableView columns
        characterNameTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCharacter().getCharacterName()));
        characterDialogueTableColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDialogue()));

        // Populate the TableView
        showDialogueTableView.setItems(getAllDialogues());
    }

    private ObservableList<Dialogue> getAllDialogues() {
        List<Dialogue> allDialogues = new ArrayList<>();
        for (List<Dialogue> dialogues : dialogueMap.values()) {
            allDialogues.addAll(dialogues);
        }
        return FXCollections.observableArrayList(allDialogues);
    }

    @FXML
    private void backToScriptwritertDashboardButtonOnClicked(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/ScriptwriterDashboardScene.fxml"));
        root = (Parent) (someLoader.load());
        Scene someScene = new Scene(root);

        ScriptwriterDashboardSceneController scriptwriterDashboardSceneController = someLoader.getController();

        // Pass the necessary data to CraftStorySceneController
        scriptwriterDashboardSceneController.initData(desig, name, selectedMovieName);

        //data passing code here
        Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();

    }

    @FXML
    private void toCreateCharacterSceneButtonOnClicked(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/Character/CreateCharacterScene.fxml"));
        root = (Parent) (someLoader.load());
        Scene someScene = new Scene(root);

        //data passing code here
        CreateCharacterSceneController x = someLoader.getController();
        x.setCharList(charList);

        Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();
    }

    @FXML
    private void clearDialogueButtonOnClicked(ActionEvent event) {
        // Clear the dialogues in the dialogueMap
        dialogueMap.clear();

        // Save the empty dialogueMap to the file
        saveDialoguesToTextFile();

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
            // data passing code here
            CreateCharacterSceneController x = someLoader.getController();
            x.setCharList(charList);

            // Set the current charList in CharacterDataHolder before switching scenes
            CharacterDataHolder.getInstance().getCharacters().setAll(charList);
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

            // Data passing code here
            //DialogueSceneController x = someLoader.getController();
            //x.setCharList(charList);
            // Get the current stage
            
            Stage currentStage = (Stage) menuItem.getParentPopup().getOwnerWindow();
            CharacterDepthSceneController characterDepthScenecontroller = someLoader.getController ();
            characterDepthScenecontroller.initData(desig, name, selectedMovieName);
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
