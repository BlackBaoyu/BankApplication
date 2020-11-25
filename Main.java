public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("華南");
        bank.addBranch("錦州");
        bank.addCostumer("錦州", "Jojo", 87.87);
        bank.addCostumer("錦州", "John", 8.38);
        bank.addCostumer("錦州", "Joan", 9.99);
        bank.addTransaction("錦州", "Jojo", -8.2);
        bank.addTransaction("錦州", "John", -6.33);
        bank.addTransaction("錦州", "Joan", -3.22);
        bank.showTransactions("錦州");
        bank.showTransactions("松江");
    }
}
