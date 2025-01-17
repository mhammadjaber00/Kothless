package com.jabxm.kothless

class PasswordlessAuthImpl(private val keyManager: KeyManager = KeyManagerImpl()) : PasswordlessAuth {
    override fun registerUser(userId: String): Boolean {
        val keyPair = keyManager.generateKeyPair()
        println("Generated keys for $userId: Public Key = ${keyPair.first}, Private Key = ${keyPair.second}")
        return true
    }

    override fun authenticateUser(userId: String, challenge: String): Boolean {
        println("Authenticating user $userId with challenge: $challenge")
        return true
    }
}