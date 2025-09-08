package dev.sorn.fmp4j.clients;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.types.FmpApiKey;
import org.junit.jupiter.api.BeforeEach;

class FmpChartClientTest {
    private final FmpConfig cfg = mock(FmpConfig.class);
    private final FmpHttpClient http = mock(FmpHttpClient.class);
    private FmpChartClient client;

    @BeforeEach
    void setUp() {
        when(cfg.fmpApiKey()).thenReturn(new FmpApiKey("ABCDEf0ghIjklmNO1pqRsT2u34VWx5y6"));
        client = new FmpChartClient(cfg, http);
    }
}
