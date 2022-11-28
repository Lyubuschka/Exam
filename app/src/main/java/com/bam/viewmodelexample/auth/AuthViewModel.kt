package com.bam.viewmodelexample.auth

import android.app.Application
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.bam.viewmodelexample.room.UserData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AuthViewModel(application: Application) : AndroidViewModel(application) {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val isAuth = MutableLiveData<Boolean>()

    fun login(email: String, pass:String){
        retrofit.create(UserService::class.java).getAll().enqueue(object: Callback<List<UserResponse>>{
            override fun onResponse(
                call: Call<List<UserResponse>>,
                response: Response<List<UserResponse>>
            ) {

                val user = UserResponse(email,pass)
                val findingUser = response.body()?.find {
                    it == user
                }

                if (findingUser != null){
                    isAuth.value = true
                }
            }

            override fun onFailure(call: Call<List<UserResponse>>, t: Throwable) {

            }

        })
    }

}