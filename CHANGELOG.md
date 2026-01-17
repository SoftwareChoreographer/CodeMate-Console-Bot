# Changelog

## [1.0.0] - 2026-01-07
### Added
- `calculateAge()` method in `AgeGuessService` for testable logic
- JUnit 5 tests for age calculation

### Changed
- Refactored `guessAge()` to separate user interaction from calculation
- Updated `CodeMate.java` to use the refactored AgeGuessService

### Notes
- Pure refactor, no functional changes for end-users
- Improves testability, maintainability, and code quality

## [1.1.0] - 2026-01-17
### Added
- `QuestionData`, `QuestionType`, `QuestionSource` for quiz abstraction
- `CsvQuestionSource` to read CSV questions
- `QuestionFactory` to generate MathQuestion & ProgrammingQuestion
- `QuizService` with randomization and 5-question limit per session
- 20 new quiz questions in CSV
- Unit tests for factory and service

### Changed
- Fixed mutable list issues for shuffle
- Updated QuizServiceTest to validate both Math and Programming questions

### Notes
- Prepares quiz system for API/DB expansion
- Fully tested and integrated with existing modules

