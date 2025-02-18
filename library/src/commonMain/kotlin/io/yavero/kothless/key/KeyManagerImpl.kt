package io.yavero.kothless.key

import io.yavero.kothless.biometric.PlatformSignature

expect class KeyManagerImpl() : KeyManager {
    override fun generateKeyPair(userId: String): Pair<String, String>
    override fun createPlatformSignature(privateKeyAlias: String): PlatformSignature
    override fun signChallenge(signature: PlatformSignature, challenge: String): String
}