package com.moontowertickets.randomuser.domain.repository

import com.moontowertickets.randomuser.domain.util.Resource
import com.moontowertickets.randomuser.network.UserData
import com.moontowertickets.randomuser.network.UserDto
import javax.inject.Inject

class UserRepositoryImpl @Inject  constructor(
    private val api: UserData
): UserRepository {

    override suspend fun getUsers(): Resource<UserDto> {
        return try {
            Resource.Success(data = api.getRandomUser())
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred")
        }
    }
}