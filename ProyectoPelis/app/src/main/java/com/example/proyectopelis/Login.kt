package com.example.proyectopelis

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectopelis.databinding.LoginBinding

class Login : AppCompatActivity() {

    private lateinit var binding: LoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pref = getSharedPreferences("user", Context.MODE_PRIVATE)
        val user = pref.getString("user","")
        binding.usertext.setText(user)

        binding.login.setOnClickListener {

            when(binding.usertext.text.toString()){
                "cinefilo" -> if(binding.passtext.text.toString() == "12345"){
                    guardar()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()

                }else{
                    if(binding.passtext.text?.isNotEmpty() == true){
                        alertdialog()
                    }
                    binding.usertext.error = "Datos incorrectos"
                    binding.passtext.error = "Datos incorrectos"

                }
                else -> if(binding.usertext.text?.isNotEmpty().toString().toBoolean() && binding.passtext.text?.isNotEmpty().toString().toBoolean()){
                    alertdialog()
                    binding.usertext.error = "Datos incorrectos"

                }else{
                    binding.passtext.error = "Datos incorrectos"
                }

            }

            if(binding.usertext.text?.isEmpty().toString().toBoolean()){
                binding.usertext.error = "El campo esta vacío"
            }

            if(binding.passtext.text?.isEmpty().toString().toBoolean()){
                binding.passtext.error = "El campo esta vacío"
            }

        }

        binding.invitado.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            pref.edit().clear().apply()
            startActivity(intent)
            finish()
        }

    }

    private fun guardar(){
        val pref = getSharedPreferences("user",Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString("user",binding.usertext.text.toString())
        editor.apply()
    }

    private fun alertdialog(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Usuario y contraseña incorrectos. Vuelve a intentarlo")
        builder.setNeutralButton("CERRAR", null)
        val dialog = builder.create()
        dialog.show()
    }
}