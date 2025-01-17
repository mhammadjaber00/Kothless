package com.jabxm.kothless

import kotlin.test.Test
import kotlin.test.assertTrue

class PasswordlessAuthTest {
    private val auth = PasswordlessAuthImpl()

    @Test
    fun testRegisterUser() {
        val result = auth.registerUser("testUser")
        assertTrue(result, "User registration should succeed")
    }

    @Test
    fun testAuthenticateUser() {
        val result = auth.authenticateUser("testUser", "sampleChallenge")
        assertTrue(result, "User authentication should succeed")
    }
}
