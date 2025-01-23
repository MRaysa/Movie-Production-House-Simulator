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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class ShootingLocationsAndDateGrantorController implements Initializable {

    @FXML
    private TableView<ShottingInformation> tableOfShootingDates;
    @FXML
    private TableColumn<ShottingInformation, LocalDate> dateCol;
    @FXML
    private TableColumn<ShottingInformation, String> locationCol;
    @FXML
    private TableColumn<ShottingInformation, String> timeCol;
    @FXML
    private DatePicker dateField;
    @FXML
    private TextField locationField;
    @FXML
    private TextField timeField;
    //Variables
    ArrayList<ShottingInformation>sLArray;
    ObservableList<ShottingInformation>obArr;
    String movie;
    ShottingInformation shootInfo;
    ShottingLocationReadWrite sLRW;
    public void initData(String movieName){
        movie = movieName;
        sLRW = new ShottingLocationReadWrite(movie);
        
        sLArray = sLRW.getArr();
        
        if(sLArray!=null){
            for (ShottingInformation i:sLArray){
                obArr.add(i);
                
            }
            tableOfShootingDates.setItems(obArr);
            
        }
    
    }    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sLArray = null;
        obArr = FXCollections.observableArrayList();
        dateCol.setCellValueFactory(new PropertyValueFactory("date"));
        locationCol.setCellValueFactory(new PropertyValueFactory("location"));
        timeCol.setCellValueFactory(new PropertyValueFactory("time"));
    }    

    @FXML
    private void addDateLocation(ActionEvent event) {
        if(sLArray==null){
            sLArray = new ArrayList();
        }
        shootInfo = new ShottingInformation(timeField.getText(),locationField.getText(),dateField.getValue());
        sLArray.add(shootInfo);
        obArr.clear();
        for(ShottingInformation i:sLArray){
            obArr.add(i);
        }
        tableOfShootingDates.setItems(obArr);
        sLRW.writeObj(sLArray);
        
    }

    @FXML
    private void removeSelectedaction(ActionEvent event) {
        if(sLArray==null || sLArray.size()<=0){
            return;
        }
        ShottingInformation temp= tableOfShootingDates.getSelectionModel().getSelectedItem();
        obArr.remove(temp);
        sLArray.remove(temp);
        sLRW.writeObj(sLArray);
    }
    
}
