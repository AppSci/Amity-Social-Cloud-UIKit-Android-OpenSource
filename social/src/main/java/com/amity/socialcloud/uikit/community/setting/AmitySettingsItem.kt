package com.amity.socialcloud.uikit.community.setting

import androidx.annotation.DimenRes
import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR
import io.reactivex.rxjava3.core.Flowable

sealed class AmitySettingsItem {
    class Header(val title: Int) : AmitySettingsItem()

    class TextContent(
            val icon: Int? = null,
            val title: Int,
            val description: Int? = null,
            val titleTextColor: Int = CommonR.color.upstraColorBase,
            val isTitleBold: Boolean = false,
            val callback: () -> Unit) : AmitySettingsItem()

    class NavigationContent(
            val icon: Int? = null,
            val iconNavigation: Int? = CommunityR.drawable.amity_ic_chevron_right,
            val title: Int,
            val value: Int? = null,
            val description: Int? = null,
            val isTitleBold: Boolean = false,
            val callback: () -> Unit) : AmitySettingsItem()

    class ToggleContent(
            val icon: Int? = null,
            val title: Int,
            val description: Int? = null,
            val isToggled: Flowable<Boolean>,
            val isTitleBold: Boolean = false,
            val callback: (Boolean) -> Unit) : AmitySettingsItem()

    class RadioContent(
        val choices: List<Pair<Int, Boolean>>,
        val callback: (Int) -> Unit) : AmitySettingsItem()

    class Margin(@DimenRes val margin: Int): AmitySettingsItem()

    object Separator : AmitySettingsItem()

}
