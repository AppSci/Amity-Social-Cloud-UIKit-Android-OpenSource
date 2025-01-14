package com.amity.socialcloud.uikit.community.followers

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.amity.socialcloud.sdk.model.core.user.AmityUser
import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR
import com.ekoapp.rxlifecycle.extension.untilLifecycleEnd
import com.google.android.material.snackbar.Snackbar

abstract class AmityFollowersBaseViewHolder(
    itemView: View, private val context: Context,
    private val itemViewModel: AmityFollowersItemViewModel
) : RecyclerView.ViewHolder(itemView) {

    fun sendReportUser(user: AmityUser, isReport: Boolean) {
        val reportUser = if (isReport) {
            itemViewModel.reportUser(user){
                showDialogSentReportMessage(isReport)
            }
        } else {
            itemViewModel.unReportUser(user){
                showDialogSentReportMessage(isReport)
            }
        }
        reportUser.untilLifecycleEnd(itemView)
            .subscribe()
    }

    private fun showDialogSentReportMessage(isReport: Boolean) {
        val messageSent = if (isReport) {
            CommunityR.string.amity_report_sent
        } else {
            CommunityR.string.amity_unreport_sent
        }
        Snackbar.make(
            itemView,
            context.getString(messageSent),
            Snackbar.LENGTH_SHORT
        ).show()
    }
}
