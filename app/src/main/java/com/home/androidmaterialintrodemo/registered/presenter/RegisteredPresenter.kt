package com.home.androidmaterialintrodemo.registered.presenter

import com.home.androidmaterialintrodemo.registered.model.RegisteredModel

class RegisteredPresenter {

    private val registeredModel: RegisteredModel = RegisteredModel()

    fun setRegisteredBean(email: String, password: String, name: String) {
        registeredModel.setRegisteredBean(email, password, name)
    }
}