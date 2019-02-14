package zymk.wzmyyj.mytop.wanandroidmy.ui.presenter;



import java.util.List;

import io.reactivex.disposables.Disposable;
import zymk.wzmyyj.mytop.wanandroidmy.api.WanService;
import zymk.wzmyyj.mytop.wanandroidmy.helper.rxjavahelper.RxObserver;
import zymk.wzmyyj.mytop.wanandroidmy.helper.rxjavahelper.RxResultHelper;
import zymk.wzmyyj.mytop.wanandroidmy.helper.rxjavahelper.RxSchedulersHelper;
import zymk.wzmyyj.mytop.wanandroidmy.ui.base.BasePresenter;
import zymk.wzmyyj.mytop.wanandroidmy.ui.modle.ArticleListVO;
import zymk.wzmyyj.mytop.wanandroidmy.ui.modle.BannerBean;
import zymk.wzmyyj.mytop.wanandroidmy.ui.view.HomeView;

/**
 * user：lqm
 * desc：首页
 */

public class HomePresenter extends BasePresenter<HomeView> {

    private int mCurrentPage;

    //刷新
    public void getRefreshData() {
        mCurrentPage = 0;
        WanService.getHomeData(mCurrentPage)
                .compose(RxSchedulersHelper.io_main())
                .compose(RxResultHelper.handleResult())
                .subscribe(new RxObserver<ArticleListVO>() {
                    @Override
                    public void _onSubscribe(Disposable d) {
                        getView().showRefreshView(true);
                    }

                    @Override
                    public void _onNext(ArticleListVO articleListVO) {
                        getView().getRefreshDataSuccess(articleListVO.getDatas());
                    }

                    @Override
                    public void _onError(String message) {
                        getView().getDataError(message);
                    }

                    @Override
                    public void _onComplete() {
                        getView().showRefreshView(false);
                    }
                });
    }

    //加载更多
    public void getMoreData() {
        mCurrentPage = mCurrentPage + 1;
        WanService.getHomeData(mCurrentPage)
                .compose(RxSchedulersHelper.io_main())
                .compose(RxResultHelper.handleResult())
                .subscribe(new RxObserver<ArticleListVO>() {
                    @Override
                    public void _onNext(ArticleListVO articleListVO) {
                        getView().getMoreDataSuccess(articleListVO.getDatas());
                    }

                    @Override
                    public void _onError(String errorMessage) {
                        getView().getDataError(errorMessage);
                    }
                });
    }

    //获取轮播图数据
    public void getBannerData() {

        WanService.getBannerData()
                .compose(RxSchedulersHelper.io_main())
                .compose(RxResultHelper.handleResult())
                .subscribe(new RxObserver<List<BannerBean>>() {
                    @Override
                    public void _onNext(List<BannerBean> bannerBeans) {
                        getView().getBannerDataSuccess(bannerBeans);
                    }

                    @Override
                    public void _onError(String errorMessage) {
                        getView().getDataError(errorMessage);
                    }
                });
    }

}