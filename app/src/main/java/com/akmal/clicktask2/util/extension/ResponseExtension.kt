package com.akmal.clicktask2.util.extension

import com.akmal.clicktask2.util.helper.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

suspend fun <T, R> safeApiCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T,
    mapToDomain: (T) -> R
): Resource<R> = withContext(dispatcher) {
    try {
        val response = apiCall()
        val result = mapToDomain(response)
        Resource.Success(result)
    } catch (e: HttpException) {
        val message = e.response()?.errorBody()?.string() ?: e.message()
        Resource.Error(message ?: "Server xatosi")
    } catch (e: IOException) {
        Resource.Error("Internetga ulanishda xatolik")
    } catch (e: Exception) {
        Resource.Error(e.message ?: "Noma'lum xatolik")
    }
}