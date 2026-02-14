# Parameterized Testing Guide - JUnit 5

## 📚 C# vs Java: Theory/InlineData → ParameterizedTest

### C# (xUnit/NUnit):
```csharp
[Theory]
[InlineData(1, 1)]
[InlineData(100, 100)]
[InlineData(120.25, 120.25)]
public void Deposit_Should_IncreaseBankBalanceByExactAmount(
    decimal amountToBeDeposited, 
    decimal expectedBalance)
{
    // Test code
}
```

### ✅ Java (JUnit 5):
```java
@ParameterizedTest
@CsvSource({
    "1, 1",
    "100, 100",
    "120.25, 120.25"
})
public void depositShouldIncreaseBalanceByExactAmount(
    double amountToBeDeposited, 
    double expectedBalance)
{
    // Test code
}
```

---

## 🎯 Parameterized Test এর বিভিন্ন Types

### 1️⃣ **@CsvSource** - Multiple Parameters
একাধিক values এর জন্য (C# এর InlineData এর মতো)

```java
@ParameterizedTest
@CsvSource({
    "100, 50, 150",      // deposit1, deposit2, expected
    "200, 300, 500",
    "10.50, 20.25, 30.75"
})
public void multipleDepositsShouldAccumulate(
    double firstDeposit, 
    double secondDeposit, 
    double expectedTotal) 
{
    account.depositBalance(firstDeposit);
    account.depositBalance(secondDeposit);
    assertEquals(expectedTotal, account.getBalance(), 0.01);
}
```

**Output Example:**
```
✓ Deposit 100 + 50 should equal 150
✓ Deposit 200 + 300 should equal 500
✓ Deposit 10.50 + 20.25 should equal 30.75
```

---

### 2️⃣ **@ValueSource** - Single Parameter
শুধুমাত্র একটি value এর জন্য

```java
@ParameterizedTest
@ValueSource(doubles = {-1, -100, -500.50, 0, -0.01})
public void depositWithInvalidAmounts(double invalidAmount) {
    assertThrows(IllegalArgumentException.class, 
        () -> account.depositBalance(invalidAmount));
}
```

**Output Example:**
```
✓ Test with -1
✓ Test with -100
✓ Test with -500.50
✓ Test with 0
✓ Test with -0.01
```

---

### 3️⃣ **@MethodSource** - Complex Objects
Complex data এর জন্য

```java
@ParameterizedTest
@MethodSource("provideTestData")
public void testWithMethodSource(String accountNumber, double balance, String name) {
    BankAccount account = new BankAccount(accountNumber, balance, name);
    assertNotNull(account);
}

static Stream<Arguments> provideTestData() {
    return Stream.of(
        Arguments.of("ACC001", 1000.0, "John"),
        Arguments.of("ACC002", 2000.0, "Jane"),
        Arguments.of("ACC003", 3000.0, "Bob")
    );
}
```

---

### 4️⃣ **@EnumSource** - Enum Values
```java
enum TransactionType { DEPOSIT, WITHDRAW, TRANSFER }

@ParameterizedTest
@EnumSource(TransactionType.class)
public void testWithEnum(TransactionType type) {
    assertNotNull(type);
}
```

---

### 5️⃣ **@CsvFileSource** - CSV File থেকে Data
```java
@ParameterizedTest
@CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
public void testWithCsvFile(double amount, double expected) {
    account.depositBalance(amount);
    assertEquals(expected, account.getBalance());
}
```

---

## 🎨 Custom Test Names

### Display Name Customization:
```java
@ParameterizedTest(name = "Deposit {0} should result in balance of {1}")
@CsvSource({"100, 100", "200, 200"})
public void testDeposit(double amount, double expected) {
    // Test code
}
```

**Output:**
```
✓ Deposit 100 should result in balance of 100
✓ Deposit 200 should result in balance of 200
```

### Available Placeholders:
- `{0}`, `{1}`, `{2}` - Parameter values by index
- `{arguments}` - All parameters
- `{index}` - Current test index (1-based)
- `{displayName}` - Display name

---

## 📊 আপনার Project এ Added Tests:

### ✅ 1. Deposit with Exact Amount (5 test cases)
```java
@ParameterizedTest
@CsvSource({"1, 1", "100, 100", "120.25, 120.25", "500.50, 500.50", "1000, 1000"})
```

### ✅ 2. Withdraw with Correct Balance (5 test cases)
```java
@CsvSource({"1000, 100, 900", "1000, 500, 500", ...})
```

### ✅ 3. Multiple Deposits Accumulation (5 test cases)
```java
@CsvSource({"100, 50, 150", "200, 300, 500", ...})
```

### ✅ 4. Invalid Deposit Amounts (5 test cases)
```java
@ValueSource(doubles = {-1, -100, -500.50, 0, -0.01})
```

### ✅ 5. Invalid Withdraw Amounts (5 test cases)
```java
@CsvSource({"1000, -100", "1000, 0", "1000, 1500", ...})
```

### ✅ 6. Mixed Transactions (4 test cases)
```java
@CsvSource({"1000, 300, 700", "500, 100, 400", ...})
```

**Total: 29 additional parameterized test cases!** 🎉

---

## 🚀 How to Run

### IntelliJ IDEA:
1. Right-click on `BankAccountTest.java`
2. Select **Run 'BankAccountTest'**
3. You'll see each parameterized test case run individually

### Output Example:
```
✓ Test Deposit Method: Should Increase Bank Balance by Exact Amount (Multiple Values)
  ✓ Deposit 1.0 should result in balance of 1.0
  ✓ Deposit 100.0 should result in balance of 100.0
  ✓ Deposit 120.25 should result in balance of 120.25
  ✓ Deposit 500.50 should result in balance of 500.50
  ✓ Deposit 1000.0 should result in balance of 1000.0
```

---

## 💡 Best Practices

1. **Use Meaningful Test Names:**
   ```java
   @ParameterizedTest(name = "When deposit {0}, balance should be {1}")
   ```

2. **Group Related Tests:**
   - Keep parameterized tests together
   - Use comments to separate sections

3. **Test Edge Cases:**
   - Zero values
   - Negative values
   - Maximum values
   - Boundary values

4. **Keep Tests Independent:**
   - Each parameterized test should be independent
   - Don't rely on execution order

---

## 📝 Summary

| Feature | C# (xUnit) | Java (JUnit 5) |
|---------|-----------|---------------|
| Multiple values | `[InlineData]` | `@CsvSource` |
| Single value | `[InlineData]` | `@ValueSource` |
| Complex data | `[MemberData]` | `@MethodSource` |
| From file | - | `@CsvFileSource` |
| Test marker | `[Theory]` | `@ParameterizedTest` |

---

আপনার প্রজেক্টে এখন **মোট 36টি test cases** আছে:
- 7টি regular tests
- 29টি parameterized tests

সব tests run করুন এবং green checkmarks দেখুন! ✅

