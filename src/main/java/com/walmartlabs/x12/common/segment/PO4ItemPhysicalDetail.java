package com.walmartlabs.x12.common.segment;

import com.walmartlabs.x12.types.UnitMeasure;
import com.walmartlabs.x12.types.WeightQualifier;

import java.math.BigDecimal;

/**
 *
 * Purpose: To specify the physical qualities, packaging, weights, and
 * dimensions relating to the item
 */
public class PO4ItemPhysicalDetail {

    public static final String IDENTIFIER = "PO4";

    // PO401
    private Integer pack; // number of inner containers, or number of eaches if no inner container, per outer container
    // PO402
    private BigDecimal size; // size of supplier unit
    // PO403
    private UnitMeasure sizeUnit;
    // PO405
    private WeightQualifier weightQualifier;
    // PO406
    private BigDecimal packWeight;
    // PO407
    private UnitMeasure packWeightUnit;
    // PO408
    private BigDecimal packVolume;
    // PO409
    private UnitMeasure packVolumeUnit;
    // PO410
    private BigDecimal length;
    // PO411
    private BigDecimal width;
    // PO412
    private BigDecimal height;
    // PO413
    private UnitMeasure dimensionsUnit;
    // PO414
    private Integer innerPack; // number of eaches per inner container, if exists

    public Integer getPack() {
        return pack;
    }

    public void setPack(Integer pack) {
        this.pack = pack;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public UnitMeasure getSizeUnit() {
        return sizeUnit;
    }

    public void setSizeUnit(UnitMeasure sizeUnit) {
        this.sizeUnit = sizeUnit;
    }

    public WeightQualifier getWeightQualifier() {
        return weightQualifier;
    }

    public void setWeightQualifier(WeightQualifier weightQualifier) {
        this.weightQualifier = weightQualifier;
    }

    public BigDecimal getPackWeight() {
        return packWeight;
    }

    public void setPackWeight(BigDecimal packWeight) {
        this.packWeight = packWeight;
    }

    public UnitMeasure getPackWeightUnit() {
        return packWeightUnit;
    }

    public void setPackWeightUnit(UnitMeasure packWeightUnit) {
        this.packWeightUnit = packWeightUnit;
    }

    public BigDecimal getPackVolume() {
        return packVolume;
    }

    public void setPackVolume(BigDecimal packVolume) {
        this.packVolume = packVolume;
    }

    public UnitMeasure getPackVolumeUnit() {
        return packVolumeUnit;
    }

    public void setPackVolumeUnit(UnitMeasure packVolumeUnit) {
        this.packVolumeUnit = packVolumeUnit;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public UnitMeasure getDimensionsUnit() {
        return dimensionsUnit;
    }

    public void setDimensionsUnit(UnitMeasure dimensionsUnit) {
        this.dimensionsUnit = dimensionsUnit;
    }

    public Integer getInnerPack() {
        return innerPack;
    }

    public void setInnerPack(Integer innerPack) {
        this.innerPack = innerPack;
    }
}
