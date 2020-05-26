package com.walmartlabs.x12.invoice810;

import com.walmartlabs.x12.X12Segment;
import com.walmartlabs.x12.types.QuantityQualifier;
import com.walmartlabs.x12.types.UnitMeasure;
import com.walmartlabs.x12.util.ConversionUtil;

import java.math.BigDecimal;

public class Quantity {
    static public String IDENTIFIER = "QTY";
    static public String IT3_IDENTIFIER = "IT3";

    // QTY01, or 39 for IT3 segments
    private QuantityQualifier qualifier;

    // QTY02, IT301
    private BigDecimal quantity;

    // QTY03-01, IT302
    private UnitMeasure unitOfMeasurement;

    static Quantity parseQTY(X12Segment segment) {
        Quantity q = null;

        if (segment != null && Quantity.IDENTIFIER.equals(segment.getIdentifier())) {
            q = new Quantity();

            q.qualifier = QuantityQualifier.convert(segment.getElement(1));
            q.quantity = ConversionUtil.convertStringToBigDecimal(segment.getElement(2), 0);
            // ignoring the composite nature of element 3; haven't seen it used in the wild, and
            // Gozer plumbing doesn't support it
            q.unitOfMeasurement = UnitMeasure.convert(segment.getElement(3));
        }

        return q;
    }

    static Quantity parseIT3(X12Segment segment) {
        Quantity q = null;

        if (segment != null && Quantity.IT3_IDENTIFIER.equals(segment.getIdentifier())) {
            q = new Quantity();

            q.qualifier = QuantityQualifier.SHIPPED;
            q.quantity = ConversionUtil.convertStringToBigDecimal(segment.getElement(1), 0);
            q.unitOfMeasurement = UnitMeasure.convert(segment.getElement(2));
        }

        return q;
    }
}
