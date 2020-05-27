package com.walmartlabs.x12.common.segment.parser;

import com.walmartlabs.x12.X12Segment;
import com.walmartlabs.x12.common.segment.PO4ItemPhysicalDetail;
import com.walmartlabs.x12.types.UnitMeasure;
import com.walmartlabs.x12.types.WeightQualifier;
import com.walmartlabs.x12.util.ConversionUtil;

public class PO4ItemPhysicalDetailParser {

    /**
     * parse the segment
     * @param segment
     * @return
     */
    public static PO4ItemPhysicalDetail parse(X12Segment segment) {
        PO4ItemPhysicalDetail pid = null;

        if (segment != null) {
            String segmentIdentifier = segment.getIdentifier();
            if (PO4ItemPhysicalDetail.IDENTIFIER.equals(segmentIdentifier)) {
                pid = new PO4ItemPhysicalDetail();
                pid.setPack(ConversionUtil.convertStringToInteger(segment.getElement(1)));
                pid.setSize(ConversionUtil.convertStringToBigDecimal(segment.getElement(2), 0));
                pid.setSizeUnit(UnitMeasure.convert(segment.getElement(3)));

                pid.setWeightQualifier(WeightQualifier.convert(segment.getElement(5)));

                pid.setPackWeight(ConversionUtil.convertStringToBigDecimal(segment.getElement(6), 0));
                pid.setPackWeightUnit(UnitMeasure.convert(segment.getElement(7)));

                pid.setPackVolume(ConversionUtil.convertStringToBigDecimal(segment.getElement(8), 0));
                pid.setPackVolumeUnit(UnitMeasure.convert(segment.getElement(9)));

                pid.setLength(ConversionUtil.convertStringToBigDecimal(segment.getElement(10), 0));
                pid.setWidth(ConversionUtil.convertStringToBigDecimal(segment.getElement(11), 0));
                pid.setHeight(ConversionUtil.convertStringToBigDecimal(segment.getElement(12), 0));
                pid.setDimensionsUnit(UnitMeasure.convert(segment.getElement(13)));

                pid.setInnerPack(ConversionUtil.convertStringToInteger(segment.getElement(14)));
            }
        }
        return pid;
    }

    private PO4ItemPhysicalDetailParser() {
        // you can't make me
    }
}
