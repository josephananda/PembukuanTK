package com.jadeappstudio.pembukuantk.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jadeappstudio.pembukuantk.R
import com.jadeappstudio.pembukuantk.UsersManagementActivity
import com.jadeappstudio.pembukuantk.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_profile, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profileViewModel = ViewModelProvider(requireActivity()).get(ProfileViewModel::class.java)

        btnUserManagement.setOnClickListener {
            startActivity(Intent(requireContext(), UsersManagementActivity::class.java))
        }

        btnLogout.setOnClickListener {
            profileViewModel =
                ViewModelProvider(this).get(ProfileViewModel::class.java)

            profileViewModel.setDataEmpty(requireContext())
            startActivity(Intent(activity, LoginActivity::class.java))
            activity?.finishAffinity()
        }

        if (profileViewModel.checkUserType(requireContext()) == 2) {
            btnUserManagement.isEnabled = false
            btnUserManagement.isClickable = false
            btnUserManagement.isVisible = false
        }
    }
}