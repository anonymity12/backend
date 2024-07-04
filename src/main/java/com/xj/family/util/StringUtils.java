package com.xj.family.utils;

import java.util.Random;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 2022 12 31
 * 2024 06 27 add convertToPinyin
 */
public class StringUtils {
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static String convertToPinyin(String original) {
        char[] chars = original.toCharArray();
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        String[] converted;
        String ret = null;
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <chars.length; i++) {
                if (String.valueOf(chars[i]).matches("[\\u4E00-\\u9FA5]+")) {
                    converted = PinyinHelper.toHanyuPinyinStringArray(chars[i], format);
                    if (converted != null) {
                        sb.append(converted[0]);
                        continue;
                    }
                } else {
                    sb.append(chars[i]);
                }
            }
            ret = sb.toString();
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return ret;
    }
}
