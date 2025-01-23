/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.*;
import java.net.URL;
import java.util.*;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;


public class User_5_ProjectBookingController implements Initializable {

    @FXML
    private ComboBox<String> selectGenreComboBox;
    @FXML
    private TableColumn<MovieCompleted, String> movieNameTableCollum;
    @FXML
    private TableColumn<MovieCompleted, String> produccerNameCollum;
    @FXML
    private TableColumn<MovieCompleted, String> movieGenreTableCollum;
    @FXML
    private TableView<MovieCompleted> movieShocaseTableView;

    private ObservableList<MovieCompleted> movieList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        movieList = FXCollections.observableArrayList();
        readDataFromBinFile();
        populateGenresComboBox();

        movieNameTableCollum.setCellValueFactory(new PropertyValueFactory<>("moviName"));
        produccerNameCollum.setCellValueFactory(new PropertyValueFactory<>("producerName"));
        movieGenreTableCollum.setCellValueFactory(new PropertyValueFactory<>("movieType"));



        movieShocaseTableView.setItems(movieList);

        selectGenreComboBox.setOnAction((event) -> filterMoviesByGenre());
    }

    private void readDataFromBinFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("CompletedMovies.bin"))) {
            List<MovieCompleted> readMovies = (List<MovieCompleted>) ois.readObject();
            movieList.addAll(readMovies);
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Creating a new one.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void populateGenresComboBox() {
        ObservableList<String> uniqueGenres = FXCollections.observableArrayList();
        for (MovieCompleted movie : movieList) {
            if (!uniqueGenres.contains(movie.getMovieType())) {
                uniqueGenres.add(movie.getMovieType());
            }
        }
        selectGenreComboBox.setItems(uniqueGenres);
    }

    private void filterMoviesByGenre() {
        String selectedGenre = selectGenreComboBox.getValue();
        if (selectedGenre == null || selectedGenre.isEmpty()) {
            movieShocaseTableView.setItems(movieList);
        } else {
            ObservableList<MovieCompleted> filteredMovies = FXCollections.observableArrayList();
            for (MovieCompleted movie : movieList) {
                if (selectedGenre.equals(movie.getMovieType())) {
                    filteredMovies.add(movie);
                }
            }
            movieShocaseTableView.setItems(filteredMovies);
        }
    }    

    @FXML
    private void backMainPageOnButtonClick(ActionEvent event) throws IOException {
            Parent sceneA=FXMLLoader.load(getClass().getResource("FxmlDocument_1.fxml"));
            Scene sceneB=new Scene(sceneA);
            Stage stg=(Stage)((Node)event.getSource()).getScene().getWindow();
            //stg.setTitle("Student Scene");
            stg.setScene(sceneB);
            stg.show();
    }

    @FXML
    private void addItemsInCartOnButtonClick(ActionEvent event) throws IOException {
            
    }

    @FXML
    private void viewCartItemOnButtonClick(ActionEvent event) throws IOException {
            Parent sceneA=FXMLLoader.load(getClass().getResource("User_5_viewCartAndOrderPage.fxml"));
            Scene sceneB=new Scene(sceneA);
            Stage stg=(Stage)((Node)event.getSource()).getScene().getWindow();
            //stg.setTitle("Student Scene");
            stg.setScene(sceneB);
            stg.show();
    }
    
}
