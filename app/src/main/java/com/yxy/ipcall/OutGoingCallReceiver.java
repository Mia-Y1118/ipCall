package com.yxy.ipcall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * Created by yangxiaoyu on 2017/12/17.
 */

public class OutGoingCallReceiver extends BroadcastReceiver {
    //当接收到外拨电话的广播的时候，则执行onReceive方法
    @Override
    public void onReceive(Context context, Intent intent) {
       //获取到保存的区号：
        SharedPreferences sp = context.getSharedPreferences("config",0);
        String number = sp.getString("ipNum","");

        //获取当前需要拨打的电话号码
        String currentNumber = getResultData();//当前Action的结果数据
        //判断拨打的电话是否是长途
        if(currentNumber.startsWith("0")){
            //在当前的号码前面加上17951
            setResultData(number+currentNumber);
        }
    }
}
