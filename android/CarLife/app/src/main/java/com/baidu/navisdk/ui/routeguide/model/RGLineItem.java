package com.baidu.navisdk.ui.routeguide.model;

public class RGLineItem {
    public boolean isAdd;
    public boolean isBack;
    public boolean isBackBright;
    public boolean isBusLine;
    public boolean isFront;
    public boolean isFrontBright;
    public boolean isLeft;
    public boolean isLeftBright;
    public boolean isRight;
    public boolean isRightBright;
    public boolean isSub;

    public String toString() {
        return String.format("[%b,%b,%b,%b,%b,%b,%b,%b,%b]", new Object[]{Boolean.valueOf(this.isBusLine), Boolean.valueOf(this.isFront), Boolean.valueOf(this.isFrontBright), Boolean.valueOf(this.isLeft), Boolean.valueOf(this.isLeftBright), Boolean.valueOf(this.isRight), Boolean.valueOf(this.isRightBright), Boolean.valueOf(this.isBack), Boolean.valueOf(this.isBackBright)});
    }
}
