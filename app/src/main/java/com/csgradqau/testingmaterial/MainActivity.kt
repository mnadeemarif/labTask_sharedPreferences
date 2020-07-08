package com.csgradqau.testingmaterial

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences : SharedPreferences
    lateinit var login : Button
    lateinit var register : Button
    lateinit var username : TextView
    lateinit var pass : TextView
    val myPref = "myPref"
    val name = "username"
    val ps = "password"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login  = findViewById<com.google.android.material.button.MaterialButton>(R.id.loginf)
        register  = findViewById<com.google.android.material.button.MaterialButton>(R.id.registerf)
        login.setOnClickListener{
            //Toast.makeText(this,"Logged In Successfully !",Toast.LENGTH_LONG).show()

            login  = findViewById<com.google.android.material.button.MaterialButton>(R.id.loginf)
            register  = findViewById<com.google.android.material.button.MaterialButton>(R.id.registerf)
            username = findViewById<TextView>(R.id.email)
            pass = findViewById<TextView>(R.id.pass)
            sharedPreferences = getSharedPreferences(myPref, Context.MODE_PRIVATE)
            if (username.getText().toString().equals("") || pass.getText().toString().equals("")){
                Toast.makeText(this,"One of Either fields is empty!",Toast.LENGTH_LONG).show()
            }
            else{
                if (sharedPreferences.contains(username.getText().toString())){
                    var x = sharedPreferences.getString(username.getText().toString(),"-1")
                    var y = x?.split(" ")
                    if (y != null) {
                        if(pass.getText().toString() == y.get(1)){
                            val it : Intent = Intent(this,home::class.java).apply {
                                putExtra("email",y.get(0).toString())
                                putExtra("myPref","myPref")
                            }
                            startActivity(it)
                            Toast.makeText(this,"Logged In Successfully !",Toast.LENGTH_LONG).show()
                        }
                    }
                }
                else {
                    Toast.makeText(this,"User not found ! please regiser first !",Toast.LENGTH_LONG).show()
                }
            }

        }
        register.setOnClickListener{
        var n = username.getText().toString()
        var m = pass.getText().toString()
        var editor = sharedPreferences.edit()
        editor.putString(n,n+" "+m)
        editor.commit()
            Toast.makeText(this,"You have been registered !"+n+" "+m,Toast.LENGTH_LONG).show()
        }
        username = findViewById<TextView>(R.id.email)
        pass = findViewById<TextView>(R.id.pass)
        sharedPreferences = getSharedPreferences(myPref, Context.MODE_PRIVATE)
        if (sharedPreferences.contains(name)){
            username.setText(sharedPreferences.getString(name,""))
            pass.setText(sharedPreferences.getString(ps,""))
        }
    }
}