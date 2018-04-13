package br.com.middleware.integration.api.logger;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public final class EncodeUtils {
    private static final String UTF_8 = "UTF-8";

    public EncodeUtils() {
    }

    public static String decode(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException var2) {
            throw new RuntimeException(var2);
        }
    }
}
