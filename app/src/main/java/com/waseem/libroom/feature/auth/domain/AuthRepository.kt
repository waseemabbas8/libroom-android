package com.waseem.libroom.feature.auth.domain

import com.waseem.libroom.core.SResult

interface AuthRepository {
    suspend fun signIn(email: String, password: String): SResult<User>
    suspend fun signOut(): SResult<Boolean>
}