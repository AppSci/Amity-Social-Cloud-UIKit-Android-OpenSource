package com.amity.socialcloud.uikit.community.newsfeed.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR
import com.amity.socialcloud.uikit.community.domain.model.AmityFileAttachment
import com.amity.socialcloud.uikit.community.newsfeed.listener.AmityCreatePostFileActionListener

class AmityCreatePostFileAdapter(val listener: AmityCreatePostFileActionListener?) :
    AmityBasePostAttachmentAdapter() {

    override fun getLayoutId(position: Int, obj: AmityFileAttachment?): Int {
        return CommunityR.layout.amity_item_create_post_file
    }

    override fun getViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder {
        return AmityCreatePostFileViewHolder(view, listener)
    }
}
