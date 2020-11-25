import java.util.ArrayList;
//Customer物件
public class Customer {
    private String name;
    private ArrayList <Double> transactionList = new ArrayList<Double>();

    //Constructor
    public Customer(String name) {
        this.name = name;
    }

    //Getter
    public String getName() {
        return name;
    }

    //Getter
    public ArrayList<Double> getTransactionList() {
        return transactionList;
    }

}
