package com.example.kataloghimati.presentation.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kataloghimati.R
import com.example.kataloghimati.ui.MainActivity

class LoginActivity : AppCompatActivity() {

    private val viewModel = LoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val etUserName = findViewById<EditText>(R.id.et_user_name)
        val etUserNim = findViewById<EditText>(R.id.et_user_nim)
        val btnLogin = findViewById<Button>(R.id.btn_login)

        btnLogin.setOnClickListener {
            val name = etUserName.text.toString()
            val nim = etUserNim.text.toString()

            val (isValid, errorMessage) = viewModel.validateInput(name, nim)

            if (isValid) {

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("USER_NAME", name)
                intent.putExtra("USER_NIM", nim)
                startActivity(intent)
                finish()
            } else {

                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
}