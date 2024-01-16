package com.amity.socialcloud.uikit.community.followers

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.amity.socialcloud.uikit.common.base.AmityBaseToolbarFragmentContainerActivity
import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR
import java.lang.Exception

class AmityUserFollowersActivity : AmityBaseToolbarFragmentContainerActivity() {


    override fun initToolbar() {
        getToolBar()?.setLeftDrawable(
            ContextCompat.getDrawable(this, CommonR.drawable.amity_ic_arrow_back)
        )
        getToolBar()?.setLeftString(
            intent.extras?.getString(DISPLAY_NAME) ?: getString(CommonR.string.amity_anonymous)
        )
    }

    override fun getContentFragment(): Fragment {
        val userId: String? = intent.extras?.getString(USER_ID)
        return if (userId == null) {
            Fragment()
        }else {
            AmityUserFollowerHomeFragment.newInstance(userId).build()
        }
    }

    companion object {
        private const val DISPLAY_NAME = "DISPLAY_NAME"
        private const val USER_ID = "USER_ID"

        fun newIntent(context: Context, displayName: String?, userId: String): Intent =
            Intent(context, AmityUserFollowersActivity::class.java).apply {
                putExtra(DISPLAY_NAME, displayName)
                putExtra(USER_ID, userId)
            }
    }
}
