package bot.models;

/**
 * Represents the supported categories of questions
 * in the CodeMate application.
 * This enum is part of the domain layer and is used by:
 * - CSV loading
 * - QuestionFactory
 * - QuizService filtering
 */

public enum QuestionType {
    MATH,
    PROGRAMMING
}