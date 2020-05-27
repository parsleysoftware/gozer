package com.walmartlabs.x12.invoice810;

import com.walmartlabs.x12.X12ParsingUtil;
import com.walmartlabs.x12.X12Segment;
import com.walmartlabs.x12.X12TransactionSet;
import com.walmartlabs.x12.exceptions.X12ParserException;
import com.walmartlabs.x12.standard.X12Group;
import com.walmartlabs.x12.standard.txset.AbstractTransactionSetParserChainable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class Invoice810Parser extends AbstractTransactionSetParserChainable {

    private static final Logger LOGGER = LoggerFactory.getLogger(Invoice810Parser.class);

    public static final String INVOICE_TRANSACTION_TYPE = "810";
    public static final String INVOICE_TRANSACTION_HEADER = "BIG";
    public static final String INVOICE_TRANSACTION_TOTALS = "CTT";

    @Override
    protected boolean handlesTransactionSet(List<X12Segment> transactionSegments, X12Group x12Group) {
        return X12ParsingUtil.verifyTransactionSetType(transactionSegments, INVOICE_TRANSACTION_TYPE);
    }

    @Override
    protected X12TransactionSet doParse(List<X12Segment> transactionSegments, X12Group x12Group) {
        InvoiceTransactionSet tx = null;

        if (!CollectionUtils.isEmpty(transactionSegments)) {
            tx = new InvoiceTransactionSet();
            this.parseSegments(transactionSegments, tx);
        }

        return tx;
    }

    private void parseSegments(List<X12Segment> transactionSegments, InvoiceTransactionSet tx) {
        Stream<X12Segment> segmentStream = transactionSegments.stream();
        try {
            this.parseTransactionSetHeader(it.next(), tx);
            this.parseBeginningInvoiceSegment(it.next());

        } catch (NoSuchElementException e) {
            throw new X12ParserException("810 Invoice message ended prematurely");
        }

        // TODO: skip through



        //
        // ST
        //
        X12Segment currentSegment = transactionSegments.get(0);
        this.parseTransactionSetHeader(currentSegment, tx);

    }
}
