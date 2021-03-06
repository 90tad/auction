package com.example.myapplication.ultis.common

import com.example.myapplication.model.dto.SignInRequest
import com.example.myapplication.model.dto.SignUpRequest
import java.util.regex.Pattern

object ValidationCheck {

    private const val EMAIL_REGEX =
        "(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"
    private const val MIN_PASSWORD_LENGTH = 6
    private const val MIN_USERNAME_LENGTH = 4

    fun isEmailValid(email: String) = Pattern.matches(EMAIL_REGEX, email)

    fun isPasswordValid(password: String) = password.length >= MIN_PASSWORD_LENGTH

    fun isUsernameValid(username: String) = username.length >= MIN_USERNAME_LENGTH

    fun isConfirmPasswordMatch(password: String, confirmPassword: String) =
        isPasswordValid(
            password
        ) && password == confirmPassword

    fun isSignUpValid(signUpRequest: SignUpRequest): Boolean {
        return isEmailValid(
            signUpRequest.email
        ) && isConfirmPasswordMatch(
            signUpRequest.password,
            signUpRequest.confirmPassword
        )
    }

    fun isSignInValid(signInRequest: SignInRequest) =
        isUsernameValid(
            signInRequest.username
        ) && isPasswordValid(
            signInRequest.password
        )
}
