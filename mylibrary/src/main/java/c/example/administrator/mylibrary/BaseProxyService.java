package c.example.administrator.mylibrary;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.util.Log;


public class BaseProxyService extends Service implements ServicePluginInterface {

    public static final String TAG = "DLBasePluginService";
    private Service mProxyService;
    protected Service that = this;


    @Override
    public void attach(Service proxyService) {
        // TODO Auto-generated method stub
        Log.d(TAG, TAG + " attach");
        mProxyService = proxyService;
        that = mProxyService;

    }



    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        Log.d(TAG, TAG + " onBind");
        return null;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        Log.d(TAG, TAG + " onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub
        Log.d(TAG, TAG + " onStartCommand");
        return 0;
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        Log.d(TAG, TAG + " onDestroy");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // TODO Auto-generated method stub
        Log.d(TAG, TAG + " onConfigurationChanged");
    }

    @Override
    public void onLowMemory() {
        // TODO Auto-generated method stub
        Log.d(TAG, TAG + " onLowMemory");
    }

    @Override
    public void onTrimMemory(int level) {
        // TODO Auto-generated method stub
        Log.d(TAG, TAG + " onTrimMemory");

    }

    @Override
    public boolean onUnbind(Intent intent) {
        // TODO Auto-generated method stub
        Log.d(TAG, TAG + " onUnbind");
        return false;
    }

    @Override
    public void onRebind(Intent intent) {
        // TODO Auto-generated method stub
        Log.d(TAG, TAG + " onRebind");
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        // TODO Auto-generated method stub
        Log.d(TAG, TAG + " onTaskRemoved");
    }

}
