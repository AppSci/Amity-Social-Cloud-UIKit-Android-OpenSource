package com.amity.socialcloud.uikit.community.newsfeed.adapter

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.amity.socialcloud.sdk.model.social.post.AmityPost
import com.amity.socialcloud.uikit.common.common.views.AmityColorPaletteUtil
import com.amity.socialcloud.uikit.common.common.views.AmityColorShade
import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR

class AmityPostItemUnknownViewHolder(itemView: View) : AmityPostContentViewHolder(itemView) {

    private val tvSomethingWentWrong: TextView = itemView.findViewById(CommunityR.id.tvSomethingWentWrong)
    private val tvUnRecognizedPost: TextView = itemView.findViewById(CommunityR.id.tvUnrecognizedPost)

    override fun bind(post: AmityPost) {
        tvSomethingWentWrong.setTextColor(
            AmityColorPaletteUtil.getColor(
                ContextCompat.getColor(
                    tvSomethingWentWrong.context, CommonR.color.upstraColorBase
                ), AmityColorShade.SHADE3
            )
        )

        tvUnRecognizedPost.setTextColor(
            AmityColorPaletteUtil.getColor(
                ContextCompat.getColor(
                    tvUnRecognizedPost.context, CommonR.color.upstraColorBase
                ), AmityColorShade.SHADE3
            )
        )
    }
}
