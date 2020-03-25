package com.example.myapplication.main.main_tab.personal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.model.dto.GetAuthoritiesResponse
import com.example.myapplication.ultis.common.SharedPrefUtils
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.current_user_view.*

class PersonalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_personal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val displayName = SharedPrefUtils.getUserDisplayName()
        var authorities = ""
        current_user_displayName_text_view.text = displayName
        SharedPrefUtils.getUserAuthority().map { e: GetAuthoritiesResponse ->
            authorities += "${e.name}/"
        }
        val currentUser = SharedPrefUtils.getCurrentUserDetail()
        Picasso.get().load(currentUser.avatarUrl).into(current_user_avatar_image_view)
        current_user_authorities_text_view.text = authorities
        current_user_container.setOnClickListener {
            Toast.makeText(activity, "click", Toast.LENGTH_LONG).show()
        }
    }

}