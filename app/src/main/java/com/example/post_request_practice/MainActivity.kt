package com.example.post_request_practice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainActivity : AppCompatActivity() {
    lateinit var btnAdd:Button
    lateinit var btnUpdateDelete:Button
    lateinit var myrview:RecyclerView
    lateinit var users:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // her we create a variable to store APIClient().getClient()
        val api = APIClient().getClient()?.create(APIInterface::class.java)

        val call:Call<List<Userinfo?>> = api!!.getUser()
        btnAdd = findViewById(R.id.btnadd)
        btnUpdateDelete = findViewById(R.id.btnUD)
        myrview=findViewById(R.id.rv)
        users = java.util.ArrayList()
        myrview.adapter=myadap(users)
        myrview.layoutManager  =LinearLayoutManager(this)

        btnAdd.setOnClickListener {
            val intent = Intent(this,main2::class.java)
            startActivity(intent)
        }
        btnUpdateDelete.setOnClickListener {
            val intent = Intent(this,MainActivity3::class.java)
            startActivity(intent)

        }


        call?.enqueue(object :Callback<List<Userinfo?>>{
            override fun onResponse(
                call: Call<List<Userinfo?>>,
                response: Response<List<Userinfo?>>
            ) {
                val Resource:List<Userinfo?>? = response.body()
                if (Resource!= null){
                    for (user in Resource){
                        val Id = user?.pk.toString()
                        val name = user?.name.toString()
                        val location = user?.Location.toString()
                        users.add(Id+"\n"+name+"\n"+ location+"\n")
                        myrview.adapter?.notifyDataSetChanged()
                        myrview.scrollToPosition(users.size-1)
                    }
                }

            }

            override fun onFailure(call: Call<List<Userinfo?>>, t: Throwable?) {
                call.cancel()
            }

        })



        }
}


