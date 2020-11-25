import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branchesList = new ArrayList<Branch>();

    public Bank(String name) {
        this.name = name;
    }

    //增加分行
    public boolean addBranch(String branchName){
        int position = find(branchName);
        if(position < 0){
            Branch newBranch = new Branch(branchName);
            branchesList.add(newBranch);
            System.out.println("New branch has added.");
            return true;
        }
        else{
            System.out.println("Fail. The branch has existed.");
            return false;
        }
    }

    //增加新顧客以及設立戶頭初始值
    public boolean addCostumer(String branchName, String userName, double initialAmount){
        int position = find(branchName);
        if(position >= 0){
            Branch branch = branchesList.get(position);
            if(branch.addCostumer(userName, initialAmount) == true){
                System.out.println("The process is successful.");
                return true;
            }
            else{
                return false;
            }
        }
        else{
            System.out.println("The process failed. The branch do not exist.");
            return false;
        }
    }

    //新增交易
    public boolean addTransaction(String branchName, String userName, double transaction){
        int position = find(branchName);
        if(position >= 0){
            Branch branch = branchesList.get(position);
            if(branch.addTransaction(userName, transaction) == true){
                System.out.println("The transaction has added.");
                return true;
            }
            else{
                return false;
            }
        }
        else{
            System.out.println("The process failed. The branch do not exist.");
            return false;
        }
    }

    //印出所有交易
    public void showTransactions(String branchName){
        int position = find(branchName);
        if(position >= 0){
            branchesList.get(position).showTransactions();
        }
        else{
            System.out.println("The branch do not exist.");
        }
    }

    //找尋重複的分行(排除bug)
    private int find(String branchName){
        for(int i = 0; i < branchesList.size(); i = i + 1){
            if(branchesList.get(i).getName().equals(branchName)){
                return i;
            }
        }
        return -1;
    }
}
