
package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abdur
 */
public class ProducersDashBoardController implements Initializable {

    @FXML
    private TableView<User> tableOfCrew;
    @FXML
    private TableColumn<User, String> nameCol;
    @FXML
    private TableColumn<User, Integer> idCol;
    @FXML
    private TableColumn<User, String> desigCol;
    @FXML
    private TableColumn<User, LocalDate> dojCol;
    @FXML
    private TextField headerName;
    String MovieName;
    String desig;
    String name;
    @FXML
    private Label welcomerField;
    ObservableList<User> userList;
    ArrayList<MovieProject> arr;
    User producer;
    MovieProject movie;
    public void initData(MovieProject movie){
        //Passing data from loginpage to the producres dashBoard
        this.movie = movie;
        producer = movie.producer;
        MovieName = movie.getMovieName();
        this.desig = producer.getDesig();
        this.name = producer.getName();
        headerName.setText("Project name : "+MovieName);
        welcomerField.setText("Welcome "+this.desig+" : "+this.name);
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userList =  FXCollections.observableArrayList();
        arr = new ArrayList();
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        idCol.setCellValueFactory(new PropertyValueFactory("id"));
        desigCol.setCellValueFactory(new PropertyValueFactory("desig"));
        dojCol.setCellValueFactory(new PropertyValueFactory("DOJ"));
    }
    public void readObject(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        MovieProject us = null;

        try {

            File f= new File("Projects.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            while (true) {
                us = (MovieProject) ois.readObject();
                arr.add(us);

            }

        } catch (Exception ex) {}
    }

    @FXML
    private void loaddashBoardAction(ActionEvent event) {
        if (userList.size()==0){

            welcomerField.setText(movie.getMovieName());
            userList.addAll(movie.getCrewList());
            tableOfCrew.setItems(userList);
        }
        else{
            tableOfCrew.setItems(userList);
        }
        
        
    }

    @FXML
    private void addRemoveCrewAction(ActionEvent event) throws IOException {
        this.readObject();

        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ProducersAddRemove.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ProducersAddRemoveController cont = loader.getController();
        cont.initData(movie,userList);

        Stage stg =(Stage)((Node)event.getSource()).getScene().getWindow();


        stg.setScene(sc);
        stg.show();
        
        
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
    private void setBudgetAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ProducerBudgetManagement.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ProducerBudgetManagementController c = loader.getController();
        c.initData(movie);

        Stage stg =(Stage)((Node)event.getSource()).getScene().getWindow();


        stg.setScene(sc);
        stg.show();
        
    }

    @FXML
    private void fixMettingAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ProducerMettingSchedule.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ProducerMettingScheduleController c = loader.getController();
        c.initData(movie);

        Stage stg =(Stage)((Node)event.getSource()).getScene().getWindow();


        stg.setScene(sc);
        stg.show();
        
    }

    @FXML
    private void addCompletedMovie(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ProducersCompletedMovieAdding.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ProducersCompletedMovieAddingController c = loader.getController();
        c.initData(movie);

        Stage stg =(Stage)((Node)event.getSource()).getScene().getWindow();


        stg.setScene(sc);
        stg.show();
    }

    @FXML
    private void showScriptAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ProducerViewScript.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ProducerViewScriptController c = loader.getController();
        c.initData(movie);

        Stage stg =(Stage)((Node)event.getSource()).getScene().getWindow();


        stg.setScene(sc);
        stg.show();
    }

    @FXML
    private void showAprovalAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ProducerAprovalApply.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ProducerAprovalApplyController c = loader.getController();
        c.initData(movie.getProducer());

        Stage stg =new Stage();


        stg.setScene(sc);
        stg.show();
        
    }

    @FXML
    private void aprovalGrantAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ProducersAprovalGrantor.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ProducersAprovalGrantorController c = loader.getController();
        c.iniData(movie);

        Stage stg =(Stage)((Node)event.getSource()).getScene().getWindow();


        stg.setScene(sc);
        stg.show();
        
    }

    @FXML
    private void spendsShowaction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ProducerSpendOfProject.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ProducerSpendOfProjectController c = loader.getController();
        c.initData(movie.getMovieName());

        Stage stg =new Stage();


        stg.setScene(sc);
        stg.show();
        
    }

    @FXML
    private void viewCHartAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ProducerSpendsChartView.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ProducerSpendsChartViewController c = loader.getController();
        c.initData(movie);

        Stage stg =new Stage();


        stg.setScene(sc);
        stg.show();
    }

    @FXML
    private void pieCharTAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ProducerSpendsPieChartView.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ProducerSpendsPieChartViewController c = loader.getController();
        c.initData(movie);

        Stage stg =new Stage();


        stg.setScene(sc);
        stg.show();
        
    }

    @FXML
    private void addLocationAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ShootingLocationsAndDateGrantor.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ShootingLocationsAndDateGrantorController c = loader.getController();
        c.initData(movie.getMovieName());

        Stage stg =new Stage();


        stg.setScene(sc);
        stg.show();
        
    }

    @FXML
    private void viewLocationAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ProducersDateLocationViewer.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ProducersDateLocationViewerController c = loader.getController();
        c.initData(movie);

        Stage stg =(Stage) ((Node) event.getSource()).getScene().getWindow();


        stg.setScene(sc);
        stg.show();
    }

    @FXML
    private void changePassAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ProducersPassWordChanging.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ProducersPassWordChangingController c = loader.getController();
        c.initData(movie);

        Stage stg =new Stage();


        stg.setScene(sc);
        stg.show();
    }

    @FXML
    private void reportCheckingAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ProducersReportChecking.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ProducersReportCheckingController cont = loader.getController();
        cont.initData(movie);

        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stg.setScene(sc);
        stg.show();
    }

    @FXML
    private void viewContractAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ContractView.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ContractViewController cont = loader.getController();
        cont.initData(movie.getMovieName());

        Stage stg = new Stage();

        stg.setScene(sc);
        stg.show();
        
    }

    @FXML
    private void viewCharacterAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ProducerCharracterView.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ProducerCharracterViewController cont = loader.getController();
        cont.initData(movie);

        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stg.setScene(sc);
        stg.show();
        
    }

    @FXML
    private void viewRescheduledDates(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ReschedulePopUp.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ReschedulePopUpController cont = loader.getController();
        cont.initData(movie.getMovieName());

        Stage stg = new Stage();

        stg.setScene(sc);
        stg.show();
    }
    
}
