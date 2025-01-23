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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abdur
 */
public class ProducersDateLocationViewerController implements Initializable {

    @FXML
    private TableColumn<ShottingInformation, LocalDate> dateCol;
    @FXML
    private TableColumn<ShottingInformation, String> locationCol;
    @FXML
    private TableColumn<ShottingInformation, String> timeCol;
    @FXML
    private TableView<ShottingInformation> tableOfShootingDates;

    //Variables
    ArrayList<ShottingInformation> sLArray;
    ObservableList<ShottingInformation> obArr;
    MovieProject movie;
    ShottingLocationReadWrite sLRW;

    public void initData(MovieProject m) {
        movie = m;
        sLRW = new ShottingLocationReadWrite(movie.getMovieName());

        sLArray = sLRW.getArr();

        if (sLArray != null) {
            for (ShottingInformation i : sLArray) {
                obArr.add(i);

            }
            tableOfShootingDates.setItems(obArr);

        }

    }

    public void initData2(User us) {
        sLRW = new ShottingLocationReadWrite(us.getMovieName());

        sLArray = sLRW.getArr();

        if (sLArray != null) {
            for (ShottingInformation i : sLArray) {
                obArr.add(i);

            }
            tableOfShootingDates.setItems(obArr);

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        obArr = FXCollections.observableArrayList();
        dateCol.setCellValueFactory(new PropertyValueFactory("date"));
        locationCol.setCellValueFactory(new PropertyValueFactory("location"));
        timeCol.setCellValueFactory(new PropertyValueFactory("time"));
    }

    @FXML
    private void backTodashBoardAction(ActionEvent event) throws IOException {
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
