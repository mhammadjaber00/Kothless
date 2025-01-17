package com.jabxm.kothless

interface KeyManager {
    fun generateKeyPair(): Pair<String, String> // Public Key, Private Key
}