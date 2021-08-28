package com.example.tekkr_assignment.Models

data class Orders(
    val logoUrl: String,
    val heading: String,
    val uiData: ArrayList<Orders.OrderList>
){data class OrderList(
    val id: String,
    val name: String,
    val address: String,
    val customer_lat: Long,
    val customer_lang: Long,
    val shop_lat: Long,
    val shop_lang: Long,
)}