/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author abdur
 */
public class MettingPopUpForDirectorController implements Initializable {

    private TextArea resultBar;


    @FXML
    private TableView<Meeting> tableOfMetting;
    @FXML
    private TableColumn<Meeting, String> nameCol;
    @FXML
    private TableColumn<Meeting, String> meetTypeCol;
    @FXML
    private TableColumn<Meeting, String> platFormCol;

    @FXML
    private TableColumn<Meeting, LocalDate> meetingDateCol;
    @FXML
    private TableColumn<Meeting, String> meetTimeCol;
    ActorsCreatetheMeetingWithDirectorReadWrite obRW;
    ArrayList<Meeting> meetArray;
    ObservableList<Meeting> meetObl;
    @FXML
    private TableColumn<Meeting, Integer> idCol;
    public void initData(String movie){
        obRW = new ActorsCreatetheMeetingWithDirectorReadWrite(movie);
        meetArray = obRW.getArr();

        System.out.println(meetArray);
        if(meetArray!=null){
            for(Meeting i:meetArray){
                meetObl.add(i);
            }
            tableOfMetting.setItems(meetObl);
        
        }
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        meetObl = FXCollections.observableArrayList();
        //Setting The Table
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        meetTypeCol.setCellValueFactory(new PropertyValueFactory("meetingType"));
        platFormCol.setCellValueFactory(new PropertyValueFactory("platform"));
        meetingDateCol.setCellValueFactory(new PropertyValueFactory("schDate"));
        meetTimeCol.setCellValueFactory(new PropertyValueFactory("time"));
        idCol.setCellValueFactory(new PropertyValueFactory("id"));
    }      
    
}
