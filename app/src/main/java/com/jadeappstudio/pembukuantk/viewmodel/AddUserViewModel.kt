package com.jadeappstudio.pembukuantk.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jadeappstudio.pembukuantk.model.AddUsersResponseModel
import com.jadeappstudio.pembukuantk.repo.UsersRepository

class AddUserViewModel: ViewModel() {
    private var usersRepository = UsersRepository()

    fun addUser(username: String, password: String, context: Context): LiveData<AddUsersResponseModel>{
        return usersRepository.addUser(username, password, context)
    }
}