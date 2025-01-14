package com.amity.socialcloud.uikit.community.newsfeed.adapter

import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.amity.socialcloud.sdk.model.core.file.AmityImage
import com.amity.socialcloud.sdk.model.core.role.AmityRoles

import com.amity.socialcloud.sdk.model.core.user.AmityUser
import com.amity.socialcloud.sdk.model.social.community.AmityCommunity
import com.amity.socialcloud.sdk.model.social.post.AmityPost
import com.amity.socialcloud.uikit.common.common.readableFeedPostTime
import com.amity.socialcloud.uikit.common.components.setImageUrl
import com.amity.socialcloud.uikit.common.utils.AmityConstants
import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR
import com.amity.socialcloud.uikit.community.databinding.AmityItemBasePostHeaderBinding
import com.amity.socialcloud.uikit.community.newsfeed.events.PostOptionClickEvent
import com.amity.socialcloud.uikit.community.newsfeed.model.AmityBasePostHeaderItem
import io.reactivex.rxjava3.subjects.PublishSubject

class AmityPostHeaderViewHolder(
    itemView: View,
    private val userClickPublisher: PublishSubject<AmityUser>,
    private val communityClickPublisher: PublishSubject<AmityCommunity>,
    private val postOptionClickPublisher: PublishSubject<PostOptionClickEvent>
) : RecyclerView.ViewHolder(itemView) {

    private val context = itemView.context
    private val binding = AmityItemBasePostHeaderBinding.bind(itemView)

    fun bind(data: AmityBasePostHeaderItem) {
        setupView(data)
        setupListener(data.post)
    }

    private fun setupView(data: AmityBasePostHeaderItem) {
        val post = data.post
        renderAvatar(post)
        renderCreatorName(post)
        renderEditBadge(post)
        renderTimeStamp(post)
        renderModBadge(post)
        renderTarget(post, data.showTarget)
        renderPostOption(data.showOptions)
    }

    private fun renderAvatar(post: AmityPost) {
        val avatarURL = post.getCreator()?.getAvatar()?.getUrl(AmityImage.Size.SMALL)
        setImageUrl(
            binding.avatarView,
            avatarURL,
            ContextCompat.getDrawable(
                binding.avatarView.context,
                CommonR.drawable.amity_ic_default_profile_large
            )
        )
    }

    private fun renderCreatorName(post: AmityPost) {
        val postedUser = post.getCreator()
        val banIcon = if (postedUser?.isGlobalBan() == true) {
            ContextCompat.getDrawable(itemView.context, CommunityR.drawable.amity_ic_ban)
        } else {
            null
        }
        binding.userName.text = postedUser?.getDisplayName() ?: ""
        binding.userName.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, banIcon, null)
    }

    private fun renderEditBadge(post: AmityPost) {
        if (post.isEdited()) {
            binding.tvEdited.visibility = View.VISIBLE
        } else {
            binding.tvEdited.visibility = View.GONE
        }
    }

    private fun renderTimeStamp(post: AmityPost) {
        binding.feedPostTime.text = post.getCreatedAt()?.millis?.readableFeedPostTime(context) ?: ""
    }

    private fun renderPostOption(showOptions: Boolean) {
        if (showOptions) {
            binding.btnFeedAction.visibility = View.VISIBLE
        } else {
            binding.btnFeedAction.visibility = View.GONE
        }
    }

    private fun renderTarget(post: AmityPost, showTarget: Boolean) {
        val target = post.getTarget()
        val isTargetingOwnFeed = if (target is AmityPost.Target.USER) (target.getUser()
            ?.getUserId() ?: "") == post.getCreatorId() else false
        val shouldShowTarget = showTarget && !isTargetingOwnFeed
        var arrowIcon: Drawable? = null
        if (shouldShowTarget) {
            arrowIcon = ContextCompat.getDrawable(context, CommonR.drawable.amity_ic_arrow)
            val text = when (target) {
                is AmityPost.Target.COMMUNITY -> {
                    target.getCommunity()?.getDisplayName()?.trim() ?: ""
                }
                is AmityPost.Target.USER -> {
                    target.getUser()?.getDisplayName()?.trim() ?: ""
                }
                else -> {
                    ""
                }
            }
            binding.communityName.text = text
            binding.communityName.visibility = View.VISIBLE

        } else {
            arrowIcon = null
            binding.communityName.text = ""
            binding.communityName.visibility = View.GONE
        }
        val isOfficial =
            (post.getTarget() as? AmityPost.Target.COMMUNITY)?.getCommunity()?.isOfficial() ?: false
        val officialBadgeIcon = if (isOfficial) {
            ContextCompat.getDrawable(context, CommonR.drawable.amity_ic_verified)
        } else {
            null
        }
        binding.communityName.setCompoundDrawablesWithIntrinsicBounds(
            arrowIcon,
            null,
            officialBadgeIcon,
            null
        )
    }

    private fun renderModBadge(post: AmityPost) {
        val roles =
            (post.getTarget() as? AmityPost.Target.COMMUNITY)?.getCreatorMember()?.getRoles()
        if (isCommunityModerator(roles)) {
            binding.tvPostBy.visibility = View.VISIBLE
        } else {
            binding.tvPostBy.visibility = View.GONE
        }
    }

    private fun isCommunityModerator(roles: AmityRoles?): Boolean {
        return roles?.any {
            it == AmityConstants.MODERATOR_ROLE || it == AmityConstants.COMMUNITY_MODERATOR_ROLE
        } ?: false
    }

    private fun setupListener(post: AmityPost) {
        binding.avatarView.setOnClickListener {
            post.getCreator()?.let {
                userClickPublisher.onNext(it)
            }
        }

        binding.userName.setOnClickListener {
            post.getCreator()?.let {
                userClickPublisher.onNext(it)
            }
        }

        binding.communityName.setOnClickListener {
            val target = post.getTarget()
            when (target) {
                is AmityPost.Target.COMMUNITY -> {
                    target.getCommunity()?.let {
                        communityClickPublisher.onNext(it)
                    }
                }
                is AmityPost.Target.USER -> {
                    target.getUser()?.let {
                        userClickPublisher.onNext(it)
                    }
                }
                else -> {}
            }
        }

        binding.btnFeedAction.setOnClickListener {
            postOptionClickPublisher.onNext(PostOptionClickEvent(post))
        }

    }

}
