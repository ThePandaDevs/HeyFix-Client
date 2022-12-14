package com.pandadevs.heyfix_client.viewmodel

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pandadevs.heyfix_client.data.model.UserGet
import com.pandadevs.heyfix_client.provider.ProfileProvider
import com.pandadevs.heyfix_client.utils.datatype.ResultType
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {
    var result: MutableLiveData<String> = MutableLiveData()
    var url: MutableLiveData<String> = MutableLiveData()
    var error: MutableLiveData<String> = MutableLiveData()
    var isDataProgress: MutableLiveData<Boolean> = MutableLiveData()

    fun updateUserData(user: UserGet) {
        val response = ProfileProvider.updateUserData(user)
        if (response.resultType == ResultType.SUCCESS) {
            result.postValue(response.data!!)
        } else {
            error.postValue(response.data!!)
        }
    }
    fun updatePhotoUser(uri: Uri,user: UserGet) {
        isDataProgress.value = true
        viewModelScope.launch {
            val response = ProfileProvider.updateProfile(uri,user)
            if(response.resultType == ResultType.SUCCESS){
                url.postValue(response.data!!)
                isDataProgress.value = false
            }else{
                error.value = response.error!!
                isDataProgress.value = false
            }
        }
    }
}