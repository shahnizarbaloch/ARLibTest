package com.shah.myapplication.util

object Validator {

    fun validateInputs(email:String,password:String) : Boolean{
        return !(email.isEmpty() || password.isEmpty())
    }

    fun validatePasswordLength(password: String) : Boolean{
        return password.length>=8
    }
}