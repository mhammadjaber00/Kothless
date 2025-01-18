package biometric

import kotlinx.cinterop.ExperimentalForeignApi
import platform.Security.SecKeyRef

class IOSPlatformSignature @OptIn(ExperimentalForeignApi::class) constructor(private val algorithm: String, val privateKey: SecKeyRef) : PlatformSignature {

    override fun update(data: ByteArray) {
        // No-op for iOS, as signing happens in one step.
    }

    override fun sign(): ByteArray {
        throw UnsupportedOperationException("Signing must be invoked with a challenge on iOS.")
    }
}