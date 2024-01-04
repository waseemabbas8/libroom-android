package com.waseem.libroom.core.usecase


interface UseCase<out T : Any, in Params : Any> {

    /**
     * Should prefer this when using from JVM
     */
    suspend operator fun invoke(params: Params): Result<T>
}
