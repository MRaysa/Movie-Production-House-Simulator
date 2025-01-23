/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author abdur
 */
public class ProducerAprovalApplyController implements Initializable {

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
    @FXML
    private TextField nameField;
    @FXML
    private TextField commentField;
    @FXML
    private ComboBox<String> applicaTionTypeCombo;
    private ComboBox<String> desigCombo;
    /// Arraylist
    ArrayList<Aproval>aprvArray;
    Aproval aprv;
    String movie;
    AprovalReadWrite appRw;
    ObservableList<Aproval>obAprv;

    MovieProject mProject;
    @FXML
    private TextField desigField;
    User user;
    @FXML
    private TextField idField;
    public void initData(User user){
        this.user = user;
        movie =user.getMovieName();

        idField.setText(Integer.toString(this.user.getId()));
        desigField.setText(this.user.getDesig());
        nameField.setText(this.user.getName());
//        for (MovieProject i:arr){
//            if(i.getMovieName().equals(movie)){
//                for(User j : i.getCrewList()){
//                    idField.setText(Integer.toString(j.getId()));
//                    desigField.setText(j.getDesig());
//                    mProject = i;
//                }
//            
//            }
//        }

        appRw = new AprovalReadWrite(movie);
        
        aprvArray = appRw.getArr();
        System.out.println(aprvArray);
        if(aprvArray!=null){
            for (Aproval i:aprvArray ){
                obAprv.add(i);
                
            }
            tableOfAprovals.setItems(obAprv);
            
        }
    
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       obAprv = FXCollections.observableArrayList();
       aprvArray = null;


       applicaTionTypeCombo.getItems().addAll("ApplyForLeave","BudgetIncrement","AddCrew"
                                                ,"ChangeMeetingSchedule","MettingApproval","Deal Cancelation");
       nameCol.setCellValueFactory(new PropertyValueFactory("name"));
       desigCol.setCellValueFactory(new PropertyValueFactory("desig"));
       applicationCol.setCellValueFactory(new PropertyValueFactory("aplicationType"));
       commentsCol.setCellValueFactory(new PropertyValueFactory("comments"));
       statusCol.setCellValueFactory(new PropertyValueFactory("status"));
    }
    @FXML
    private void addaprovalAction(ActionEvent event) {

        if(aprvArray==null){
            aprvArray=  new ArrayList();
        }
        aprv = new Aproval(nameField.getText(),desigField.getText(),commentField.getText(),
                            applicaTionTypeCombo.getValue());
        System.out.println(aprv);
        aprvArray.add(aprv);
        obAprv.add(aprv);
        tableOfAprovals.setItems(obAprv);
        appRw.writeObj(aprvArray);
    }



    @FXML
    private void RemoveAprovalAction(ActionEvent event) {
        if((aprvArray==null)||(aprvArray.size()==0)){
            return;
        }
        Aproval temp = tableOfAprovals.getSelectionModel().getSelectedItem();
        if((temp.getName().equals(user.getName())) && (temp.getDesig().equals(user.getDesig()))){
            aprvArray.remove(temp);
            obAprv.remove(temp);
            tableOfAprovals.setItems(obAprv);
            appRw.writeObj(aprvArray);
        }else{return;}
        
    }
            

    
}
