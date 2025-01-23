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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abdur
 */
public class ProducersAprovalGrantorController implements Initializable {

    @FXML
    private TableView<Aproval> tableOfAprovals;
    @FXML
    private TableColumn<Aproval, String> nameCol;
    @FXML
    private TableColumn<Aproval, String> desigCol;
    @FXML
    private TableColumn<Aproval, String> applicationCol;
    @FXML
    private TableColumn<Aproval, String> commentsCol;
    @FXML
    private TableColumn<Aproval, String> statusCol;

    ArrayList<Aproval>aprArray;
    ObservableList<Aproval>Obarr;
    AprovalReadWrite aprv;
    MovieProject mProject;
    public void iniData(MovieProject movie){
        mProject = movie;
        aprv = new AprovalReadWrite(mProject.getMovieName());
        aprArray = aprv.getArr();
        Obarr = FXCollections.observableArrayList();
        if(aprArray!=null){
            for(Aproval i:aprArray){
                Obarr.add(i);
            }
            tableOfAprovals.setItems(Obarr);
        }
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       aprArray = null;
       nameCol.setCellValueFactory(new PropertyValueFactory("name"));
       desigCol.setCellValueFactory(new PropertyValueFactory("desig"));
       applicationCol.setCellValueFactory(new PropertyValueFactory("aplicationType"));
       commentsCol.setCellValueFactory(new PropertyValueFactory("comments"));
       statusCol.setCellValueFactory(new PropertyValueFactory("status"));
        
    }    

    @FXML
    private void aprovalAction(ActionEvent event) {
        if(aprArray == null){return;}
        Aproval temp = tableOfAprovals.getSelectionModel().getSelectedItem();
        for(Aproval i :aprArray){
            if(temp==i){
                i.setStatus("Aproved");
            }
        }
        Obarr.clear();
        Obarr.addAll(aprArray);
        tableOfAprovals.setItems(Obarr);
        aprv.writeObj(aprArray);
        
        
    }

    @FXML
    private void notAprovalAction(ActionEvent event) {
        if(aprArray == null){return;}
                if(aprArray == null){return;}
        Aproval temp = tableOfAprovals.getSelectionModel().getSelectedItem();
        for(Aproval i :aprArray){
            if(temp==i){
                i.setStatus("NotAproved");
            }
        }
        Obarr.clear();
        Obarr.addAll(aprArray);
        tableOfAprovals.setItems(Obarr);
        aprv.writeObj(aprArray);
    }

    @FXML
    private void backToDashBoardAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ProducersDashBoard.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ProducersDashBoardController cont = loader.getController();
        cont.initData(mProject);

        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stg.setScene(sc);
        stg.show();
    }
    
}
