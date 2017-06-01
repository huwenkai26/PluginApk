package c.example.administrator.mylibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;


public class BaseProxyActivity extends Activity implements ActivityPluginInterface {

    private static final String TAG = "DLBasePluginActivity";

    /**
     * 代理activity，可以当作Context来使用，会根据需要来决定是否指向this
     */
    protected Activity mProxyActivity;

    /**
     * 等同于mProxyActivity，可以当作Context来使用，会根据需要来决定是否指向this<br/>
     * 可以当作this来使用
     */
    protected Activity that;


    @Override
    public void attach(Activity proxyActivity) {
        Log.d(TAG, "attach: proxyActivity= " + proxyActivity);
        mProxyActivity = (Activity) proxyActivity;
        that = mProxyActivity;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void setContentView(View view) {

        mProxyActivity.setContentView(view);

    }

    @Override
    public void setContentView(View view, LayoutParams params) {

        mProxyActivity.setContentView(view, params);

    }

    @Override
    public void setContentView(int layoutResID) {

        mProxyActivity.setContentView(layoutResID);

    }

    @Override
    public void addContentView(View view, LayoutParams params) {

        mProxyActivity.addContentView(view, params);

    }

    @Override
    public View findViewById(int id) {

        return mProxyActivity.findViewById(id);

    }

    @Override
    public Intent getIntent() {

            return mProxyActivity.getIntent();

    }

    @Override
    public ClassLoader getClassLoader() {

        return mProxyActivity.getClassLoader();

    }

    @Override
    public Resources getResources() {

        return mProxyActivity.getResources();

    }

    @Override
    public String getPackageName() {

            return mProxyActivity.getPackageName();

    }

    @Override
    public LayoutInflater getLayoutInflater() {

            return mProxyActivity.getLayoutInflater();

    }

    @Override
    public MenuInflater getMenuInflater() {

            return mProxyActivity.getMenuInflater();

    }

    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {

            return mProxyActivity.getSharedPreferences(name, mode);

    }

    @Override
    public Context getApplicationContext() {

            return mProxyActivity.getApplicationContext();

    }

    @Override
    public WindowManager getWindowManager() {

            return mProxyActivity.getWindowManager();

    }

    @Override
    public Window getWindow() {

            return mProxyActivity.getWindow();

    }

    @Override
    public Object getSystemService(String name) {

            return mProxyActivity.getSystemService(name);

    }

    @Override
    public void finish() {

            mProxyActivity.finish();

    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    public void onNewIntent(Intent intent) {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    public boolean onTouchEvent(MotionEvent event) {

        return false;
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {

        return false;
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {


    }

    public void onWindowFocusChanged(boolean hasFocus) {

    }

    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        return false;
    }



}
