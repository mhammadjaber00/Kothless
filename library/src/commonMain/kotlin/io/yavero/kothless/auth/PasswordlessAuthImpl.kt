package io.yavero.kothless.auth

import io.yavero.kothless.client.ServerClient
import io.yavero.kothless.key.KeyManager
import io.yavero.kothless.key.KeyManagerImpl

class PasswordlessAuthImpl(
    private val keyManager: KeyManager = KeyManagerImpl(),
    private val serverClient: ServerClient = ServerClient()
) : PasswordlessAuth {
    override suspend fun registerUser(userId: String): Boolean {
        val keyPair = keyManager.generateKeyPair(userId)

        return runCatching {
            serverClient.registerPublicKey(userId, keyPair.first)
        }.onFailure {
            println("Failed to register user: ${it.message}")
        }.getOrDefault(false)
    }

    override suspend fun authenticateUser(userId: String, challenge: String): Boolean {
        val platformSignature = keyManager.createPlatformSignature("privateKey")

        val signedChallenge = keyManager.signChallenge(platformSignature, challenge)

        val success = runCatching {
            serverClient.verifyChallenge(userId, signedChallenge)
        }.getOrElse {
            println("Failed to authenticate user: ${it.message}")
            return false
        }

        return success
    }
}