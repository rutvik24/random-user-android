package com.moontowertickets.randomuser.network

import com.squareup.moshi.Json

data class UserDto(
    @field:Json(name = "results")
    val results: List<ResultsDto>? = null,
)
