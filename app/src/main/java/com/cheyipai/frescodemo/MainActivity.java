package com.cheyipai.frescodemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.iv4)
    SimpleDraweeView iv4;
    @Bind(R.id.iv1)
    SimpleDraweeView iv1;
    @Bind(R.id.iv2)
    SimpleDraweeView iv2;

    private String url1 = "http://img1.ph.126.net/gqloZVzevsmGMSwo1dMsyA==/1699264434502423144.jpg";
    private String url2 = "http://img.pconline.com.cn/images/photoblog/6/5/3/1/6531901/20082/15/1203039671191.jpg";
    private String url4 = "http://down1.cnmo.com/cnmo-app/a177/weimeihuaersheying.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initNetImageSimple();
    }

    /**
     * 加载网络图片简单用法
     */
    private void initNetImageSimple() {
        Uri uri1 = Uri.parse(url1);
        Uri uri2 = Uri.parse(url2);
        Uri uri4 = Uri.parse(url4);

        //直接使用setImageURI来显示一张图片
        iv1.setImageURI(uri1);
        iv2.setImageURI(uri2);

        iv4.setImageURI(uri4);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_1) {
            Intent intent = new Intent(MainActivity.this,Main1Activity.class);
            startActivity(intent);
        }else if (id == R.id.action_2){
            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
        }else if (id == R.id.action_3){
            Intent intent = new Intent(MainActivity.this,Main3Activity.class);
            startActivity(intent);
        }else if (id == R.id.action_4){
            Intent intent = new Intent(MainActivity.this,Main4Activity.class);
            startActivity(intent);
        }else if (id == R.id.action_5){
            Intent intent = new Intent(MainActivity.this,Main5Activity.class);
            startActivity(intent);
        }else if (id == R.id.action_6){
            Intent intent = new Intent(MainActivity.this,Main6Activity.class);
            startActivity(intent);
        }else if (id == R.id.action_7){
            Intent intent = new Intent(MainActivity.this,Main7Activity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
