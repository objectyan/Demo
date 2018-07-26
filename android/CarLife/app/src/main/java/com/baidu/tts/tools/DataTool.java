package com.baidu.tts.tools;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataTool {
    public static Set<String> fromArrayToSet(String[] array) {
        if (array == null) {
            return null;
        }
        Set<String> hashSet = new HashSet();
        for (Object add : array) {
            hashSet.add(add);
        }
        return hashSet;
    }

    public static String[] fromSetToArray(Set<String> set) {
        if (set == null) {
            return null;
        }
        String[] strArr = new String[set.size()];
        set.toArray(strArr);
        return strArr;
    }

    public static String[] connect(String[] first, String[]... rest) {
        if (first == null) {
            first = new String[0];
        }
        int length = first.length;
        for (String[] length2 : rest) {
            try {
                length += length2.length;
            } catch (Exception e) {
            }
        }
        String[] strArr = (String[]) Arrays.copyOf(first, length);
        int length3 = first.length;
        int i = length3;
        for (Object obj : rest) {
            try {
                System.arraycopy(obj, 0, strArr, i, obj.length);
                i += obj.length;
            } catch (Exception e2) {
            }
        }
        return strArr;
    }

    public static Set<String> copy(Set<String> ori) {
        if (ori == null) {
            return null;
        }
        Set<String> hashSet = new HashSet();
        for (String add : ori) {
            hashSet.add(add);
        }
        return hashSet;
    }

    public static <T extends Set<?>> boolean isSetEmpty(T t) {
        return t == null || t.isEmpty();
    }

    public static <T extends Map<?, ?>> boolean isMapEmpty(T t) {
        return t == null || t.isEmpty();
    }

    public static <T extends List<?>> boolean isListEmpty(T t) {
        return t == null || t.isEmpty();
    }

    public static Map<String, Integer> getSuitItem(Map<String, Integer> map, boolean isEqual, int value) {
        if (isMapEmpty(map)) {
            return null;
        }
        Map<String, Integer> hashMap = new HashMap();
        for (String str : map.keySet()) {
            int intValue = ((Integer) map.get(str)).intValue();
            if (isEqual) {
                if (value == intValue) {
                    hashMap.put(str, Integer.valueOf(intValue));
                }
            } else if (value != intValue) {
                hashMap.put(str, Integer.valueOf(intValue));
            }
        }
        return hashMap;
    }

    public static Map<String, Map<String, String>> getSuitItem(Map<String, Map<String, String>> out, String inKey, boolean isEqual, String inValue) {
        if (isMapEmpty(out)) {
            return null;
        }
        Map<String, Map<String, String>> hashMap = new HashMap();
        for (String str : out.keySet()) {
            Map map = (Map) out.get(str);
            String str2 = (String) map.get(inKey);
            if (isEqual) {
                if (inValue.equals(str2)) {
                    hashMap.put(str, map);
                }
            } else if (!inValue.equals(str2)) {
                hashMap.put(str, map);
            }
        }
        return hashMap;
    }

    public static void putMapItem(Map<String, Map<String, String>> out, String outKey, Map<String, String> item) {
        Map map = (Map) out.get(outKey);
        if (map == null) {
            out.put(outKey, item);
        } else {
            map.putAll(item);
        }
    }

    public static Map<String, String> putIfAbsent(Map<String, Map<String, String>> out, String key) {
        Map<String, String> map = (Map) out.get(key);
        if (map != null) {
            return map;
        }
        Map hashMap = new HashMap();
        out.put(key, hashMap);
        return hashMap;
    }

    public static void putMapValue(Map<String, Map<String, String>> out, String outKey, String inKey, String value) {
        putIfAbsent(out, outKey).put(inKey, value);
    }

    public static String getMapInnerValue(Map<String, Map<String, String>> out, String outKey, String inKey) {
        if (out == null) {
            return null;
        }
        Map map = (Map) out.get(outKey);
        if (map != null) {
            return (String) map.get(inKey);
        }
        return null;
    }

    public static String getMapValue(Map<String, String> map, String key) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        return (String) map.get(key);
    }

    public static boolean isLong(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
