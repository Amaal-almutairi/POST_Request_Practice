package com.example.post_request_practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity3 : AppCompatActivity() {
    lateinit var edId:EditText
    lateinit var edname:EditText
    lateinit var edlocation:EditText
    lateinit var btnupdate:Button
    lateinit var btndelete:Button
    lateinit var btnview:Button
    var api = APIClient().getClient()?.create(APIInterface::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        edId = findViewById(R.id.edid)
        edname = findViewById(R.id.ednammain3)
        edlocation = findViewById(R.id.edlocmain3)
        btnupdate = findViewById(R.id.btnUpdmain3)
        btndelete = findViewById(R.id.btnDelmain3)
        btnview = findViewById(R.id.btnviewmain3)
        btnupdate.setOnClickListener {
            update()}

        btndelete.setOnClickListener {
     delete()}

        btnview.setOnClickListener {
            move()}

    }
// update the data by gavin the id
    fun update(){
        val id = edId.text.toString().toInt()
        val name = edname.text.toString()
        val location = edlocation.toString()
    // this function will work if the application is work
        api!!.updateUser(id,Users(id,name,location)).enqueue(object:Callback<Users>{
            // this function will work if the application is work
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                Toast.makeText(this@MainActivity3, "User updated", Toast.LENGTH_SHORT).show()
            }
            // this function will not work if the application is failed

            override fun onFailure(call: Call<Users>, t: Throwable) {
                Toast.makeText(this@MainActivity3, "User Not updated", Toast.LENGTH_SHORT).show()
            }

        })
    }
    // delete the data by gavin the id as primary key and all information will delete
    fun delete(){
        val id = edId.text.toString().toInt()
        api!!.deleteUser(id).enqueue(object :Callback<Void>{
            // this function will work if the application is work
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                Toast.makeText(this@MainActivity3, "User Deleted", Toast.LENGTH_SHORT).show()
            }
            // this function will not work if the application is failed

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(this@MainActivity3, "User Not Deleted", Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun move(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)

    }
}