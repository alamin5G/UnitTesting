
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Bank Account Test Suite")
public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount("123456789", 0, "Md. Alamin");
    }

    @Test
    @DisplayName("Test Deposit Method: Should Increase Bank Balance by 500 When Amount is 500")

    public void depositTestWithSpecificAmount()
    {
        //arrange
        double amountToBeDeposited = 500;
        //act
        account.depositBalance(amountToBeDeposited);
        double expectedBalance = 500;
        //assert
        assertEquals(expectedBalance, account.getBalance());
    }


    @Test
    @DisplayName("Test Deposit Method: Should Throw IllegalArgumentException When Deposit Amount is Negative")
    public void depositTestWithNegativeAmount() {
        //arrange
        double negativeAmount = -100;
        //act and assert
        assertThrows(IllegalArgumentException.class, () -> account.depositBalance(negativeAmount));
    }

    @Test
    @DisplayName("Test Deposit Method: Should Throw IllegalArgumentException When Deposit Amount is Zero")
    public void depositTestWithZeroAmount() {
        double zeroAmount = 0;
        assertThrows(IllegalArgumentException.class, () -> account.depositBalance(zeroAmount));
    }

    @Test
    @DisplayName("Test Withdraw Method: Should Decrease Bank Balance by 200 When Amount is 200")
    public void withdrawTestWithSpecificAmount(){
        //arrange
        double initialDeposit = 500;
        account.depositBalance(initialDeposit);
        double amountToBeWithdrawn = 200;
        //act
        account.withdraw(amountToBeWithdrawn);
        double expectedBalance = 300;
        //assert
        assertEquals(expectedBalance, account.getBalance());
    }

    @Test
    @DisplayName("Test Withdraw Method: Should Throw IllegalArgumentException When Withdrawal Amount is Negative")
    public void withdrawTestWithNegativeAmount() {
        double negativeAmount = -100;
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(negativeAmount));
    }

    @Test
    @DisplayName("Test Withdraw Method: Should Throw IllegalArgumentException When Withdrawal Amount is Zero")
    public void withdrawTestWithZeroAmount() {
        double zeroAmount = 0;
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(zeroAmount));
    }

    @Test
    @DisplayName("Test Withdraw Method: Should Throw IllegalArgumentException When Withdrawal Amount is Greater Than Balance")
    public void withdrawTestWithAmountGreaterThanBalance() {
        double initialDeposit = 300;
        account.depositBalance(initialDeposit);
        double amountToBeWithdrawn = 400;
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(amountToBeWithdrawn));
    }

}


