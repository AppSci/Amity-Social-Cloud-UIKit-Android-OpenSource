package com.amity.socialcloud.uikit.community.setting

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.amity.socialcloud.uikit.common.base.AmityBaseActivity
import com.amity.socialcloud.uikit.common.components.AmityToolBarClickListener
import com.amity.socialcloud.uikit.community.BR
import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR
import com.amity.socialcloud.uikit.community.databinding.AmityActivityCommunitySettingBinding
import com.amity.socialcloud.uikit.community.utils.EXTRA_PARAM_COMMUNITY_ID

class AmityCommunitySettingsActivity :
    AmityBaseActivity<AmityActivityCommunitySettingBinding, AmityCommunitySettingViewModel>(),
    AmityToolBarClickListener {

    companion object {
        fun newIntent(context: Context, id: String? = null): Intent =
            Intent(context, AmityCommunitySettingsActivity::class.java).apply {
                putExtra(EXTRA_PARAM_COMMUNITY_ID, id)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpToolbar()
        loadFragment()
    }

    private fun setUpToolbar() {
        getViewDataBinding().communitySettingsToolbar.setLeftDrawable(
            ContextCompat.getDrawable(
                this,
                CommonR.drawable.amity_ic_arrow_back
            )
        )
        getViewDataBinding().communitySettingsToolbar.setClickListener(this)

        val titleToolbar = getString(CommunityR.string.amity_community_setting)
        getViewDataBinding().communitySettingsToolbar.setLeftString(titleToolbar)

        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        setSupportActionBar(getViewDataBinding().communitySettingsToolbar)
    }

    private fun loadFragment() {
        val communityId = intent.getStringExtra(EXTRA_PARAM_COMMUNITY_ID) ?: ""
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = AmityCommunitySettingsFragment.Builder().communityId(communityId)
        fragmentTransaction.replace(CommunityR.id.fragmentContainer, fragment.build())
        fragmentTransaction.commit()
    }

    override fun getLayoutId(): Int = CommunityR.layout.amity_activity_community_setting

    override fun getViewModel(): AmityCommunitySettingViewModel =
        ViewModelProvider(this).get(AmityCommunitySettingViewModel::class.java)

    override fun getBindingVariable(): Int = BR.viewModel

    override fun leftIconClick() {
        this.finish()
    }

    override fun rightIconClick() {
    }
}
