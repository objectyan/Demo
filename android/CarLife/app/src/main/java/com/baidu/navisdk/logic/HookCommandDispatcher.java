package com.baidu.navisdk.logic;

import com.baidu.navisdk.util.common.LogUtil;
import java.lang.reflect.Field;
import java.util.HashMap;

public class HookCommandDispatcher {
    private HashMap<String, Class<? extends CommandBase>> mReqHandlerMap = new HashMap();

    public HookCommandDispatcher(Class<?> cls) {
        init(cls);
    }

    public CommandBase getCommandParser(String cmd) {
        return getHandlerByReqKey(cmd);
    }

    private void init(Class<?> cls) {
        loadFields(cls);
    }

    private void loadFields(Class<?> cls) {
        Field[] fields = cls.getDeclaredFields();
        if (fields != null) {
            for (Field f : fields) {
                try {
                    Object obj = f.get(null);
                    if (obj instanceof String) {
                        String cmd = (String) obj;
                        CommandDeclare handle = (CommandDeclare) f.getAnnotation(CommandDeclare.class);
                        LogUtil.m15791e("xxxxxx", handle.toString() + handle.annotationType().toString());
                        if (!(cmd == null || handle == null)) {
                            Class<? extends CommandBase> handleClass = handle.value();
                            if (handleClass == null) {
                                LogUtil.m15791e("", "Command mapping definition in CommandConstant is error:" + cmd);
                            } else {
                                this.mReqHandlerMap.put(cmd, handleClass);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private CommandBase getHandlerByReqKey(String cmd) {
        Class<? extends CommandBase> handleClass = (Class) this.mReqHandlerMap.get(cmd);
        if (handleClass != null) {
            try {
                return (CommandBase) handleClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
