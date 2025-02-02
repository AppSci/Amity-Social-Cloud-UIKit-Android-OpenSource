package com.amity.socialcloud.uikit.community.newsfeed.adapter

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.amity.socialcloud.sdk.model.core.user.AmityUser
import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR
import com.amity.socialcloud.uikit.community.databinding.AmityItemUserMentionBinding
import com.amity.socialcloud.uikit.community.newsfeed.model.AmityUserMention

class AmityUserMentionPagingDataViewHolder constructor(
    private val binding: AmityItemUserMentionBinding,
    private val listener: AmityUserMentionViewHolder.AmityUserMentionListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: AmityUser?) {
        data?.let { userItem ->
            val banIcon = if (userItem.isGlobalBan()) {
                ContextCompat.getDrawable(itemView.context, CommunityR.drawable.amity_ic_ban)
            } else {
                null
            }
            binding.apply {
                user = userItem
                userMention = AmityUserMention(userItem)
                isGlobalBan = userItem.isGlobalBan()
                textviewDisplayname.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    null,
                    null,
                    banIcon,
                    null
                )
                clickListener = listener
            }
        }
    }
}
