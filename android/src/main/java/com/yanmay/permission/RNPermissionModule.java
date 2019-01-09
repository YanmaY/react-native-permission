
package com.yanmay.permission;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import java.util.List;

import com.hjq.permissions.OnPermission;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;

public class RNPermissionModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNPermissionModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNPermission";
  }
  
  @ReactMethod
  public void requestPermission() {
      XXPermissions.with(getCurrentActivity())
              // .constantRequest() //可设置被拒绝后继续申请，直到用户授权或者永久拒绝
              // .permission(Permission.SYSTEM_ALERT_WINDOW,
              // Permission.REQUEST_INSTALL_PACKAGES) //支持请求6.0悬浮窗权限8.0请求安装权限
              .permission(Permission.Group.LOCATION) // 不指定权限则自动获取清单中的危险权限
              .request(new OnPermission() {

                  @Override
                  public void hasPermission(List<String> granted, boolean isAll) {
                      if (isAll) 
                          Toast.makeText(getReactApplicationContext(), "获取权限成功",Toast.LENGTH_SHORT).show();
                       else 
                          Toast.makeText(getReactApplicationContext(), "获取权限成功，部分权限未正常授予",Toast.LENGTH_SHORT).show();
                  }

                  @Override
                  public void noPermission(List<String> denied, boolean quick) {
                      if (quick) {
                          Toast.makeText(getReactApplicationContext(), "被永久拒绝授权，请手动授予权限",Toast.LENGTH_SHORT).show();
                          // 如果是被永久拒绝就跳转到应用权限系统设置页面
                          XXPermissions.gotoPermissionSettings(getCurrentActivity());
                      } else 
                          Toast.makeText(getReactApplicationContext(), "获取权限失败",Toast.LENGTH_SHORT).show();
                  }
              });

  }
}