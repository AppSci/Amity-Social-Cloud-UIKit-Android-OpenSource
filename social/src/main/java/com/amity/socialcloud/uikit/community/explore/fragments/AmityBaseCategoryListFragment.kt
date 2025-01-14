package com.amity.socialcloud.uikit.community.explore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.amity.socialcloud.sdk.model.social.category.AmityCommunityCategory
import com.amity.socialcloud.uikit.common.base.AmityBaseFragment
import com.amity.socialcloud.uikit.common.common.showSnackBar
import com.amity.socialcloud.uikit.common.utils.AmityRecyclerViewItemDecoration
import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR
import com.amity.socialcloud.uikit.community.databinding.AmityFragmentCategoryListBinding
import com.amity.socialcloud.uikit.community.explore.adapter.AmityCategoryListAdapter
import com.amity.socialcloud.uikit.community.explore.listener.AmityCategoryItemClickListener
import com.amity.socialcloud.uikit.community.explore.viewmodel.AmityCategoryListViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

const val ARG_DEFAULT_SELECTION = "default_selection"

abstract class AmityBaseCategoryListFragment internal constructor() : AmityBaseFragment(),
    AmityCategoryItemClickListener {

    private var _binding: AmityFragmentCategoryListBinding? = null
    private val binding get() = _binding!!

    internal lateinit var viewModel: AmityCategoryListViewModel

    private lateinit var adapter: AmityCategoryListAdapter


    abstract fun getCategoryListAdapter(): AmityCategoryListAdapter

    private fun setupToolBar() {
        (activity as AppCompatActivity).supportActionBar?.setTitle(CommunityR.string.amity_category)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity()).get(AmityCategoryListViewModel::class.java)
        _binding = AmityFragmentCategoryListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = getCategoryListAdapter()
        setupToolBar()
        initView()
        getCategories()
    }

    private fun initView() {
        val itemDecorSpace =
            AmityRecyclerViewItemDecoration(resources.getDimensionPixelSize(CommonR.dimen.amity_padding_xs))
        binding.rvCategory.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCategory.adapter = adapter
        binding.rvCategory.addItemDecoration(itemDecorSpace)
    }

    private fun getCategories() {
        disposable.add(viewModel.getCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                adapter.submitData(lifecycle, it)
            }
            .doOnError {
                run {
                    it.message?.let { view?.showSnackBar(it) }
                }
            }
            .subscribe()
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCategorySelected(category: AmityCommunityCategory) {
        viewModel.categoryItemClickListener?.onCategorySelected(category)
    }

    fun setCategoryItemClickListener(listener: AmityCategoryItemClickListener) {
        viewModel.categoryItemClickListener = listener
    }
}
