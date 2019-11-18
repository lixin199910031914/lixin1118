package com.bawei.lixin1118.model;

import android.widget.Toast;

import com.bawei.lixin1118.contract.HomeContract;
import com.bawei.lixin1118.entity.ChuanEntity;
import com.bawei.lixin1118.entity.HomeEntity;
import com.bawei.lixin1118.entity.ShangEntity;
import com.bawei.lixin1118.ustil.ApiSerice;
import com.bawei.lixin1118.ustil.App;
import com.bawei.lixin1118.ustil.RetrofUstil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;

public class HomeModel implements HomeContract.Imodel {
    @Override
    public void getHome(String title, int page, int count, ICallBack iCallBack) {
        RetrofUstil.getInstance().setApiSerice(ApiSerice.class)
                .getBy("",page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HomeEntity>() {
                    @Override
                    public void accept(HomeEntity homeEntity) throws Exception {
                        if (homeEntity != null) {
                            iCallBack.onHomeSeccess(homeEntity);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(App.sContext, "无网", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void shang(int userId, String sessionId, ICallBack iCallBack) {
        RetrofUstil.getInstance().setApiSerice(ApiSerice.class)
                .getUser(777,"1573876247506777")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShangEntity>() {
                    @Override
                    public void accept(ShangEntity shangEntity) throws Exception {
                        if (shangEntity != null) {
                            iCallBack.onShangSeccess(shangEntity);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(App.sContext, "无网", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void Chuang(int userId, String sessionId, MultipartBody.Part file, ICallBack iCallBack) {
        RetrofUstil.getInstance().setApiSerice(ApiSerice.class)
                .HeandPic(777,"1573876247506777",file)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ChuanEntity>() {
                    @Override
                    public void accept(ChuanEntity chuanEntity) throws Exception {
                        if (chuanEntity != null) {
                            iCallBack.onChuanSeccess(chuanEntity);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(App.sContext, "无网", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
