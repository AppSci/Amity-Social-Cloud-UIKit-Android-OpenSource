package com.amity.socialcloud.uikit.community.setting

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.amity.socialcloud.uikit.common.base.AmityBaseRecyclerViewAdapter
import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR
import com.amity.socialcloud.uikit.community.setting.viewholder.*

class AmitySettingsItemAdapter : AmityBaseRecyclerViewAdapter<AmitySettingsItem>() {

    override fun getLayoutId(position: Int, obj: AmitySettingsItem?): Int {
        obj?.let { item ->
            when (item) {
                is AmitySettingsItem.Header -> {
                    return CommunityR.layout.amity_item_settings_header
                }
                is AmitySettingsItem.TextContent -> {
                    return CommunityR.layout.amity_item_settings_text_content
                }
                is AmitySettingsItem.NavigationContent -> {
                    return CommunityR.layout.amity_item_settings_nav_content
                }
                is AmitySettingsItem.ToggleContent -> {
                    return CommunityR.layout.amity_item_settings_toggle_content
                }
                is AmitySettingsItem.RadioContent -> {
                    return CommunityR.layout.amity_item_settings_radio_content
                }
                is AmitySettingsItem.Margin -> {
                    return CommunityR.layout.amity_item_settings_margin
                }
                AmitySettingsItem.Separator -> {
                    return CommunityR.layout.amity_item_separate_content
                }
            }
        }
        return CommunityR.layout.amity_item_separate_content
    }

    override fun getViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder {
        val context = view.context
        return when (viewType) {
            CommunityR.layout.amity_item_settings_header -> AmitySettingsHeaderViewHolder(context, view)
            CommunityR.layout.amity_item_settings_text_content -> AmitySettingsTextContentViewHolder(context, view)
            CommunityR.layout.amity_item_settings_nav_content -> AmitySettingsNavContentViewHolder(context, view)
            CommunityR.layout.amity_item_settings_toggle_content -> AmitySettingsToggleContentViewHolder(context, view)
            CommunityR.layout.amity_item_separate_content -> AmitySeparateContentViewHolder(view)
            CommunityR.layout.amity_item_settings_radio_content -> AmitySettingsRadioContentViewHolder(context, view)
            CommunityR.layout.amity_item_settings_margin -> AmitySettingsMarginViewHolder(context, view)

            else -> AmitySettingsHeaderViewHolder(context, view)
        }
    }
}
