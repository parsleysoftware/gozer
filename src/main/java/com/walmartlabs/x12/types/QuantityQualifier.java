package com.walmartlabs.x12.types;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// EDI 673
public enum QuantityQualifier {
    ORIGINAL("ORIGINAL QUANTITY", "38"),
    SHIPPED("SHIPPED QUANTITY", "39"),
    UNKNOWN("UNKNOWN");

    private final String description;
    private final Optional<String> nonJavaName;

    // some values are not valid Java identifiers, so can't rely on native Java valueOf()
    private static final Map<String, QuantityQualifier> nameMap = new HashMap<>();

    private QuantityQualifier(String desc) {
        this(desc, Optional.empty());
    }

    private QuantityQualifier(String desc, String nonJavaName) {
        this(desc, Optional.of(nonJavaName));
    }

    private QuantityQualifier(String desc, Optional<String> nonJavaName) {
        this.description = desc;
        this.nonJavaName = nonJavaName;
    }

    public String getDescription() {
        return description;
    }

    static {
        for (QuantityQualifier q: QuantityQualifier.values()) {
            nameMap.put(q.nonJavaName.orElse(q.name()), q);
        }
    }

    /**
     * Convert the code to an enum
     *
     * @param code
     * @return
     */
    public static QuantityQualifier convert(String code) {
        if (code == null) {
            return null;
        } else {
            return nameMap.getOrDefault(code, QuantityQualifier.UNKNOWN);
        }
    }

}
