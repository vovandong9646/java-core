package com.realexample;

public interface AccountFactory {
    public abstract BankAccount getBankAccount(int id, int balance, String name);
}
