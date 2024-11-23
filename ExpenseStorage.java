import java.io.*;
import java.util.ArrayList;

class ExpenseStorage{
    private static final String fileName = "expenses1.txt";
    
    public static void saveExpenses(ArrayList<Expense> expense) {
        try(PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for(Expense e: expense) {
                writer.println(e.getDate() + "," + e.getDescription()+","+e.getAmount());
            }
        }catch(IOException e){
            System.out.println("Error while saving expenses: "+ e.getMessage());
        }
    }
    
    public static ArrayList<Expense> viewExpenses() {
        ArrayList<Expense> expenses = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line = reader.readLine())!= null) {
                String[] parts = line.split(",");
                expenses.add(new Expense(parts[0],parts[1],parts[2],Double.parseDouble(parts[3])));
            }
            
        }catch(IOException e) {
            System.out.println("Error while loading expenses: " + e.getMessage());            
        }
        return expenses;
    }
}
