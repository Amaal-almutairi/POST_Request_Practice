package com.example.post_request_practice

import com.google.gson.annotations.SerializedName


    class Userinfo {
        @SerializedName("pk")
        var pk: Int? = null

     @SerializedName("name")
     var name:String?=null

        @SerializedName("Location")
        var Location:String?= null

    }
