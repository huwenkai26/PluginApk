package c.example.administrator.pluginapk;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import c.example.administrator.mylibrary.BaseProxyService;

public class TestService extends BaseProxyService {

    private static final String TAG = "TestService";
    private MyBinder mBinder = new MyBinder();
    
    public class MyBinder extends Binder{
        

        public int sum(int a, int b) {
            // TODO Auto-generated method stub
            return a + b;
        }
    }
    
    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        Log.e(TAG, "onBind");


        return mBinder;
    } 
    
    @Override
    public boolean onUnbind(Intent intent) {
        // TODO Auto-generated method stub
        Log.e(TAG, "onUnbind");
        return super.onUnbind(intent);
    }
    
    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        Log.e(TAG, "onCreate");
    }
    
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub
        Log.e(TAG, "onStartCommand " + this.toString());
        return super.onStartCommand(intent, flags, startId);
    }

    
    
}
