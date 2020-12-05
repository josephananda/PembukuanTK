package com.jadeappstudio.pembukuantk.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jadeappstudio.pembukuantk.model.GetUsersResponseModel
import com.jadeappstudio.pembukuantk.repo.UsersRepository

class UsersManagementViewModel: ViewModel() {
    private var usersRepository = UsersRepository()

    fun getUsers(context: Context): LiveData<GetUsersResponseModel>{
        return usersRepository.getUsers(context)
    }
}