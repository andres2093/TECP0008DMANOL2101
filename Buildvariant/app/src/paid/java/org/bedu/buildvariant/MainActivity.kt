package org.bedu.buildvariant

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

val listUser = listOf(
    UserModel("andres", "123456"),
    UserModel("carlos", "123456")
)

class MainActivity : AppCompatActivity() {

    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtUsername = findViewById(R.id.edtUsername)
        edtPassword = findViewById(R.id.edtPassword)
        val btnLogin =findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            when{
                edtUsername.text.toString() == "" -> Toast.makeText(this, R.string.error_user, Toast.LENGTH_SHORT).show()
                edtPassword.text.toString() == "" -> Toast.makeText(this, R.string.error_pass, Toast.LENGTH_SHORT).show()
                else -> {
                    val userModel = UserModel(edtUsername.text.toString(), edtPassword.text.toString())
                    val userModels = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        listUser.stream().filter { user -> user.username == userModel.username && user.password == userModel.password }.findFirst().orElse(null)
                    } else {
                        var find: UserModel? = null
                        for (user in listUser) {
                                if (user.username == userModel.username && user.password == userModel.password){
                                    find = user
                                }
                        }
                        find
                    }
                    if (userModels != null){
                        Toast.makeText(this, R.string.login_success, Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, R.string.login_failed, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}