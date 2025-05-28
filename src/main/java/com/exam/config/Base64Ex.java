package com.exam.config;

import java.util.Base64;

public class Base64Ex {
    public static String encode(byte[] input) {
        return Base64.getEncoder().encodeToString(input);
    }

    public static byte[] decode(String input) {
        return Base64.getDecoder().decode(input);
    }
}

