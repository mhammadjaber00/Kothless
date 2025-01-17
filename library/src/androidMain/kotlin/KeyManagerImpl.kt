package com.jabxm.kothless

actual class KeyManagerImpl : KeyManager {
    actual override fun generateKeyPair(): Pair<String, String> {
        // TODO: Implement using Android Keystore
        return Pair("androidPublicKey", "androidPrivateKey")
    }
}