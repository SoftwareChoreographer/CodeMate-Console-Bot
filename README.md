# CodeMate 🤖

**CodeMate** is a console-based Java chatbot designed to provide an engaging and interactive way to practice **Java programming** and **basic math**. Developed with a focus on **clean code**, **modular design**, and **object-oriented principles**, it serves as both an educational tool and a flexible foundation for building interactive Java console applications.

---

## 🚀 Features

CodeMate delivers a variety of fun, interactive features:

- **Personalized Interaction:** The bot offers a friendly and customized experience by addressing users by name.
- **Age Guessing Game:** Demonstrates a clever math trick to accurately guess the user's age.
- **Counting Demonstration:** Counts from 0 to any positive number entered, showcasing iterative loops in action.
- **Programming Quiz:** Tests basic programming knowledge and tracks the user's score to encourage learning.
- **Menu-Driven Interface:** Intuitive navigation through interactive menus ensures a smooth user experience.

---

## 🧩 Project Architecture

CodeMate is built with a clear focus on modularity and separation of concerns, adhering to principles of maintainability and extendability.

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

### Key Components
- **Main Orchestrator (`CodeMate.java`):** Acts as the controller, integrating all the services and managing the program flow.
- **Feature Services (`services/`):** Each feature is implemented in a dedicated service class:
  - `AgeGuessService.java`: Encapsulates the logic for the age guessing game.
  - `CountingService.java`: Manages the counting functionality.
  - `QuizService.java`: Handles the interactive programming quiz.
- **Utility Classes (`utils/InputHelper.java`):** Provides reusable methods for reading and validating user input.

### Highlights:
- **Design Patterns:** The modular architecture ensures maintainability and makes adding new features seamless.
- **Structured Workflow:** Each service encapsulates its logic, following the **single responsibility principle**.

---

## 💡 Concepts Demonstrated

CodeMate was designed to showcase several fundamental software design principles and practices:

- **Clean Code Practices:** Readable, maintainable, and professional code following best practices.
- **Separation of Concerns:** Isolates features into dedicated service classes, ensuring a modular design.
- **Object-Oriented Programming (OOP):**
  - Encapsulation: All services encapsulate their logic.
  - Abstraction: Simplified interface for interacting with complex logic.
  - Reusability: Utilities like `InputHelper` reduce code duplication.
- **Scalable Design:** A modular structure that can be extended with minimal changes.
- **User Interaction:** Delivers a smooth and intuitive user experience through personalized prompts and meaningful feedback.

---

## 🎨 Visuals

### Flow Diagram:
Below is a simplified diagram of how the classes interact:
```
             +----------------------+
             |    CodeMate.java     |
             |   (Main Orchestrator)| 
             +-----------+----------+
                         |
   +----------------+----+----+----------------+
   |                |         |                |
   v                v         v                v
 AgeGuessService CountingService QuizService InputHelper
```

### Demo Screenshot:
_A screenshot of the bot interacting with the user in the terminal can be added here._

--- 

## ⚙️ Getting Started

Follow these steps to set up and run CodeMate on your local machine.

### 1. Clone the Repository
```bash
git clone https://github.com/SoftwareChoreographer/CodeMate-Console-Bot.git
```

### 2. Open in Your Preferred IDE
Use **IntelliJ IDEA**, **Eclipse**, or **VS Code**.

### 3. Build the Project
Depending on your setup, you may build the project using:
- Default IDE build tool
- Maven (optional)

### 4. Run the Application
Execute the `CodeMate.java` class to start the bot.

### 5. Interact with CodeMate
Follow the interactive menu to explore its features. Test the programming quiz, enjoy the math games, and have fun.

---

## 🔍 Testing

### Future Testing Plans:
- Add **JUnit 5** unit tests for each service to demonstrate robust testing coverage.
- Current roadmap includes writing tests for:
  - AgeGuessService (Edge cases for the math trick)
  - InputHelper (Handling invalid and corner case inputs)

---

## 🔮 Future Enhancements

There’s tremendous potential to expand CodeMate, such as:

1. **Additional Features:**
   - Introduce more quizzes (e.g., general knowledge or advanced Java).
   - Add math puzzles and educational challenges.

2. **Testing Coverage:**
   - Integrate **JUnit 5** unit tests to verify service logic and edge cases.

3. **Enhanced User Interface:**
   - Add basic **console styling** (e.g., colored output for headers and highlights).
   - Implement **input validation** for better error handling.

4. **Spring Boot Integration:**
   - Adapt CodeMate into a web-based quiz bot or backend system prototype.

5. **Multilingual Support:**
   - Expand the bot to handle multiple languages (e.g., English, Spanish).

---

## 📝 License

This project is licensed under an **open-source license** and is free to use for learning and personal development.

---

## 🌟 Contributing

Contributions are welcome! If you have ideas for new features, testing improvements, or any enhancements, feel free to fork this repository and submit a pull request.

---

**Enjoy your journey with CodeMate!**
