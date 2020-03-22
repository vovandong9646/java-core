package com.realexample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiFunction;

public class BankAccount {
    private int id;
    // số tiền đang có trong tài khoản
    private double balance;
    private String accountName;

    final Lock lock = new ReentrantLock();
    BiFunction<Double, Double, Double> subtractFunction = (a,b) -> a - b;
    BiFunction<Double, Double, Double> addFunction = (a, b) -> a + b;

    public BankAccount(int id, double balance, String accountName) {
        this.id = id;
        this.balance = balance;
        this.accountName = accountName;
    }

    /**
     * Rút tiền (số tiền có trong tài khoản (balance) - số tiền muốn rút (amount)
     * @param amount số tiền muốn rút
     * @return rút thành công hay thất bại
     * @throws InterruptedException
     */
    public boolean withdraw(double amount) throws InterruptedException {
        if(this.lock.tryLock()) {
            Thread.sleep(100);
            balance = subtractFunction.apply(balance, amount);
            this.lock.unlock();
            return true;
        }
        return false;
    }

    /**
     * gửi tiền vào tài khoản ( số tiền đang có (balance) + số tiền muốn gửi vào (amount) )
     * @param amount số tiền muốn gửi
     * @return gửi thành công hay thất bại
     * @throws InterruptedException
     */
    public boolean deposit(double amount) throws InterruptedException {
        if(this.lock.tryLock()) {
            Thread.sleep(100);
            balance = addFunction.apply(balance, amount);
            this.lock.unlock();
            return true;
        }
        return false;
    }

    /**
     * Chuyển khoản
     * rút từ ngân hàng A (balance = 10) -> sau đó chuyển vào ngân hàng B (balance = 12) và amount ddnag là 4
     * ->sau khi qua transfer -> A: balance = 6, B: balance = 16
     * @param to ngân hàng muốn chuyển vào
     * @param amount số tiền muốn chuyển
     * @return chuyển thành công hay không
     * @throws InterruptedException
     */
    public boolean transfer(BankAccount to, double amount) throws InterruptedException {
        if(withdraw(amount)) {
            System.out.println("Withdrawing amount: " + amount + " from: " + getAccountName());
            if(to.deposit(amount)) {
                System.out.println("Depositing amount: " + amount + " to:" + to.getAccountName());
                return true;
            } else {
                System.out.println("Failed to acquire both locks: refunding " + amount + " to: " + accountName);
                while(!deposit(amount)) {
                    continue;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", balance=" + balance +
                ", accountName='" + accountName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Lock getLock() {
        return lock;
    }

    public BiFunction<Double, Double, Double> getSubtractFunction() {
        return subtractFunction;
    }

    public void setgetSubtractFunction(BiFunction<Double, Double, Double> subtractFunction) {
        this.subtractFunction = subtractFunction;
    }

    public BiFunction<Double, Double, Double> getAddFunction() {
        return addFunction;
    }

    public void setAddFunction(BiFunction<Double, Double, Double> addFunction) {
        this.addFunction = addFunction;
    }
}
