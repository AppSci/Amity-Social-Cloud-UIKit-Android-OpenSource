package com.amity.socialcloud.uikit.community.mycommunity.adapter

import android.view.View
import com.amity.socialcloud.sdk.model.social.community.AmityCommunity
import com.amity.socialcloud.uikit.common.base.AmityBaseRecyclerViewPagingDataAdapter
import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR
import com.amity.socialcloud.uikit.community.mycommunity.listener.AmityMyCommunityItemClickListener


class AmityMyCommunityPreviewAdapter(private val listener: AmityMyCommunityItemClickListener) :
    AmityBaseRecyclerViewPagingDataAdapter<AmityCommunity>(AmityMyCommunityDiffImpl.diffCallBack) {

    private val VIEW_ALL_ITEM_POSITION = 8

    override fun getLayoutId(position: Int, obj: AmityCommunity?): Int {
        return if (position == VIEW_ALL_ITEM_POSITION) {
            CommunityR.layout.amity_item_my_community_more
        } else {
            CommunityR.layout.amity_item_my_community
        }
    }

    override fun getViewHolder(view: View, viewType: Int): AmityBaseMyCommunityPreviewItemViewHolder {
        return when (viewType) {
            CommunityR.layout.amity_item_my_community_more -> {
                AmityViewAllCommunityPreviewItemViewHolder(view, listener)
            }
            else -> {
                AmityMyCommunityPreviewItemViewHolder(view, listener)
            }
        }
    }

    override fun getItemCount(): Int {
        return Math.min(super.getItemCount(), VIEW_ALL_ITEM_POSITION + 1)
    }

}
