package wobiancao.stickydemo.app;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by wxy on 2017/4/27.
 */

public class SimpleAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public SimpleAdapter(@Nullable List<String> data) {
        super(R.layout.item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
