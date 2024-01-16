package com.amity.socialcloud.uikit.community.newsfeed.model

import android.os.Parcelable
import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR
import kotlinx.parcelize.Parcelize

sealed class AmityPostAttachmentOptionItem(
    val activeIcon: Int,
    val inactiveIcon: Int,
    val optionName: Int,
) : Parcelable{

    var isEnable: Boolean = false

    @Parcelize
    internal object CAMERA : AmityPostAttachmentOptionItem(CommunityR.drawable.amity_ic_attachment_camera_enable, CommunityR.drawable.amity_ic_attachment_camera_disable, CommunityR.string.amity_post_attachment_option_camera)
    @Parcelize
    object PHOTO : AmityPostAttachmentOptionItem(CommunityR.drawable.amity_ic_attachment_photo_enable, CommunityR.drawable.amity_ic_attachment_photo_disable, CommunityR.string.amity_post_attachment_option_photo)
    @Parcelize
    object VIDEO : AmityPostAttachmentOptionItem(CommunityR.drawable.amity_ic_attachment_video_enable, CommunityR.drawable.amity_ic_attachment_video_disable, CommunityR.string.amity_post_attachment_option_video)
    @Parcelize
    object FILE : AmityPostAttachmentOptionItem(CommunityR.drawable.amity_ic_attachment_file_enable, CommunityR.drawable.amity_ic_attachment_file_disable, CommunityR.string.amity_post_attachment_option_file)
    @Parcelize
    internal object EXPAND : AmityPostAttachmentOptionItem(CommunityR.drawable.amity_ic_content_expand, CommunityR.drawable.amity_ic_content_expand, 0)
    @Parcelize
    internal object BLANK : AmityPostAttachmentOptionItem(0, 0, 0)
}
