package com.amity.socialcloud.uikit.community.notificationsettings

import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR
import com.amity.socialcloud.uikit.community.notificationsettings.pushDetail.AmityCommunityPostNotificationSettingsActivity
import com.amity.socialcloud.uikit.community.setting.AmitySettingsItem
import io.reactivex.rxjava3.core.Flowable

class AmityPushNotificationMenuCreatorImpl(private val fragment: AmityCommunityNotificationSettingsFragment): AmityPushNotificationMenuCreator {

    override fun createAllNotificationsMenu(communityId: String, isToggled: Flowable<Boolean>): AmitySettingsItem.ToggleContent {
        return AmitySettingsItem.ToggleContent(
            title = CommunityR.string.amity_allow_notifications,
            description = CommunityR.string.amity_notifications_description,
            isToggled = isToggled,
            isTitleBold = true,
            callback = fragment::toggleAllSettings
        )
    }

    override fun createPostMenu(communityId: String): AmitySettingsItem.NavigationContent {
        return AmitySettingsItem.NavigationContent(
            icon = CommunityR.drawable.amity_ic_new_posts,
            title = CommunityR.string.amity_posts,
            callback = { fragment.navigateToNewPostSettings(communityId, AmityCommunityPostNotificationSettingsActivity.SettingType.POSTS)}
        )
    }

    override fun createCommentMenu(communityId: String): AmitySettingsItem.NavigationContent {
        return AmitySettingsItem.NavigationContent(
            icon = CommunityR.drawable.amity_ic_push_comments,
            title = CommunityR.string.amity_comments,
            callback = { fragment.navigateToNewPostSettings(communityId, AmityCommunityPostNotificationSettingsActivity.SettingType.COMMENTS)}
        )
    }
}
