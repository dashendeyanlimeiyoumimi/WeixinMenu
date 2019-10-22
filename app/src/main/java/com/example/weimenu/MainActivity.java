package com.example.weimenu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {

    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnMenu(View view) {
        //获取自定义的菜单布局文件
        final View popupWindow_view = getLayoutInflater().inflate(R.layout.menu, null, false);
        //创建PopupWindow实例，设置菜单宽度和高度为包裹其自身内容
        popupWindow = new PopupWindow(popupWindow_view, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, true);
        //设置菜单显示在按钮的下面
        popupWindow.showAsDropDown(findViewById(R.id.btn_menu),0,0);
        //设置显示在任何地方
        //popupWindow.showAtLocation(popupWindow_view,0,20,30);
        //点击其他地方消失
        popupWindow_view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (popupWindow!=null&&popupWindow.isShowing()){
                    popupWindow.dismiss();
                    popupWindow = null;
                }
                return false;
            }
        });
    }
}
