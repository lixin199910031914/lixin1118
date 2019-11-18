package com.bawei.lixin1118.contract;

import com.bawei.lixin1118.base.mvp.BasePresenter;
import com.bawei.lixin1118.entity.ChuanEntity;
import com.bawei.lixin1118.entity.HomeEntity;
import com.bawei.lixin1118.entity.ShangEntity;

import okhttp3.MultipartBody;

public interface HomeContract {
    interface Iview{
        void  onHomeSeccess(HomeEntity homeEntity);
        void  onShangSeccess(ShangEntity shangEntity);
        void onChuanSeccess(ChuanEntity chuanEntity);
        void onFailtuer(String meg);
    }
    interface Imodel{
        void  getHome(String title,int page,int count,ICallBack iCallBack);
        void  shang(int userId,String sessionId,ICallBack iCallBack);
        void Chuang(int userId, String sessionId, MultipartBody.Part file,ICallBack iCallBack);
        interface ICallBack{
            void  onHomeSeccess(HomeEntity homeEntity);
            void  onShangSeccess(ShangEntity shangEntity);
            void onChuanSeccess(ChuanEntity chuanEntity);
            void onFailtuer(String meg);
        }
    }
    abstract class Ipresenter extends BasePresenter {
        public abstract void  getHome(String title, int page, int count);
        public abstract void  shang(int userId, String sessionId);
        public abstract void Chuang(int userId, String sessionId, MultipartBody.Part file);
    }
}
