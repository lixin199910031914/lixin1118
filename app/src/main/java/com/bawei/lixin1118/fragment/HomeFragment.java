package com.bawei.lixin1118.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.lixin1118.adapter.AAdapter;
import com.bawei.lixin1118.R;
import com.bawei.lixin1118.base.BaseFragment;
import com.bawei.lixin1118.contract.HomeContract;
import com.bawei.lixin1118.entity.ChuanEntity;
import com.bawei.lixin1118.entity.HomeEntity;
import com.bawei.lixin1118.entity.ShangEntity;
import com.bawei.lixin1118.presenter.HomePresenter;

import java.util.List;

public class HomeFragment extends BaseFragment implements HomeContract.Iview {
    int page=1;
    int count=5;
    private RecyclerView re;
    private LinearLayoutManager linearLayoutManager;
    private HomePresenter homePresenter;

    @Override
    protected int initLayout() {
        return R.layout.home;
    }

    @Override
    protected void initView(View view) {
        re = view.findViewById(R.id.re);
        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

    }

    @Override
    protected void initData() {
        homePresenter = new HomePresenter(this);
        if (homePresenter != null) {
            homePresenter.Bangding(this);
            homePresenter.JianBang();
        }
        homePresenter.getHome("",page,count);
    }

    @Override
    public void onHomeSeccess(HomeEntity homeEntity) {
        Toast.makeText(getContext(), homeEntity.getMessage(), Toast.LENGTH_SHORT).show();
        List<HomeEntity.ResultBean> result = homeEntity.getResult();
        re.setLayoutManager(linearLayoutManager);
        re.setAdapter(new AAdapter(getContext(),result));
    }

    @Override
    public void onShangSeccess(ShangEntity shangEntity) {

    }

    @Override
    public void onChuanSeccess(ChuanEntity chuanEntity) {

    }

    @Override
    public void onFailtuer(String meg) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
