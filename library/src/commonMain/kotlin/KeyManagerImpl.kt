package com.jabxm.kothless

expect class KeyManagerImpl() : KeyManager {
    override fun generateKeyPair(): Pair<String, String>
}