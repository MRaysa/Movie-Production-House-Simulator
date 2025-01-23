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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abdur
 */
public class ProducersReportCheckingController implements Initializable {
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

    ArrayList<Report>arrReport;
    ObservableList<Report>oblReport;
    ActorReportSubmissionReadWrite obj;
    MovieProject movie;
    @FXML

    public void initData(MovieProject m){
        movie = m;

        obj = new ActorReportSubmissionReadWrite(m.getMovieName());
        arrReport = obj.getArr();

        if(arrReport!=null){
            for(Report i:arrReport){
                oblReport.add(i);
            
            }
            tableOfReports.setItems(oblReport);
        
        }

        
    
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        oblReport = FXCollections.observableArrayList();
        
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        idCol.setCellValueFactory(new PropertyValueFactory("id"));
        reportedNameCol.setCellValueFactory(new PropertyValueFactory("reportedName"));
        reportedDesigCol.setCellValueFactory(new PropertyValueFactory("reportedDesig"));
        reasonCol.setCellValueFactory(new PropertyValueFactory("reason"));
    }    

    @FXML
    private void backDashBoardAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ProducersDashBoard.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ProducersDashBoardController cont = loader.getController();
        cont.initData(movie);

        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stg.setScene(sc);
        stg.show();
    }
    
}
