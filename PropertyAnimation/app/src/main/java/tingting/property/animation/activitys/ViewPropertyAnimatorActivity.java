package tingting.property.animation.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

import tingting.property.animation.R;

/**
 * 关于ViewPropertyAnimator的定义和解释，
 * 相关参考链接：https://blog.csdn.net/zhaoyanjun6/article/details/111650621
 */
public class ViewPropertyAnimatorActivity extends AppCompatActivity {

    private TextView center_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_property_animator);

        center_text = findViewById(R.id.center_text);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                center_text.animate().x(500).y(1800).setDuration(3000);
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                center_text.animate().rotationX(180f).setDuration(3000);
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                center_text.animate().alpha(0.1f);
            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                center_text.animate().scaleX(3f).scaleY(3f);
            }
        });

        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                center_text.animate().scaleX(3f).scaleY(3f).rotation(360f).setDuration(3000).setInterpolator(new BounceInterpolator());
            }
        });
    }
}