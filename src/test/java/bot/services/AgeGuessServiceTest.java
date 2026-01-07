package bot.services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AgeGuessServiceTest {

    AgeGuessService ageGuessService = new AgeGuessService();

    @Test
    void testGuessAgeCalculation() {

        int expectedAge = 52; // example expected value
        int actualAge = ageGuessService.calculateAge(1, 2, 3);

        // Check if the calculation is correct
        assertEquals(expectedAge, actualAge, "The guessed age should match the expected calculation");
    }

    @Test
    void testAnotherAgeScenario() {

        int expectedAge = 23;
        int actualAge = ageGuessService.calculateAge(2, 3, 2);

        assertEquals(expectedAge, actualAge, "The guessed age should match the expected calculation");
    }
}
