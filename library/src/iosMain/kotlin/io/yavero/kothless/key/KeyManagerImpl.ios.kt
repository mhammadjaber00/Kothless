package io.yavero.kothless.key

import io.yavero.kothless.biometric.PlatformSignature

actual class KeyManagerImpl actual constructor() : KeyManager {
    actual override fun generateKeyPair(userId: String): Pair<String, String> {
        TODO("Not yet implemented")
    }

    actual override fun createPlatformSignature(privateKeyAlias: String): PlatformSignature {
        TODO("Not yet implemented")
    }

    actual override fun signChallenge(
        signature: PlatformSignature,
        challenge: String
    ): String {
        TODO("Not yet implemented")
    }
}