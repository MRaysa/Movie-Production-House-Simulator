/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author abdur
 */
public class ProducerSpendsChartViewController implements Initializable {

    @FXML
    private BarChart<String,Float> barChart1;
    @FXML
    private BarChart<String,Float> barChart2;
    @FXML
    private BarChart<String,Float> barChart3;

    @FXML
    private BarChart<String,Float> barChart4;
    //Variables
    ProducerSpendOfProjectReadWrite obj;
    ArrayList<Spends>arr;
    ArrayList<BudgetManangeMent>budArr;
    MovieProject movie;
    float budget,preProductionBudget,supliesBudget,postProductionBudget;
    float cost,preCost,postCost,supCost;
    public void initData(MovieProject m){
        movie = m;
        obj = new ProducerSpendOfProjectReadWrite(movie.getMovieName());
        arr = obj.getArr();
        budArr = ProducersBudgetMangeMentDataBase.getArr();
        System.out.println(budArr);

        if (arr!=null){
            for(Spends i:arr){
                cost+=i.getCost();
                if(i.getSpendType().equals("PreProduction")){
                    preCost+=i.getCost();
                
                }
                if(i.getSpendType().equals("PostProduction")){
                    postCost+=i.getCost();
                
                }
                if(i.getSpendType().equals("SupliesCost")){
                    supCost+=i.getCost();
                
                }
                    
            }
        if(budArr!=null){
            for(BudgetManangeMent i : budArr){
                if(i.getMovieName().equals(movie.getMovieName())){
                    budget = i.getBudget();
                    preProductionBudget = i.getPreProduction();
                    postProductionBudget = i.getPostProduction();
                    supliesBudget = i.getToolCost();
                    System.out.println( i.getPreProduction()+" "+i.getPostProduction()+" "+i.getToolCost());
                }
            }
            //for chart 1
            XYChart.Series<String,Float>series1 =new XYChart.Series<String,Float>();
            series1.getData().add(new XYChart.Data<String,Float>("Total Budget",budget ));
            series1.getData().add(new XYChart.Data<String,Float>("Total Spend", cost));
            series1.setName("Total Spends");
            barChart1.getData().add(series1);
            ////for chart 2
            XYChart.Series<String,Float>series2 =new XYChart.Series<String,Float>();
            series2.getData().add(new XYChart.Data<String,Float>("PreProductionBudget", preProductionBudget));
            series2.getData().add(new XYChart.Data<String,Float>("Total Spend", preCost));
            series2.setName("TotalPrePorductionCost");
            barChart2.getData().add(series2);
            /////for chart 3
            XYChart.Series<String,Float>series3 =new XYChart.Series<String,Float>();
            series3.getData().add(new XYChart.Data<String,Float>("PreProductionBudget", postProductionBudget));
            series3.getData().add(new XYChart.Data<String,Float>("PostProductionSpend", postCost));
            series3.setName("TotalPostProductionSpend");
            barChart3.getData().add(series3);
            ///for chart 4
            XYChart.Series<String,Float>series4 =new XYChart.Series<String,Float>();
            series4.getData().add(new XYChart.Data<String,Float>("Subply Budget", supliesBudget));
            series4.getData().add(new XYChart.Data<String,Float>("Total Spend", supCost));
            series4.setName("Toatal Suply Cost Spends");
            barChart4.getData().add(series4);
        }else{return;}
        
        }
    
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cost=0;
        preCost=0;
        postCost=0;
        supCost=0;
        
        
        
    }    
    
}
