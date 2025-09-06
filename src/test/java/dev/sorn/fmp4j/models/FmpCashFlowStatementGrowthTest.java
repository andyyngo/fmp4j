package dev.sorn.fmp4j.models;

import static dev.sorn.fmp4j.TestUtils.deserialize;
import static dev.sorn.fmp4j.TestUtils.serialize;
import static dev.sorn.fmp4j.TestUtils.verifySerialization;
import static org.junit.jupiter.api.Assertions.assertEquals;

import dev.sorn.fmp4j.CashFlowStatementGrowthTestData;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class FmpCashFlowStatementGrowthTest implements CashFlowStatementGrowthTestData {
    @Test
    void is_serializable() throws IOException, ClassNotFoundException {
        // given
        var before = aCashFlowStatementGrowth();

        // when
        var after = (FmpCashFlowStatementGrowth) deserialize(serialize(before));

        // then
        assertEquals(before, after);
    }

    @Test
    void serializes() throws IOException {
        // given
        var o = aCashFlowStatementGrowth();

        // when // then
        verifySerialization(o);
    }
}
