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
public class ContractViewController implements Initializable {

    @FXML
    private TableView<Contract> tableOfContract;
    @FXML
    private TableColumn<Contract, String> nameCol;
    @FXML
    private TableColumn<Contract, Integer> idCol;
    @FXML
    private TableColumn<Contract, LocalDate> startCol;
    @FXML
    private TableColumn<Contract, LocalDate> endCol;

    User user;
    ArrayList<Contract>arrCon;
    ObservableList<Contract>obLCon;
    ActorsContractSettingReadWrite obj;
    public void initData(String moviename){
   

       obj = new ActorsContractSettingReadWrite(moviename);
       arrCon = obj.getArr();
       if(arrCon!=null){
           for(Contract i:arrCon){
               
               
                 obLCon.add(i);
                 tableOfContract.setItems(obLCon);

                   
               }           
       
       }
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        obLCon = FXCollections.observableArrayList();

        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        idCol.setCellValueFactory(new PropertyValueFactory("id"));
        startCol.setCellValueFactory(new PropertyValueFactory("startDate"));
        endCol.setCellValueFactory(new PropertyValueFactory("endDate"));
    }     
    
}
