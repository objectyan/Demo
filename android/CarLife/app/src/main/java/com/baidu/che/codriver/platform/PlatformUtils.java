package com.baidu.che.codriver.platform;

import com.baidu.che.codriver.vr.C2746e;
import com.baidu.che.codriver.vr.C2848p;

public class PlatformUtils {
    public static int getCommandType(C2746e command) {
        if (command == null) {
            return 16;
        }
        return getCommandType(command.mo1953d());
    }

    private static int getCommandType(String domain) {
        if (C2848p.f9315p.equals(domain) || "app".equals(domain)) {
            return 1;
        }
        if ("music".equals(domain) || "player".equals(domain)) {
            return 4;
        }
        if ("navigate_instruction".equals(domain) || "map".equals(domain)) {
            return 8;
        }
        if ("telephone".equals(domain)) {
            return 2;
        }
        return 16;
    }
}
