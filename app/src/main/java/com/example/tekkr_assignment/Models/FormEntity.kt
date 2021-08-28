package com.example.tekkr_assignment.Models

import com.google.gson.annotations.SerializedName

class FormEntity (
    @SerializedName("uiType")
    var uiType: String? = null,

    @SerializedName("value")
    var value: String? = null,

    @SerializedName("key")
    var key: String? = null,

    @SerializedName("hint")
    var hint: String? = null
)