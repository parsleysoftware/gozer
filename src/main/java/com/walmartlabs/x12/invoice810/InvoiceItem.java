package com.walmartlabs.x12.invoice810;

import com.walmartlabs.x12.common.segment.PO4ItemPhysicalDetail;

import java.math.BigDecimal;
import java.util.List;

public class InvoiceItem {

    // IT102
    private BigDecimal quantityInvoiced;

    //IT103
    private String unitOfMeasurement; // standard.elementTypes.QuantityQualifier

    // IT104
    private BigDecimal unitPrice;
    // CTP
    private BigDecimal netPrice;

    // IT105
    private String pricingUnit; // PE = each, PP = pound, UM = other unit of measure. should unitOfMeasurement?

    // IT06 and onwards are a bunch of product IDs with different qualifiers
    private List<ProductId> productIds;

    // QTY, IT3
    private List<Quantity> quantities;

    private List<TaxInfo> tax;

    private List<ServicePromotionAllowanceOrCharge> sac;

    // PID05
    private String productDescription;

    // PKG05
    private String packagingDescription;

    // PO4
    private PO4ItemPhysicalDetail packaging;

}
