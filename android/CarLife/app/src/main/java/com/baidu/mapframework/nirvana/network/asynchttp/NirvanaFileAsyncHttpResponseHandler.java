package com.baidu.mapframework.nirvana.network.asynchttp;

import android.content.Context;
import com.baidu.mapframework.commonlib.asynchttp.FileAsyncHttpResponseHandler;
import com.baidu.mapframework.commonlib.asynchttp.NirvanaResponseHandlerInterface;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import java.io.File;

public abstract class NirvanaFileAsyncHttpResponseHandler extends FileAsyncHttpResponseHandler implements NirvanaResponseHandlerInterface {
    public NirvanaFileAsyncHttpResponseHandler(Module module, ScheduleConfig config, File file) {
        this(module, config, file, false);
    }

    public NirvanaFileAsyncHttpResponseHandler(Module module, ScheduleConfig config, File file, boolean append) {
        this(module, config, file, append, false);
    }

    public NirvanaFileAsyncHttpResponseHandler(Module module, ScheduleConfig config, File file, boolean append, boolean renameTargetFileIfExists) {
        super(file, append, renameTargetFileIfExists);
        this.module = module;
        this.scheduleConfig = config;
    }

    public NirvanaFileAsyncHttpResponseHandler(Module module, ScheduleConfig config, Context context) {
        super(context);
        this.module = module;
        this.scheduleConfig = config;
    }

    public Module getNirvanaModule() {
        return this.module;
    }

    public ScheduleConfig getNirvanaScheduleConfig() {
        return this.scheduleConfig;
    }
}
