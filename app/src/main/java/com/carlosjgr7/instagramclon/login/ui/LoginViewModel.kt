package com.carlosjgr7.instagramclon.login.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlosjgr7.instagramclon.login.domain.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase : LoginUseCase) : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _pass = MutableLiveData<String>()
    val pass: LiveData<String> = _pass

    private val _isEnable = MutableLiveData<Boolean>()
    val isEnable: LiveData<Boolean> = _isEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading


    fun onLoginChange(email: String, pass: String) {
        _email.value = email
        _pass.value = pass
        _isEnable.value = enableLogin(email,pass)
    }

    fun enableLogin(email: String, pass: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && pass.length > 6

    fun onLoginSelected(){
        viewModelScope.launch {
            _isLoading.value=true
            val result = loginUseCase(email.value!!,pass.value!!)
            if(result){
                Log.i("LoginViewModel", "pulsado el boton ")
            }
            _isLoading.value=false

        }
    }
}
