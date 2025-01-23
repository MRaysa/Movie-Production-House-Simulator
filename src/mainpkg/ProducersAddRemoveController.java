/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import CrewMembers.Actor;
import CrewMembers.CineMatoGrapher;
import CrewMembers.Client;
import CrewMembers.Director;

import CrewMembers.ProjectManager;
import CrewMembers.ScriptWriter;
import CrewMembers.Suplier;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ProducersAddRemoveController implements Initializable {

    String movieName;
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
    private ComboBox<String> desigCombo;
    @FXML
    private TextField nameField;
    @FXML
    private TextField idField;
    @FXML
    private DatePicker doj;
    @FXML
    private TextField passField;
    int id;
    ObservableList<User> obList;
    User user;
    ArrayList<MovieProject> arrList;
    String prevname, prevdesig;
    User pro;
    IdCount count;
    MovieProject movie;

    MovieProject AfterRemoving;

    public void initData(MovieProject movie, ObservableList<User> obList) {
        this.movie = movie;
        this.pro = movie.producer;
        this.obList = obList;

        movieName = movie.getMovieName();
        tableOfCrew.setItems(obList);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        count = new IdCount();
        id = count.getId();
        idField.setText(Integer.toString(id));
        desigCombo.getItems().addAll("Director", "Project Manger", "Actor", "Actress", "CinematoGrapher","Resource Suplier",
                             "Script Writer");
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));

        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        idCol.setCellValueFactory(new PropertyValueFactory("id"));
        dojCol.setCellValueFactory(new PropertyValueFactory("DOJ"));
        desigCol.setCellValueFactory(new PropertyValueFactory("desig"));

    }

    @FXML
    private void addMemBerToProject(ActionEvent event) throws IOException {
        ArrayList<MovieProject> temp = readWriteObject.getArr();

        Period p = Period.between(LocalDate.now(),doj.getValue());
        if(p.getDays()>=0){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("The Date of joining input is Incorrect");
            a.setHeaderText("Invalid Date input");
            a.showAndWait();
            return;
        }


        if(desigCombo.getValue().equals("Actor")){
            user =  new Actor(id, nameField.getText(), desigCombo.getValue(), doj.getValue(),passField.getText(),movie.getMovieName());
        } 
        else if(desigCombo.getValue().equals("Actress")){
            user =  new Actor(id, nameField.getText(), desigCombo.getValue(), doj.getValue(),passField.getText(),movie.getMovieName());
        } 
        else if(desigCombo.getValue().equals("CinematoGrapher")){
            user =  new CineMatoGrapher(id, nameField.getText(), desigCombo.getValue(), doj.getValue(),passField.getText(),movie.getMovieName());
        } 
        else if(desigCombo.getValue().equals("Director")){
            user =  new Director(id, nameField.getText(), desigCombo.getValue(), doj.getValue(),passField.getText(),movie.getMovieName());
        } 
        else if(desigCombo.getValue().equals("Script Writer")){
            user =  new ScriptWriter(id, nameField.getText(), desigCombo.getValue(), doj.getValue(),passField.getText(),movie.getMovieName());
        } 
        else{
            user =  new Suplier(id, nameField.getText(), desigCombo.getValue(), doj.getValue(),passField.getText(),movie.getMovieName());
        } 
        System.out.println(user);
        obList.add(user);
        for (MovieProject i : temp) {

            if (i.getMovieName().equals(movie.getMovieName())) {
                i.getCrewList().add(user);
                // chnaging to new instance
                movie = i;
            }

        }
        id++;
        idField.setText(Integer.toString(id));
        count.writeId(id);

        readWriteObject.writeObj(temp);

    }

    @FXML
    private void backToDashBoard(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ProducersDashBoard.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ProducersDashBoardController cont = loader.getController();
        if (AfterRemoving != null) {
            cont.initData(AfterRemoving);
        } else {
            cont.initData(movie);
        }

        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stg.setScene(sc);
        stg.show();
    }

    @FXML
    private void removeAction(ActionEvent event) {
        ArrayList<MovieProject> temp = readWriteObject.getArr();
        System.out.println(temp);

        User user = tableOfCrew.getSelectionModel().getSelectedItem();
        obList.remove(user);
        ArrayList<User> userTemp = new ArrayList();
        for (MovieProject i : temp) {

            if (i.getMovieName().equals(movie.getMovieName())) {
                for (User j : i.getCrewList()) {
                    //avoiding that specific user
                    if (j.getId() == user.getId() && j.getName().equals(user.getName())) {
                        System.out.println("got");

                    } //adding in temporary user list
                    else {
                        userTemp.add(j);
                    }
                }
                i.addCrewList(userTemp);
                AfterRemoving = i;
            }
        }
        readWriteObject.writeObj(temp);

    }

}
