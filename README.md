# BankAccount Unit Testing Project

এই প্রজেক্টে BankAccount ক্লাসের জন্য সম্পূর্ণ unit testing setup করা আছে।

## Project Structure
```
UnitTesting/
├── src/
│   └── BankAccount.java        (Main class)
├── test/
│   └── BankAccountTest.java    (Test class with 17 test cases)
└── UnitTesting.iml             (IntelliJ project configuration)
```

## Features Tested

### BankAccountTest ক্লাসে নিম্নলিখিত test cases আছে:

1. **Account Initialization Tests**
   - Account initialization with valid data
   - Account with zero initial balance

2. **Deposit Tests**
   - Deposit with positive amount
   - Deposit with negative amount (should not change balance)
   - Deposit with zero amount
   - Multiple deposits

3. **Withdrawal Tests**
   - Withdraw with valid amount
   - Withdraw entire balance
   - Withdraw with insufficient funds
   - Withdraw with negative amount
   - Withdraw with zero amount
   - Multiple withdrawals

4. **Getter/Setter Tests**
   - Get account number
   - Get account holder name
   - Set account holder name

5. **Mixed Transaction Tests**
   - Mixed deposits and withdrawals

## How to Run Tests in IntelliJ IDEA

### Method 1: Using IntelliJ UI
1. **Project Reload করুন:**
   - File → Reload All from Disk
   - অথবা File → Invalidate Caches / Restart

2. **Test Run করুন:**
   - BankAccountTest.java ফাইল খুলুন
   - ক্লাসের নামের পাশে green play button এ ক্লিক করুন
   - অথবা Right-click → Run 'BankAccountTest'

### Method 2: Using Keyboard Shortcut
- BankAccountTest.java ফাইল open করুন
- **Ctrl + Shift + F10** press করুন

### Method 3: Run Single Test
- যেকোনো individual test method এর পাশে green play button এ ক্লিক করুন
- একটি মাত্র test run হবে

## Test Coverage

এই test suite টি নিম্নলিখিত scenarios cover করে:

✓ Valid deposits and withdrawals
✓ Edge cases (zero, negative amounts)
✓ Insufficient funds
✓ Multiple transactions
✓ Getter/Setter methods
✓ Account initialization

## Total Test Cases: 17

সব test cases pass করলে আপনার BankAccount class সঠিকভাবে কাজ করছে!

## Dependencies

- JUnit 5.8.1 (Jupiter)
- Java 8 or higher

## Notes

- প্রথমবার run করার সময় IntelliJ IDEA automatically JUnit dependencies download করবে
- যদি কোনো error দেখায়, তাহলে project reimport করুন (File → Reload All from Disk)

