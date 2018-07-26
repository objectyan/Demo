package com.baidu.navisdk.module.ugc;

public interface BaseView<T extends BasePresenter> {
    void initPresenterView();

    void setPresenter(T t);
}
