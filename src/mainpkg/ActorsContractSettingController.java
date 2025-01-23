/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
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
public class ActorsContractSettingController implements Initializable {

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
    @FXML
    private TextField IdField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField desigField;
    @FXML
    private DatePicker startingDate;
    @FXML
    private DatePicker endIngDate;
    User user;
    ArrayList<Contract>arrCon;
    ObservableList<Contract>obLCon;
    ActorsContractSettingReadWrite obj;
    public void initData(User u){
       user = u;
       IdField.setText(Integer.toString(u.getId())); 
       nameField.setText(user.getName()); 
       desigField.setText(user.getDesig());
       startingDate.setValue(user.getDOJ());
       obj = new ActorsContractSettingReadWrite(user.getMovieName());
       arrCon = obj.getArr();
       if(arrCon!=null){
           for(Contract i:arrCon){
               
               if(i.getId()==user.getId()){
                 obLCon.add(i);
                 tableOfContract.setItems(obLCon);

                   
               }
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
    @FXML
    private void addAction(ActionEvent event) {
        if(arrCon!=null){
           for(Contract i:arrCon){
               
               if(i.getId()==user.getId()){

                 Alert a = new Alert(AlertType.INFORMATION);
                 a.setContentText("You All ready decleared");
                 a.setHeaderText("Information");
                 a.showAndWait();
                 return;
                   
               }
            }
        }
        if(arrCon==null){arrCon = new ArrayList();}
        Period p = Period.between(startingDate.getValue(),endIngDate.getValue());
        if((p.getDays()<=0)){
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText(" Date is Selection is Wrong ");
            a.setHeaderText("Date error");
            a.showAndWait();
            return;
        
        }
        
        Contract newCont = new Contract(nameField.getText(),Integer.parseInt(IdField.getText()), desigField.getText(),startingDate.getValue(),endIngDate.getValue());
        arrCon.add(newCont);
        obLCon.clear();
        for(Contract i:arrCon){
            if(i.getId()==user.getId()){
                obLCon.add(i);}
        }
        tableOfContract.setItems(obLCon);
        obj.writeObj(arrCon);
        

   }

    @FXML
    private void removeAction(ActionEvent event) {
        if(arrCon==null||obLCon.size()==0){
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText(" No Data Available ");
            a.setHeaderText("NODataError");
            a.showAndWait();
            return;
        }
        Contract temp =  tableOfContract.getSelectionModel().getSelectedItem();
        arrCon.remove(temp);
        obLCon.remove(temp);
        tableOfContract.setItems(obLCon);
        obj.writeObj(arrCon);
    }
    

    @FXML
    private void backToDashBoardAction(ActionEvent event) throws IOException {
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
