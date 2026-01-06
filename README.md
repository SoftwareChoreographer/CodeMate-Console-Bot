# CodeMate 🤖

**CodeMate** is a console-based Java chatbot designed to help beginners practice **Java programming and basic math** in a fun, interactive way.
It demonstrates **clean code, separation of concerns, and OOP principles**, making it a strong portfolio project for entry-level backend roles.

---

## 🚀 Features

* **Personalized interaction:** Prompts and messages include the user’s name.
* **Age Guessing Game:** Uses a math trick to guess the user’s age.
* **Counting Demo:** Counts from 0 up to any positive number entered by the user.
* **Programming Quiz:** Tests basic programming knowledge and tracks quiz score.
* **Menu-driven:** Easy-to-use menu for navigating features.

---

## 🏟️ Project Structure

```
bot/
 ├── CodeMate.java          # Main orchestrator class
 ├── services/
 │    ├── AgeGuessService.java
 │    ├── CountingService.java
 │    └── QuizService.java
 └── utils/
      └── InputHelper.java
```

* **bot:** Main entry point of the program.
* **services:** Each feature is in its own class (modular design).
* **utils:** Helper classes for reusable logic (like input handling).

---

## 💡 Key Concepts Demonstrated

* **Separation of concerns:** Each feature lives in its own service class.
* **Clean code practices:** Readable, maintainable, and professional code.
* **Object-oriented programming:** Non-static service methods, proper use of classes.
* **User interaction:** Personalized prompts and output messages.
* **Preparation for backend development:** The `main()` class orchestrates services like a controller.

---

## ⚙️ How to Run

1. Clone the repository:

```bash
git clone https://github.com/SoftwareChoreographer/CodeMate-Console-Bot.git
```

2. Open in your IDE (IntelliJ, VS Code, or Eclipse).
3. Build the project (Maven optional).
4. Run `CodeMate.java`.
5. Follow the on-screen prompts to interact with the bot.

---

## 🤚 Next Steps / Improvements

* Add **JUnit 5 tests** for each service to demonstrate testing skills.
* Extend bot with new features (e.g., additional quizzes, math games).
* Prepare for **Spring Boot** integration in the future.
* Enhance **user experience** with input validation and colored console output.

---

## 📝 License

This project is **open source** and free to use for learning and portfolio purposes.
