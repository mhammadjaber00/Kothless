package auth

interface PasswordlessAuth {
    suspend fun registerUser(userId: String): Boolean
    suspend fun authenticateUser(userId: String, challenge: String): Boolean
}