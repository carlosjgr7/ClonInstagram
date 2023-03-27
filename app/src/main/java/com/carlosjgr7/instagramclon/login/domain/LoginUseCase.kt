package com.carlosjgr7.instagramclon.login.domain

import com.carlosjgr7.instagramclon.login.data.LoginRepository
import javax.inject.Inject


class LoginUseCase @Inject constructor(private val repository:LoginRepository) {
    suspend operator fun invoke(user:String,pass:String) : Boolean{
        return repository.doLogin(user,pass)
    }
}