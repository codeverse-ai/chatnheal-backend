package com.chatnheal.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ZodiacUtil {
    public static String getZodiacSign(String dob) {
        LocalDate date = LocalDate.parse(dob, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();

        return switch (month) {
            case 1  -> (day < 20) ? "Capricorn" : "Aquarius";
            case 2  -> (day < 19) ? "Aquarius" : "Pisces";
            case 3  -> (day < 21) ? "Pisces" : "Aries";
            case 4  -> (day < 20) ? "Aries" : "Taurus";
            case 5  -> (day < 21) ? "Taurus" : "Gemini";
            case 6  -> (day < 21) ? "Gemini" : "Cancer";
            case 7  -> (day < 23) ? "Cancer" : "Leo";
            case 8  -> (day < 23) ? "Leo" : "Virgo";
            case 9  -> (day < 23) ? "Virgo" : "Libra";
            case 10 -> (day < 23) ? "Libra" : "Scorpio";
            case 11 -> (day < 22) ? "Scorpio" : "Sagittarius";
            case 12 -> (day < 22) ? "Sagittarius" : "Capricorn";
            default -> "Unknown";
        };
    }
}
