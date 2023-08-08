package com.moontowertickets.randomuser.ui

import com.moontowertickets.randomuser.network.UserDto

data class UserState(
    val users: UserDto? = null,
    val isLoading: Boolean? = false,
    val error: String? = "",
)
