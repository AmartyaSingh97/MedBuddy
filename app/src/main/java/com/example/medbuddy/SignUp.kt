package com.example.medbuddy

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignupActivity : AppCompatActivity() {

    lateinit var etFirstName: EditText
    lateinit var etLastName:EditText
    lateinit var etEmail: EditText
    lateinit var etPassword:EditText
    lateinit var etRepeatPassword:EditText
    val MIN_PASSWORD_LENGTH = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        viewInitializations()
    }

    fun viewInitializations() {
        etFirstName = findViewById(R.id.et_first_name)
        etLastName = findViewById(R.id.et_last_name)
        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)
        etRepeatPassword = findViewById(R.id.et_repeat_password)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    fun validateInput(): Boolean {
        if (etFirstName.text.toString().equals("")) {
            etFirstName.error = "Please Enter First Name"
            return false
        }
        if (etLastName.text.toString().equals("")) {
            etLastName.error = "Please Enter Last Name"
            return false
        }
        if (etEmail.text.toString().equals("")) {
            etEmail.error = "Please Enter Email"
            return false
        }
        if (etPassword.text.toString().equals("")) {
            etPassword.error = "Please Enter Password"
            return false
        }
        if (etRepeatPassword.text.toString().equals("")) {
            etRepeatPassword.error = "Please Enter Repeat Password"
            return false
        }


        if (!isEmailValid(etEmail.text.toString())) {
            etEmail.error = "Please Enter Valid Email"
            return false
        }


        if (etPassword.text.length < MIN_PASSWORD_LENGTH) {
            etPassword.error = "Password Length must be more than " + MIN_PASSWORD_LENGTH + " characters"
            return false
        }


        if (!etPassword.text.toString().equals(etRepeatPassword.text.toString())) {
            etRepeatPassword.error = "Password does not match"
            return false
        }
        return true
    }

    fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }



    fun performSignUp (view: View) {
        if (validateInput()) {



            val firstName = etFirstName.text.toString()
            val lastName = etLastName.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val repeatPassword = etRepeatPassword.text.toString()

            Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show()
            // Here you can call you API

        }
    }

}