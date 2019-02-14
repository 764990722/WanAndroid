package zymk.wzmyyj.mytop.wanandroidmy.ui.view;

import android.support.design.widget.TabLayout;

import java.util.List;

import zymk.wzmyyj.mytop.wanandroidmy.ui.adapter.ArticleListAdapter;
import zymk.wzmyyj.mytop.wanandroidmy.ui.modle.ArticleBean;
import zymk.wzmyyj.mytop.wanandroidmy.widget.AutoLinefeedLayout;


/**
 * user：lqm
 * desc：分类View
 */

public interface TypeView {

    TabLayout getTabLayout();
    AutoLinefeedLayout getTagLayout();
    ArticleListAdapter getAdapter();

    void getDataError(String message);
    void getRefreshDataSuccess(List<ArticleBean> data);
    void getMoreDataSuccess(List<ArticleBean> data);

}
