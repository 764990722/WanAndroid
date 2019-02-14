package zymk.wzmyyj.mytop.wanandroidmy.ui.presenter;


import java.util.List;

import zymk.wzmyyj.mytop.wanandroidmy.api.WanService;
import zymk.wzmyyj.mytop.wanandroidmy.helper.rxjavahelper.RxObserver;
import zymk.wzmyyj.mytop.wanandroidmy.helper.rxjavahelper.RxResultHelper;
import zymk.wzmyyj.mytop.wanandroidmy.helper.rxjavahelper.RxSchedulersHelper;
import zymk.wzmyyj.mytop.wanandroidmy.ui.base.BasePresenter;
import zymk.wzmyyj.mytop.wanandroidmy.ui.modle.ArticleListVO;
import zymk.wzmyyj.mytop.wanandroidmy.ui.modle.HotKeyBean;
import zymk.wzmyyj.mytop.wanandroidmy.ui.view.SearchView;

/**
 * user：lqm
 * desc：搜索
 */

public class SearchPresenter extends BasePresenter<SearchView> {


    private int mCurrentPage;

    //热门搜索
    public void getHotKeyData() {
        WanService.getHotKey()
                .compose(RxSchedulersHelper.io_main())
                .compose(RxResultHelper.handleResult())
                .subscribe(new RxObserver<List<HotKeyBean>>() {
                    @Override
                    public void _onNext(List<HotKeyBean> hotKeyBeans) {
                        getView().getHotKeySuccess(hotKeyBeans);
                    }

                    @Override
                    public void _onError(String errorMessage) {
                        getView().getHotKeyFail(errorMessage);
                    }
                });
    }

    //搜索
    public void searchData(String key) {
        mCurrentPage = 0;
        WanService.searchArticle(mCurrentPage, key)
                .compose(RxSchedulersHelper.io_main())
                .compose(RxResultHelper.handleResult())
                .subscribe(new RxObserver<ArticleListVO>() {
                    @Override
                    public void _onNext(ArticleListVO articleListVO) {
                        getView().searchDataSuccess(articleListVO.getDatas());
                    }

                    @Override
                    public void _onError(String errorMessage) {
                        getView().searchDataFail(errorMessage);
                    }
                });
    }

    //加载更多
    public void getMoreData(String key) {
        mCurrentPage += 1;
        WanService.searchArticle(mCurrentPage, key)
            .compose(RxSchedulersHelper.io_main())
            .compose(RxResultHelper.handleResult())
            .subscribe(new RxObserver<ArticleListVO>() {
                @Override
                public void _onNext(ArticleListVO articleListVO) {
                    getView().loadMoreDataSuccess(articleListVO.getDatas());
                }

                @Override
                public void _onError(String errorMessage) {
                    getView().loadMoreDataFail(errorMessage);
                }
            });
    }

}
