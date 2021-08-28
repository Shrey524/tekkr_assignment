package com.example.tekkr_assignment.Models

import com.google.gson.annotations.SerializedName

open class Form(
    @SerializedName("logo-url")
    var logo_url: String? = null,
    @SerializedName("heading-text")
    val heading_text: String? = null,
    @SerializedName("uidata")
    val uiData: ArrayList<FormEntity>
    ) {

}


