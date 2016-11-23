package yzuic.kevinchang.multithreadbutterfly;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private LinearLayout ll;
    private ImageView iv;
    private Button btnGo;
    private TextView tv;
    int img = 0;
    int[] pic = {R.drawable.up, R.drawable.mid, R.drawable.down};
    boolean flag = false;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            iv.setBackgroundResource(pic[img]);
            img = (img + 1) % 3;
            handler.postDelayed(this, 200);
        }
    };

    @Override
    protected void onDestroy() {
        if (handler != null)
            handler.removeCallbacks(runnable);
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = (LinearLayout) findViewById(R.id.mainLayout);
        iv = new ImageView(this);
        btnGo = new Button(this);
        tv = new TextView(this);
        tv.setTextSize(20);

        ll.addView(iv);
        ll.addView(btnGo);
        ll.addView(tv);

        Thread tr = new Thread(runnable);
        tr.start();

        btnGo.setText("Go");
        btnGo.setTextSize(20);
        btnGo.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = !flag;
                if (flag) {
                    tv.setText("Kevin Chang");
                } else {
                    tv.setText("");
                }
            }
        });
    }
}
