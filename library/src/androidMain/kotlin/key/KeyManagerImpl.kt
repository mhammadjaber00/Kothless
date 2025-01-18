package key

import android.os.Build
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import androidx.annotation.RequiresApi
import biometric.AndroidPlatformSignature
import biometric.PlatformSignature
import java.security.*
import java.util.Base64

actual class KeyManagerImpl : KeyManager {

    companion object {
        private const val ANDROID_KEYSTORE = "AndroidKeyStore"
        private const val ALIAS_PREFIX = "passkey_"
    }

    @RequiresApi(Build.VERSION_CODES.R)
    actual override fun generateKeyPair(userId: String): Pair<String, String> {
        val keyPair = generateKeyPairInKeystore(userId)
        val publicKey = Base64.getEncoder().encodeToString(keyPair.public.encoded)
        val privateKey = "stored_in_keystore"
        return Pair(publicKey, privateKey)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    private fun generateKeyPairInKeystore(userId: String): KeyPair {
        val keyStore = KeyStore.getInstance(ANDROID_KEYSTORE)
        keyStore.load(null)

        if (keyStore.containsAlias("$ALIAS_PREFIX$userId")) {
            val privateKey = keyStore.getKey("$ALIAS_PREFIX$userId", null) as java.security.PrivateKey
            val publicKey = keyStore.getCertificate("$ALIAS_PREFIX$userId").publicKey
            return KeyPair(publicKey, privateKey)
        }

        val keyPairGenerator = KeyPairGenerator.getInstance(
            KeyProperties.KEY_ALGORITHM_RSA,
            ANDROID_KEYSTORE
        )
        val parameterSpec = KeyGenParameterSpec.Builder(
            "$ALIAS_PREFIX$userId",
            KeyProperties.PURPOSE_SIGN or KeyProperties.PURPOSE_VERIFY
        ).setDigests(KeyProperties.DIGEST_SHA256, KeyProperties.DIGEST_SHA512)
            .setSignaturePaddings(KeyProperties.SIGNATURE_PADDING_RSA_PKCS1)
            .setKeySize(2048)
            .setUserAuthenticationRequired(true)
            .setUserAuthenticationParameters(0, KeyProperties.AUTH_BIOMETRIC_STRONG)
            .build()

        keyPairGenerator.initialize(parameterSpec)
        return keyPairGenerator.generateKeyPair()
    }

    actual override fun createPlatformSignature(privateKeyAlias: String): PlatformSignature {
        val keyStore = KeyStore.getInstance("AndroidKeyStore").apply { load(null) }
        val privateKey = keyStore.getKey(privateKeyAlias, null) as PrivateKey
        return AndroidPlatformSignature("SHA256withRSA", privateKey)
    }

    actual override fun signChallenge(signature: PlatformSignature, challenge: String): String {
        signature.update(challenge.toByteArray())
        val signedData = signature.sign()
        return Base64.getEncoder().encodeToString(signedData)
    }
}