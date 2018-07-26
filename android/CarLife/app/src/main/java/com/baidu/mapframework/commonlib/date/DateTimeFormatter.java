package com.baidu.mapframework.commonlib.date;

import com.baidu.navisdk.util.statistic.datacheck.regular.Regular;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class DateTimeFormatter {
    /* renamed from: a */
    private static final String f18951a = "|";
    /* renamed from: b */
    private static final Pattern f18952b = Pattern.compile("\\|[^\\|]*\\|");
    /* renamed from: c */
    private static final String f18953c = "YYYY";
    /* renamed from: d */
    private static final String f18954d = "YY";
    /* renamed from: e */
    private static final String f18955e = "M";
    /* renamed from: f */
    private static final String f18956f = "MM";
    /* renamed from: g */
    private static final String f18957g = "MMM";
    /* renamed from: h */
    private static final String f18958h = "MMMM";
    /* renamed from: i */
    private static final String f18959i = "D";
    /* renamed from: j */
    private static final String f18960j = "DD";
    /* renamed from: k */
    private static final String f18961k = "WWW";
    /* renamed from: l */
    private static final String f18962l = "WWWW";
    /* renamed from: m */
    private static final String f18963m = "hh";
    /* renamed from: n */
    private static final String f18964n = "h";
    /* renamed from: o */
    private static final String f18965o = "m";
    /* renamed from: p */
    private static final String f18966p = "mm";
    /* renamed from: q */
    private static final String f18967q = "s";
    /* renamed from: r */
    private static final String f18968r = "ss";
    /* renamed from: s */
    private static final String f18969s = "h12";
    /* renamed from: t */
    private static final String f18970t = "hh12";
    /* renamed from: u */
    private static final int f18971u = 0;
    /* renamed from: v */
    private static final int f18972v = 1;
    /* renamed from: w */
    private static final String f18973w = "a";
    /* renamed from: x */
    private static final Pattern f18974x = Pattern.compile("f{1,9}");
    /* renamed from: y */
    private static final String f18975y = "";
    /* renamed from: z */
    private static final List<String> f18976z = new ArrayList();
    /* renamed from: A */
    private final String f18977A;
    /* renamed from: B */
    private final Locale f18978B;
    /* renamed from: C */
    private final Map<Locale, List<String>> f18979C = new LinkedHashMap();
    /* renamed from: D */
    private final Map<Locale, List<String>> f18980D = new LinkedHashMap();
    /* renamed from: E */
    private final Map<Locale, List<String>> f18981E = new LinkedHashMap();
    /* renamed from: F */
    private final CustomLocalization f18982F;
    /* renamed from: G */
    private Collection<InterpretedRange> f18983G;
    /* renamed from: H */
    private Collection<EscapedRange> f18984H;

    private final class CustomLocalization {
        /* renamed from: a */
        List<String> f18942a;
        /* renamed from: b */
        List<String> f18943b;
        /* renamed from: c */
        List<String> f18944c;
        /* renamed from: d */
        final /* synthetic */ DateTimeFormatter f18945d;

        CustomLocalization(DateTimeFormatter dateTimeFormatter, List<String> aMonths, List<String> aWeekdays, List<String> aAmPm) {
            this.f18945d = dateTimeFormatter;
            if (aMonths.size() != 12) {
                throw new IllegalArgumentException("Your List of custom months must have size 12, but its size is " + aMonths.size());
            } else if (aWeekdays.size() != 7) {
                throw new IllegalArgumentException("Your List of custom weekdays must have size 7, but its size is " + aWeekdays.size());
            } else if (aAmPm.size() != 2) {
                throw new IllegalArgumentException("Your List of custom a.m./p.m. indicators must have size 2, but its size is " + aAmPm.size());
            } else {
                this.f18942a = aMonths;
                this.f18943b = aWeekdays;
                this.f18944c = aAmPm;
            }
        }
    }

    private static final class EscapedRange {
        /* renamed from: a */
        int f18946a;
        /* renamed from: b */
        int f18947b;

        private EscapedRange() {
        }
    }

    private static final class InterpretedRange {
        /* renamed from: a */
        int f18948a;
        /* renamed from: b */
        int f18949b;
        /* renamed from: c */
        String f18950c;

        private InterpretedRange() {
        }

        public String toString() {
            return "Start:" + this.f18948a + " End:" + this.f18949b + " '" + this.f18950c + "'";
        }
    }

    static {
        f18976z.add(f18953c);
        f18976z.add(f18954d);
        f18976z.add(f18958h);
        f18976z.add(f18957g);
        f18976z.add(f18956f);
        f18976z.add(f18955e);
        f18976z.add(f18960j);
        f18976z.add(f18959i);
        f18976z.add(f18962l);
        f18976z.add(f18961k);
        f18976z.add(f18970t);
        f18976z.add(f18969s);
        f18976z.add(f18963m);
        f18976z.add("h");
        f18976z.add(f18966p);
        f18976z.add("m");
        f18976z.add("ss");
        f18976z.add("s");
        f18976z.add("a");
        f18976z.add("fffffffff");
        f18976z.add("ffffffff");
        f18976z.add("fffffff");
        f18976z.add("ffffff");
        f18976z.add("fffff");
        f18976z.add("ffff");
        f18976z.add("fff");
        f18976z.add("ff");
        f18976z.add(Regular.CATEGORY_FIX_VALUE);
    }

    DateTimeFormatter(String aFormat) {
        this.f18977A = aFormat;
        this.f18978B = null;
        this.f18982F = null;
        m15015c();
    }

    DateTimeFormatter(String aFormat, Locale aLocale) {
        this.f18977A = aFormat;
        this.f18978B = aLocale;
        this.f18982F = null;
        m15015c();
    }

    DateTimeFormatter(String aFormat, List<String> aMonths, List<String> aWeekdays, List<String> aAmPmIndicators) {
        this.f18977A = aFormat;
        this.f18978B = null;
        this.f18982F = new CustomLocalization(this, aMonths, aWeekdays, aAmPmIndicators);
        m15015c();
    }

    /* renamed from: a */
    String m15026a(DateTime aDateTime) {
        this.f18984H = new ArrayList();
        this.f18983G = new ArrayList();
        m15006a();
        m15012b(aDateTime);
        return m15008b();
    }

    /* renamed from: a */
    private void m15006a() {
        Matcher matcher = f18952b.matcher(this.f18977A);
        while (matcher.find()) {
            EscapedRange escapedRange = new EscapedRange();
            escapedRange.f18946a = matcher.start();
            escapedRange.f18947b = matcher.end() - 1;
            this.f18984H.add(escapedRange);
        }
    }

    /* renamed from: a */
    private boolean m15007a(InterpretedRange aInterpretedRange) {
        for (EscapedRange escapedRange : this.f18984H) {
            if (escapedRange.f18946a <= aInterpretedRange.f18948a && aInterpretedRange.f18948a <= escapedRange.f18947b) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m15012b(DateTime aDateTime) {
        String format = this.f18977A;
        for (String token : f18976z) {
            Matcher matcher = Pattern.compile(token).matcher(format);
            while (matcher.find()) {
                InterpretedRange interpretedRange = new InterpretedRange();
                interpretedRange.f18948a = matcher.start();
                interpretedRange.f18949b = matcher.end() - 1;
                if (!m15007a(interpretedRange)) {
                    interpretedRange.f18950c = m15005a(matcher.group(), aDateTime);
                    this.f18983G.add(interpretedRange);
                }
            }
            format = format.replace(token, m15003a(token));
        }
    }

    /* renamed from: a */
    private String m15003a(String aToken) {
        StringBuilder result = new StringBuilder();
        for (int idx = 1; idx <= aToken.length(); idx++) {
            result.append("@");
        }
        return result.toString();
    }

    /* renamed from: b */
    private String m15008b() {
        StringBuilder result = new StringBuilder();
        int idx = 0;
        while (idx < this.f18977A.length()) {
            String letter = m15009b(idx);
            InterpretedRange interpretation = m15000a(idx);
            if (interpretation != null) {
                result.append(interpretation.f18950c);
                idx = interpretation.f18949b;
            } else if (!f18951a.equals(letter)) {
                result.append(letter);
            }
            idx++;
        }
        return result.toString();
    }

    /* renamed from: a */
    private InterpretedRange m15000a(int aIdx) {
        InterpretedRange result = null;
        for (InterpretedRange interpretedRange : this.f18983G) {
            if (interpretedRange.f18948a == aIdx) {
                result = interpretedRange;
            }
        }
        return result;
    }

    /* renamed from: b */
    private String m15009b(int aIdx) {
        String strNextLetter = "";
        if (this.f18977A.length() >= aIdx + 1) {
            return this.f18977A.substring(aIdx, aIdx + 1);
        }
        return strNextLetter;
    }

    /* renamed from: a */
    private String m15005a(String aCurrentToken, DateTime aDateTime) {
        String result = "";
        if (f18953c.equals(aCurrentToken)) {
            return m15002a(aDateTime.getYear());
        }
        if (f18954d.equals(aCurrentToken)) {
            return m15011b(m15002a(aDateTime.getYear()));
        }
        if (f18958h.equals(aCurrentToken)) {
            return m15010b(Integer.valueOf(aDateTime.getMonth().intValue()));
        }
        if (f18957g.equals(aCurrentToken)) {
            return m15017d(m15010b(Integer.valueOf(aDateTime.getMonth().intValue())));
        }
        if (f18956f.equals(aCurrentToken)) {
            return m15014c(m15002a(aDateTime.getMonth()));
        }
        if (f18955e.equals(aCurrentToken)) {
            return m15002a(aDateTime.getMonth());
        }
        if (f18960j.equals(aCurrentToken)) {
            return m15014c(m15002a(aDateTime.getDay()));
        }
        if (f18959i.equals(aCurrentToken)) {
            return m15002a(aDateTime.getDay());
        }
        if (f18962l.equals(aCurrentToken)) {
            return m15018e(Integer.valueOf(aDateTime.getWeekDay().intValue()));
        }
        if (f18961k.equals(aCurrentToken)) {
            return m15017d(m15018e(Integer.valueOf(aDateTime.getWeekDay().intValue())));
        }
        if (f18963m.equals(aCurrentToken)) {
            return m15014c(m15002a(aDateTime.getHour()));
        }
        if ("h".equals(aCurrentToken)) {
            return m15002a(aDateTime.getHour());
        }
        if (f18969s.equals(aCurrentToken)) {
            return m15002a(m15021h(aDateTime.getHour()));
        }
        if (f18970t.equals(aCurrentToken)) {
            return m15014c(m15002a(m15021h(aDateTime.getHour())));
        }
        if ("a".equals(aCurrentToken)) {
            return m15022i(Integer.valueOf(aDateTime.getHour().intValue()));
        }
        if (f18966p.equals(aCurrentToken)) {
            return m15014c(m15002a(aDateTime.getMinute()));
        }
        if ("m".equals(aCurrentToken)) {
            return m15002a(aDateTime.getMinute());
        }
        if ("ss".equals(aCurrentToken)) {
            return m15014c(m15002a(aDateTime.getSecond()));
        }
        if ("s".equals(aCurrentToken)) {
            return m15002a(aDateTime.getSecond());
        }
        if (!aCurrentToken.startsWith(Regular.CATEGORY_FIX_VALUE)) {
            throw new IllegalArgumentException("Unknown token in date formatting pattern: " + aCurrentToken);
        } else if (f18974x.matcher(aCurrentToken).matches()) {
            return m15004a(m15001a(aDateTime.getNanoseconds()), aCurrentToken.length());
        } else {
            throw new IllegalArgumentException("Unknown token in date formatting pattern: " + aCurrentToken);
        }
    }

    /* renamed from: a */
    private String m15002a(Object aItem) {
        String result = "";
        if (aItem != null) {
            return String.valueOf(aItem);
        }
        return result;
    }

    /* renamed from: b */
    private String m15011b(String aItem) {
        String result = "";
        if (Util.m15096a(aItem)) {
            return aItem.substring(2);
        }
        return result;
    }

    /* renamed from: a */
    private String m15001a(Integer aNanos) {
        String result = m15002a((Object) aNanos);
        while (result.length() < 9) {
            result = "0" + result;
        }
        return result;
    }

    /* renamed from: c */
    private String m15014c(String aTimePart) {
        String result = aTimePart;
        if (Util.m15096a(aTimePart) && aTimePart.length() == 1) {
            return "0" + result;
        }
        return result;
    }

    /* renamed from: d */
    private String m15017d(String aText) {
        String result = aText;
        if (!Util.m15096a(aText) || aText.length() < 3) {
            return result;
        }
        return aText.substring(0, 3);
    }

    /* renamed from: b */
    private String m15010b(Integer aMonth) {
        String result = "";
        if (aMonth == null) {
            return result;
        }
        if (this.f18982F != null) {
            return m15013c(aMonth);
        }
        if (this.f18978B != null) {
            return m15016d(aMonth);
        }
        throw new IllegalArgumentException("Your date pattern requires either a Locale, or your own custom localizations for text:" + Util.m15093a(this.f18977A));
    }

    /* renamed from: c */
    private String m15013c(Integer aMonth) {
        if (this.f18982F == null || this.f18982F.f18942a == null) {
            return "";
        }
        return (String) this.f18982F.f18942a.get(aMonth.intValue() - 1);
    }

    /* renamed from: d */
    private String m15016d(Integer aMonth) {
        String result = "";
        if (!this.f18979C.containsKey(this.f18978B)) {
            List<String> months = new ArrayList();
            SimpleDateFormat format = new SimpleDateFormat(f18958h, this.f18978B);
            for (int idx = 0; idx <= 11; idx++) {
                Calendar firstDayOfMonth = new GregorianCalendar();
                firstDayOfMonth.set(1, 2000);
                firstDayOfMonth.set(2, idx);
                firstDayOfMonth.set(5, 15);
                months.add(format.format(firstDayOfMonth.getTime()));
            }
            this.f18979C.put(this.f18978B, months);
        }
        return (String) ((List) this.f18979C.get(this.f18978B)).get(aMonth.intValue() - 1);
    }

    /* renamed from: e */
    private String m15018e(Integer aWeekday) {
        String result = "";
        if (aWeekday == null) {
            return result;
        }
        if (this.f18982F != null) {
            return m15019f(aWeekday);
        }
        if (this.f18978B != null) {
            return m15020g(aWeekday);
        }
        throw new IllegalArgumentException("Your date pattern requires either a Locale, or your own custom localizations for text:" + Util.m15093a(this.f18977A));
    }

    /* renamed from: f */
    private String m15019f(Integer aWeekday) {
        if (this.f18982F == null || this.f18982F.f18943b == null) {
            return "";
        }
        return (String) this.f18982F.f18943b.get(aWeekday.intValue() - 1);
    }

    /* renamed from: g */
    private String m15020g(Integer aWeekday) {
        String result = "";
        if (!this.f18980D.containsKey(this.f18978B)) {
            List<String> weekdays = new ArrayList();
            SimpleDateFormat format = new SimpleDateFormat("EEEE", this.f18978B);
            for (int idx = 8; idx <= 14; idx++) {
                Calendar firstDayOfWeek = new GregorianCalendar();
                firstDayOfWeek.set(1, 2009);
                firstDayOfWeek.set(2, 1);
                firstDayOfWeek.set(5, idx);
                weekdays.add(format.format(firstDayOfWeek.getTime()));
            }
            this.f18980D.put(this.f18978B, weekdays);
        }
        return (String) ((List) this.f18980D.get(this.f18978B)).get(aWeekday.intValue() - 1);
    }

    /* renamed from: a */
    private String m15004a(String aText, int aN) {
        String result = aText;
        if (!Util.m15096a(aText) || aText.length() < aN) {
            return result;
        }
        return aText.substring(0, aN);
    }

    /* renamed from: h */
    private Integer m15021h(Integer aHour) {
        Integer result = aHour;
        if (aHour == null) {
            return result;
        }
        if (aHour.intValue() == 0) {
            return Integer.valueOf(12);
        }
        if (aHour.intValue() > 12) {
            return Integer.valueOf(aHour.intValue() - 12);
        }
        return result;
    }

    /* renamed from: i */
    private String m15022i(Integer aHour) {
        String result = "";
        if (aHour == null) {
            return result;
        }
        if (this.f18982F != null) {
            return m15023j(aHour);
        }
        if (this.f18978B != null) {
            return m15024k(aHour);
        }
        throw new IllegalArgumentException("Your date pattern requires either a Locale, or your own custom localizations for text:" + Util.m15093a(this.f18977A));
    }

    /* renamed from: j */
    private String m15023j(Integer aHour) {
        String result = "";
        if (this.f18982F == null || this.f18982F.f18944c == null) {
            return result;
        }
        if (aHour.intValue() < 12) {
            return (String) this.f18982F.f18944c.get(0);
        }
        return (String) this.f18982F.f18944c.get(1);
    }

    /* renamed from: k */
    private String m15024k(Integer aHour) {
        String result = "";
        if (!this.f18981E.containsKey(this.f18978B)) {
            List<String> indicators = new ArrayList();
            indicators.add(m15025l(Integer.valueOf(6)));
            indicators.add(m15025l(Integer.valueOf(18)));
            this.f18981E.put(this.f18978B, indicators);
        }
        if (aHour.intValue() < 12) {
            return (String) ((List) this.f18981E.get(this.f18978B)).get(0);
        }
        return (String) ((List) this.f18981E.get(this.f18978B)).get(1);
    }

    /* renamed from: l */
    private String m15025l(Integer aHour) {
        SimpleDateFormat format = new SimpleDateFormat("a", this.f18978B);
        Calendar someDay = new GregorianCalendar();
        someDay.set(1, 2000);
        someDay.set(2, 6);
        someDay.set(5, 15);
        someDay.set(11, aHour.intValue());
        return format.format(someDay.getTime());
    }

    /* renamed from: c */
    private void m15015c() {
        if (!Util.m15096a(this.f18977A)) {
            throw new IllegalArgumentException("DateTime format has no content.");
        }
    }
}
