package client

import client.DummyServerBackend
import kotlinx.coroutines.delay

class ServerClient(private val dummyBackend: DummyServerBackend = DummyServerBackend()) {
    suspend fun registerPublicKey(userId: String, publicKey: String): Boolean {
        delay(500)
        return dummyBackend.registerPublicKey(userId, publicKey)
    }

    suspend fun verifyChallenge(userId: String, signedChallenge: String): Boolean {
        delay(500)
        return dummyBackend.verifyChallenge(userId, signedChallenge)
    }
}