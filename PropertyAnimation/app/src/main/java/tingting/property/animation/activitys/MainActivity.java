package tingting.property.animation.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import tingting.property.animation.R;

/**
 * Android 属性动画
 *
 * 参考：
 *
 * https://www.jianshu.com/p/2412d00a0ce4
 *
 * https://blog.csdn.net/guolin_blog/article/details/43536355
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.spec_button1).setOnClickListener(v -> startActivity(new Intent(MainActivity.this,ValueAnimatorOfIntActivity.class)));
        findViewById(R.id.spec_button2).setOnClickListener(v -> Toast.makeText(MainActivity.this, "和ValueAnimator.ofInt()用法几乎类似，只不过初始化时可以传多个数字型参数", Toast.LENGTH_SHORT).show());
        findViewById(R.id.spec_button3).setOnClickListener(v -> startActivity(new Intent(MainActivity.this,ValueAnimatorOfObjectActivity.class)));
        findViewById(R.id.spec_button4).setOnClickListener(v -> startActivity(new Intent(MainActivity.this,SystemInterpolatorActivity.class)));
        findViewById(R.id.spec_button5).setOnClickListener(v -> startActivity(new Intent(MainActivity.this,DecelerateAccelerateInterpolatorActivity.class)));
        findViewById(R.id.spec_button6).setOnClickListener(v -> startActivity(new Intent(MainActivity.this,ObjectAnimatorActivity.class)));
        findViewById(R.id.spec_button7).setOnClickListener(v -> startActivity(new Intent(MainActivity.this,ObjectAnimatorAdvanceActivity.class)));
        findViewById(R.id.spec_button8).setOnClickListener(v -> startActivity(new Intent(MainActivity.this,BallFreeFallActivity.class)));
        findViewById(R.id.spec_button9).setOnClickListener(v -> startActivity(new Intent(MainActivity.this,ViewPropertyAnimatorActivity.class)));

        
    }
}