# StickyDemo
三步实现控件悬浮
之前做项目的时候实现的一个悬浮效果，如图（可能不够清晰）
![meibei.gif](http://upload-images.jianshu.io/upload_images/1216032-05d8f2b54825f593.gif?imageMogr2/auto-orient/strip)
*接下来就是实现效果,如图所示*
![sticky.gif](http://upload-images.jianshu.io/upload_images/1216032-ffe9839fa6ec0c84.gif?imageMogr2/auto-orient/strip)
`demo直接用的截图`

原理很简单，用RecyclerView addHeaderView的方式实现，实现步骤：
>1.添加依赖
```
 compile 'com.github.CymChad:BaseRecyclerViewAdapterHelper:2.9.14'
 compile 'com.android.support:recyclerview-v7:25.1.0'
 ```
导入BaseRecyclerViewAdapterHelper，用于RecyclerView添加HeaderView;

>2.布局，用标签include，写入需要悬浮的view；主界面用帧布局FrameLayout
```
<FrameLayout
       android:layout_width="match_parent"
       android:layout_height="match_parent">
       <android.support.v7.widget.RecyclerView
           android:id="@+id/main_recycler"
           android:layout_width="match_parent"
           android:layout_height="match_parent"/>
    <include layout="@layout/include_header_product"/>
   </FrameLayout> 
	 ```;
然后布局headerView
```
<ImageView
        android:layout_width="wrap_content"
        android:src="@mipmap/img_header_category"
        android:adjustViewBounds="true"
        android:layout_height="wrap_content"/>
    <include layout="@layout/include_header_product"/>
		```

>3.逻辑，滑动的时候，对RecyclerView进行滑动监听然后在onScrollStateChanged(RecyclerView recyclerView, int newState)方法里监听悬浮View在
``屏幕上Y轴位移``，在onScrolled(RecyclerView recyclerView, int dx, int dy)里不停的获取headerView里面悬浮标签在``屏幕上Y轴位移``,
进行判断悬浮view的显示或隐藏
if (mHeaderView == null) return;
                int getTop = mHeaderView.getDistanceY();
                if (getTop <= imageY) {
                    mImageView.setVisibility(View.VISIBLE);
                } else {
                    mImageView.setY(0);
                    mImageView.setVisibility(View.GONE);
                }
								

[简书地址](http://www.jianshu.com/p/167507486ff2)

[apk下载](https://fir.im/sticky)
