package key

import biometric.PlatformSignature
import biometric.IOSPlatformSignature
import kotlinx.cinterop.*
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Security.*

actual class KeyManagerImpl : KeyManager {

    actual override fun generateKeyPair(userId: String): Pair<String, String> {
        return Pair("", "")
    }

    @OptIn(ExperimentalForeignApi::class)
    actual override fun createPlatformSignature(privateKeyAlias: String): PlatformSignature {
        val dummyKey: SecKeyRef = memScoped {
            alloc<SecKeyRefVar>().ptr.reinterpret()
        }
        return IOSPlatformSignature("SHA256", dummyKey)
    }

    actual override fun signChallenge(signature: PlatformSignature, challenge: String): String {
        return ""
    }
}
