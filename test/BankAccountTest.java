import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Bank Account Test Suite")
public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    public void setUp() {
        // Initialize a fresh BankAccount before each test
        account = new BankAccount("12345", 1000.0, "John Doe");
    }

    @Test
    @DisplayName("Test account initialization with valid data")
    public void testAccountInitialization() {
        assertNotNull(account, "Account should not be null");
        assertEquals("12345", account.getAccountNumber(), "Account number should match");
        assertEquals(1000.0, account.getBalance(), 0.01, "Initial balance should be 1000.0");
        assertEquals("John Doe", account.getAccountHolderName(), "Account holder name should match");
    }

    @Test
    @DisplayName("Test deposit with positive amount")
    public void testDepositPositiveAmount() {
        account.depositBalance(500.0);
        assertEquals(1500.0, account.getBalance(), 0.01, "Balance should be 1500.0 after depositing 500.0");
    }

    @Test
    @DisplayName("Test deposit with negative amount (should not change balance)")
    public void testDepositNegativeAmount() {
        account.depositBalance(-100.0);
        assertEquals(1000.0, account.getBalance(), 0.01, "Balance should remain 1000.0 when depositing negative amount");
    }

    @Test
    @DisplayName("Test deposit with zero amount (should not change balance)")
    public void testDepositZeroAmount() {
        account.depositBalance(0.0);
        assertEquals(1000.0, account.getBalance(), 0.01, "Balance should remain 1000.0 when depositing zero");
    }

    @Test
    @DisplayName("Test withdraw with valid amount")
    public void testWithdrawValidAmount() {
        boolean result = account.withdraw(300.0);
        assertTrue(result, "Withdrawal should be successful");
        assertEquals(700.0, account.getBalance(), 0.01, "Balance should be 700.0 after withdrawing 300.0");
    }

    @Test
    @DisplayName("Test withdraw entire balance")
    public void testWithdrawEntireBalance() {
        boolean result = account.withdraw(1000.0);
        assertTrue(result, "Withdrawal should be successful");
        assertEquals(0.0, account.getBalance(), 0.01, "Balance should be 0.0 after withdrawing entire balance");
    }

    @Test
    @DisplayName("Test withdraw with insufficient funds")
    public void testWithdrawInsufficientFunds() {
        boolean result = account.withdraw(1500.0);
        assertFalse(result, "Withdrawal should fail");
        assertEquals(1000.0, account.getBalance(), 0.01, "Balance should remain 1000.0 when withdrawal fails");
    }

    @Test
    @DisplayName("Test withdraw with negative amount")
    public void testWithdrawNegativeAmount() {
        boolean result = account.withdraw(-100.0);
        assertFalse(result, "Withdrawal should fail with negative amount");
        assertEquals(1000.0, account.getBalance(), 0.01, "Balance should remain 1000.0");
    }

    @Test
    @DisplayName("Test withdraw with zero amount")
    public void testWithdrawZeroAmount() {
        boolean result = account.withdraw(0.0);
        assertFalse(result, "Withdrawal should fail with zero amount");
        assertEquals(1000.0, account.getBalance(), 0.01, "Balance should remain 1000.0");
    }

    @Test
    @DisplayName("Test multiple deposits")
    public void testMultipleDeposits() {
        account.depositBalance(100.0);
        account.depositBalance(200.0);
        account.depositBalance(300.0);
        assertEquals(1600.0, account.getBalance(), 0.01, "Balance should be 1600.0 after multiple deposits");
    }

    @Test
    @DisplayName("Test multiple withdrawals")
    public void testMultipleWithdrawals() {
        account.withdraw(100.0);
        account.withdraw(200.0);
        account.withdraw(300.0);
        assertEquals(400.0, account.getBalance(), 0.01, "Balance should be 400.0 after multiple withdrawals");
    }

    @Test
    @DisplayName("Test mixed deposits and withdrawals")
    public void testMixedTransactions() {
        account.depositBalance(500.0);  // 1500.0
        account.withdraw(300.0);         // 1200.0
        account.depositBalance(200.0);  // 1400.0
        account.withdraw(100.0);         // 1300.0
        assertEquals(1300.0, account.getBalance(), 0.01, "Balance should be 1300.0 after mixed transactions");
    }

    @Test
    @DisplayName("Test get account number")
    public void testGetAccountNumber() {
        assertEquals("12345", account.getAccountNumber(), "Account number should be retrievable");
    }

    @Test
    @DisplayName("Test get account holder name")
    public void testGetAccountHolderName() {
        assertEquals("John Doe", account.getAccountHolderName(), "Account holder name should be retrievable");
    }

    @Test
    @DisplayName("Test set account holder name")
    public void testSetAccountHolderName() {
        account.setAccountHolderName("Jane Smith");
        assertEquals("Jane Smith", account.getAccountHolderName(), "Account holder name should be updated");
    }

    @Test
    @DisplayName("Test account with zero initial balance")
    public void testZeroInitialBalance() {
        BankAccount zeroAccount = new BankAccount("67890", 0.0, "Zero User");
        assertEquals(0.0, zeroAccount.getBalance(), 0.01, "Initial balance should be 0.0");

        zeroAccount.depositBalance(100.0);
        assertEquals(100.0, zeroAccount.getBalance(), 0.01, "Balance should be 100.0 after first deposit");
    }
}

