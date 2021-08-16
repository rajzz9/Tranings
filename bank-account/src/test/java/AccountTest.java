import bank.account.Account;
import bank.account.AccountRepository;
import bank.account.Balance;
import bank.account.Currency;
import bank.usecases.AccountUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import printer.PrintAsString;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class AccountTest {

    private static final BigDecimal VALUE_AMOUNT_0 = new BigDecimal(0);
    private static final BigDecimal VALUE_AMOUNT_50 = new BigDecimal(50);
    private static final BigDecimal VALUE_AMOUNT_100 = new BigDecimal(100);
    private static final BigDecimal VALUE_AMOUNT_200 = new BigDecimal(200);
    private static final BigDecimal VALUE_AMOUNT_500 = new BigDecimal(500);
    public static final String ALI_IBAN = "AL35202111090000000001234520";

    @Mock
    private AccountRepository accountRepositoryMock;

    @Mock
    private PrintAsString printAsString;

    @Test
    void should_return_the_deposit_amount_when_make_deposit() {
        Balance balance = Balance.getInstance(VALUE_AMOUNT_100, Currency.EURO);
        Account account = Account.getInstance(balance, ALI_IBAN);
        AccountUseCase accountUseCase = new AccountUseCase(accountRepositoryMock);

        Mockito.when(accountRepositoryMock.find(any())).thenReturn(Optional.of(account));
        Mockito.when(accountRepositoryMock.save(any())).thenReturn(account);

        Account deposit = accountUseCase.deposit(ALI_IBAN, VALUE_AMOUNT_200);

        Mockito.verify(accountRepositoryMock).find(any());

        assertEquals(account.getBalance(), deposit.getBalance());
    }


}