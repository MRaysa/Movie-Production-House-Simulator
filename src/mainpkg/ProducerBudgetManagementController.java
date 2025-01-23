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
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abdur
 */
public class ProducerBudgetManagementController implements Initializable {

    @FXML
    private TextField budgetField;
    @FXML
    private TextArea resultBar;
    @FXML
    private TableView<BudgetManangeMent> BudgetTable;
    @FXML
    private TableColumn<BudgetManangeMent, Float> budgetCol;
    @FXML
    private TableColumn<BudgetManangeMent, Float> prebudgetCol;
    @FXML
    private TableColumn<BudgetManangeMent, Float> postbudgetCol;
    @FXML
    private TableColumn<BudgetManangeMent, Float> toolCostCol;
    @FXML
    private PieChart pieChart;
    ObservableList<PieChart.Data> List;
    ObservableList<PieChart.Data> List2;
    ArrayList<BudgetManangeMent> budgetArr;
    ObservableList<BudgetManangeMent> budgetList;
    String MovieName;
    BudgetManangeMent budget;
    
    @FXML
    private PieChart recomendedChart;
    @FXML
    private TextField preProductionField;
    @FXML
    private TextField toolBudgetField;
    @FXML
    private TextField postProductionField;
    MovieProject movie;
    public void initData(MovieProject Movie){
        this.movie = Movie;
        MovieName = Movie.getMovieName();
        System.out.println(MovieName);
        budgetArr = ProducersBudgetMangeMentDataBase.getArr();
        if(budgetArr!=null){
            for(BudgetManangeMent i : budgetArr){
                if(i.getMovieName().equals(MovieName)){
                    budget = i;
                    System.out.println(budget);
                    budgetList.add(budget);
                    BudgetTable.setItems(budgetList);
                    List.add(new PieChart.Data("Preproduction",budget.getPreProduction()));
                    List.add(new PieChart.Data("Postproduction",budget.getPostProduction()));
                    List.add(new PieChart.Data("ToolCost",budget.getToolCost()));
                    pieChart.setData(List);
                    //recomended piechart
                    List2.add(new PieChart.Data("Your Preproduction",budget.getPreProduction()));
                    List2.add(new PieChart.Data("Your Postproduction",budget.getPostProduction()));
                    List2.add(new PieChart.Data("Your ToolCost",budget.getToolCost()));
                    List2.add(new PieChart.Data("Preproduction",1000000));
                    List2.add(new PieChart.Data("Postproduction",1000000));
                    List2.add(new PieChart.Data("ToolCost",500000));
                    recomendedChart.setData(List2);

                }
            }
        }
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        budgetArr = null;
        List = FXCollections.observableArrayList();
        List2 = FXCollections.observableArrayList();
        budgetList = FXCollections.observableArrayList();



        /// connecting the columns with variables
        budgetCol.setCellValueFactory(new PropertyValueFactory("budget"));
        prebudgetCol.setCellValueFactory(new PropertyValueFactory("preProduction"));
        postbudgetCol.setCellValueFactory(new PropertyValueFactory("postProduction"));
        toolCostCol.setCellValueFactory(new PropertyValueFactory("toolCost"));
        
  }    

    @FXML
    private void setBudgetAction(ActionEvent event) {

        if(budgetArr==null){
            float bud = Float.parseFloat(budgetField.getText());
            float pre = Float.parseFloat(preProductionField.getText());
            float tool =Float.parseFloat(toolBudgetField.getText());
            float post =Float.parseFloat(postProductionField.getText());
            float sum = bud-pre-post-tool;
            if(sum<0){
                resultBar.setText("Invalid distribution ,please recheck the budget");
                return;
                
            }
            budgetArr = new ArrayList();
            budget = new BudgetManangeMent(bud,pre ,post,tool,MovieName);
            budgetArr.add(budget);
            budgetList.add(budget);
            BudgetTable.setItems(budgetList);
            List.add(new PieChart.Data("Preproduction",budget.getPreProduction()));
            List.add(new PieChart.Data("Postproduction",budget.getPostProduction()));
            List.add(new PieChart.Data("ToolCost",budget.getToolCost()));
            pieChart.setData(List);
            //recomended piechart
            List2.add(new PieChart.Data("Your Preproduction",budget.getPreProduction()));
            List2.add(new PieChart.Data("Your Postproduction",budget.getPostProduction()));
            List2.add(new PieChart.Data("Your ToolCost",budget.getToolCost()));
            List2.add(new PieChart.Data("Preproduction",1000000));
            List2.add(new PieChart.Data("Postproduction",1000000));
            List2.add(new PieChart.Data("ToolCost",500000));
            recomendedChart.setData(List2);
            ProducersBudgetMangeMentDataBase.writeObj(budgetArr);
        }else{
            resultBar.setText("You have Declear The budget");
        }
        
        
        
    }

    @FXML
    private void updateBudgetAction(ActionEvent event) {
        ArrayList<BudgetManangeMent> temp =ProducersBudgetMangeMentDataBase.getArr();
        ArrayList<BudgetManangeMent> temp2 = new ArrayList();
        if(temp!=null){
            for(BudgetManangeMent i:temp){
                if(i.getMovieName().equals(MovieName)){
                    System.out.println("got");
                    
                }else{
                    temp2.add(i);
                }
            }
            float bud = Float.parseFloat(budgetField.getText());
            float pre = Float.parseFloat(preProductionField.getText());
            float tool =Float.parseFloat(toolBudgetField.getText());
            float post =Float.parseFloat(postProductionField.getText());
            float sum = bud-pre-post-tool;
            if(sum<0){
                resultBar.setText("Invalid distribution ,please recheck the budget");
                return;
            }
            
            budget = new BudgetManangeMent(bud,pre ,post,tool,MovieName);
            temp2.add(budget);
            budgetList.add(budget);
            BudgetTable.setItems(budgetList);
            List.add(new PieChart.Data("Preproduction",budget.getPreProduction()));
            List.add(new PieChart.Data("Postproduction",budget.getPostProduction()));
            List.add(new PieChart.Data("ToolCost",budget.getToolCost()));
            pieChart.setData(List);
            //recomended piechart
            List2.add(new PieChart.Data("Your Preproduction",budget.getPreProduction()));
            List2.add(new PieChart.Data("Your Postproduction",budget.getPostProduction()));
            List2.add(new PieChart.Data("Your ToolCost",budget.getToolCost()));
            List2.add(new PieChart.Data("Preproduction",1000000));
            List2.add(new PieChart.Data("Postproduction",1000000));
            List2.add(new PieChart.Data("ToolCost",500000));
            recomendedChart.setData(List2);
            ProducersBudgetMangeMentDataBase.writeObj(temp2);
            
            
        }
    }

    @FXML
    private void backToDashBoardAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("ProducersDashBoard.fxml"));
        Parent r = loader.load();
        Scene sc = new Scene(r);
        ProducersDashBoardController c = loader.getController();
        c.initData(movie);
        
        Stage stg =(Stage)((Node)event.getSource()).getScene().getWindow();


        stg.setScene(sc);
        stg.show();
    }


    
}
