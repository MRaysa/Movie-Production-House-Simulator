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
import javafx.scene.control.ComboBox;
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
public class ActorRescheduleShootingDateController implements Initializable {

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
    @FXML
    private TextField nameField;
    @FXML
    private TextField idField;
    @FXML
    private TextField desigField;
    private DatePicker oldDate;
    @FXML
    private DatePicker newDate;
    @FXML
    private TextField descripField;
    User user;
    ActorRescheduleShootingDateReadWrite rw;
    ArrayList<Reschedule>arrRSch;
    ArrayList<ShottingInformation>arrSInfo;
    
    ObservableList<Reschedule>obRSch;
    ShottingLocationReadWrite oldRw;
    Reschedule reSch;
    @FXML
    private ComboBox<LocalDate> oldDateCombo;
    public void initData(User user){
        this.user = user;
        nameField.setText(user.getName());
        idField.setText(Integer.toString(this.user.getId()));
        desigField.setText(user.getDesig());
        rw = new ActorRescheduleShootingDateReadWrite(user.getMovieName());
        oldRw=new ShottingLocationReadWrite(user.getMovieName());
        arrSInfo =oldRw.getArr();
        arrRSch = rw.getArr();
        if(arrSInfo!=null){
            for(ShottingInformation i: arrSInfo){
                oldDateCombo.getItems().add(i.getDate());
                
            }
        }else{
            Alert a = new Alert(AlertType.ERROR);
            a.setTitle("No old date Available");
            a.setHeaderText("ERROR");
            a.showAndWait();
            return;
        }
        if(arrRSch!=null){
            for(Reschedule i:arrRSch){
                if((i.getId()==user.getId())){
                    obRSch.add(i);
                    
                }
            }
            tableForReschedule.setItems(obRSch);
        }
       
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        obRSch= FXCollections.observableArrayList();
        arrRSch=null;
        arrSInfo=null;
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        
        olddateCol.setCellValueFactory(new PropertyValueFactory("oldDate"));
        newDateCol.setCellValueFactory(new PropertyValueFactory("newDate"));
        commentsCol.setCellValueFactory(new PropertyValueFactory("comments"));
    }    

    @FXML
    private void addDateAction(ActionEvent event) {
        if(arrRSch==null){arrRSch = new ArrayList();}
        if((newDate.getValue().equals(oldDateCombo.getValue()))){
            Alert a = new Alert(AlertType.ERROR);
            
            a.setContentText("Chosing the same Date Same Date ERROR");
            a.setHeaderText("Same Date");
            a.showAndWait();
            return;
        
        }
        
        Period p = Period.between(oldDateCombo.getValue(),newDate.getValue());
        if(p.getDays()<=0){
            Alert a = new Alert(AlertType.ERROR);
            a.setHeaderText("Date Error");
            a.setContentText("Your Date input is Wrong");
            a.showAndWait();
            return;
        }
        for(LocalDate i:oldDateCombo.getItems()){
            if(newDate.getValue().equals(i)){
                Alert a = new Alert(AlertType.ERROR);
                a.setContentText("Your Date is conflicting with another Date");
                a.setHeaderText("Conflicting Error");
                a.showAndWait();
                return;
            
            
            }
        
        }

        reSch = new Reschedule(Integer.parseInt(idField.getText()),nameField.getText(),descripField.getText(),oldDateCombo.getValue(),newDate.getValue());
        
        arrRSch.add(reSch);
        obRSch.clear();
        for(Reschedule i:arrRSch){
            if((i.getId()==user.getId())&&(user.getName().equals(i.getName()))){
                obRSch.add(i);
            
            }
        
        }
        tableForReschedule.setItems(obRSch);
        rw.writeObj(arrRSch);
    }

    @FXML
    private void removeDateAction(ActionEvent event) {
        if(arrRSch==null || obRSch.size()==0){
            Alert a = new Alert(AlertType.INFORMATION);
            a.setTitle("No date Available");
            a.setHeaderText("INFORMATION");
            a.showAndWait();
            return;
            
        }
        Reschedule temp =  tableForReschedule.getSelectionModel().getSelectedItem();
        
        arrRSch.remove(temp);
        obRSch.remove(temp);
        rw.writeObj(arrRSch);
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
