package com.amity.socialcloud.uikit.community.notificationsettings.pushDetail

import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR
import com.amity.socialcloud.uikit.community.setting.AmitySettingsItem

class AmityPostMenuCreatorImpl(private val fragment: AmityCommunityBaseNotificationSettingsFragment): AmityPostMenuCreator {
    override fun createReactPostMenu(communityId: String): AmitySettingsItem.TextContent {
        return AmitySettingsItem.TextContent(
            title = CommunityR.string.amity_reacts_post,
            isTitleBold = true,
            description = CommunityR.string.amity_reacts_post_description,
            callback = {}
        )
    }

    override fun createReactPostRadioMenu(
        communityId: String,
        choices: List<Pair<Int, Boolean>>
    ): AmitySettingsItem.RadioContent {
        return AmitySettingsItem.RadioContent(
            choices = choices,
            callback = fragment::toggleReactPost
        )
    }

    override fun createNewPostMenu(communityId: String): AmitySettingsItem.TextContent {
        return AmitySettingsItem.TextContent(
            title = CommunityR.string.amity_new_posts,
            isTitleBold = true,
            description = CommunityR.string.amity_new_posts_description,
            callback = {}
        )
    }

    override fun createNewPostRadioMenu(
        communityId: String,
        choices: List<Pair<Int, Boolean>>
    ): AmitySettingsItem.RadioContent {
        return AmitySettingsItem.RadioContent(
            choices = choices,
            callback = fragment::toggleNewPost
        )
    }
}
