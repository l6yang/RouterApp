package com.router.loyal.ui;

import android.Manifest;
import android.widget.TextView;

import com.loyal.base.ui.activity.ABasicPerMissionActivity;
import com.router.loyal.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PermissionActivity extends ABasicPerMissionActivity implements ABasicPerMissionActivity.onItemPermissionListener {
    @BindView(R.id.textPermission)
    TextView textPermission;

    @Override
    protected int actLayoutRes() {
        return R.layout.activity_permission;
    }

    @Override
    public void bindViews() {
        ButterKnife.bind(this);
    }

    @Override
    public void afterOnCreate() {
        requestPermission(100, this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    @Override
    public boolean isTransStatus() {
        return false;
    }

    @Override
    public void onItemPermissionResult(int reqCode, boolean successful) {
        textPermission.setText(successful ? "内存权限成功" : "完犊子");
    }
}
