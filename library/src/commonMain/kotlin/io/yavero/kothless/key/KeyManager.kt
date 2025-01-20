package io.yavero.kothless.key

import io.yavero.kothless.biometric.PlatformSignature

interface KeyManager {
    fun generateKeyPair(userId: String): Pair<String, String>
    fun createPlatformSignature(privateKeyAlias: String): PlatformSignature
    fun signChallenge(signature: PlatformSignature, challenge: String): String
}