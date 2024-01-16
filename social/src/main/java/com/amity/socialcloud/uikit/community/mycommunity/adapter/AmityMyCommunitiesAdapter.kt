package com.amity.socialcloud.uikit.community.mycommunity.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.amity.socialcloud.sdk.model.social.community.AmityCommunity
import com.amity.socialcloud.uikit.common.base.AmityBaseRecyclerViewPagingDataAdapter
import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR
import com.amity.socialcloud.uikit.community.mycommunity.listener.AmityMyCommunityItemClickListener

class AmityMyCommunitiesAdapter(private val listener: AmityMyCommunityItemClickListener) :
    AmityBaseRecyclerViewPagingDataAdapter<AmityCommunity>(AmityMyCommunityDiffImpl.diffCallBack) {

    override fun getLayoutId(position: Int, obj: AmityCommunity?): Int =
        CommunityR.layout.amity_item_community

    override fun getViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder =
        AmityMyCommunitiesViewHolder(view, listener)


}
