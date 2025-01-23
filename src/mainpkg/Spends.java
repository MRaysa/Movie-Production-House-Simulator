/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.Serializable;

/**
 *
 * @author abdur
 */
public class Spends implements Serializable{
    
    String spendType,spendField;
    float cost,reaminedBudget;

    public Spends(String spendType, String spendField, float cost, float reaminedBudget) {
        this.spendType = spendType;
        this.spendField = spendField;
        this.cost = cost;
        this.reaminedBudget = reaminedBudget;
    }

    public String getSpendType() {
        return spendType;
    }

    public void setSpendType(String spendType) {
        this.spendType = spendType;
    }

    public String getSpendField() {
        return spendField;
    }

    public void setSpendField(String spendField) {
        this.spendField = spendField;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getReaminedBudget() {
        return reaminedBudget;
    }

    public void setReaminedBudget(float reaminedBudget) {
        this.reaminedBudget = reaminedBudget;
    }

    @Override
    public String toString() {
        return "Spends{" + "spendType=" + spendType + ", spendField=" + spendField + ", cost=" + cost + ", reaminedBudget=" + reaminedBudget + '}';
    }


    
}
