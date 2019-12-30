package com.itemdatashow.itemdata.activities

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.WindowManager
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.itemdatashow.itemdata.R
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject
import java.lang.reflect.Method
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {

    val login_url = "http://dev.maxmobility.in:81/grabloyalty/qc/public/api/v1/customer/login"
    val user_url = "https://reqres.in/api/users?page=2"
    val jsonobj = JSONObject()

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

           // login(email, password)

            jsonobj.put("username", email)
            jsonobj.put("password", password)

            val que = Volley.newRequestQueue(this@LoginActivity)
            val req = JsonObjectRequest(Request.Method.GET,user_url, jsonobj,
                Response.Listener {
                    response -> Toast(this)

                }, Response.ErrorListener {error ->
                      Toast(this)
                } )
            que.add(req)

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

        //MySingleton.addToRequestQueue()
       // Application.instance!!.addToReuestQueue()
    }
}
