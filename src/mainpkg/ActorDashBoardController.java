/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.Button;
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
public class ActorDashBoardController implements Initializable {

    @FXML
    private Label nameField;
    @FXML
    private Label movieNameField;
    User user;
    @FXML
    private TableView<ShottingInformation> tableOfLocation;
    @FXML
    private TableColumn<ShottingInformation, LocalDate> dateCol;
    @FXML
    private TableColumn<ShottingInformation, String> locationCol;
    @FXML
    private TableColumn<ShottingInformation, String> tmeCol;
    //Variables
    ArrayList<ShottingInformation>sLArray;
    ObservableList<ShottingInformation>obArr;
    MovieProject movie;
    ShottingLocationReadWrite sLRW;
    public void initData(User us){
        user = us;
        nameField.setText(user.getName());
        movieNameField.setText("Movie Name :"+user.getMovieName());
        sLRW = new ShottingLocationReadWrite(user.getMovieName());
        
        sLArray = sLRW.getArr();
        
        if(sLArray!=null){
            for (ShottingInformation i:sLArray){
                obArr.add(i);
                
            }
            tableOfLocation.setItems(obArr);
            
        }else{return;}
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sLArray = null;
        obArr = FXCollections.observableArrayList();
        dateCol.setCellValueFactory(new PropertyValueFactory("date"));
        locationCol.setCellValueFactory(new PropertyValueFactory("location"));
        tmeCol.setCellValueFactory(new PropertyValueFactory("time"));
    }    

    @FXML
    private void signOutAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        Stage stg =(Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(scene);
        stg.show();
        
    }

    @FXML
    private void applyForAprovalAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ProducerAprovalApply.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        ProducerAprovalApplyController cont = loader.getController();
        cont.initData(user);
        Stage stg =new Stage();
        stg.setScene(scene);
        stg.show();
        
    }

    @FXML
    private void rescheduleAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ActorRescheduleShootingDate.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        ActorRescheduleShootingDateController cont = loader.getController();
        cont.initData(user);
        Stage stg =(Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(scene);
        stg.show();
        
    }

    @FXML
    private void viewMettingAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ProducerMettingColabBorativeDash.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ProducerMettingColabBorativeDashController c = loader.getController();
        c.initData(user.getMovieName());
        
        Stage stg = new Stage();


        stg.setScene(sc);
        stg.show();
    }

    @FXML
    private void setTheContractAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ActorsContractSetting.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ActorsContractSettingController c = loader.getController();
        c.initData(user);
        
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();


        stg.setScene(sc);
        stg.show();
    }

    @FXML
    private void showScriptAction(ActionEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//
//        loader.setLocation(getClass().getResource("ActorCharacterInputs.fxml"));
//        Parent r = loader.load();
//        Scene sc = new Scene(r);
//        ActorCharacterInputsController c = loader.getController();
//        c.initData(user);
//        
//        Stage stg = new Stage();
////(Stage)((Node)event.getSource()).getScene().getWindow()
//
//        stg.setScene(sc);
//        stg.show();
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ActorsScriptView.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ActorsScriptViewController c = loader.getController();
        c.initData(user);
        Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
//        Stage s = new Stage();
//

        s.setScene(sc);
        s.show();
    }

    @FXML
    private void showDialogueAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ActorViewDialogue.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ActorViewDialogueController c = loader.getController();
        c.initData(user);
        Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
//        Stage s = new Stage();
//

        s.setScene(sc);
        s.show();
    }

    @FXML
    private void showCharctersAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ActorsCharacterView.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ActorsCharacterViewController c = loader.getController();
        c.initData(user);
        
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();


        stg.setScene(sc);
        stg.show();
        
    }

    @FXML
    private void reportAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ActorReportSubmission.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ActorReportSubmissionController c = loader.getController();
        c.initData(user);
        
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();


        stg.setScene(sc);
        stg.show();
        
    }

    @FXML
    private void meetingWithDirectorAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ActorsCreatetheMeetingWithDirector.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ActorsCreatetheMeetingWithDirectorController c = loader.getController();
        c.initData(user);
        
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();


        stg.setScene(sc);
        stg.show();
        
    }

    @FXML
    private void chnagePassAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ActorsChangePassWord.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ActorsChangePassWordController c = loader.getController();
        c.initData(user);
        
        Stage stg = new Stage();


        stg.setScene(sc);
        stg.show();
    }
    
}
