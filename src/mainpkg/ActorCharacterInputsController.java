
package mainpkg;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author abdur
 */
public class ActorCharacterInputsController implements Initializable {

    @FXML
    private TableView<Character> tableOfCharacters;
    @FXML
    private TableColumn<Character, String> nameCol;
    @FXML
    private TableColumn<Character, Integer> idCol;
    @FXML
    private TableColumn<Character, String> charCol;
    @FXML
    private ComboBox<Integer> idField;
    @FXML
    private Label nameField;
    @FXML
    private TextField charField;

    ArrayList<Character> arrChar;
    ObservableList<Character> obLChar;
    CharacterReadWrite obj;
    MovieProject movie;
    User user;
    ArrayList<MovieProject>projectArr;
    public void initData(String moviename){
//        this.user = user;
        projectArr = readWriteObject.getArr();
        obj = new CharacterReadWrite(moviename);
        arrChar = obj.getArr();
        for(MovieProject i:projectArr){
            if(i.getMovieName().equals(moviename)){
                movie = i;
                for(User j:i.getCrewList()){
                    if((j.getDesig().equals("Actor"))||(j.getDesig().equals("Actress")))
                        idField.getItems().add(j.getId());
                }
                break;
            }
        }
        if(arrChar!=null){
            for(Character i: arrChar){
               obLChar.add(i);
            
            }
            tableOfCharacters.setItems(obLChar);
            
        
        }
    
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        obLChar = FXCollections.observableArrayList();
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        idCol.setCellValueFactory(new PropertyValueFactory("id"));
        charCol.setCellValueFactory(new PropertyValueFactory("character"));

    }    

    @FXML
    private void idFieldAction(ActionEvent event) {
        for(User i:movie.getCrewList()){
            if(i.getId()==idField.getValue()){
                nameField.setText(i.getName());
            }
        
        }
        
    }

    @FXML
    private void removeSelectedCharAction(ActionEvent event) {
        if(arrChar==null){
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("List Is Empty");
            a.setHeaderText("Error");
            a.showAndWait();
            return;
        }
        Character newChar = tableOfCharacters.getSelectionModel().getSelectedItem();
        arrChar.remove(newChar);
        
        obLChar.remove(newChar);
        tableOfCharacters.setItems(obLChar);
        obj.writeObj(arrChar);

    }

    @FXML
    private void addCharAction(ActionEvent event) {
        Character newChar;
        if(arrChar==null){arrChar = new ArrayList();}
        if((charField.getText().equals(""))||(charField.getText()==null)){
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("Char Field Is Empty");
            a.setHeaderText("Char Field Null Error");
            a.showAndWait();
            return;
        }
        newChar= new Character(nameField.getText(),idField.getValue(),charField.getText()); 
        arrChar.add(newChar);
        obLChar.clear();
        obLChar.addAll(arrChar);
        tableOfCharacters.setItems(obLChar);
        obj.writeObj(arrChar);
        
    }

    
}
