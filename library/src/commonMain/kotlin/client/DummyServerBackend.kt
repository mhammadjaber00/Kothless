package client

class DummyServerBackend {
    private val userPublicKeys = mutableMapOf<String, String>()

    fun registerPublicKey(userId: String, publicKey: String): Boolean {
        if (userPublicKeys.containsKey(userId)) {
            println("User $userId is already registered with public key: ${userPublicKeys[userId]}")
            return false
        }

        userPublicKeys[userId] = publicKey
        println("Successfully registered user $userId with public key: $publicKey")
        return true
    }

    fun verifyChallenge(userId: String, signedChallenge: String): Boolean {
        val publicKey = userPublicKeys[userId]
        return if (publicKey != null) {
            println("Verified challenge for user $userId with public key: $publicKey")
            true
        } else {
            println("Failed to verify challenge: User $userId not found.")
            false
        }
    }
}