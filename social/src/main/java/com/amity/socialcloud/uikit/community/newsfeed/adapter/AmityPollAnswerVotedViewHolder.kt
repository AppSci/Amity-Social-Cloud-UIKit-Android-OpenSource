package com.amity.socialcloud.uikit.community.newsfeed.adapter

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import com.amity.socialcloud.sdk.model.social.poll.AmityPollAnswer
import com.amity.socialcloud.uikit.common.base.AmityViewHolder
import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR
import com.amity.socialcloud.uikit.community.databinding.AmityItemPollAnswerVotedBinding

class AmityPollAnswerVotedViewHolder(val context: Context, private val totalVoteCount: Int) :
    AmityViewHolder<AmityPollAnswer>(
        View.inflate(
            context,
            CommunityR.layout.amity_item_poll_answer_voted,
            null
        )
    ) {

    override fun bind(data: AmityPollAnswer) {
        val binding = AmityItemPollAnswerVotedBinding.bind(itemView)

        binding.answerTextView.text = data.data

        binding.voteCountProgressBar.max = totalVoteCount
        binding.voteCountProgressBar.progress = data.voteCount
        binding.voteCountProgressBar.progressDrawable = when (data.isVotedByUser) {
            true -> ContextCompat.getDrawable(
                context,
                CommunityR.drawable.amity_bg_poll_answer_progress_voted
            )
            false -> ContextCompat.getDrawable(context, CommunityR.drawable.amity_bg_poll_answer_progress)
        }

        binding.voteCountTextView.setTextColor(
            when (data.isVotedByUser) {
                true -> ContextCompat.getColor(context, CommonR.color.amityColorPrimary)
                false -> ContextCompat.getColor(context, CommunityR.color.amityColorShuttleGray)
            }
        )

        binding.voteCountTextView.text = context.resources.getQuantityString(
            CommunityR.plurals.amity_poll_vote_count,
            data.voteCount,
            data.voteCount
        )

        binding.answerCardView.setCardBackgroundColor(
            when (data.isVotedByUser) {
                true -> ContextCompat.getColor(context, CommonR.color.amityColorPrimary)
                false -> ContextCompat.getColor(context, CommonR.color.amityColorWhite)
            }
        )

        binding.answerCardView.strokeColor = when (data.isVotedByUser) {
            true -> ContextCompat.getColor(context, CommonR.color.amityColorPrimary)
            false -> ContextCompat.getColor(context, CommonR.color.upstraMessageBubbleInverse)
        }
    }
}
