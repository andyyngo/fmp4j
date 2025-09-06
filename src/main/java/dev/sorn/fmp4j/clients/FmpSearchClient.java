package dev.sorn.fmp4j.clients;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpSearchByCik;
import dev.sorn.fmp4j.models.FmpSearchByCusip;
import dev.sorn.fmp4j.models.FmpSearchByIsin;
import dev.sorn.fmp4j.models.FmpSearchByName;
import dev.sorn.fmp4j.models.FmpSearchBySymbol;
import dev.sorn.fmp4j.services.FmpSearchByCikService;
import dev.sorn.fmp4j.services.FmpSearchByCusipService;
import dev.sorn.fmp4j.services.FmpSearchByIsinService;
import dev.sorn.fmp4j.services.FmpSearchByNameService;
import dev.sorn.fmp4j.services.FmpSearchBySymbolService;
import dev.sorn.fmp4j.services.FmpService;
import dev.sorn.fmp4j.types.FmpCik;
import dev.sorn.fmp4j.types.FmpCusip;
import dev.sorn.fmp4j.types.FmpIsin;
import dev.sorn.fmp4j.types.FmpSymbol;

public class FmpSearchClient {

    // Alphabetical order
    protected final FmpService<FmpSearchByCik[]> fmpSearchByCikService;
    protected final FmpService<FmpSearchByCusip[]> fmpSearchByCusipService;
    protected final FmpService<FmpSearchByIsin[]> fmpSearchByIsinService;
    protected final FmpService<FmpSearchByName[]> fmpSearchByNameService;
    protected final FmpService<FmpSearchBySymbol[]> fmpSearchBySymbolService;

    public FmpSearchClient(FmpConfig fmpConfig, FmpHttpClient fmpHttpClient) {
        this.fmpSearchByCikService = new FmpSearchByCikService(fmpConfig, fmpHttpClient);
        this.fmpSearchByCusipService = new FmpSearchByCusipService(fmpConfig, fmpHttpClient);
        this.fmpSearchByIsinService = new FmpSearchByIsinService(fmpConfig, fmpHttpClient);
        this.fmpSearchByNameService = new FmpSearchByNameService(fmpConfig, fmpHttpClient);
        this.fmpSearchBySymbolService = new FmpSearchBySymbolService(fmpConfig, fmpHttpClient);
    }

    public synchronized FmpSearchByCik[] byCik(FmpCik cik) {
        fmpSearchByCikService.param("cik", cik);
        return fmpSearchByCikService.download();
    }

    public synchronized FmpSearchByCusip[] byCusip(FmpCusip cusip) {
        fmpSearchByCusipService.param("cusip", cusip);
        return fmpSearchByCusipService.download();
    }

    public synchronized FmpSearchByIsin[] byIsin(FmpIsin isin) {
        fmpSearchByIsinService.param("isin", isin);
        return fmpSearchByIsinService.download();
    }

    public synchronized FmpSearchByName[] byName(String query) {
        fmpSearchByNameService.param("query", query);
        return fmpSearchByNameService.download();
    }

    public synchronized FmpSearchBySymbol[] bySymbol(FmpSymbol query) {
        fmpSearchBySymbolService.param("query", query);
        return fmpSearchBySymbolService.download();
    }
}
