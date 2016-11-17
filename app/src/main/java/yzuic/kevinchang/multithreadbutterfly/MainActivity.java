package yzuic.kevinchang.multithreadbutterfly;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout ll;
    private Button btnGo;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = (LinearLayout) findViewById(R.id.mainLayout);
        btnGo = new Button(this);
        iv = new ImageView(this);

        btnGo.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

        ll.addView(iv);
        ll.addView(btnGo);
    }
}
