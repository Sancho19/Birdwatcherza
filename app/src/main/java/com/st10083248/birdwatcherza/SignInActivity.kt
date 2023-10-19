package com.st10083248.birdwatcherza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {

    // private lateinit var binding:ActivitySigninBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_signin)

        firebaseAuth = FirebaseAuth.getInstance()

        val signuplink = findViewById<TextView>(R.id.tvSignup)
        signuplink.setOnClickListener{
       // tvSignup.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        val loginButton = findViewById<Button>(R.id.btnLogin)
        loginButton.setOnClickListener{

            val email = findViewById<EditText>(R.id.etxtEmail).text.toString()

            val pass = findViewById<EditText>(R.id.etxtPassword).text.toString()

            if(email != null && pass != null){


                    firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener{
                        if(it.isSuccessful){
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this, it.exception.toString() , Toast.LENGTH_SHORT).show()
                        }
                    }

            }else{
                Toast.makeText(this, "Empty Fields Are not Allowed !!" , Toast.LENGTH_SHORT).show()
            }
        }

    }
}