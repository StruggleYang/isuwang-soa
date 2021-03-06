package com.isuwang.dapeng.core.helper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tangliu on 2016/7/13.
 */
public class MasterHelper {

    public static Map<String, Boolean> isMaster = new HashMap<>();

    /**
     * 根据serviceName, versionName，判断当前服务是否集群中的master
     *
     * @param servieName
     * @param versionName
     * @return
     */
    public static boolean isMaster(String servieName, String versionName) {

        String key = generateKey(servieName, versionName);

        if (!isMaster.containsKey(key))
            return false;
        else
            return isMaster.get(key);

    }

    public static String generateKey(String serviceName, String versionName) {
        return serviceName + ":" + versionName;
    }
}
