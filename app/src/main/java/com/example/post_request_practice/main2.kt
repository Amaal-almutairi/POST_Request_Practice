package com.example.post_request_practice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class main2 : AppCompatActivity() {
    lateinit var edname:EditText
    lateinit var edlocation:EditText
    lateinit var btnSave:Button
    lateinit var btnview:Button
         override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
             edname =findViewById(R.id.ednamemain2)
             edlocation = findViewById(R.id.edlocmain2)
             btnSave = findViewById(R.id.btnsavemain2)
             btnview = findViewById(R.id.btnviewmain2)


             btnSave.setOnClickListener {
                 allinfo ()


             }
             btnview.setOnClickListener {
                 val intent = Intent(this,MainActivity::class.java)
                 startActivity(intent)

             }

}

    fun allinfo (){
        val api = APIClient().getClient()?.create(APIInterface::class.java)
        val name = edname.text.toString()
        val location = edlocation.text.toString()
        api!!.addUser(User1(name,location)).enqueue(object: Callback<User1>{
            override fun onResponse(call: Call<User1>, response: Response<User1>) {
                Toast.makeText(this@main2, "User Added", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<User1>, t: Throwable) {
                Toast.makeText(this@main2, "User Not Add", Toast.LENGTH_SHORT).show()

            }

        })

    }}
