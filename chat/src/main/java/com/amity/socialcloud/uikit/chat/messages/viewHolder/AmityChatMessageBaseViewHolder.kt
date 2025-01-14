package com.amity.socialcloud.uikit.chat.messages.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.amity.socialcloud.sdk.api.core.AmityCoreClient
import com.amity.socialcloud.sdk.model.chat.message.AmityMessage
import com.amity.socialcloud.uikit.chat.R as ChatR
import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.chat.messages.viewModel.AmityChatMessageBaseViewModel
import com.amity.socialcloud.uikit.common.utils.AmityDateUtils

abstract class AmityChatMessageBaseViewHolder(
    itemView: View,
    val itemBaseViewModel: AmityChatMessageBaseViewModel
) : RecyclerView.ViewHolder(itemView) {

    abstract fun setMessage(message: AmityMessage)

    fun setItem(item: AmityMessage?) {
        itemBaseViewModel.amityMessage = item
        itemBaseViewModel.msgTime.set(item?.getCreatedAt()?.toString("hh:mm a"))
        itemBaseViewModel.editedAt.set(item?.getEditedAt()?.toString("hh:mm a"))
        itemBaseViewModel.msgDate.set(
            AmityDateUtils.getRelativeDate(
                item?.getCreatedAt()?.millis ?: 0
            )
        )
        if (itemBaseViewModel.isDeleted.get() != item?.isDeleted()) {
            itemBaseViewModel.isDeleted.set(item?.isDeleted() ?: false)
        }
        itemBaseViewModel.isFailed.set(item?.getState() == AmityMessage.State.FAILED)
        if (item != null) {
            itemBaseViewModel.sender.set(getSenderName(item))
            itemBaseViewModel.isSelf.set(item.getCreatorId() == AmityCoreClient.getUserId())
            itemBaseViewModel.isEdited.set(item.isEdited())
            setMessage(item)
        }
    }

    private fun getSenderName(item: AmityMessage): String {
        return if (item.getCreatorId() == AmityCoreClient.getUserId()) {
            "ME"
        } else {
            item.getCreator()?.getDisplayName() ?: itemView.context.getString(CommonR.string.amity_anonymous)
        }
    }
}
