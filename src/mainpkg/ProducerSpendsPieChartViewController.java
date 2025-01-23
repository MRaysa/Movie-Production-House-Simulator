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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;


public class ProducerSpendsPieChartViewController implements Initializable {

    @FXML
    private PieChart pieChart1;
    @FXML
    private PieChart pieChart2;
    @FXML
    private PieChart pieChart3;
    ObservableList<PieChart.Data>list1;
    ObservableList<PieChart.Data>list2;
    ObservableList<PieChart.Data>list3;
    ProducerSpendOfProjectReadWrite obj;
    ArrayList<Spends>arr;

    MovieProject movie;

    public void initData(MovieProject m){
        movie = m;
        obj = new ProducerSpendOfProjectReadWrite(movie.getMovieName());
        arr = obj.getArr();
        


        if (arr!=null){
            for(Spends i:arr){

                if(i.getSpendType().equals("PreProduction")){
                    list1.add(new PieChart.Data(i.getSpendField(),i.getCost()));
                
                }
                if(i.getSpendType().equals("PostProduction")){
                    list2.add(new PieChart.Data(i.getSpendField(),i.getCost()));
                
                }
                if(i.getSpendType().equals("SupliesCost")){
                    list3.add(new PieChart.Data(i.getSpendField(),i.getCost()));
                
                }
            }
            pieChart1.setData(list1);
            pieChart2.setData(list2);
            pieChart3.setData(list3);
        }else{return;}
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list1 = FXCollections.observableArrayList();
        list2 = FXCollections.observableArrayList();
        list3 = FXCollections.observableArrayList();
    }    
    
}
