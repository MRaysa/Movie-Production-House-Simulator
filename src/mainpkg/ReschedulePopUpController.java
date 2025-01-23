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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author abdur
 */
public class ReschedulePopUpController implements Initializable {

    @FXML
    private TableView<Reschedule> tableForReschedule;
    @FXML
    private TableColumn<Reschedule, String> nameCol;

    @FXML
    private TableColumn<Reschedule, LocalDate> olddateCol;
    @FXML
    private TableColumn<Reschedule, LocalDate> newDateCol;
    @FXML
    private TableColumn<Reschedule, String> commentsCol;


    ActorRescheduleShootingDateReadWrite rw;
    ArrayList<Reschedule>arrRSch;

    
    ObservableList<Reschedule>obRSch;
    


    public void initData(String movieName){
        

        rw = new ActorRescheduleShootingDateReadWrite(movieName);
        
        
        arrRSch = rw.getArr();

        if(arrRSch!=null){
            for(Reschedule i:arrRSch){
                obRSch.add(i);
            }
            tableForReschedule.setItems(obRSch);
        }
       
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        obRSch= FXCollections.observableArrayList();

        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        
        olddateCol.setCellValueFactory(new PropertyValueFactory("oldDate"));
        newDateCol.setCellValueFactory(new PropertyValueFactory("newDate"));
        commentsCol.setCellValueFactory(new PropertyValueFactory("comments"));
    }    
   
    
}
