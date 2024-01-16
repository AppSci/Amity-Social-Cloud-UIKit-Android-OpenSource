package com.amity.socialcloud.uikit.community.setting

import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR

class AmityCommunitySettingsMenuCreatorImpl(private val fragment: AmityCommunitySettingsFragment) : AmityCommunitySettingsMenuCreator {

    override fun createEditProfileMenu(communityId: String): AmitySettingsItem.NavigationContent {
        return AmitySettingsItem.NavigationContent(
                icon = CommunityR.drawable.amity_ic_pen,
                title = CommunityR.string.amity_edit_profile,
                callback = { fragment.navigateToCommunityProfile(communityId) }
        )
    }

    override fun createMembersMenu(communityId: String): AmitySettingsItem.NavigationContent {
        return AmitySettingsItem.NavigationContent(
                icon = CommunityR.drawable.amity_ic_user_friends,
                title = CommunityR.string.amity_members_capital,
                callback = { fragment.navigateToCommunityMemberSettings(communityId) }
        )
    }

    override fun createNotificationMenu(
        communityId: String,
        value: Int
    ): AmitySettingsItem.NavigationContent {
        return AmitySettingsItem.NavigationContent(
            icon = CommunityR.drawable.amity_ic_bell,
            title = CommunityR.string.amity_notifications,
            value = value,
            callback = { fragment.navigateToPushNotificationSettings(communityId) }
        )
    }

    override fun createPostReviewMenu(communityId: String): AmitySettingsItem.NavigationContent {
        return AmitySettingsItem.NavigationContent(
                icon = CommunityR.drawable.amity_ic_clipboard_check,
                title = CommunityR.string.amity_post_review,
                callback = { fragment.navigateToPostReview() }
        )
    }

    override fun createLeaveCommunityMenu(communityId: String, hasDeletePermission: Boolean): AmitySettingsItem.TextContent {
        return if (hasDeletePermission) {
            AmitySettingsItem.TextContent(
                title = CommunityR.string.amity_leave_community,
                titleTextColor = CommonR.color.amityColorAlert,
                callback = { fragment.confirmModeratorLeaveCommunity() }
            )
        } else {
            AmitySettingsItem.TextContent(
                title = CommunityR.string.amity_leave_community,
                titleTextColor = CommonR.color.amityColorAlert,
                callback = { fragment.confirmLeaveCommunity() }
            )
        }
    }

    override fun createCloseCommunityMenu(communityId: String): AmitySettingsItem.TextContent {
        return AmitySettingsItem.TextContent(
                title = CommunityR.string.amity_close_community,
                titleTextColor = CommonR.color.amityColorAlert,
                description = CommunityR.string.amity_close_community_description,
                callback = { fragment.confirmCloseCommunity() }
        )
    }
}
