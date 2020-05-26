package com.walmartlabs.x12.invoice810;

import com.walmartlabs.x12.AbstractX12TransactionSet;
import com.walmartlabs.x12.common.segment.DTMDateTimeReference;
import com.walmartlabs.x12.common.segment.N1PartyIdentification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class InvoiceTransactionSet extends AbstractX12TransactionSet {
    //
    // BIG
    //
    // BIG 01
    private LocalDate invoiceDate;
    // BIG 02
    private String invoiceNumber;
    // BIG 03
    private LocalDate purchaseOrderDate;
    // BEG 04
    private String purchaseOrderNumber;

    private Map<String, String> notes;

    private List<N1PartyIdentification> n1PartyIdentifications;

    // CUR 02
    private String currency;

    // DTM with qualifier 011
    public DTMDateTimeReference getShippedDate() {
        return dtms.stream()
                .filter(dtm -> Objects.equals(dtm.getDateTimeQualifier(), "011"))
                .findFirst().orElse(null);
    };

    public DTMDateTimeReference getDeliveredDateDate() {
        return dtms.stream()
                .filter(dtm -> Objects.equals(dtm.getDateTimeQualifier(), "035"))
                .findFirst().orElse(null);
    }
    // DTM with qualifier 035
    // other DTMs
    private List<DTMDateTimeReference> dtms = new ArrayList<>();

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public LocalDate getPurchaseOrderDate() {
        return purchaseOrderDate;
    }

    public void setPurchaseOrderDate(LocalDate purchaseOrderDate) {
        this.purchaseOrderDate = purchaseOrderDate;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }
}
