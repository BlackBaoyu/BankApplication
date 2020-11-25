import java.util.ArrayList;
//Branch物件
public class Branch {
    private String name;
    private ArrayList<Customer> customersList = new ArrayList<Customer>();

    //Constructor
    public Branch(String name) {
        this.name = name;
    }

    //Getter
    public String getName() {
        return name;
    }

    //Getter
    public ArrayList<Customer> getCustomersList() {
        return customersList;
    }

    //增加新顧客以及設立戶頭初始值
    public boolean addCostumer(String userName, double initialAmount){
        int position = find(userName);
        if(position < 0){
            Customer newCustomer = new Customer(userName);
            customersList.add(newCustomer);
            newCustomer.getTransactionList().add(Double.valueOf(initialAmount));
            System.out.println("The account has created.");
            return true;
        }
        else{
            System.out.println(userName + " has existed.");
            return false;
        }
    }

    //新增交易
    public boolean addTransaction(String userName, double transaction){
        int position = find(userName);
        if(position >= 0){
            Customer customer = customersList.get(position);
            customer.getTransactionList().add(Double.valueOf(transaction));
            System.out.println("Complete transaction.");
            return true;
        }
        else{
            System.out.println(userName + " do not exist.");
            return false;
        }
    }

    //印出所有交易
    public void showTransactions(){
        System.out.println("All transactions: ");
        for(int i = 0; i < customersList.size(); i = i + 1){
            for(int j = 0; j < customersList.get(i).getTransactionList().size(); j = j + 1){
                System.out.println("Customer: " + customersList.get(i).getName() +
                        ", " + "transaction: " + customersList.get(i).getTransactionList().get(j));
            }
        }
    }

    //找尋重複的用戶(排除bug)
    private int find(String userName){
        for(int i = 0; i < customersList.size(); i = i + 1){
            if(customersList.get(i).getName().equals(userName)){
                return i;
            }
        }
        return -1;
    }
}
