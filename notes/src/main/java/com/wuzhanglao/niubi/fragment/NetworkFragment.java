package com.wuzhanglao.niubi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.wuzhanglao.niubi.R;
import com.wuzhanglao.niubi.mvp.presenter.NetworkFragmentMvpPresenter;
import com.wuzhanglao.niubi.mvp.view.NetworkFragmentMvpView;
import com.wuzhanglao.niubi.utils.ToastUtils;

/**
 * Created by wuming on 16/10/19.
 */

public class NetworkFragment extends BaseMvpFragment<NetworkFragmentMvpView, NetworkFragmentMvpPresenter>
        implements View.OnClickListener, NetworkFragmentMvpView {

    private TextView result;

    @Override
    public int setResId() {
        return R.layout.fragment_network;
    }

    @Override
    public void initView(View view, @Nullable Bundle savedInstanceState) {
        result = (TextView) view.findViewById(R.id.fragment_network_result_tv);
        view.findViewById(R.id.fragment_network_get_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragment_network_get_btn:
                presenter.request("北京");
                break;
        }
    }

    @Override
    public NetworkFragmentMvpPresenter initPresenter() {
        return new NetworkFragmentMvpPresenter();
    }


    @Override
    public void requestSuccess(Object obj) {

    }

    @Override
    public void requestFailed(String msg) {
        ToastUtils.show("请求失败");
    }
}
