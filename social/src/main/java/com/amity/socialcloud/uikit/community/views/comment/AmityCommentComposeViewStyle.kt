package com.amity.socialcloud.uikit.community.views.comment

import android.content.Context
import android.util.AttributeSet
import android.view.inputmethod.EditorInfo
import androidx.annotation.StyleRes
import com.amity.socialcloud.uikit.common.common.views.AmityStyle
import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR

class AmityCommentComposeViewStyle : AmityStyle {
    var backgroundColor: Int = -1
    var textColor: Int = -1
    var hintTextColor: Int = -1
    var padding: Int = -1
    var hint: Int = -1

    init {
        backgroundColor = getColor(android.R.color.transparent)
        textColor = getColor(CommonR.color.amityColorBase)
        hintTextColor = getColor(CommonR.color.amityColorBase)
        hint = CommunityR.string.amity_post_comment_hint
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context)
    constructor(context: Context, @StyleRes style: Int) : super(context)
}
