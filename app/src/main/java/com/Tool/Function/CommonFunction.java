package com.Tool.Function;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

import com.Tool.Common.CommonApplication;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;

/**
 * Created by zhengtongyu on 16/5/23.
 */
public class CommonFunction {
    public static String GetDate() {
        long time = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        String date = simpleDateFormat.format(time);
        return date;
    }

    public static String GetDate(long time) {
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        String date = simpleDateFormat.format(time);
        return date;
    }

    public static boolean notEmpty(CharSequence text) {
        return !isEmpty(text);
    }

    public static boolean isEmpty(CharSequence text) {
        if (text == null || text.length() == 0) {
            return true;
        }

        return false;
    }

    public static String GetPackageName() {
        String processName = "";
        ActivityManager activityManager = (ActivityManager) CommonApplication.getInstance()
                .getSystemService(Context.ACTIVITY_SERVICE);
        Iterator<ActivityManager.RunningAppProcessInfo> infoIterator =
                activityManager.getRunningAppProcesses().iterator();
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo;

        while (infoIterator.hasNext()) {
            runningAppProcessInfo = infoIterator.next();

            try {
                if (runningAppProcessInfo.pid == android.os.Process.myPid()) {
                    processName = runningAppProcessInfo.processName;
                    return processName;
                }
            } catch (Exception e) {
                Log.e("查询进程出错", e.toString());
            }
        }

        return processName;
    }
}
