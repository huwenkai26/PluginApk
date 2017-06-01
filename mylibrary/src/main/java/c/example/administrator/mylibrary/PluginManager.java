package c.example.administrator.mylibrary;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.widget.Toast;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

/**
 * Created by Administrator on 2017/5/25.
 */

public class PluginManager {
    private  Context context;
    private static PluginManager pluginmanager;
    private Resources mResources;
    private DexClassLoader mDexClassLoader;
    private PackageInfo mPackageInfo;
    private Class<?> mAClass;

    private PluginManager(Context context) {
        this.context = context;
    }


    public static PluginManager getInstance(Context context){
        if(pluginmanager == null){
            pluginmanager = new PluginManager(context);
        }
        return  pluginmanager;
    }
    public static PluginManager getInstance(){
        if(pluginmanager == null){
           throw new RuntimeException("请调用带Context的方法");
        }
        return  pluginmanager;
    }
    public Resources getResources() {
        return mResources;
    }

    public DexClassLoader getDexClassLoader() {
        return mDexClassLoader;
    }

    public PackageInfo getPackageInfo() {
        return mPackageInfo;
    }

    public void loadPath(String dexPath){
        try {
            mDexClassLoader = new DexClassLoader(dexPath,context.getDir("dex.apk", Context.MODE_PRIVATE).getAbsolutePath(),null,context.getClassLoader());

            AssetManager assetManager = AssetManager.class.newInstance();
            Method addAssetPath = assetManager.getClass().getMethod("addAssetPath", String.class);
            addAssetPath.invoke(assetManager, dexPath);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            Configuration configuration =  context.getResources().getConfiguration();

            mResources = new  Resources(assetManager,displayMetrics,configuration);



            mPackageInfo = context.getPackageManager().getPackageArchiveInfo(dexPath, PackageManager.GET_ACTIVITIES);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }


}
