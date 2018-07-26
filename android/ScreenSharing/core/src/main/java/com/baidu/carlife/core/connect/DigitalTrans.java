package com.baidu.carlife.core.connect;

/* compiled from: DigitalTrans */
/* renamed from: com.baidu.carlife.core.connect.j */
public class DigitalTrans {
    /* renamed from: a */
    public static String toHexString(String content) {
        String result = "";
        int max = content.length();
        for (int i = 0; i < max; i++) {
            result = result + Integer.toHexString(content.charAt(i));
        }
        return result;
    }

    /* renamed from: a */
    public static String m4319a(String hexString, int encodeType) {
        String result = "";
        int max = hexString.length() / encodeType;
        for (int i = 0; i < max; i++) {
            result = result + ((char) DigitalTrans.m4321b(hexString.substring(i * encodeType, (i + 1) * encodeType)));
        }
        return result;
    }

    /* renamed from: b */
    public static int m4321b(String hex) {
        hex = hex.toUpperCase();
        int max = hex.length();
        int result = 0;
        for (int i = max; i > 0; i--) {
            int algorism;
            char c = hex.charAt(i - 1);
            if (c < '0' || c > '9') {
                algorism = c - 55;
            } else {
                algorism = c - 48;
            }
            result = (int) (((double) result) + (Math.pow(16.0d, (double) (max - i)) * ((double) algorism)));
        }
        return result;
    }

    /* renamed from: c */
    public static String m4325c(String hex) {
        hex = hex.toUpperCase();
        String result = "";
        int max = hex.length();
        for (int i = 0; i < max; i++) {
            switch (hex.charAt(i)) {
                case '0':
                    result = result + "0000";
                    break;
                case '1':
                    result = result + "0001";
                    break;
                case '2':
                    result = result + "0010";
                    break;
                case '3':
                    result = result + "0011";
                    break;
                case '4':
                    result = result + "0100";
                    break;
                case '5':
                    result = result + "0101";
                    break;
                case '6':
                    result = result + "0110";
                    break;
                case '7':
                    result = result + "0111";
                    break;
                case '8':
                    result = result + "1000";
                    break;
                case '9':
                    result = result + "1001";
                    break;
                case 'A':
                    result = result + "1010";
                    break;
                case 'B':
                    result = result + "1011";
                    break;
                case 'C':
                    result = result + "1100";
                    break;
                case 'D':
                    result = result + "1101";
                    break;
                case 'E':
                    result = result + "1110";
                    break;
                case 'F':
                    result = result + "1111";
                    break;
                default:
                    break;
            }
        }
        return result;
    }

    /* renamed from: d */
    public static String m4326d(String content) {
        String result = "";
        int length = content.length() / 2;
        for (int i = 0; i < length; i++) {
            result = result + String.valueOf((char) DigitalTrans.m4321b(content.substring(i * 2, (i * 2) + 2)));
        }
        return result;
    }

    /* renamed from: a */
    public static String m4320a(byte[] bytearray) {
        String result = "";
        for (byte b : bytearray) {
            result = result + ((char) b);
        }
        return result;
    }

    /* renamed from: e */
    public static int m4327e(String binary) {
        int max = binary.length();
        int result = 0;
        for (int i = max; i > 0; i--) {
            result = (int) (((double) result) + (Math.pow(2.0d, (double) (max - i)) * ((double) (binary.charAt(i - 1) - 48))));
        }
        return result;
    }

    /* renamed from: a */
    public static String m4316a(int algorism) {
        String str = "";
        str = Integer.toHexString(algorism);
        if (str.length() % 2 == 1) {
            str = "0" + str;
        }
        return str.toUpperCase();
    }

    /* renamed from: a */
    public static String m4317a(int algorism, int maxLength) {
        String str = "";
        str = Integer.toHexString(algorism);
        if (str.length() % 2 == 1) {
            str = "0" + str;
        }
        return DigitalTrans.m4322b(str.toUpperCase(), maxLength);
    }

    /* renamed from: b */
    public static String m4322b(String str, int maxLength) {
        String temp = "";
        for (int i = 0; i < maxLength - str.length(); i++) {
            temp = "0" + temp;
        }
        return (temp + str).substring(0, maxLength);
    }

    /* renamed from: a */
    public static int m4315a(String s, int defaultInt, int radix) {
        try {
            return Integer.parseInt(s, radix);
        } catch (NumberFormatException e) {
            return defaultInt;
        }
    }

    /* renamed from: c */
    public static int m4324c(String s, int defaultInt) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return defaultInt;
        }
    }

    /* renamed from: f */
    public static byte[] m4328f(String hex) {
        int max = hex.length() / 2;
        byte[] bytes = new byte[max];
        String binarys = DigitalTrans.m4325c(hex);
        for (int i = 0; i < max; i++) {
            bytes[i] = (byte) DigitalTrans.m4327e(binarys.substring((i * 8) + 1, (i + 1) * 8));
            if (binarys.charAt(i * 8) == '1') {
                bytes[i] = (byte) (0 - bytes[i]);
            }
        }
        return bytes;
    }

    /* renamed from: g */
    public static final byte[] m4329g(String hex) throws IllegalArgumentException {
        if (hex.length() % 2 != 0) {
            throw new IllegalArgumentException();
        }
        char[] arr = hex.toCharArray();
        byte[] b = new byte[(hex.length() / 2)];
        int j = 0;
        int l = hex.length();
        int i = 0;
        while (i < l) {
            int i2 = i + 1;
            b[j] = new Integer(Integer.parseInt("" + arr[i] + arr[i2], 16) & 255).byteValue();
            j++;
            i = i2 + 1;
        }
        return b;
    }

    /* renamed from: b */
    public static final String m4323b(byte[] b) {
        if (b == null) {
            throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
        }
        String hs = "";
        String stmp = "";
        for (byte b2 : b) {
            stmp = Integer.toHexString(b2 & 255);
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }
        return hs.toUpperCase();
    }
}
