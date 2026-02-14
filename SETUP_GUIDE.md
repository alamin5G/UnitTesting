# 🚀 Quick Setup Guide - Parameterized Testing

## ⚠️ যদি "Cannot resolve symbol 'params'" Error দেখায়

IntelliJ IDEA তে JUnit Parameterized Testing চালানোর জন্য নিচের steps follow করুন:

---

## 📦 Method 1: IntelliJ দিয়ে Automatically Add করুন (RECOMMENDED)

### Steps:
1. **BankAccountTest.java** file open করুন
2. যেকোনো red underlined import এ cursor রাখুন (যেমন: `ParameterizedTest`)
3. **Alt + Enter** press করুন
4. **"Add 'JUnit5.8.1' to classpath"** select করুন
5. **OK** button click করুন

✅ IntelliJ automatically library add করে দেবে!

---

## 🔧 Method 2: Project Structure থেকে Manually Add করুন

### Steps:
1. **File → Project Structure** (অথবা **Ctrl + Alt + Shift + S**)
2. **Modules** select করুন
3. **Dependencies** tab এ যান
4. **+ (Plus)** button → **JARs or directories** click করুন
5. নিচের JARs add করুন (IntelliJ Maven repository থেকে):
   - `junit-jupiter-api-5.8.1.jar`
   - `junit-jupiter-params-5.8.1.jar`
   - `junit-jupiter-engine-5.8.1.jar`
   - `junit-platform-commons-1.8.1.jar`

---

## 🔄 Method 3: Project Reload করুন

Sometimes IntelliJ cache issue হতে পারে। এই steps try করুন:

### Steps:
1. **File → Invalidate Caches / Restart**
2. **"Invalidate and Restart"** select করুন
3. IntelliJ restart হবে এবং project reload হবে

অথবা:

1. **File → Reload All from Disk**
2. Project reimport হবে

---

## 🏃 Method 4: Maven/Gradle Setup (Best Practice)

### যদি আপনার project Maven/Gradle use করে:

#### **Maven (pom.xml):**
```xml
<dependencies>
    <!-- JUnit 5 -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.8.1</version>
        <scope>test</scope>
    </dependency>
    
    <!-- JUnit 5 Parameterized Tests -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-params</artifactId>
        <version>5.8.1</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

#### **Gradle (build.gradle):**
```gradle
dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter:5.8.1'
    testImplementation 'org.junit.jupiter:junit-jupiter-params:5.8.1'
}

test {
    useJUnitPlatform()
}
```

---

## ✅ Verify Setup

Setup সঠিক হয়েছে কিনা check করার জন্য:

1. **BankAccountTest.java** open করুন
2. এই imports গুলো green হয়ে যাবে (no red underlines):
   ```java
   import org.junit.jupiter.params.ParameterizedTest;
   import org.junit.jupiter.params.provider.CsvSource;
   import org.junit.jupiter.params.provider.ValueSource;
   ```

3. Right-click on test class → **Run 'BankAccountTest'**
4. সব tests green checkmark দেখাবে! ✅

---

## 🎯 Quick Test Run

Setup complete হলে:

1. **Right-click** on `BankAccountTest.java`
2. **Run 'BankAccountTest'**
3. IntelliJ এর **Run window** open হবে
4. **36 tests** run হবে এবং results দেখাবে:

```
✓ 7 regular tests
✓ 29 parameterized tests (5+5+5+5+5+4)
━━━━━━━━━━━━━━━━━━━━━━
✓ Total: 36 tests passed
```

---

## 🐛 Common Issues & Solutions

### Issue 1: "Cannot resolve symbol 'params'"
**Solution:** Method 1 follow করুন (Alt + Enter → Add to classpath)

### Issue 2: "Test not found"
**Solution:** Project reload করুন (File → Reload All from Disk)

### Issue 3: JUnit 4 conflict
**Solution:** Make sure শুধু JUnit 5 libraries আছে, JUnit 4 remove করুন

### Issue 4: Tests don't run
**Solution:** 
- Make sure `test` folder is marked as **Test Sources Root**
- Right-click `test` folder → **Mark Directory as** → **Test Sources Root**

---

## 📚 Next Steps

1. ✅ Setup complete করুন
2. ✅ Tests run করুন
3. ✅ **PARAMETERIZED_TESTING_GUIDE.md** পড়ুন detailed examples এর জন্য
4. ✅ নিজের custom parameterized tests লিখুন!

---

**Happy Testing! 🎉**

