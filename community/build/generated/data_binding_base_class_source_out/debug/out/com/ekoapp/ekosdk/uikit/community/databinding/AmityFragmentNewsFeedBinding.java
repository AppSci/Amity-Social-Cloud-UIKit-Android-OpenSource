// Generated by data binding compiler. Do not edit!
package com.ekoapp.ekosdk.uikit.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.ekoapp.ekosdk.uikit.community.R;
import com.ekoapp.ekosdk.uikit.community.newsfeed.viewmodel.EkoNewsFeedViewModel;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class AmityFragmentNewsFeedBinding extends ViewDataBinding {
  @NonNull
  public final AppBarLayout appBar;

  @NonNull
  public final MaterialButton btnExplore;

  @NonNull
  public final CollapsingToolbarLayout collapsingToolbar;

  @NonNull
  public final View divider;

  @NonNull
  public final FloatingActionButton fabCreatePost;

  @NonNull
  public final FrameLayout globalFeedContainer;

  @NonNull
  public final ImageView ivIcon;

  @NonNull
  public final FrameLayout myCommunityContainer;

  @NonNull
  public final SwipeRefreshLayout refreshLayout;

  @NonNull
  public final TextView tvCreateCommunity;

  @NonNull
  public final TextView tvEmptyGlobalFeed;

  @NonNull
  public final TextView tvFindCommunity;

  @Bindable
  protected EkoNewsFeedViewModel mViewModel;

  protected AmityFragmentNewsFeedBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppBarLayout appBar, MaterialButton btnExplore, CollapsingToolbarLayout collapsingToolbar,
      View divider, FloatingActionButton fabCreatePost, FrameLayout globalFeedContainer,
      ImageView ivIcon, FrameLayout myCommunityContainer, SwipeRefreshLayout refreshLayout,
      TextView tvCreateCommunity, TextView tvEmptyGlobalFeed, TextView tvFindCommunity) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appBar = appBar;
    this.btnExplore = btnExplore;
    this.collapsingToolbar = collapsingToolbar;
    this.divider = divider;
    this.fabCreatePost = fabCreatePost;
    this.globalFeedContainer = globalFeedContainer;
    this.ivIcon = ivIcon;
    this.myCommunityContainer = myCommunityContainer;
    this.refreshLayout = refreshLayout;
    this.tvCreateCommunity = tvCreateCommunity;
    this.tvEmptyGlobalFeed = tvEmptyGlobalFeed;
    this.tvFindCommunity = tvFindCommunity;
  }

  public abstract void setViewModel(@Nullable EkoNewsFeedViewModel viewModel);

  @Nullable
  public EkoNewsFeedViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static AmityFragmentNewsFeedBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.amity_fragment_news_feed, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static AmityFragmentNewsFeedBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<AmityFragmentNewsFeedBinding>inflateInternal(inflater, R.layout.amity_fragment_news_feed, root, attachToRoot, component);
  }

  @NonNull
  public static AmityFragmentNewsFeedBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.amity_fragment_news_feed, null, false, component)
   */
  @NonNull
  @Deprecated
  public static AmityFragmentNewsFeedBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<AmityFragmentNewsFeedBinding>inflateInternal(inflater, R.layout.amity_fragment_news_feed, null, false, component);
  }

  public static AmityFragmentNewsFeedBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static AmityFragmentNewsFeedBinding bind(@NonNull View view, @Nullable Object component) {
    return (AmityFragmentNewsFeedBinding)bind(component, view, R.layout.amity_fragment_news_feed);
  }
}