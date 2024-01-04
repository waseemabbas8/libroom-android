package com.waseem.libroom.feature.auth.data

import com.google.firebase.auth.FirebaseAuth
import com.waseem.libroom.feature.auth.domain.AuthRepository
import com.waseem.libroom.feature.auth.domain.User
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {
    override suspend fun signIn(email: String, password: String): Result<User> {
        val authResult = firebaseAuth.signInWithEmailAndPassword(email, password).await()
        authResult.user?.let {firebaseUser ->
            return Result.success(
                User(
                    id = firebaseUser.uid,
                    email = firebaseUser.email ?: "invalid email",
                    name = firebaseUser.displayName
                )
            )
        } ?: run {
            return Result.failure(Exception("User not found"))
        }
    }

    override suspend fun signOut(): Result<Boolean> {
        firebaseAuth.signOut()
        return Result.success(true)
    }
}