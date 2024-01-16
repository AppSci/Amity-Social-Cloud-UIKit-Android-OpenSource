package com.amity.socialcloud.uikit.community.setting.user

import com.amity.socialcloud.sdk.model.core.user.AmityUser
import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR
import com.amity.socialcloud.uikit.community.setting.AmitySettingsItem

class AmityOtherUserSettingsMenuCreatorImpl(private val fragment: AmityUserSettingsFragment) :
    AmityOtherUserSettingsMenuCreator {
    override fun createManageHeader(): AmitySettingsItem.Header {
        return AmitySettingsItem.Header(
            title = CommunityR.string.amity_manage
        )
    }

    override fun createNotificationMenu(
        userId: String,
        value: Int
    ): AmitySettingsItem.NavigationContent {
        return AmitySettingsItem.NavigationContent(
            icon = CommunityR.drawable.amity_ic_bell,
            title = CommunityR.string.amity_notifications,
            value = value,
            callback = { }
        )
    }

    override fun createUnfollowMenu(userId: String): AmitySettingsItem.NavigationContent {
        return AmitySettingsItem.NavigationContent(
            title = CommunityR.string.amity_unfollow,
            icon = CommunityR.drawable.amity_ic_unfollow,
            iconNavigation = null,
            callback = { fragment.showUnfollowDialog(userId) }
        )
    }

    override fun createReportUserMenu(user: AmityUser): AmitySettingsItem.NavigationContent {
        return AmitySettingsItem.NavigationContent(
            title = if (user.isFlaggedByMe()) {
                CommunityR.string.amity_un_report_user
            } else {
                CommunityR.string.amity_report_user
            },
            icon = CommunityR.drawable.amity_ic_report,
            iconNavigation = null,
            callback = { fragment.reportUser(user) }
        )
    }

    override fun createOthersHeader(): AmitySettingsItem.Header {
        return AmitySettingsItem.Header(
            title = CommunityR.string.amity_others
        )
    }

    override fun createShareProfileMenu(userId: String): AmitySettingsItem.NavigationContent {
        return AmitySettingsItem.NavigationContent(
            title = CommunityR.string.amity_share_profile,
            icon = CommunityR.drawable.amity_ic_share_profile,
            callback = { fragment.shareUserProfile(userId) }
        )
    }
}
