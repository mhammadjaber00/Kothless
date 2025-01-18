package biometric

interface PlatformSignature {
    fun update(data: ByteArray)
    fun sign(): ByteArray
}