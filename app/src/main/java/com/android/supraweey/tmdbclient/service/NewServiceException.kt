package com.android.supraweey.tmdbclient.service

import com.android.supraweey.tmdbclient.domain.MISSING_REQUIRE

data class NewServiceException(
    var errorCd: String,
    override var message: String?
) : Exception() {
    constructor(errorCd: String) : this(errorCd, null)

    constructor(exception: NewServiceException, message: String?) : this(exception.errorCd, message)

    override fun toString(): String = "Error [$errorCd] ~> $message"

    companion object {
        fun missingRequire(message: String?) = NewServiceException(MISSING_REQUIRE, message)
    }
}