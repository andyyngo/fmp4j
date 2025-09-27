package dev.sorn.fmp4j.types;

import static dev.sorn.fmp4j.types.FmpIndustry.industry;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import dev.sorn.fmp4j.exceptions.FmpInvalidIndustryException;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class FmpIndustryTest {

    // --- Parameterized test with all industries ---
    @ParameterizedTest(name = "industry should resolve correctly for {0}")
    @MethodSource("allIndustryLabels")
    void testAllIndustries(String label) {
        FmpIndustry industry = industry(label);
        assertEquals(label, industry.value(), "Industry enum should map back to the same label");
    }

    static Stream<String> allIndustryLabels() {
        return Stream.of(FmpIndustry.values()).map(FmpIndustry::value);
    }

    // --- Some invalid checks ---
    @Test
    @DisplayName("industry throws exception for invalid inputs")
    void testInvalidIndustries() {
        Executable invalid1 = () -> industry("NotAnIndustry");
        Executable invalid2 = () -> industry("Steeel"); // typo
        Executable invalid3 = () -> industry("");

        assertAll(
                () -> assertThrows(FmpInvalidIndustryException.class, invalid1),
                () -> assertThrows(FmpInvalidIndustryException.class, invalid2),
                () -> assertThrows(FmpInvalidIndustryException.class, invalid3));
    }
}
