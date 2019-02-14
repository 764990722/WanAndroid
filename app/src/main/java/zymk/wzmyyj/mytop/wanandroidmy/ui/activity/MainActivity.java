package zymk.wzmyyj.mytop.wanandroidmy.ui.activity;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import zymk.wzmyyj.mytop.wanandroidmy.R;
import zymk.wzmyyj.mytop.wanandroidmy.ui.adapter.FragPagerAdapter;
import zymk.wzmyyj.mytop.wanandroidmy.ui.base.BaseActivity;
import zymk.wzmyyj.mytop.wanandroidmy.ui.base.BasePresenter;
import zymk.wzmyyj.mytop.wanandroidmy.ui.fragment.HomeFragment;
import zymk.wzmyyj.mytop.wanandroidmy.ui.fragment.TypeFragment;
import zymk.wzmyyj.mytop.wanandroidmy.ui.fragment.UserFragment;
import zymk.wzmyyj.mytop.wanandroidmy.util.UIUtils;
import zymk.wzmyyj.mytop.wanandroidmy.widget.IconFontTextView;


public class MainActivity extends BaseActivity {

    @Bind(R.id.viewpager)
    ViewPager viewPager;
    @Bind(R.id.if_home)
    IconFontTextView ifHome;
    @Bind(R.id.tv_home)
    TextView tvHome;
    @Bind(R.id.ll_home)
    LinearLayout llHome;
    @Bind(R.id.if_type)
    IconFontTextView ifType;
    @Bind(R.id.tv_type)
    TextView tvType;
    @Bind(R.id.ll_type)
    LinearLayout llType;
    @Bind(R.id.if_user)
    IconFontTextView ifUser;
    @Bind(R.id.tv_user)
    TextView tvUser;
    @Bind(R.id.ll_user)
    LinearLayout llUser;
    @Bind(R.id.tv_hot)
    IconFontTextView tvHot;
    @Bind(R.id.tv_search)
    IconFontTextView tvSearch;

    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

        setTabColor(ifHome, tvHome);
        mFragments.add(HomeFragment.newInstance());
        mFragments.add(TypeFragment.newInstance());
        mFragments.add(UserFragment.newInstance());
        viewPager.setAdapter(new FragPagerAdapter(getSupportFragmentManager(), mFragments));
        viewPager.setCurrentItem(0, false);
        viewPager.setOffscreenPageLimit(3);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        setTabColor(ifHome, tvHome);
                        break;
                    case 1:
                        setTabColor(ifType, tvType);
                        break;
                    case 2:
                        setTabColor(ifUser, tvUser);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick({R.id.ll_home, R.id.ll_type,R.id.ll_user, R.id.tv_hot, R.id.tv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_home:
                viewPager.setCurrentItem(0);
                setTabColor(ifHome, tvHome);
                break;
            case R.id.ll_type:
                viewPager.setCurrentItem(1);
                setTabColor(ifType, tvType);
                break;
            case R.id.ll_user:
                viewPager.setCurrentItem(2);
                setTabColor(ifUser, tvUser);
                break;
            case R.id.tv_hot:

                break;
            case R.id.tv_search:
                startActivity(new Intent(MainActivity.this,SearchActivity.class));
                break;
        }
    }

    private void setTabColor(IconFontTextView icon, TextView textView) {
        ifHome.setTextColor(UIUtils.getColor(R.color.tab_nor_color));
        tvHome.setTextColor(UIUtils.getColor(R.color.tab_nor_color));
        ifType.setTextColor(UIUtils.getColor(R.color.tab_nor_color));
        tvType.setTextColor(UIUtils.getColor(R.color.tab_nor_color));
        ifUser.setTextColor(UIUtils.getColor(R.color.tab_nor_color));
        tvUser.setTextColor(UIUtils.getColor(R.color.tab_nor_color));
        icon.setTextColor(UIUtils.getColor(R.color.tab_sel_color));
        textView.setTextColor(UIUtils.getColor(R.color.tab_sel_color));
    }


}