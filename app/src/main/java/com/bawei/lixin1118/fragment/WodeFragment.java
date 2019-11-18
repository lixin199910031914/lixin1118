package com.bawei.lixin1118.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bawei.lixin1118.R;
import com.bawei.lixin1118.base.BaseFragment;
import com.bawei.lixin1118.contract.HomeContract;
import com.bawei.lixin1118.entity.ChuanEntity;
import com.bawei.lixin1118.entity.HomeEntity;
import com.bawei.lixin1118.entity.ShangEntity;
import com.bawei.lixin1118.presenter.HomePresenter;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.io.File;
import java.util.List;

public class WodeFragment extends BaseFragment implements HomeContract.Iview {

    private Button shang;
    private Button butt01;
    private Button butt02;
    private Button butt03;
    private RelativeLayout layout;
    private ImageView img;
    private HomePresenter homePresenter;
    private List<LocalMedia> localMedia;

    @Override
    protected int initLayout() {
        return R.layout.wode;
    }

    @Override
    protected void initView(View view) {
        shang = view.findViewById(R.id.shang);
        butt01 = view.findViewById(R.id.butt01);
        butt02 = view.findViewById(R.id.butt02);
        butt03 = view.findViewById(R.id.butt03);
        layout = view.findViewById(R.id.layout);
        img = view.findViewById(R.id.img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setVisibility(View.GONE);
            }
        });
        butt01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setVisibility(View.GONE);
                PictureSelector.create(WodeFragment.this)
                        .openGallery(PictureMimeType.ofImage())
                        .compress(true)
                        .forResult(PictureConfig.CHOOSE_REQUEST);
            }
        });
        butt02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setVisibility(View.GONE);
                PictureSelector.create(WodeFragment.this)
                        .openCamera(PictureMimeType.ofImage())
                        .compress(true)
                        .forResult(PictureConfig.CHOOSE_REQUEST);
            }
        });

        butt03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setVisibility(View.GONE);
            }
        });

        shang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        if (localMedia!=null&&localMedia.size()>0){

        }
    }

    @Override
    protected void initData() {
        homePresenter = new HomePresenter(this);
        if (homePresenter != null) {
            homePresenter.Bangding(this);
            homePresenter.JianBang();
            homePresenter.shang(777,"1573876247506777");
           /* homePresenter.Chuang(777,"1573876247506777");*/
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case  PictureConfig.CHOOSE_REQUEST:
                localMedia = PictureSelector.obtainMultipleResult(data);
               break;
        }
    }

    @Override
    public void onHomeSeccess(HomeEntity homeEntity) {

    }
    @Override
    public void onShangSeccess(ShangEntity shangEntity) {
        Toast.makeText(getContext(), shangEntity.getMessage(), Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onChuanSeccess(ChuanEntity chuanEntity) {
        Toast.makeText(getContext(), chuanEntity.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailtuer(String meg) {

    }
}
