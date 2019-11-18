package com.bawei.lixin1118.base.mvp;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V> {
    private V view;
    private WeakReference<V> vWeakReference;

    public void  Bangding(V v) {
        this.view = view;
        vWeakReference = new WeakReference<>(v);
    }
    public void JianBang(){
        if (vWeakReference != null) {
            vWeakReference.clear();
            vWeakReference=null;
        }
    }
}
