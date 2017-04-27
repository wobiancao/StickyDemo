package wobiancao.stickydemo.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView mImageView;
    RecyclerView mRecyclerView;
    HeaderProductLayout mHeaderView;
    int imageY = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.header_product_image);
        mRecyclerView = (RecyclerView) findViewById(R.id.main_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            strings.add("" + i);
        }
        mHeaderView = new HeaderProductLayout(this);
        SimpleAdapter simpleAdapter = new SimpleAdapter(strings);
        simpleAdapter.addHeaderView(mHeaderView);
        mRecyclerView.setAdapter(simpleAdapter);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int[] location = new int[2];
                mImageView.getLocationOnScreen(location);
                int y = location[1];
                imageY = y;
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (mHeaderView == null) return;
                int getTop = mHeaderView.getDistanceY();
                if (getTop <= imageY) {
                    mImageView.setVisibility(View.VISIBLE);
                } else {
                    mImageView.setY(0);
                    mImageView.setVisibility(View.GONE);
                }
            }
        });
    }
}
