package com.amity.socialcloud.uikit.community.setting.postreview

import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR
import com.amity.socialcloud.uikit.community.setting.AmitySettingsItem
import io.reactivex.rxjava3.core.Flowable

class AmityPostReviewSettingsSettingsMenuCreatorImpl(private val fragment: AmityPostReviewSettingsFragment) : AmityPostReviewSettingsMenuCreator {

    override fun createApproveMemberPostMenu(isChecked: Flowable<Boolean>): AmitySettingsItem.ToggleContent {
        return AmitySettingsItem.ToggleContent(
                title = CommunityR.string.amity_approve_member_post,
                description = CommunityR.string.amity_approve_member_post_desc,
                isToggled = isChecked,
                isTitleBold = true,
                callback = fragment::toggleApproveMemberPostEvent
        )
    }
}
