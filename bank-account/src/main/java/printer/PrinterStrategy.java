package printer;

import bank.account.Account;

public interface PrinterStrategy {
    String print(Account account);
}