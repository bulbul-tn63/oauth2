package com.tnpay.userservice.constant;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ApplicationConstant {
    public static final String TRACE_ID = "traceId";
    public static final String ERROR_CODE_JSON_FILE_NAME = "error_code.json";
    public static final String VALID_PASSWORD_REGEX = "^((((?=.*?[A-Z])|(?=.*?[a-z]))(?=.*?[0-9]))" +
            "|((?=.*?[0-9])(?=.*?[!#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]))|" +
            "((?=.*?[!#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~])((?=.*?[A-Z])|(?=.*?[a-z])))).{8,256}$";
    public static final String EMAIL_VALIDATION_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    public static final String MOBILE_VALIDATION_REGEX = "(?:\\+88|88)?(01[3-9]\\d{8})";
    public static final String MESSAGE_SEPARATOR = "###";
    public static String SUCCESSFULLY_LOGOUT = "successfully logout";
    public static final int FIRST_INDEX = 0;
    public static final String EMPTY_STRING = "";
    public static final String BEARER = "Bearer ";
    public static final String AUTHORIZATION = "Authorization";
    public static final String ACTIVE_STATUS_CHANGED_SUCCESSFULLY_MESSAGE = "Active Status Changed Successfully";
    public static final int DEFAULT_PAGE_SIZE = 20;
    public static final String DEFAULT_SORT = "id";
    public static final String SORT_BY_COUNTRY = "country";
    public static final int UPPER_CASE_LETTER_START_FORM = 65;
    public static final int UPPER_CASE_LETTER_END_TO = 90;
    public static final int LOWER_CASE_LETTER_START_FORM = 97;
    public static final int LOWER_CASE_LETTER_END_TO = 122;
    public static final String MINIMUM_VALUE_FOR_EXCHANGE_RATE = "0.0000000001";
    public static final String AWS_BUCKET_PROP_KEY = "aws.s3.bucket";
    public static final String AWS_S3_BASE_URL_PROP_KEY = "aws.s3.base.url";
    public static final String HTTPS_PROTOCOL = "https://";
    public static final String DOT_SEPARATOR = ".";
    public static final String SPRING_HTTP_MULTIPART_MAX_FILE_SIZE_PROP_KEY = "spring.http.multipart.max-file-size";
    public static final String FILE_SEPARATOR = "/";
    public static final String IMAGE_FILE_NOT_FOUND_EN_PROP_KEY = "image.file.not.found.ln.eng";
    public static final String IMAGE_FILE_HAS_BEEN_DELETED_EN_PROP_KEY = "image.file.deleted.ln.eng";
    public static final String UNDERSCORE_SEPARATOR = "_";
    public static final String WHITE_SPACE = " ";
    public static final String IMAGE_FILE_FAILED_TO_DELETE_EN_PROP_KEY = "image.file.failed.to.delete.ln.eng";
    public static final String APPLICATION_SIGN_IN_URL = "application.url.sign-in";
    public static final String MINIMUM_EXCHANGE_RATE = "0";
    public static final String[] WILD_CARD_URLS = new String[]{
            "/p/api/auth/signin",
            "/p/api/auth/refresh/token",
            "/p/api/auth/check-token",
            "/swagger-resources",
            "/swagger-resources/",
            "/swagger-ui.html",
            "/swagger-ui/",
            "/p/api/brac/receipt",
            "/p/api/brac/refund",
    };
    public static final Integer SUPER_ADMIN_ROLE_ID = 1;
    public static Map<Integer, Set<Integer>> roleMap = new HashMap<>();
    public static final Integer DEFAULT_PERMISSION_ID = 0;
    public static final String JASPER_REPORT_BASE_PATH = "jasper_template/";
    public static final String PAYMENT_HISTORY_FILE_NAME = "payment_history.jrxml";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String CHARSET_UTF_8 = " charset=UTF-8";
    public static final String SEMICOLON = ";";
    public static final String FILE_TYPE_XLSX = "xlsx";
    public static final String FILE_TYPE_PDF = "pdf";
    public static final String CONTENT_TYPE_APPLICATION_PDF = "application/pdf";
    public static final String CONTENT_TYPE_SPREED_SHEET = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    public static final String ACCESS_RIGHTS_FILE_PATH = "access_rights.json";
    public static final String AWS_BUCKET_SECRET_KEY = "JhEaPwplxJHz/6LCMFWsK6t/NVjfYvvEtq5h7Vjt";
    public static final String AWS_BUCKET_ACCESS_KEY = "AKIARL5XEC3Y6JMONY7J";
    public static final String API_MAP_FILE_PATH = "api_map.json";
    public static final String VALID_JWT = "This is  a valid jwt token";
    public static final String BANGLADESH_COUNTRY_CODE = "BD";
    public static final String REST_API_MAX_RETRY_PROP_KEY  = "rest.api.max.retry";
    public static final String REQUEST_DELAY_PROPERTY_KEY = "request.delay";
    public static final String BD_CURRENCY_CODE = "050";
    public static final String BEARER_TOKEN  = "Bearer ";
    public static final Integer ZERO = 0;
    public static final String MERCHANT_ID = "merchantId";
}
