package bank.usecases;

import bank.account.Account;
import bank.account.OperationTypes;
import bank.domain.historyAction.HistoryAction;
import bank.domain.historyAction.HistoryActionRepository;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class HistoryActionUseCase {

    private final HistoryActionRepository historyActionRepository;

    public HistoryAction audit(OperationTypes operationTypes, Account account, BigDecimal value) {
        HistoryAction historyAction = HistoryAction.getInstance(operationTypes, account, value);
        return historyActionRepository.save(historyAction);
    }

}