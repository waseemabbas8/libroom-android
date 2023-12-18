package com.waseem.libroom.feature.auth.data

import com.google.firebase.auth.FirebaseAuth
import com.waseem.libroom.core.SResult
import com.waseem.libroom.feature.auth.domain.AuthRepository
import com.waseem.libroom.feature.auth.domain.User
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {
    override suspend fun signIn(email: String, password: String): SResult<User> {
        val authResult = firebaseAuth.signInWithEmailAndPassword(email, password).await()
        authResult.user?.let {firebaseUser ->
            return SResult.success(
                User(
                    id = firebaseUser.uid,
                    email = firebaseUser.email ?: "invalid email",
                    name = firebaseUser.displayName
                )
            )
        } ?: run {
            return SResult.failure(Exception("User not found"))
        }
    }

    override suspend fun signOut(): SResult<Boolean> {
        TODO("Not yet implemented")
    }
}