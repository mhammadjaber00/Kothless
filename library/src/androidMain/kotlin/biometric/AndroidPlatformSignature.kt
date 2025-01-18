package biometric

import java.security.PrivateKey
import java.security.Signature

class AndroidPlatformSignature(algorithm: String, private val privateKey: PrivateKey) : PlatformSignature {

    private val signatureInstance: Signature = Signature.getInstance(algorithm).apply {
        initSign(privateKey)
    }

    override fun update(data: ByteArray) {
        signatureInstance.update(data)
    }

    override fun sign(): ByteArray {
        return signatureInstance.sign()
    }
}