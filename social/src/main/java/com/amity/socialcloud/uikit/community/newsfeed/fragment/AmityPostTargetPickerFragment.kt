package com.amity.socialcloud.uikit.community.newsfeed.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.media3.common.util.UnstableApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.amity.socialcloud.sdk.model.core.file.AmityImage
import com.amity.socialcloud.sdk.model.social.community.AmityCommunity
import com.amity.socialcloud.uikit.common.base.AmityBaseFragment
import com.amity.socialcloud.uikit.common.utils.AmityRecyclerViewItemDecoration
import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR
import com.amity.socialcloud.uikit.community.databinding.AmityFragmentPostTargetSelectionBinding
import com.amity.socialcloud.uikit.community.newsfeed.activity.AmityLiveStreamPostCreatorActivity
import com.amity.socialcloud.uikit.community.newsfeed.activity.AmityPollPostCreatorActivity
import com.amity.socialcloud.uikit.community.newsfeed.activity.AmityPostCreatorActivity
import com.amity.socialcloud.uikit.community.newsfeed.activity.AmityPostDetailsActivity
import com.amity.socialcloud.uikit.community.newsfeed.activity.POST_CREATION_TYPE_GENERIC
import com.amity.socialcloud.uikit.community.newsfeed.activity.POST_CREATION_TYPE_LIVE_STREAM
import com.amity.socialcloud.uikit.community.newsfeed.activity.POST_CREATION_TYPE_POLL
import com.amity.socialcloud.uikit.community.newsfeed.adapter.AmityCreatePostCommunitySelectionAdapter
import com.amity.socialcloud.uikit.community.newsfeed.listener.AmityCreatePostCommunitySelectionListener
import com.amity.socialcloud.uikit.community.newsfeed.viewmodel.AmityPostTargetViewModel
import com.amity.socialcloud.uikit.community.utils.EXTRA_PARAM_POST_CREATION_TYPE
import com.bumptech.glide.Glide
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber

@UnstableApi
class AmityPostTargetPickerFragment : AmityBaseFragment(),
    AmityCreatePostCommunitySelectionListener {

    private val viewModel: AmityPostTargetViewModel by viewModels()
    private lateinit var communityAdapter: AmityCreatePostCommunitySelectionAdapter
    private lateinit var binding: AmityFragmentPostTargetSelectionBinding
    private val TAG = AmityPostTargetPickerFragment::class.java.canonicalName

    private val createGenericPost =
        registerForActivityResult(
            AmityPostCreatorActivity
                .AmityCreateCommunityPostActivityContract()
        ) {
            if (it != null) {
                getCommunity()
                handleBackPress()
            }
        }

    private val createLiveStreamPost =
        registerForActivityResult(
            AmityLiveStreamPostCreatorActivity
                .AmityCreateLiveStreamPostActivityContract()
        ) { createdPostId ->
            createdPostId?.let {
                val intent =
                    AmityPostDetailsActivity.newIntent(requireContext(), createdPostId, null, null)
                startActivity(intent)
            }
            if (createdPostId != null) {
                getCommunity()
                handleBackPress()
            }
        }

    private val createPollPost = registerForActivityResult(
        AmityPollPostCreatorActivity
            .AmityPollCreatorActivityContract()
    ) {
        if (it != null) {
            getCommunity()
            handleBackPress()
        }
    }

    companion object {
        fun newInstance(): Builder {
            return Builder()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            CommunityR.layout.amity_fragment_post_target_selection,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.postCreationType =
            arguments?.getString(EXTRA_PARAM_POST_CREATION_TYPE) ?: POST_CREATION_TYPE_GENERIC
        initRecyclerView()
        initProfileImage()
        binding.clMyTimeline.setOnClickListener { launchPostCreator() }
    }

    private fun launchPostCreator() {
        when (viewModel.postCreationType) {
            POST_CREATION_TYPE_GENERIC -> {
                createGenericPost.launch(null)
            }

            POST_CREATION_TYPE_LIVE_STREAM -> {
                createLiveStreamPost.launch(null)
            }

            POST_CREATION_TYPE_POLL -> {
                createPollPost.launch(null)
            }
        }
    }

    private fun initProfileImage() {
        val user = viewModel.getUser()
        val imageURL = user.getAvatar()?.getUrl(AmityImage.Size.SMALL)
        Glide.with(this)
            .load(imageURL)
            .placeholder(CommonR.drawable.amity_ic_default_profile_large)
            .centerCrop()
            .into(binding.avProfile)
    }

    private fun initRecyclerView() {
        communityAdapter = AmityCreatePostCommunitySelectionAdapter(this)
//        adapter.addLoadStateListener { loadState ->
//            if (loadState.source.refresh is LoadState.NotLoading) {
//                handleCommunitySectionVisibility()
//            }
//        }
        binding.rvCommunity.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = communityAdapter
            addItemDecoration(
                AmityRecyclerViewItemDecoration(
                    resources.getDimensionPixelSize(CommonR.dimen.amity_padding_xs),
                    0, resources.getDimensionPixelSize(CommonR.dimen.amity_padding_xs)
                )
            )
            hasFixedSize()
        }
        getCommunity()
    }

    private fun getCommunity() {
        viewModel.getCommunityList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                communityAdapter.submitData(lifecycle, it)
                binding.separator.visibility = View.VISIBLE
                binding.tvCommunityLabel.visibility = View.VISIBLE
                Timber.e(">>>>>>>>>>>>>adapter: ${communityAdapter.snapshot().size}")
            }.doOnError {
                Log.e(TAG, "initRecyclerView: ${it.localizedMessage}")
            }.subscribe()
    }

    private fun handleCommunitySectionVisibility() {
        val communitySectionVisibility =
            if (communityAdapter.itemCount > 0) View.VISIBLE else View.GONE
        binding.separator.visibility = communitySectionVisibility
        binding.tvCommunityLabel.visibility = communitySectionVisibility
    }


    override fun onClickCommunity(community: AmityCommunity, position: Int) {
        when (viewModel.postCreationType) {
            POST_CREATION_TYPE_GENERIC -> {
                createGenericPost.launch(community.getCommunityId())
            }

            POST_CREATION_TYPE_LIVE_STREAM -> {
                createLiveStreamPost.launch(community.getCommunityId())
            }

            POST_CREATION_TYPE_POLL -> {
                createPollPost.launch(community.getCommunityId())
            }
        }
    }

    class Builder internal constructor() {
        fun build(
            postCreationType: String
        ): AmityPostTargetPickerFragment {
            return AmityPostTargetPickerFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_PARAM_POST_CREATION_TYPE, postCreationType)
                }
            }
        }
    }
}
