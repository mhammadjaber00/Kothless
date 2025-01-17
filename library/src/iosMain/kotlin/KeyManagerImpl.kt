package com.jabxm.kothless

actual class KeyManagerImpl : KeyManager {
    actual override fun generateKeyPair(): Pair<String, String> {
        // TODO: Implement using iOS Secure Enclave
        return Pair("iosPublicKey", "iosPrivateKey")
    }
}
