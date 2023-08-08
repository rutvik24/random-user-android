package com.moontowertickets.randomuser.domain.repository

import com.moontowertickets.randomuser.domain.util.Resource
import com.moontowertickets.randomuser.network.UserDto

interface UserRepository {
    suspend fun getUsers(): Resource<UserDto>
}