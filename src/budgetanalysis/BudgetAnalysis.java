
package budgetanalysis;
import javax.swing.JOptionPane;

/**
 *
 * @author Shanell Spann
 * Course: IT-DEV 140  Programming with JAVA
 * Assignment 3
 * Date:  10/10/2020
 * Description: Create a program that helps a person determine their monthly budget.
 * Purpose: Practice decision structures using loops & if else statements.
 */
public class BudgetAnalysis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String userInput;
        double inputBudget;
        double houseExpense;
        double carExpense;
        double extraExpense;
        double totalExpense = 0;  //initialize. this helps to keep a running total. 
        int moreExpenses = 0;    // 0 equals yes
        
        userInput = JOptionPane.showInputDialog("What is your monthly budget?");
        inputBudget = Double.parseDouble(userInput);
        
        userInput = JOptionPane.showInputDialog("Enter housing expenses: ");
        houseExpense = Double.parseDouble(userInput);
        
        userInput = JOptionPane.showInputDialog("Enter car expenses: ");
        carExpense = Double.parseDouble(userInput);
        
        totalExpense = (totalExpense + houseExpense + carExpense);
        
        while(moreExpenses == JOptionPane.YES_OPTION) {
            userInput = JOptionPane.showInputDialog("Enter an extra expense: ");
            extraExpense = Double.parseDouble(userInput);
            totalExpense = (totalExpense + extraExpense); // originally had a logic error here. 
                                                          //I placed all expense variables here & if user entered YES to loop, 
                                                          // the program added additional housing & car expenses. I moved that
                                                          //calculation outside the loop to prevent duplicates in my calculation. 
            moreExpenses = JOptionPane.showConfirmDialog(null,"Do you have additional expenses?", "Budet Analysis App", JOptionPane.YES_NO_OPTION);
        }
        
        if(totalExpense < inputBudget){
            JOptionPane.showMessageDialog(null, "You are under budget by $" + (inputBudget - totalExpense) + "\nTotal monthly expenses = $" + totalExpense);
        }
        else if(totalExpense > inputBudget){
            JOptionPane.showMessageDialog(null, "You are over budget by $" + (totalExpense - inputBudget) + "\nTotal monthly expenses = $" + totalExpense);
        }
        else{
            JOptionPane.showMessageDialog(null, "You are on budget. Total expenses = $" + totalExpense );
        }
        
        System.exit(0);
    }
}
