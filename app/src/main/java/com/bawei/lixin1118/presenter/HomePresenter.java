package com.bawei.lixin1118.presenter;

import android.widget.Toast;

import com.bawei.lixin1118.model.HomeModel;
import com.bawei.lixin1118.contract.HomeContract;
import com.bawei.lixin1118.entity.ChuanEntity;
import com.bawei.lixin1118.entity.HomeEntity;
import com.bawei.lixin1118.entity.ShangEntity;
import com.bawei.lixin1118.ustil.App;

import okhttp3.MultipartBody;

public class HomePresenter extends HomeContract.Ipresenter {
    HomeContract.Iview iview;
    private final HomeModel homeModel;

    public HomePresenter(HomeContract.Iview iview) {
        this.iview = iview;
        homeModel = new HomeModel();
    }

    @Override
    public void getHome(String title, int page, int count) {
        homeModel.getHome(title, page, count, new HomeContract.Imodel.ICallBack() {
            @Override
            public void onHomeSeccess(HomeEntity homeEntity) {
                if (homeEntity != null) {
                    iview.onHomeSeccess(homeEntity);
                }
            }

            @Override
            public void onShangSeccess(ShangEntity shangEntity) {

            }

            @Override
            public void onChuanSeccess(ChuanEntity chuanEntity) {

            }

            @Override
            public void onFailtuer(String meg) {
                Toast.makeText(App.sContext, "无网", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void shang(int userId, String sessionId) {
        homeModel.shang(userId, sessionId, new HomeContract.Imodel.ICallBack() {
            @Override
            public void onHomeSeccess(HomeEntity homeEntity) {

            }

            @Override
            public void onShangSeccess(ShangEntity shangEntity) {
                if (shangEntity != null) {
                    iview.onShangSeccess(shangEntity);
                }
            }

            @Override
            public void onChuanSeccess(ChuanEntity chuanEntity) {

            }

            @Override
            public void onFailtuer(String meg) {
                Toast.makeText(App.sContext, "无网", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void Chuang(int userId, String sessionId, MultipartBody.Part file) {
        homeModel.shang(userId, sessionId, new HomeContract.Imodel.ICallBack() {
            @Override
            public void onHomeSeccess(HomeEntity homeEntity) {

            }

            @Override
            public void onShangSeccess(ShangEntity shangEntity) {

            }

            @Override
            public void onChuanSeccess(ChuanEntity chuanEntity) {
                if (chuanEntity != null) {
                    iview.onChuanSeccess(chuanEntity);
                }
            }

            @Override
            public void onFailtuer(String meg) {
                Toast.makeText(App.sContext, "无网", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
