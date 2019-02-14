package zymk.wzmyyj.mytop.wanandroidmy.ui.view;


import java.util.List;

import zymk.wzmyyj.mytop.wanandroidmy.ui.modle.ArticleBean;
import zymk.wzmyyj.mytop.wanandroidmy.ui.modle.BannerBean;

/**
 * user：lqm
 * desc：首页
 */

public interface HomeView {

    void showRefreshView(Boolean refresh);
    void getBannerDataSuccess(List<BannerBean> data);
    void getDataError(String message);
    void getRefreshDataSuccess(List<ArticleBean> data);
    void getMoreDataSuccess(List<ArticleBean> data);

}
