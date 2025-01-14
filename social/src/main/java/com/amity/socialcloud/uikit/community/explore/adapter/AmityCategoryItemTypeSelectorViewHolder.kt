package com.amity.socialcloud.uikit.community.explore.adapter

import android.view.View
import com.amity.socialcloud.sdk.model.social.category.AmityCommunityCategory
import com.amity.socialcloud.uikit.common.R as CommonR
import com.amity.socialcloud.uikit.community.R as CommunityR
import com.amity.socialcloud.uikit.community.explore.listener.AmityCategoryItemClickListener
import com.google.android.material.radiobutton.MaterialRadioButton

class AmityCategoryItemTypeSelectorViewHolder(
    itemView: View,
    itemClickListener: AmityCategoryItemClickListener?,
    private val selectionListener: AmityCategorySelectionListener
) : AmityCategoryItemViewHolder(itemView, itemClickListener) {

    private val rbCategorySelection: MaterialRadioButton =
        itemView.findViewById(CommunityR.id.cbCategorySelecion)

    override fun bind(data: AmityCommunityCategory?, position: Int) {
        super.bind(data, position)
        data?.let {
            rbCategorySelection.isChecked = selectionListener.getSelection() == data.getName()
            itemView.setOnClickListener {
                handleCategorySelection(data)
            }
            rbCategorySelection.setOnClickListener {
                handleCategorySelection(data)
            }

        }
    }

    private fun handleCategorySelection(data: AmityCommunityCategory) {
        selectionListener.setSelection(data.getName())
        rbCategorySelection.isChecked = true
        itemClickListener?.onCategorySelected(data)
    }


}
