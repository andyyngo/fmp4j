package dev.sorn.fmp4j.services;

import static dev.sorn.fmp4j.HttpClientStub.httpClientStub;
import static dev.sorn.fmp4j.TestUtils.assertAllFieldsNonNull;
import static dev.sorn.fmp4j.TestUtils.jsonTestResource;
import static dev.sorn.fmp4j.json.FmpJsonDeserializerImpl.FMP_JSON_DESERIALIZER;
import static java.util.stream.IntStream.range;
import static org.junit.jupiter.api.Assertions.assertEquals;

import dev.sorn.fmp4j.CashFlowStatementTestData;
import dev.sorn.fmp4j.HttpClientStub;
import dev.sorn.fmp4j.cfg.FmpConfigImpl;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.http.FmpHttpClientImpl;
import dev.sorn.fmp4j.models.FmpCashFlowStatement;
import java.util.Set;
import org.junit.jupiter.api.Test;

class FmpCashFlowStatementTtmServiceTest implements CashFlowStatementTestData {
    private final HttpClientStub httpStub = httpClientStub();
    private final FmpHttpClient http = new FmpHttpClientImpl(httpStub, FMP_JSON_DESERIALIZER);
    private final FmpService<FmpCashFlowStatement[]> service =
            new FmpCashFlowStatementTtmService(new FmpConfigImpl(), http);

    @Test
    void relative_url() {
        // when
        var relativeUrl = service.relativeUrl();

        // then
        assertEquals("/cash-flow-statement-ttm", relativeUrl);
    }

    @Test
    void required_params() {
        // when
        var params = service.requiredParams();

        // then
        assertEquals(Set.of("symbol"), params);
    }

    @Test
    void optional_params() {
        // when
        var params = service.optionalParams();

        // then
        assertEquals(Set.of("limit"), params);
    }

    @Test
    void successful_download() {
        // given
        var symbol = "AAPL";
        var limit = 2;
        service.param("symbol", symbol);
        httpStub.configureResponse()
                .body(jsonTestResource("stable/cash-flow-statement-ttm/?symbol=%s&limit=%d.json", symbol, limit))
                .statusCode(200)
                .apply();

        // when
        var result = service.download();

        // then
        assertEquals(limit, result.length);
        range(0, limit).forEach(i -> assertAllFieldsNonNull(result[i]));
    }
}
