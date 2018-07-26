package com.baidu.mapframework.location;

public class FailLocationEvent {
    public String diagnosticMessage;
    public int diagnosticType;
    public int locType;

    public FailLocationEvent(int locType, int diagnosticType, String diagnosticMessage) {
        this.locType = locType;
        this.diagnosticMessage = diagnosticMessage;
        this.diagnosticType = diagnosticType;
    }
}
