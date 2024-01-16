package com.amity.socialcloud.uikit.chat.home.groupchat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.amity.socialcloud.uikit.chat.R as ChatR
import com.amity.socialcloud.uikit.common.R as CommonR


class AmityCreateGroupChatFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(ChatR.layout.amity_fragment_create_group_chat, container, false)
    }

}
