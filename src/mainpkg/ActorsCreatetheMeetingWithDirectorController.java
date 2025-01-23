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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abdur
 */
public class ActorsCreatetheMeetingWithDirectorController implements Initializable {


    @FXML
    private Label nameBar;
    @FXML
    private TextField timeField;
    @FXML
    private TextField platFormField;
    @FXML
    private DatePicker mettingDate;


    @FXML
    private ComboBox<String> meetingTypeCombo;
    private TextArea resultBar;
    private ComboBox<Integer> IdCombo;
    ProducersMettingScheduleSaving str;
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

    Meeting meet;
    ActorsCreatetheMeetingWithDirectorReadWrite obRW;
    ArrayList<Meeting> meetArray;
    ObservableList<Meeting> meetObl;
    MovieProject Movie;
    @FXML
    private TableColumn<Meeting, Integer> idCol;
    User user;

    @FXML
    private TextField IdField;
    public void initData(User us){
        user = us;
        
        obRW = new ActorsCreatetheMeetingWithDirectorReadWrite(user.getMovieName());
        meetArray = obRW.getArr();
//        arrMP = readWriteObject.getArr();
        IdField.setText(Integer.toString(user.getId()));
        nameBar.setText(user.getName());

        if(meetArray!=null){
            for(Meeting i:meetArray){
                if(i.getId()==user.getId()){
                    meetObl.add(i);
                }
            }
            tableOfMetting.setItems(meetObl);
        
        }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        meetArray = null;
        meetObl = FXCollections.observableArrayList();
        meetingTypeCombo.getItems().addAll("Online","Physical");
        /// For table View
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        meetTypeCol.setCellValueFactory(new PropertyValueFactory("meetingType"));
        platFormCol.setCellValueFactory(new PropertyValueFactory("platform"));
        meetingDateCol.setCellValueFactory(new PropertyValueFactory("schDate"));
        meetTimeCol.setCellValueFactory(new PropertyValueFactory("time"));
        idCol.setCellValueFactory(new PropertyValueFactory("id"));
        
    }    

    @FXML
    private void saveTheFileaction(ActionEvent event) throws IOException {
        
        if(meetArray==null){
            meetArray = new ArrayList();
        }
        LocalDate now = LocalDate.now();
        LocalDate meetValue = mettingDate.getValue();
        Period p = Period.between(now,meetValue);
        if((p.getDays()<=0)||(timeField.getText()==null)||(meetingTypeCombo.getValue()==null)||(platFormField.getText()==null)||(meetValue == null)){
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("Wrong Meeting Date");
            a.setHeaderText("WrongDateError");
            a.showAndWait();
            return;
        
        }

        meet = new Meeting(user.getName(),user.getId(),mettingDate.getValue(),timeField.getText(),meetingTypeCombo.getValue(),platFormField.getText());
        meetArray.add(meet);
        meetObl.clear();
        for(Meeting i :meetArray ){
            meetObl.add(i);
        
        }
        tableOfMetting.setItems(meetObl);
        obRW.writeObj(meetArray);

        
        
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("MettingPopUpForDirector.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        MettingPopUpForDirectorController c = loader.getController();
        c.initData(user.getMovieName());
        
        Stage stg = new Stage();


        stg.setScene(sc);
        stg.show();
        
    }

    @FXML
    private void backTodashAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ActorDashBoard.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ActorDashBoardController c = loader.getController();
        c.initData(user);
        
        Stage stg =(Stage)((Node)event.getSource()).getScene().getWindow();


        stg.setScene(sc);
        stg.show();
    }

    @FXML
    private void removeMeetingAction(ActionEvent event) {
        if(meetArray==null||meetObl.size()==0){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("No value Found");
            a.setHeaderText("ERROr");
            a.showAndWait();
            return;
        }
        Meeting m = tableOfMetting.getSelectionModel().getSelectedItem();
        meetArray.remove(m);
        meetObl.remove(m);
        tableOfMetting.setItems(meetObl);
        obRW.writeObj(meetArray);
        
        
    }


}
