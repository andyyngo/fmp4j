package dev.sorn.fmp4j.services;

import static dev.sorn.fmp4j.json.FmpJsonUtils.typeRef;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpIposDisclosure;
import java.time.LocalDateTime;
import java.util.Map;

public class FmpIposDisclosureService extends FmpService<FmpIposDisclosure[]> {
    public FmpIposDisclosureService(FmpConfig cfg, FmpHttpClient http) {
        super(cfg, http, typeRef(FmpIposDisclosure[].class));
    }

    @Override
    protected String relativeUrl() {
        return "/ipos-disclosure";
    }

    @Override
    protected Map<String, Class<?>> requiredParams() {
        return Map.of();
    }

    @Override
    protected Map<String, Class<?>> optionalParams() {
        return Map.of("from", LocalDateTime.class, "to", LocalDateTime.class);
    }
}
