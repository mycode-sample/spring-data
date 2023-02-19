package com.wrotecode.springdata.util;

import java.util.UUID;

public class IdUtil {
    public static String nextId() {
        return UUID.randomUUID().toString().replace("-","");
    }
}
