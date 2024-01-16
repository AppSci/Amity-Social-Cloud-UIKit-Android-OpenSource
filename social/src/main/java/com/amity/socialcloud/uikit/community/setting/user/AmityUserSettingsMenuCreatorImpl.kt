package com.amity.socialcloud.uikit.community.setting.user

import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR
import com.amity.socialcloud.uikit.community.setting.AmitySettingsItem

class AmityUserSettingsMenuCreatorImpl(private val fragment: AmityUserSettingsFragment): AmityUserSettingsMenuCreator {

    override fun createBasicInfoHeader(): AmitySettingsItem.Header {
        return AmitySettingsItem.Header(
            title = CommunityR.string.amity_basic_info
        )
    }

    override fun createEditProfileMenu(): AmitySettingsItem.NavigationContent {
        return AmitySettingsItem.NavigationContent(
            title = CommunityR.string.amity_edit_profile,
            icon = CommunityR.drawable.amity_ic_edit_user_profile,
            iconNavigation = null,
            callback = { fragment.editProfile() }
        )
    }
}
