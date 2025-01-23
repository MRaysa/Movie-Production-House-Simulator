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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
public class ActorReportSubmissionController implements Initializable {

    @FXML
    private TableView<Report> tableOfReports;
    @FXML
    private TableColumn<Report, String> nameCol;
    @FXML
    private TableColumn<Report, Integer> idCol;
    @FXML
    private TableColumn<Report, String> reportedNameCol;
    @FXML
    private TableColumn<Report, String> reportedDesigCol;
    @FXML
    private TableColumn<Report, String> reasonCol;
    @FXML
    private TextField nameField;
    @FXML
    private TextField idField;
    @FXML
    private ComboBox<Integer> reportedIndividualCol;
    @FXML
    private ComboBox<String> reasons;
    @FXML
    private Label reportedName;
    User user;
    MovieProject movie;
    ArrayList<MovieProject>arrProject;
    ArrayList<Report>arrReport;
    ObservableList<Report>oblReport;
    ActorReportSubmissionReadWrite obj;
    @FXML
    private Label desigField;
    public void initData(User us){
        user = us;
        obj = new ActorReportSubmissionReadWrite(user.getMovieName());
        arrReport = obj.getArr();
        arrProject = readWriteObject.getArr();
        for(MovieProject i:arrProject){
            if(i.getMovieName().equals(user.getMovieName())){
                movie = i;
                for(User k : movie.getCrewList()){
                    if(user.getId()!=k.getId()){
                        reportedIndividualCol.getItems().add(k.getId());
                    }
                }
            }
        
        }
        if(arrReport!=null){
            for(Report i:arrReport){
                if(i.getId()==user.getId())
                    oblReport.add(i);
            
            }
            tableOfReports.setItems(oblReport);
        
        }
        nameField.setText(user.getName());
        idField.setText(Integer.toString(user.getId()));
        
    
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        oblReport = FXCollections.observableArrayList();
        
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        idCol.setCellValueFactory(new PropertyValueFactory("id"));
        reportedNameCol.setCellValueFactory(new PropertyValueFactory("reportedName"));
        reportedDesigCol.setCellValueFactory(new PropertyValueFactory("reportedDesig"));
        reasonCol.setCellValueFactory(new PropertyValueFactory("reason"));
        //Resons
        reasons.getItems().addAll("Harassment","Sexual Harassment","Illegal Activities","Violations in Professional Settings",
                                    "Security Concerns","Disruptive Behavior","Violation of Social Norms","Bullying","Others");
    }    

    @FXML
    private void submitAction(ActionEvent event) {
        if(arrReport==null){arrReport = new ArrayList();}
        if((reportedIndividualCol.getValue()==null)||(reasons.getValue()==null)){
            Alert a = new Alert(AlertType.INFORMATION);
            a.setContentText("Please Select Data Properly");
            a.setHeaderText("DATA NOt found");
            a.showAndWait();
            return;
        
        }
        //String name, int id, String reportedName, String reportedDesig, String reason
        Report r = new Report(nameField.getText(),Integer.parseInt(idField.getText()),reportedName.getText(),desigField.getText(),reasons.getValue());
        arrReport.add(r);
        oblReport.clear();
        for(Report i:arrReport){
            if(user.getId()==i.getId()){
                oblReport.add(i);
            }
        
        }
        tableOfReports.setItems(oblReport);
        obj.writeObj(arrReport);
    }

    @FXML
    private void removeAction(ActionEvent event) {
        if((arrReport==null)||(oblReport.size()==0)){
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("No Data Available");
            a.setHeaderText("Data NOt found");
            a.showAndWait();
            return;
        }
        Report r = tableOfReports.getSelectionModel().getSelectedItem();
        arrReport.remove(r);
        oblReport.remove(r);
        tableOfReports.setItems(oblReport);
        obj.writeObj(arrReport);
        
    }

    @FXML
    private void backDashBoardAction(ActionEvent event) throws IOException {
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

    @FXML
    private void reportedIndividualIdAction(ActionEvent event) {
        if(reportedIndividualCol.getValue()==null){
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("Id not selected");
            a.setHeaderText("ID Not found");
            a.showAndWait();
            return;
        }
        for(User i : movie.getCrewList()){
            if(i.getId()==reportedIndividualCol.getValue()){
                reportedName.setText(i.getName());
                desigField.setText(i.getDesig());
                break;
            }
        }
    }
    
}
