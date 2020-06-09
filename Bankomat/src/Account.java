public class Account {
    private int id;
    private int balance;
    private String name;


    public Account(){}
    public Account(int id, String name, int balance){
        this.id = id;
        this.balance = balance;
    }
    public void setName(String name){this.name = name;}
    public void setBalance(int balance) {this.balance = balance;}
    public void setId(int id){this.id = id;}
    public int getBalance(){return balance;}
    public int getId(){return id;}
    public String getName(){return name;}



}
