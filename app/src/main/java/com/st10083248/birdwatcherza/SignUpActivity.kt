package com.st10083248.birdwatcherza

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.st10083248.birdwatcherza.databinding.ActivitySignupBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_signup)

        firebaseAuth = FirebaseAuth.getInstance()

        val signinlink = findViewById<TextView>(R.id.tvSignin)
        signinlink.setOnClickListener{
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
        val SignUpButton = findViewById<Button>(R.id.btnSignUp)
        SignUpButton.setOnClickListener{
            val email = findViewById<EditText>(R.id.etxtEmail).text.toString()

            val pass = findViewById<EditText>(R.id.etxtPassword).text.toString()

            val repass = findViewById<EditText>(R.id.etxtReassword).text.toString()

            if(email != null && pass != null && repass != null){
                if(pass == repass){

                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener{
                        if(it.isSuccessful){
                            val intent = Intent(this, SignInActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this, it.exception.toString() , Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(this, "Password Does not Match" , Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Empty Fields Are not Allowed !!" , Toast.LENGTH_SHORT).show()
            }
        }
    }
}