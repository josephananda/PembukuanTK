package com.jadeappstudio.pembukuantk.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jadeappstudio.pembukuantk.model.DeleteResponseModel
import com.jadeappstudio.pembukuantk.repo.UsersRepository

class DetailUserViewModel: ViewModel() {
    private var usersRepository = UsersRepository()

    fun deleteUser(userId: Int, context: Context): LiveData<DeleteResponseModel>{
        return usersRepository.deleteUser(userId, context)
    }
}