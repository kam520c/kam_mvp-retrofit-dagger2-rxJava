package com.kammvp.utils;


import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputUtils {
    private static boolean isMobileNumber(String mobile) {
        Pattern p = Pattern.compile("^0?(13[0-9]|15[012356789]|18[0-9]|14[57]|17[0678])[0-9]{8}$");
        Matcher m = p.matcher(mobile);
        return m.matches();
    }

    public static boolean verifyMobile(String username) {
        return !(TextUtils.isEmpty(username) || username.length() != 11 || !isMobileNumber(username));
    }

    public static boolean verifyUserName(String username) {
        return !(TextUtils.isEmpty(username) || username.length() > 7);
    }

    public static boolean verifyPassword(String password) {
        return !(TextUtils.isEmpty(password) || password.length() < 6 || password.length() > 20);
    }

    public static boolean verifyCaptcha(String captcha) {
        return !(TextUtils.isEmpty(captcha) || captcha.length() != 4);
    }
}
