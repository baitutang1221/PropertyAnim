package tingting.property.animation.activitys;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import tingting.property.animation.R;

/**
 *
 * Android动画内置插值器：
 *
 * 动画加速进行	                    @android:anim/accelerate_interpolator	            AccelerateInterpolator
 * 快速完成动画，超出再回到结束样式	    @android:anim/overshoot_interpolator	            OvershootInterpolator
 * 先加速再减速	                    @android:anim/accelerate_decelerate_interpolator	AccelerateDecelerateInterpolator
 * 先退后再加速前进	                @android:anim/anticipate_interpolator	            AnticipateInterpolator
 * 先退后再加速前进，超出终点后再回终点	@android:anim/anticipate_overshoot_interpolator	    AnticipateOvershootInterpolator
 * 最后阶段弹球效果	                @android:anim/bounce_interpolator	                BounceInterpolator
 * 周期运动	                        @android:anim/cycle_interpolator	                CycleInterpolator
 * 减速	                            @android:anim/decelerate_interpolator	            DecelerateInterpolator
 * 匀速	                            @android:anim/linear_interpolator	                LinearInterpolator
 *
 *
 * 参考：https://www.jianshu.com/p/2f19fe1e3ca1
 *
 */
public class SystemInterpolatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_interpolator);

        findViewById(R.id.start_button).setOnClickListener(v -> initAnim());
        initAnim();
    }

    private void initAnim(){
        showAnim(R.id.text1,new AccelerateInterpolator());
        showAnim(R.id.text2,new OvershootInterpolator());
        showAnim(R.id.text3,new AccelerateDecelerateInterpolator());
        showAnim(R.id.text4,new AnticipateInterpolator());
        showAnim(R.id.text5,new AnticipateOvershootInterpolator());
        showAnim(R.id.text6,new BounceInterpolator());
        showAnim(R.id.text7,new CycleInterpolator(3)); //参数为重复次数
        showAnim(R.id.text8,new DecelerateInterpolator());
        showAnim(R.id.text9,new LinearInterpolator());
    }

    private void showAnim(int id, Interpolator obj){
        // 步骤1:创建 需要设置动画的 视图View
        TextView textView1 = (TextView) findViewById(id);
        // 步骤2：创建动画的对象 & 设置动画效果
        TranslateAnimation translateAnimation = new TranslateAnimation(0,400.0f,0,0.0f);
        // 步骤3：创建对应的插值器类对象
        translateAnimation.setDuration(3000);
        translateAnimation.setFillAfter(true);
        // 步骤4：给动画设置插值器
        translateAnimation.setInterpolator(obj);
        // 步骤5：播放动画
        textView1.startAnimation(translateAnimation);
    }
}