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
import javafx.scene.control.ComboBox;
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
public class ProducersCompletedMovieAddingController implements Initializable {

    @FXML
    private TableView<MovieCompleted> tableOfData;
    @FXML
    private TableColumn<MovieCompleted, String> movieNameCol;
    @FXML
    private TableColumn<MovieCompleted, String> movieTypeCol;
    @FXML
    private TableColumn<MovieCompleted, String> proCol;
    @FXML
    private TableColumn<MovieCompleted, String> actorCol;
    @FXML
    private TableColumn<MovieCompleted, String> actressCol;
    @FXML
    private ComboBox<Integer> actorIdCombo;
    @FXML
    private ComboBox<Integer> actressIdCombo;
    @FXML
    private Label actorName;
    @FXML
    private Label actressName;
    MovieProject movie;
    ArrayList<User> arr ;
    ObservableList<MovieCompleted>addDataObList;
    ArrayList<MovieCompleted>dataArrayList;
    MovieCompleted comMovie;
    public void initData(MovieProject movie){
        dataArrayList=ProducersCompletedMovieAddingDataBase.getArr();
        this.movie = movie;
        System.out.println(this.movie.getCrewList());
        for(User i : this.movie.getCrewList()){
            if(i.getDesig().equals("Actor")||i.getDesig().equals("Actress")){
                arr.add(i);
                if(i.getDesig().equals("Actor")){
                    actorIdCombo.getItems().add(i.getId());}
                if(i.getDesig().equals("Actress")){
                    actressIdCombo.getItems().add(i.getId());}
            }
        }
        System.out.println(arr);
        if(dataArrayList!=null){
            for(MovieCompleted i :dataArrayList){
                if(i.getMoviName().equals(this.movie.getMovieName())&&i.getMovieType().equals(this.movie.getMovieType())){
                    addDataObList.add(i);
                    comMovie=i;
                }
            }
            
            tableOfData.setItems(addDataObList);
        }
        
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//            String moviName ,movieType,aproval;
//    String producerName,actorName,actressName;
        comMovie=null;
        movieNameCol.setCellValueFactory(new PropertyValueFactory("moviName"));
        movieTypeCol.setCellValueFactory(new PropertyValueFactory("movieType"));
        proCol.setCellValueFactory(new PropertyValueFactory("producerName"));
        actorCol.setCellValueFactory(new PropertyValueFactory("actorName"));
        actressCol.setCellValueFactory(new PropertyValueFactory("actressName"));
        dataArrayList=null;
        
        addDataObList = FXCollections.observableArrayList();
        arr = new ArrayList();
    }    

    @FXML
    private void addToMovieProductionHouseAction(ActionEvent event) {
        
        if(comMovie==null && dataArrayList==null){
            dataArrayList = new ArrayList();
            comMovie = new MovieCompleted(movie.getMovieName(),movie.getMovieType(),movie.getProducer().getName(),
                        actorName.getText(),actressName.getText());
            
            addDataObList.add(comMovie);
            dataArrayList.add(comMovie);
            ProducersCompletedMovieAddingDataBase.writeObj(dataArrayList);
            tableOfData.setItems(addDataObList);
            
        
        }else{
            return;
        }
        
        
    }

    @FXML
    private void actorIdAction(ActionEvent event) {
        if(arr==null){
            return ;
        }
        System.out.println(arr);
        for(User i : arr){
            if(actorIdCombo.getValue()==i.getId() && i.getDesig().equals("Actor")){
                actorName.setText(i.getName());
            }
        } 
    }

    @FXML
    private void actressIdAction(ActionEvent event) {
        if(arr==null){
            return ;
        }
//        System.out.println(arr);
        for(User i : arr){
            if(actressIdCombo.getValue()==i.getId()&& i.getDesig().equals("Actress")){
                
                actressName.setText(i.getName());
                System.out.println(i.getName());
            }
        }
    }

    @FXML
    private void backToDashBoardAction(ActionEvent event) throws IOException {
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
