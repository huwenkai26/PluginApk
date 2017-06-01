package c.example.administrator.mylibrary;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ProxyActivity extends Activity {
    public static final String EXTRA_DEX_PATH = "className";
    private String className;
    private ActivityPluginInterface mPluginInterface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        className =  intent.getStringExtra(EXTRA_DEX_PATH);
        lauchActivity(className);
    }

    private void lauchActivity(String className) {
        try {
            Class<?> clazz = PluginManager.getInstance().getDexClassLoader().loadClass(className);
            Constructor<?> constructors = clazz.getConstructor(new Class[]{});
            Object instance = constructors.newInstance(new Object[]{});
            mPluginInterface = (ActivityPluginInterface)instance;
            mPluginInterface.attach(this);

            Bundle bundle = new Bundle();
            mPluginInterface.onCreate(bundle);
        } catch (ClassNotFoundException e) {
            LogUtils.e("dsada");
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
    protected void onResume() {
        mPluginInterface.onResume();
        super.onResume();
        LogUtils.e("onResume");
    }

    @Override
    protected void onStart() {
        mPluginInterface.onStart();
        super.onStart();
        LogUtils.e("onStart");
    }

    @Override
    protected void onDestroy() {
        mPluginInterface.onDestroy();
        super.onDestroy();
        LogUtils.e("onDestroy");
    }

    @Override
    public Resources getResources() {
        return PluginManager.getInstance().getResources();
    }
    /*
    @Override
    protected void onResume() {
//        mPluginInterface.onResume();
        super.onResume();
        LogUtils.e("onResume");
    }

    @Override
    protected void onStart() {
//        mPluginInterface.onStart();
        super.onStart();
        LogUtils.e("onStart");
    }

    @Override
    protected void onDestroy() {
//        mPluginInterface.onDestroy();
        super.onDestroy();
        LogUtils.e("onDestroy");
    }*/
}
