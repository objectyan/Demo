package com.baidu.mapframework.commonlib.asynchttp;

import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;

public interface NirvanaResponseHandlerInterface extends ResponseHandlerInterface {
    Module getNirvanaModule();

    ScheduleConfig getNirvanaScheduleConfig();
}
