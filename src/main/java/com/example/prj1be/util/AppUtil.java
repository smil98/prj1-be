package com.example.prj1be.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class AppUtil {
    public static String getAgo(LocalDateTime a, LocalDateTime b) {
        if(a.isBefore(b.minusYears(1))) {
            Period between = Period.between(a.toLocalDate(), b.toLocalDate());
            return between.get(ChronoUnit.YEARS) + " years ago";
        } else if (a.isBefore(b.minusMonths(1))) {
            Period between = Period.between(a.toLocalDate(), b.toLocalDate());
            return between.get(ChronoUnit.MONTHS) + " months ago";
        } else if (a.isBefore(b.minusDays(1))) {
            Period between = Period.between(a.toLocalDate(), b.toLocalDate());
            return between.get(ChronoUnit.DAYS) + " days ago";
        } else if (a.isBefore(b.minusHours(1))) {
            Duration between = Duration.between(a,b);
            return (between.getSeconds() / 60 / 60) + " hours ago";
        } else if (a.isBefore(b.minusMinutes(1))) {
            Duration between = Duration.between(a,b);
            return (between.getSeconds() / 60) + " minutes ago";
        } else {
            Duration between = Duration.between(a,b);
            return between.getSeconds() + " seconds ago";
        }
    }
}
