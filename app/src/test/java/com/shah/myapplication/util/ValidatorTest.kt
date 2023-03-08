package com.shah.myapplication.util


import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ValidatorTest{

    @Test
    fun whenInputIsValid (){
        val email = "some_email@gmail.com"
        val password = "ass"
        val result = Validator.validateInputs(email,password)
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun whenInputIsInvalid(){
        val email = "some_email@gmail.com"
        val password = ""
        val result = Validator.validateInputs(email,password)
        assertThat(result).isEqualTo(false)
    }


    @Test
    fun whenPasswordLengthIsGreaterThan8(){
        val password="sadsadas"
        val result = Validator.validatePasswordLength(password)
        assertThat(result).isEqualTo(true)
    }

}