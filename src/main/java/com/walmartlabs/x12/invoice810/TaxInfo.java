package com.walmartlabs.x12.invoice810;

import java.math.BigDecimal;

public class TaxInfo {
    // TXI01
    private String taxCode; // standard.elementTypes.TaxCode

    // TXI02
    private BigDecimal monetaryAmount;

    // TXI03
    private BigDecimal percent;
}
