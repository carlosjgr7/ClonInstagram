package com.carlosjgr7.instagramclon.login.data

import com.carlosjgr7.instagramclon.login.data.network.LoginService
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api : LoginService){
    suspend fun doLogin(user:String,pass:String):Boolean{
        return api.doLogin(user,pass)
    }
}