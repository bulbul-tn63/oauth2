package com.tnpay.userservice.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.tnpay.userservice.constant.ApplicationConstant.*;

public class StringUtil {

    public static String valueOf(Object value) {
        return Objects.isNull(value) ? null : String.valueOf(value);
    }

    public static String generateRandomPassword() {
        String upperCaseLetters = RandomStringUtils
                .random(2, UPPER_CASE_LETTER_START_FORM, UPPER_CASE_LETTER_END_TO, true, true);
        String lowerCaseLetters = RandomStringUtils
                .random(2, LOWER_CASE_LETTER_START_FORM, LOWER_CASE_LETTER_END_TO, true, true);
        String numbers = RandomStringUtils.randomNumeric(2);

        String totalChars = RandomStringUtils.randomAlphanumeric(2);

        String combinedChars = upperCaseLetters.concat(lowerCaseLetters)
                .concat(numbers)
                .concat(totalChars);

        List<Character> pwdChars = combinedChars.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        Collections.shuffle(pwdChars);

        String password = pwdChars.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        return password;
    }

}
