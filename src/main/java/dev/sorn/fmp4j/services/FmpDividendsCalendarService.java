package dev.sorn.fmp4j.services;

import static dev.sorn.fmp4j.json.FmpJsonUtils.typeRef;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpDividendsCalendar;
import java.util.Map;

public class FmpDividendsCalendarService extends FmpService<FmpDividendsCalendar[]> {
    public FmpDividendsCalendarService(FmpConfig cfg, FmpHttpClient http) {
        super(cfg, http, typeRef(FmpDividendsCalendar[].class));
    }

    @Override
    protected String relativeUrl() {
        return "/dividends-calendar";
    }

    @Override
    protected Map<String, Class<?>> requiredParams() {
        return Map.of();
    }

    @Override
    protected Map<String, Class<?>> optionalParams() {
        return Map.of();
    }
}
