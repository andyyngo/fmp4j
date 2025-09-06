package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.types.FmpPeriod;
import dev.sorn.fmp4j.types.FmpSymbol;
import dev.sorn.fmp4j.types.FmpYear;
import java.io.Serial;
import java.time.LocalDate;

public record FmpIncomeStatementGrowth(
        FmpSymbol symbol,
        LocalDate date,
        FmpYear fiscalYear,
        FmpPeriod period,
        String reportedCurrency,
        Double growthRevenue,
        Double growthCostOfRevenue,
        Double growthGrossProfit,
        Double growthGrossProfitRatio,
        Double growthResearchAndDevelopmentExpenses,
        Double growthGeneralAndAdministrativeExpenses,
        Double growthSellingAndMarketingExpenses,
        Double growthOtherExpenses,
        Double growthOperatingExpenses,
        Double growthCostAndExpenses,
        Double growthInterestIncome,
        Double growthInterestExpense,
        Double growthDepreciationAndAmortization,
        Double growthEBITDA,
        Double growthOperatingIncome,
        Double growthIncomeBeforeTax,
        Double growthIncomeTaxExpense,
        Double growthNetIncome,
        Double growthEPS,
        Double growthEPSDiluted,
        Double growthWeightedAverageShsOut,
        Double growthWeightedAverageShsOutDil,
        Double growthEBIT,
        Double growthNonOperatingIncomeExcludingInterest,
        Double growthNetInterestIncome,
        Double growthTotalOtherIncomeExpensesNet,
        Double growthNetIncomeFromContinuingOperations,
        Double growthOtherAdjustmentsToNetIncome,
        Double growthNetIncomeDeductions)
        implements FmpModel {
    @Serial
    private static final long serialVersionUID = 1L;
}
