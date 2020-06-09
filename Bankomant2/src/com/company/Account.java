package com.company;

public class Account {


    private int id;
    private int balance;
    private String name;
    private int changes;
    private String changeDate;
    private String createDate;
    private String changed;

    public void setName(String name){this.name = name;}
    public void setBalance(int balance) {this.balance = balance;}
    public void setId(int id){this.id = id;}
    public void setChanges(int changes){this.changes = changes;}
    public void setCreateDate(String createDate){this.createDate = createDate;}
    public void setChangeDate(String changeDate){this.changeDate = changeDate;}
    public void setChanged(String changed) {this.changed = changed;}
    public int getBalance(){return balance;}
    public int getId(){return id;}
    public String getName(){return name;}
    public int getChanges(){return changes;}
    public String getCreateDate(){return createDate;}
    public String getChangeDate(){return changeDate;}
    public String getChanged() {return changed;}


    public Account(){}
    public Account(int id, String name, int balance, String createDate){
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.createDate = createDate;
    }

    //Method to print all info about an account.
    public void show(){
        System.out.println("Account ID: "+id+"\nAccount Name: "+name+"\nAccount balance: "
                +balance+"\nAccount create date: "+createDate
                +"\nLatest change on account: "+changed);
    }
    //Method to save the last change made.
    public void change() {
        Works uselessWorks = new Works();
        changed = "Last changed amount was: " + changes + ". Change was made at: " + uselessWorks.getTime();
    }

}
