package com.example.santepriceindex

import java.io.Serializable

data class Product(

    var id: String = "",

    var productName: String = "",

    var costPrice: String = "",

    var sellingPrice: String = ""

) : Serializable