package com.baidu.mapframework.commonlib.http;

import java.util.Set;

public interface DNSProxy {
    Set<String> getDomains(String str);

    String getIP(String str);

    void putIP2DomainsRecord(String str, String str2);
}
