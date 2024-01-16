package com.amity.socialcloud.uikit.community.home.activity

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR
import com.amity.socialcloud.uikit.community.databinding.AmityActivityCommunityHomeBinding
import com.amity.socialcloud.uikit.community.home.fragments.AmityCommunityHomePageFragment

class AmityCommunityHomePageActivity : AppCompatActivity() {

    private val binding : AmityActivityCommunityHomeBinding by lazy {
        AmityActivityCommunityHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initToolbar()
        loadFragment()
    }

    private fun initToolbar() {
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        setSupportActionBar(binding.communityHomeToolbar)
        binding.communityHomeToolbar.setLeftString(getString(CommunityR.string.amity_community))
    }

    private fun loadFragment() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = AmityCommunityHomePageFragment.newInstance().build()
        fragmentTransaction.replace(CommunityR.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }
}
