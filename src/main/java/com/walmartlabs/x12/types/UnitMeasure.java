/**
Copyright (c) 2018-present, Walmart, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.walmartlabs.x12.types;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * unit or basis of measure code (x12 element 355)
 * set of values used on DEX G8303, ASN LIN08, INVOIC IT302, &c
 */
public enum UnitMeasure {
    BX("BOX"),
    CA("CASE"),
    CATCH_WEIGHT("CATCH_WEIGHT", "31"),
    CT("CARTON"),
    EA("EACH"),
    DZ("DOZEN"),
    GA("GALLON"),
    KE("KEG"),
    KG("KILOGRAM"),
    LB("POUND"),
    PK("PACKAGE"),
    PN("POUNDS_NET"),
    PL("PALLET"),
    TK("TANK"),
    UN("UNIT"),
    UNKNOWN("UNKNOWN");

    private String description;
    private final Optional<String> nonJavaName;

    // some values are not valid Java identifiers, so can't rely on native Java valueOf()
    private static Map<String, UnitMeasure> nameMap = new HashMap<>();

    private UnitMeasure(String desc) {
        this(desc, Optional.empty());
    }

    private UnitMeasure(String desc, String nonJavaName) {
        this(desc, Optional.of(nonJavaName));
    }

    private UnitMeasure(String desc, Optional<String> nonJavaName) {
        this.description = desc;
        this.nonJavaName = nonJavaName;
    }

    static {
        for (UnitMeasure m: UnitMeasure.values()) {
            nameMap.put(m.nonJavaName.orElse(m.name()), m);
        }
    }

    private void setDescription(String desc) {
        this.description = desc;
    }

    public String getDescription() {
        return this.description;
    }

    /**
     * Convert the code to an enum
     * 
     * @param code
     * @return
     */
    public static UnitMeasure convert(String code) {
        if (code == null) {
            return null;
        } else {
            return nameMap.getOrDefault(code, UnitMeasure.UNKNOWN);
        }
    }

}
