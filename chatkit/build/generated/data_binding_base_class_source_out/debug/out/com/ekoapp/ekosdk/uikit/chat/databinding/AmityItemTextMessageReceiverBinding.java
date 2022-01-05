// Generated by data binding compiler. Do not edit!
package com.ekoapp.ekosdk.uikit.chat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ekoapp.ekosdk.uikit.chat.R;
import com.ekoapp.ekosdk.uikit.chat.messages.viewModel.EkoTextMessageViewModel;
import com.ekoapp.ekosdk.uikit.components.EkoReadMoreTextView;
import com.ekoapp.ekosdk.uikit.components.ILongPressListener;
import com.google.android.material.imageview.ShapeableImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class AmityItemTextMessageReceiverBinding extends ViewDataBinding {
  @NonNull
  public final AmityViewDateBinding dateHeader;

  @NonNull
  public final ShapeableImageView ivAvatar;

  @NonNull
  public final EkoReadMoreTextView tvMessageIncoming;

  @NonNull
  public final TextView tvName;

  @NonNull
  public final TextView tvTime;

  @Bindable
  protected EkoTextMessageViewModel mVmTextMessage;

  @Bindable
  protected ILongPressListener mLonPressListener;

  protected AmityItemTextMessageReceiverBinding(Object _bindingComponent, View _root,
      int _localFieldCount, AmityViewDateBinding dateHeader, ShapeableImageView ivAvatar,
      EkoReadMoreTextView tvMessageIncoming, TextView tvName, TextView tvTime) {
    super(_bindingComponent, _root, _localFieldCount);
    this.dateHeader = dateHeader;
    setContainedBinding(this.dateHeader);
    this.ivAvatar = ivAvatar;
    this.tvMessageIncoming = tvMessageIncoming;
    this.tvName = tvName;
    this.tvTime = tvTime;
  }

  public abstract void setVmTextMessage(@Nullable EkoTextMessageViewModel vmTextMessage);

  @Nullable
  public EkoTextMessageViewModel getVmTextMessage() {
    return mVmTextMessage;
  }

  public abstract void setLonPressListener(@Nullable ILongPressListener lonPressListener);

  @Nullable
  public ILongPressListener getLonPressListener() {
    return mLonPressListener;
  }

  @NonNull
  public static AmityItemTextMessageReceiverBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.amity_item_text_message_receiver, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static AmityItemTextMessageReceiverBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<AmityItemTextMessageReceiverBinding>inflateInternal(inflater, R.layout.amity_item_text_message_receiver, root, attachToRoot, component);
  }

  @NonNull
  public static AmityItemTextMessageReceiverBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.amity_item_text_message_receiver, null, false, component)
   */
  @NonNull
  @Deprecated
  public static AmityItemTextMessageReceiverBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<AmityItemTextMessageReceiverBinding>inflateInternal(inflater, R.layout.amity_item_text_message_receiver, null, false, component);
  }

  public static AmityItemTextMessageReceiverBinding bind(@NonNull View view) {
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
  public static AmityItemTextMessageReceiverBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (AmityItemTextMessageReceiverBinding)bind(component, view, R.layout.amity_item_text_message_receiver);
  }
}