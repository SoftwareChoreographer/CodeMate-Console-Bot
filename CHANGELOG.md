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
