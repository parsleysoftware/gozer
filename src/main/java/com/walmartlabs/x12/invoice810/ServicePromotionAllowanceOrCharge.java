package com.walmartlabs.x12.invoice810;

import java.math.BigDecimal;

public class ServicePromotionAllowanceOrCharge {
    // SAC01
    private String allowanceOrChargeIndicator; // Allowance/charge indicator
    // SAC02
    private String sacCode; // standard.elementTypes.SACCode
    // SAC05
    private BigDecimal amount;
    // SAC15
    private String description;
}
