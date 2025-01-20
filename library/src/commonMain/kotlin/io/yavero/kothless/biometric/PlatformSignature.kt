package io.yavero.kothless.biometric

interface PlatformSignature {
    fun update(data: ByteArray)
    fun sign(): ByteArray
}