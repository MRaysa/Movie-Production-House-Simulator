/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abdur
 */
public class ActorsCharacterViewController implements Initializable {

    @FXML
    private TableView<Character> tableOfCharacters;
    @FXML
    private TableColumn<Character, String> nameCol;
    @FXML
    private TableColumn<Character, Integer> idCol;
    @FXML
    private TableColumn<Character, String> charCol;




    ArrayList<Character> arrChar;
    ObservableList<Character> obLChar;
    CharacterReadWrite obj;
    MovieProject movie;
    User user;
    ArrayList<MovieProject>projectArr;
    public void initData(User user){
        this.user = user;

        obj = new CharacterReadWrite(user.getMovieName());
        arrChar = obj.getArr();

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
    private void backtoDashBoardAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ActorDashBoard.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ActorDashBoardController c = loader.getController();
        c.initData(user);
        
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();


        stg.setScene(sc);
        stg.show();
        
    }
    
}
