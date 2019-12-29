package com.itemdatashow.itemdata.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.WindowManager
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.itemdatashow.itemdata.R
import com.itemdatashow.itemdata.util.MySingleton
import kotlinx.android.synthetic.main.activity_login.*
import java.lang.reflect.Method
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {

    val login_url = "http://dev.maxmobility.in:81/grabloyalty/qc/public/api/v1/customer/login"
    val user_url = "https://reqres.in/api/users?page=2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_login)

        login_btn.setOnClickListener(){
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            tlemail.error = ""
            tlemail.isErrorEnabled = false
            tlPassword.error = ""
            tlPassword.isErrorEnabled = false

            if (email.isEmpty()){
                tlemail.isErrorEnabled = true
                tlemail.error = "Field can not be empty"
                etEmail.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                tlemail.isErrorEnabled = true
                tlemail.error = "Field can not be empty"
                etEmail.requestFocus()
                return@setOnClickListener
            }

            if(password.isEmpty()){
                tlPassword.isErrorEnabled = true
                tlPassword.error = "Field can not be empty"
                etPassword.requestFocus()
                return@setOnClickListener
            }

            login(email, password)

            //startActivity(Intent(this, OrderListActivity::class.java))
        }
    }

    private fun login(email: String, password: String) {
        val request = object:
        StringRequest(Method.POST, user_url,
            Response.Listener { response ->

            },
            Response.ErrorListener { error ->

            }){
            override fun getParams(): MutableMap<String, String> {
                val map = HashMap<String, String>()
                map.put("username", email)
                map.put("password", password)
                map.put("device_type", "2")
                return map

            }
        }

        //MySingleton.getInstance()
    }
}
