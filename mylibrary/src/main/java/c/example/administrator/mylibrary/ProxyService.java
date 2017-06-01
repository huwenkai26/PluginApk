package c.example.administrator.mylibrary;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ProxyService extends Service {
    public static final String EXTRA_DEX_PATH = "className";
    private static final String TAG = "DLProxyService";


    private String mClassName;
    private ServicePluginInterface mPluginInterface;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        Log.d(TAG, TAG + " onBind");
        //判断是否存在插件Service，如果存在，则不进行Service插件的构造工作
        Intent Serviceintent = intent;
        mClassName = intent.getStringExtra(EXTRA_DEX_PATH);
        lauchService(mClassName,Serviceintent);
        return mPluginInterface.onBind(intent);
    }

    private void lauchService(String className, Intent serviceintent) {
        try {
            Class<?> clazz = PluginManager.getInstance().getDexClassLoader().loadClass(className);
            Constructor<?> constructors = clazz.getConstructor(new Class[]{});
            Object instance = constructors.newInstance(new Object[]{});
            mPluginInterface = (ServicePluginInterface)instance;
            mPluginInterface.attach(this);



        } catch (ClassNotFoundException e) {
            LogUtils.e("ClassNotFoundException");
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        Log.d(TAG, TAG + " onCreate");


    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub
        Log.d(TAG, TAG + " onStartCommand " + this.toString());
        //判断是否存在插件Service，如果存在，则不进行Service插件的构造工作
        if (mPluginInterface == null) {
            Intent Serviceintent = intent;
            mClassName = intent.getStringExtra(EXTRA_DEX_PATH);
            lauchService(mClassName,Serviceintent);
        }
        super.onStartCommand(intent, flags, startId);
        return  mPluginInterface.onStartCommand(intent,flags,startId);
    }

    @Override
    public void onDestroy() {
        mPluginInterface.onDestroy();
        super.onDestroy();
        Log.d(TAG, TAG + " onDestroy");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

        mPluginInterface.onConfigurationChanged(newConfig);
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, TAG + " onConfigurationChanged");
    }

    @Override
    public void onLowMemory() {
        mPluginInterface.onLowMemory();
        super.onLowMemory();
        Log.d(TAG, TAG + " onLowMemory");
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onTrimMemory(int level) {
        mPluginInterface.onTrimMemory(level);
        super.onTrimMemory(level);
        Log.d(TAG, TAG + " onTrimMemory");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, TAG + " onUnbind");
        super.onUnbind(intent);
        return mPluginInterface.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        mPluginInterface.onRebind(intent);
        super.onRebind(intent);
        Log.d(TAG, TAG + " onRebind");
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onTaskRemoved(Intent rootIntent) {
        // TODO Auto-generated method stub
        mPluginInterface.onTaskRemoved(rootIntent);
        super.onTaskRemoved(rootIntent);
        Log.d(TAG, TAG + " onTaskRemoved");
    }


}
