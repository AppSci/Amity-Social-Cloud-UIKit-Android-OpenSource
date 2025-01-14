package com.amity.socialcloud.uikit.community.mycommunity.adapter

import android.view.View
import android.widget.LinearLayout
import com.amity.socialcloud.sdk.model.social.community.AmityCommunity
import com.amity.socialcloud.uikit.common.common.setBackgroundColor
import com.amity.socialcloud.uikit.common.common.views.AmityColorShade
import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR
import com.amity.socialcloud.uikit.community.mycommunity.listener.AmityMyCommunityItemClickListener
import com.google.android.material.imageview.ShapeableImageView

class AmityViewAllCommunityPreviewItemViewHolder(itemView: View, val listener: AmityMyCommunityItemClickListener) : AmityBaseMyCommunityPreviewItemViewHolder(itemView) {

    private val viewMoreLayout: LinearLayout = itemView.findViewById(CommunityR.id.layout_view_more)
    private val avatar: ShapeableImageView = itemView.findViewById(CommunityR.id.ivAvatar)

    override fun bind(data: AmityCommunity?, position: Int) {
        avatar.setBackgroundColor(null, AmityColorShade.SHADE4)
        avatar.setImageResource(CommonR.drawable.amity_ic_arrow_forward)

        viewMoreLayout.setOnClickListener {
            listener.onCommunitySelected(null)
        }
    }

}
