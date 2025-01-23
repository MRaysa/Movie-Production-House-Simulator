package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DirectorDashboardSceneController implements Initializable {

    private String desig;
    private String name;

    MovieProject movie;
    private String selectedMovieName;

    public void initData(String desig, String name, String selectedMovieName) {
        // Initialize other data if needed
        this.selectedMovieName = selectedMovieName;
        this.desig = desig;
        this.name = name;

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void goToInterpretScriptButtonOnClick(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/VisualizeScene.fxml"));
        root = (Parent) (someLoader.load());
        Scene someScene = new Scene(root);

        //data passing code here
        VisualizeSceneController visualizeSceneController = someLoader.getController();
        // Pass the necessary data to CraftStorySceneController
        visualizeSceneController.initData(desig, name, selectedMovieName);
        Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();
    }

    @FXML
    private void goTovisualizeFilmButtonOnClick(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/VisualizeScene.fxml"));
        root = (Parent) (someLoader.load());
        Scene someScene = new Scene(root);

        //data passing code here
        VisualizeSceneController visualizeSceneController = someLoader.getController();
        // Pass the necessary data to CraftStorySceneController
        visualizeSceneController.initData(desig, name, selectedMovieName);
        Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();
    }

    @FXML
    private void goTosetPaceAndTimingButtonOnClick(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/VisualizeScene.fxml"));
        root = (Parent) (someLoader.load());
        Scene someScene = new Scene(root);

        //data passing code here
        VisualizeSceneController visualizeSceneController = someLoader.getController();
        // Pass the necessary data to CraftStorySceneController
        visualizeSceneController.initData(desig, name, selectedMovieName);
        Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();
    }

    @FXML
    private void goToDirectActorButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/DirectActorScene.fxml"));
        Parent root = someLoader.load();
        Scene someScene = new Scene(root);

        // Data passing code here
        DirectActorSceneController directActorSceneController = someLoader.getController();
        directActorSceneController.initData(desig, name, selectedMovieName);

        Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();
    }

    @FXML
    private void goToScheduleFilmButtonOnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainpkg/ScheduleFilmDateScene.fxml"));
            Parent root = loader.load();

            // Create a new stage for the Request Product window
            Stage ScheduleFilmDateStage = new Stage();
            ScheduleFilmDateStage.setTitle("Schedule Film Dates Window");
            ScheduleFilmDateStage.setScene(new Scene(root));

            //data passing code here
            ScheduleFilmDateSceneController scheduleFilmDateSceneController = loader.getController();
            // Pass the necessary data to CraftStorySceneController
            scheduleFilmDateSceneController.initData(desig, name, selectedMovieName);
            ScheduleFilmDateStage.initModality(Modality.APPLICATION_MODAL);

            // Show the new stage
            ScheduleFilmDateStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }

    @FXML
    private void goToEquipmentSetupButtonOnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainpkg/EquipmentSetupScene.fxml"));
            Parent root = loader.load();

            // Create a new stage for the Request Product window
            Stage EquipmentSetupStage = new Stage();
            EquipmentSetupStage.setTitle("Equipment Setup Window");
            EquipmentSetupStage.setScene(new Scene(root));

            // Set the RequestProductWindowController as the controller for the new stage
            //EquipmentSetupSceneController controller = loader.getController();
            // You can pass any necessary data to the controller here if needed
            // Set the new stage to be modal (blocks interactions with the main window)
            EquipmentSetupStage.initModality(Modality.APPLICATION_MODAL);

            // Show the new stage
            EquipmentSetupStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }

    }

    @FXML
    private void goToRequestProductButtonOnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainpkg/RequestProductScene.fxml"));
            Parent root = loader.load();

            // Create a new stage for the Request Product window
            Stage requestProductStage = new Stage();
            requestProductStage.setTitle("Request Product Window");
            requestProductStage.setScene(new Scene(root));

            // Set the RequestProductWindowController as the controller for the new stage
            RequestProductSceneController controller = loader.getController();
            // You can pass any necessary data to the controller here if needed

            // Set the new stage to be modal (blocks interactions with the main window)
            requestProductStage.initModality(Modality.APPLICATION_MODAL);

            // Show the new stage
            requestProductStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }

    @FXML
    private void goToLocationButtonOnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainpkg/AddLocationScene.fxml"));
            Parent root = loader.load();

            // Create a new stage for the Request Product window
            Stage AddLocationStage = new Stage();
            AddLocationStage.setTitle("Add Location Window");
            AddLocationStage.setScene(new Scene(root));

            // Set the RequestProductWindowController as the controller for the new stage
            //EquipmentSetupSceneController controller = loader.getController();
            // You can pass any necessary data to the controller here if needed
            // Set the new stage to be modal (blocks interactions with the main window)
            AddLocationStage.initModality(Modality.APPLICATION_MODAL);

            // Show the new stage
            AddLocationStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }

    @FXML
    private void logOutButtonOnClick(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("/mainpkg/FXMLDocument.fxml"));
        root = (Parent) (someLoader.load());
        Scene someScene = new Scene(root);

        //data passing code here
        //WriteScriptSceneController writeScriptSceneController = someLoader.getController();
        // Pass the necessary data to CraftStorySceneController
        // writeScriptSceneController.initData(desig, name, selectedMovieName);
        Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();

    }

}
