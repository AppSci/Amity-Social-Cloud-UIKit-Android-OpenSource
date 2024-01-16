package com.amity.socialcloud.uikit.chat.messages.viewModel

import androidx.databinding.ObservableField
import com.amity.socialcloud.uikit.chat.R as ChatR
import com.amity.socialcloud.uikit.common.R as CommonR

class AmityTextMessageViewModel : AmitySelectableMessageViewModel() {

    val text = ObservableField<String>()
    val senderFillColor = ObservableField<Int>(CommonR.color.amityColorPrimary)
    val receiverFillColor = ObservableField<Int>(CommonR.color.amityMessageBubbleInverse)
}
