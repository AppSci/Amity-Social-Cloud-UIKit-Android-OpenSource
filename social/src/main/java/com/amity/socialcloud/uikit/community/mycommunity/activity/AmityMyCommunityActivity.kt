package com.amity.socialcloud.uikit.community.mycommunity.activity

import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.amity.socialcloud.uikit.common.base.AmityBaseToolbarFragmentContainerActivity
import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR
import com.amity.socialcloud.uikit.community.mycommunity.fragment.AmityMyCommunityFragment

class AmityMyCommunityActivity : AmityBaseToolbarFragmentContainerActivity() {
    override fun initToolbar() {
        getToolBar()?.setLeftDrawable(
            ContextCompat.getDrawable(this, CommonR.drawable.amity_ic_arrow_back)
        )
        getToolBar()?.setLeftString(getString(CommunityR.string.amity_my_community))
    }

    override fun getContentFragment(): Fragment {
        return AmityMyCommunityFragment.newInstance().build()
    }
}
