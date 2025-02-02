package com.amity.socialcloud.uikit.community.notificationsettings.pushDetail

import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR
import com.amity.socialcloud.uikit.community.setting.AmitySettingsItem

class AmityCommentMenuCreatorImpl(private val fragment: AmityCommunityBaseNotificationSettingsFragment): AmityCommentMenuCreator {
    override fun createReactCommentsMenu(communityId: String): AmitySettingsItem.TextContent {
        return AmitySettingsItem.TextContent(
            title = CommunityR.string.amity_reacts_comments,
            isTitleBold = true,
            description = CommunityR.string.amity_reacts_comments_description,
            callback = {}
        )
    }

    override fun createReactCommentsRadioMenu(
        communityId: String,
        choices: List<Pair<Int, Boolean>>
    ): AmitySettingsItem.RadioContent {
        return AmitySettingsItem.RadioContent(
            choices = choices,
            callback = fragment::toggleReactComment
        )
    }

    override fun createNewCommentsMenu(communityId: String): AmitySettingsItem.TextContent {
        return AmitySettingsItem.TextContent(
            title = CommunityR.string.amity_new_comments,
            isTitleBold = true,
            description = CommunityR.string.amity_new_comments_description,
            callback = {}
        )
    }

    override fun createNewCommentsRadioMenu(
        communityId: String,
        choices: List<Pair<Int, Boolean>>
    ): AmitySettingsItem.RadioContent {
        return AmitySettingsItem.RadioContent(
            choices = choices,
            callback = fragment::toggleNewComment
        )
    }

    override fun createReplyCommentsMenu(communityId: String): AmitySettingsItem.TextContent {
        return AmitySettingsItem.TextContent(
            title = CommunityR.string.amity_replies,
            isTitleBold = true,
            description = CommunityR.string.amity_replies_description,
            callback = {}
        )
    }

    override fun createReplyCommentsRadioMenu(
        communityId: String,
        choices: List<Pair<Int, Boolean>>
    ): AmitySettingsItem.RadioContent {
        return AmitySettingsItem.RadioContent(
            choices = choices,
            callback = fragment::toggleReplyComment
        )
    }
}
