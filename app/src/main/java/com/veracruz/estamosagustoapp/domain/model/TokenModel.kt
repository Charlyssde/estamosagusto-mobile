package com.veracruz.estamosagustoapp.domain.model

data class TokenModel(
    val access_token : String = "" ,
    val expires_in : String = "" ,
    val refresh_expires_in : String = "",
    val refresh_token : String = "",
    val token_type : String = "",
    val id_token : Int = 0,
    val session_state : String = "",
    val scope : String = "",
    val error : String = "",
    val error_description : String = "",
    val error_uri : String = ""
)
