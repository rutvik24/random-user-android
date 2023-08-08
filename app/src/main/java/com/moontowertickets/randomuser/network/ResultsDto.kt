package com.moontowertickets.randomuser.network

data class ResultsDto(
    val name: NameDto? = null,
    val email: String? = "",
    val phone: String? = "",
    val picture: PictureDto? = null,
)
