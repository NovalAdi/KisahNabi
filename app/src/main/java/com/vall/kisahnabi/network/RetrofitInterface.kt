package com.vall.kisahnabi.network

import com.vall.kisahnabi.model.ResponseNabiRasulItem
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("v1/nabi")
    fun getDataNabi() : Call<List<ResponseNabiRasulItem>>

    @GET("v1/rasul")
    fun getDataRasul() : Call<List<ResponseNabiRasulItem>>

}