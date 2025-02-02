package com.amity.socialcloud.uikit.community.newsfeed.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.amity.socialcloud.sdk.model.core.user.AmityUser
import com.amity.socialcloud.uikit.common.base.AmityBaseRecyclerViewPagingDataAdapter
import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR
import com.amity.socialcloud.uikit.community.newsfeed.diffutil.UserDiffUtil
import com.amity.socialcloud.uikit.community.newsfeed.model.AmityUserMention

class AmityUserMentionAdapter :
    AmityBaseRecyclerViewPagingDataAdapter<AmityUser>(UserDiffUtil()),
    AmityUserMentionViewHolder.AmityUserMentionListener {

    private var listener: AmityUserMentionAdapterListener? = null

    override fun getLayoutId(position: Int, obj: AmityUser?) = CommunityR.layout.amity_item_user_mention

    override fun getViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder {
        return AmityUserMentionViewHolder(view, this)
    }

    override fun onClickUserMention(userMention: AmityUserMention) {
        listener?.onClickUserMention(userMention)
    }

    fun setListener(listener: AmityUserMentionAdapterListener) {
        this.listener = listener
    }

    interface AmityUserMentionAdapterListener {
        fun onClickUserMention(userMention: AmityUserMention)
    }
}
