package com.waseem.libroom.core.usecase

import com.waseem.libroom.core.SResult


interface UseCase<out T : Any, in Params : Any> {

    /**
     * Should prefer this when using from JVM
     */
    suspend operator fun invoke(params: Params): SResult<T>
}
