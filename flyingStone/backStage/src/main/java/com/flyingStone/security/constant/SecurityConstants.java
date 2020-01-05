package com.flyingStone.security.constant;

public class SecurityConstants {
    public static final String LOGIN_URL = "/admin/login";
    public static final String REGISTER_URL = "/admin/register";
    public static final String DEFAULT_TARGET_URL = "/";
    public static final String LOGIN_TYPE = "REDIRECT";

    public static final String SECRET = "flyingstonesecretkeyflyingstonesecretkeyflyingstonesecretkeyflyingstonesecretkeyflyingstonesecretkeyflyingstonesecretkey";
    public static final long EXPIRATION_TIME = 28_800_000;
    public static final long VALIDATE_HOUR = 24;
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_TYPE = "JWT";

    public static final String ROLE_REFRESH_TOKEN = "ROLE_REFRESH_TOKEN";

    public static final String CLAIM_KEY_USER_ID = "userId";
    public static final String CLAIM_KEY_USER_NAME="username";
    public static final String CLAIM_KEY_EMAIL="email";
    public static final String CLAIM_KEY_AUTHORITIES = "authorities";

    public SecurityConstants() {
        throw new IllegalStateException("Cannot create instance of static util class");
    }
}
