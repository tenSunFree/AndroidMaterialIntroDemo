package com.home.androidmaterialintrodemo.registered.model

import com.google.gson.annotations.SerializedName

data class RegisteredBean(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("name")
    val name: String
)