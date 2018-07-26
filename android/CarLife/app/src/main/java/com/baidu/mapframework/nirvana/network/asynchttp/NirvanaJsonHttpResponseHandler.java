package com.baidu.mapframework.nirvana.network.asynchttp;

import com.baidu.mapframework.commonlib.asynchttp.JsonHttpResponseHandler;
import com.baidu.mapframework.commonlib.asynchttp.NirvanaResponseHandlerInterface;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;

public class NirvanaJsonHttpResponseHandler extends JsonHttpResponseHandler implements NirvanaResponseHandlerInterface {
    public NirvanaJsonHttpResponseHandler(Module module, ScheduleConfig config) {
        this(module, config, "UTF-8");
    }

    public NirvanaJsonHttpResponseHandler(Module module, ScheduleConfig config, String encoding) {
        super(encoding);
        this.module = module;
        this.scheduleConfig = config;
    }

    public NirvanaJsonHttpResponseHandler(Module module, ScheduleConfig config, boolean useRFC5179CompatibilityMode) {
        this(module, config, "UTF-8");
        this.useRFC5179CompatibilityMode = useRFC5179CompatibilityMode;
    }

    public NirvanaJsonHttpResponseHandler(Module module, ScheduleConfig config, String encoding, boolean useRFC5179CompatibilityMode) {
        this(module, config, encoding);
        this.useRFC5179CompatibilityMode = useRFC5179CompatibilityMode;
    }

    public Module getNirvanaModule() {
        return this.module;
    }

    public ScheduleConfig getNirvanaScheduleConfig() {
        return this.scheduleConfig;
    }
}
