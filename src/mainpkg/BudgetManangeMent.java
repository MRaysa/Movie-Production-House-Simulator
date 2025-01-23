
package mainpkg;

import java.io.Serializable;

/**
 *
 * @author abdur
 */
public class BudgetManangeMent implements Serializable{
    
    float budget,preProduction,postProduction,toolCost;
    String MovieName;

    public BudgetManangeMent(float budget, float preProduction, float postProduction, float toolCost, String MovieName) {
        this.budget = budget;
        this.preProduction = preProduction;
        this.postProduction = postProduction;
        this.toolCost = toolCost;
        this.MovieName = MovieName;
    }
    

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String MovieName) {
        this.MovieName = MovieName;
    }

    public float getBudget() {
        return budget;
    }

    public float getPreProduction() {
        return preProduction;
    }

    public float getPostProduction() {
        return postProduction;
    }

    public float getToolCost() {
        return toolCost;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "BudgetManangeMent{" + "budget=" + budget + ", preProduction=" + preProduction + ", postProduction=" + postProduction + ", toolCost=" + toolCost + ", MovieName=" + MovieName + '}';
    }
    
}
