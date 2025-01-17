package com.jabxm.kothless

interface PasswordlessAuth {
    fun registerUser(userId: String): Boolean
    fun authenticateUser(userId: String, challenge: String): Boolean
}