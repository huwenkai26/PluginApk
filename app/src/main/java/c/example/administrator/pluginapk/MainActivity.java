package c.example.administrator.pluginapk;

import android.content.ServiceConnection;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import c.example.administrator.mylibrary.BaseProxyActivity;

public class MainActivity extends BaseProxyActivity {

    private ImageView mImage;
    private ServiceConnection mConnecton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        that.setContentView(R.layout.activity_main);
        mImage = (ImageView)findViewById(R.id.image);
        that.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(that.getApplicationContext(),"成功",Toast.LENGTH_LONG).show();
                handleView();
            }
        });


    }

    private void handleView() {
        AnimationDrawable anim = (AnimationDrawable) mImage.getBackground();
        if (anim != null) {
            if (anim.isRunning()) {
                anim.stop();

            } else {
                anim.stop();
                anim.start();
            }
        }
    }
}
