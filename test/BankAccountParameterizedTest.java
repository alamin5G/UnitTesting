import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountParameterizedTest {



    // ==================== PARAMETERIZED TESTS ====================

    @ParameterizedTest(name = "Deposit {0} should result in balance of {1}")
    @DisplayName("Test Deposit Method: Should Increase Bank Balance by Exact Amount (Multiple Values)")
    @CsvSource({
            "1, 1",
            "100, 100",
            "120.25, 120.25",
            "500.50, 500.50",
            "1000, 1000"
    })
    public void depositShouldIncreaseBalanceByExactAmount(double amountToBeDeposited, double expectedBalance) {
        // Arrange
        BankAccount newAccount = new BankAccount("TEST001", 0, "Test User");

        // Act
        newAccount.depositBalance(amountToBeDeposited);

        // Assert
        assertEquals(expectedBalance, newAccount.getBalance(), 0.01);
    }

    @ParameterizedTest(name = "Initial: {0}, Withdraw: {1} → Expected: {2}")
    @DisplayName("Test Withdraw Method: Should Decrease Balance Correctly (Multiple Values)")
    @CsvSource({
            "1000, 100, 900",
            "1000, 500, 500",
            "1000, 1000, 0",
            "500, 250.50, 249.50",
            "100, 99.99, 0.01"
    })
    public void withdrawShouldDecreaseBalanceCorrectly(double initialBalance, double withdrawAmount, double expectedBalance) {
        // Arrange
        BankAccount newAccount = new BankAccount("TEST002", initialBalance, "Test User");

        // Act
        newAccount.withdraw(withdrawAmount);

        // Assert
        assertEquals(expectedBalance, newAccount.getBalance(), 0.01);
    }

    @ParameterizedTest(name = "Deposit {0} + {1} should equal {2}")
    @DisplayName("Test Multiple Deposits: Should Accumulate Correctly")
    @CsvSource({
            "100, 50, 150",
            "200, 300, 500",
            "10.50, 20.25, 30.75",
            "1000, 1000, 2000",
            "1, 1, 2"
    })
    public void multipleDepositsShouldAccumulate(double firstDeposit, double secondDeposit, double expectedTotal) {
        // Arrange
        BankAccount newAccount = new BankAccount("TEST003", 0, "Test User");

        // Act
        newAccount.depositBalance(firstDeposit);
        newAccount.depositBalance(secondDeposit);

        // Assert
        assertEquals(expectedTotal, newAccount.getBalance(), 0.01);
    }

    @ParameterizedTest(name = "Invalid deposit amount: {0}")
    @DisplayName("Test Deposit Method: Should Throw Exception for Invalid Amounts")
    @ValueSource(doubles = {-1, -100, -500.50, 0, -0.01})
    public void depositWithInvalidAmountsShouldThrowException(double invalidAmount) {
        // Arrange
        BankAccount newAccount = new BankAccount("TEST004", 1000, "Test User");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> newAccount.depositBalance(invalidAmount));
    }

    @ParameterizedTest(name = "Balance: {0}, Invalid withdrawal: {1}")
    @DisplayName("Test Withdraw Method: Should Throw Exception for Invalid Amounts")
    @CsvSource({
            "1000, -100",
            "1000, 0",
            "1000, 1500",
            "500, 501",
            "100, -50"
    })
    public void withdrawWithInvalidAmountsShouldThrowException(double initialBalance, double invalidWithdrawAmount) {
        // Arrange
        BankAccount newAccount = new BankAccount("TEST005", initialBalance, "Test User");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> newAccount.withdraw(invalidWithdrawAmount));
    }

    @ParameterizedTest(name = "Deposit {0}, Withdraw {1} → Balance: {2}")
    @DisplayName("Test Mixed Transactions: Deposit Then Withdraw")
    @CsvSource({
            "1000, 300, 700",
            "500, 100, 400",
            "1000, 999.99, 0.01",
            "250.50, 50.25, 200.25"
    })
    public void mixedTransactionsShouldWorkCorrectly(double depositAmount, double withdrawAmount, double expectedBalance) {
        // Arrange
        BankAccount newAccount = new BankAccount("TEST006", 0, "Test User");

        // Act
        newAccount.depositBalance(depositAmount);
        newAccount.withdraw(withdrawAmount);

        // Assert
        assertEquals(expectedBalance, newAccount.getBalance(), 0.01);
    }

}
