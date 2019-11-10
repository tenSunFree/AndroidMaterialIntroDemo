package com.home.androidmaterialintrodemo.registered.model

class RegisteredModel {

    var registeredBean: RegisteredBean? = RegisteredBean("", "", "")

    fun setRegisteredBean(email: String, password: String, name: String) {
        registeredBean = RegisteredBean(email, password, name)
    }
}