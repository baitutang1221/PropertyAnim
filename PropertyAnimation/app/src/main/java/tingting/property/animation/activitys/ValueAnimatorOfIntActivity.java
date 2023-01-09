package tingting.property.animation.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.widget.Button;

import tingting.property.animation.R;

/**
 * ValueAnimator.ofInt()
 *
 * 参考：https://www.jianshu.com/p/7c95342f4bc2
 */
public class ValueAnimatorOfIntActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator_of_int);

        // 创建动画作用对象：此处以Button为例
        Button mButton = (Button) findViewById(R.id.button1);

        // 步骤1：设置属性数值的初始值 & 结束值
        ValueAnimator valueAnimator = ValueAnimator.ofInt(mButton.getLayoutParams().width, 500);
        // 初始值 = 当前按钮的宽度，此处在xml文件中设置为150
        // 结束值 = 500
        // ValueAnimator.ofInt()内置了整型估值器,直接采用默认的.不需要设置
        // 即默认设置了如何从初始值150 过渡到 结束值500

        // 步骤2：设置动画的播放各种属性
        // 设置动画运行时长:1s
        valueAnimator.setDuration(2000);

        // 步骤3：将属性数值手动赋值给对象的属性:此处是将值赋给按钮的宽度
        // 设置更新监听器：即数值每次变化更新都会调用该方法
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {

                // 获得每次变化后的属性值
                int currentValue = (Integer) animator.getAnimatedValue();

                // 每次值变化时，将值手动赋值给对象的属性
                // 即将每次变化后的值赋给按钮的宽度，这样就实现了按钮宽度属性的动态变化
                mButton.getLayoutParams().width = currentValue;

                // 步骤4：刷新视图，即重新绘制，从而实现动画效果
                mButton.requestLayout();
            }
        });

        // 步骤4：启动动画
        valueAnimator.start();
    }
}