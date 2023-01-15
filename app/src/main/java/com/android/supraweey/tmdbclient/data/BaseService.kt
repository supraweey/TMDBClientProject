package com.android.supraweey.tmdbclient.data

import android.content.Context
import com.android.supraweey.tmdbclient.domain.*
import com.android.supraweey.tmdbclient.network.Networkable
import com.android.supraweey.tmdbclient.service.NewServiceException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

abstract class BaseService<R, M> constructor(private val networkable: Networkable): KoinComponent {
    abstract suspend fun callApi(): R
    abstract fun mapper(from: R): M

    private val context: Context by inject()

    fun execute(): Flow<M> = flow { emit(checkInternetConnection()) }
        .map {
            callApi() }
        .map {
            mapper(it) }
        .catch {error: Throwable ->
            mapError(error) }

    private fun checkInternetConnection() {
        if (!networkable.isInternetConnection())
            throw NewServiceException(
                NO_INTERNET_CONNECTION,
                NO_INTERNET_CONNECTION
            )
    }

    private fun mapError(e: Throwable) {
        when (e) {
            is TimeoutException ->
                throw NewServiceException(TIMEOUT, e.message)
            is SocketTimeoutException ->
                throw NewServiceException(SOCKET_TIMEOUT, e.message)
            is UnknownHostException ->
                throw NewServiceException(UNKNOWN_HOST, e.message)
            is HttpException ->
                e.handleHttpError()
            is NewServiceException ->
                    throw NewServiceException(e.errorCd, e.message)
            else ->
                e.handleFailToDecryptError()
        }
    }

    private fun Throwable.handleFailToDecryptError() {
        when (message) {
            FAIL_TO_DECRYPT_ERROR_CODE -> throw NewServiceException(FAIL_TO_DECRYPT_ERROR_CODE)
            else -> throw NewServiceException(APP_COMMON_ERROR, message)
        }
    }

    companion object {
        private val SUCCESS_CODE = arrayListOf("0000")
    }
}