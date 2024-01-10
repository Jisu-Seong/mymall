package com.example.mallapi.util;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class JWTUtil {
    private static String key = "${jwt.secret.key}";

}
