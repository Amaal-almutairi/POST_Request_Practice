package com.example.post_request_practice

import retrofit2.Call
import retrofit2.http.*


data class User1(val name:String, val Location:String )
data class Users(val id: Int, val name: String, val Location: String)



interface APIInterface {
// we will get the data from the json object
  @Headers("Content-Type: application/json")
  @GET("/test/")
  fun getUser():Call<List<Userinfo?>>

// posting data ( name and location )
  @Headers("Content-Type: application/json")
  @POST("/test/")
  fun addUser(@Body userData: User1):Call<User1>

  // posting data ( id,name and location  )
  @Headers("Content-Type: application/json")
  @PUT("/test/{id}")
  fun updateUser(@Path("id") id:Int, @Body userData: Users):Call<Users>

  // delete the data by gavin the id as primary key and all information will delete
  @Headers("Content-Type: application/json")
  @DELETE("/test/{id}")
  fun deleteUser(@Path ("id") id: Int):Call<Void>
    }


