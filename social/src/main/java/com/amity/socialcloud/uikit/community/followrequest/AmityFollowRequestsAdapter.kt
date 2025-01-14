package com.amity.socialcloud.uikit.community.followrequest

import android.content.Context
import android.content.DialogInterface
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.amity.socialcloud.sdk.model.core.follow.AmityFollowRelationship
import com.amity.socialcloud.uikit.common.base.AmityBaseRecyclerViewPagingDataAdapter
import com.amity.socialcloud.uikit.common.common.showSnackBar
import com.amity.socialcloud.uikit.common.utils.AmityAlertDialogUtil
import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR
import com.amity.socialcloud.uikit.community.databinding.AmityItemFollowRequestBinding

class AmityFollowRequestsAdapter(private val context: Context) :
    AmityBaseRecyclerViewPagingDataAdapter<AmityFollowRelationship>(diffCallBack) {

    override fun getLayoutId(position: Int, obj: AmityFollowRelationship?): Int =
        CommunityR.layout.amity_item_follow_request

    override fun getViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder {
        val itemViewModel = AmityItemFollowRequestViewModel()
        return AmityFollowRequestsViewHolder(view, context, itemViewModel)
    }

    class AmityFollowRequestsViewHolder(
        itemView: View, private val context: Context,
        private val itemViewModel: AmityItemFollowRequestViewModel
    ) : RecyclerView.ViewHolder(itemView),
        Binder<AmityFollowRelationship> {

        private val binding: AmityItemFollowRequestBinding? = DataBindingUtil.bind(itemView)

        override fun bind(data: AmityFollowRelationship?, position: Int) {
            data?.let {
                binding?.apply {
                    user = data.getSourceUser()

                    btnAccept.setOnClickListener {
                        itemViewModel.accept(user?.getUserId() ?: "",
                            onSuccess = {
                                itemView.showSnackBar(context.getString(CommunityR.string.amity_done))
                            },
                            onError = {
                                showErrorDialog()
                            })
                            .subscribe()
                    }

                    btnDecline.setOnClickListener {
                        itemViewModel.decline(user?.getUserId() ?: "",
                            onSuccess = {
                                itemView.showSnackBar(context.getString(CommunityR.string.amity_done))
                            },
                            onError = {
                                showErrorDialog()
                            })
                            .subscribe()
                    }
                }
            }
        }

        private fun showErrorDialog() {
            AmityAlertDialogUtil.showDialog(
                context = context,
                title = context.getString(CommunityR.string.amity_request_error),
                msg = context.getString(CommunityR.string.amity_request_withdrawn),
                positiveButton = context.getString(CommonR.string.amity_ok),
                negativeButton = null
            ) { dialog, which ->
                if (which == DialogInterface.BUTTON_POSITIVE) {
                    dialog.cancel()
                }
            }
        }

    }

    companion object {
        private val diffCallBack = object : DiffUtil.ItemCallback<AmityFollowRelationship>() {

            override fun areItemsTheSame(
                oldItem: AmityFollowRelationship,
                newItem: AmityFollowRelationship
            ): Boolean =
                oldItem.getSourceUser()?.getUserId() == newItem.getSourceUser()?.getUserId()

            override fun areContentsTheSame(
                oldItem: AmityFollowRelationship,
                newItem: AmityFollowRelationship
            ): Boolean = oldItem.getStatus() == newItem.getStatus()
        }
    }
}
