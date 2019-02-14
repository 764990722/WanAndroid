package zymk.wzmyyj.mytop.wanandroidmy.ui.view;


import java.util.List;

import zymk.wzmyyj.mytop.wanandroidmy.ui.modle.ArticleBean;
import zymk.wzmyyj.mytop.wanandroidmy.ui.modle.HotKeyBean;

/**
 * user：lqm
 * desc：搜索
 */

public interface SearchView {
    void getHotKeySuccess(List<HotKeyBean> data);

    void getHotKeyFail(String message);

    void searchDataSuccess(List<ArticleBean> data);

    void searchDataFail(String message);

    void loadMoreDataSuccess(List<ArticleBean> data);

    void loadMoreDataFail(String message);
}
