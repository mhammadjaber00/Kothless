# Passwordless Authentication Library

## What is it?

This repository contains a **Kotlin Multiplatform** library designed to provide a **passwordless authentication solution** using public-key cryptography principles (similar to Passkeys). It allows developers to integrate secure authentication across multiple platforms (currently **Android** and **iOS**) with a shared codebase.

The library enables:

- **Registration**: Generate a public/private key pair and store the public key on a backend server.
- **Authentication**: Use the private key to sign a server challenge and verify the user.
- **User Management**: Simplified API for organizations to manage user keys and authentication flows.

---

## Key Features

### 1. **Passwordless Authentication**
- Based on **FIDO2/WebAuthn principles**.
- Uses platform-specific secure storage:
  - **Android**: Android Keystore.
  - **iOS**: Secure Enclave/Keychain.

### 2. **Cross-Platform Support**
- Common logic shared across **Android** and **iOS** using Kotlin Multiplatform.

### 3. **User Management API**
- Simple, customizable API for registering users and authenticating securely.

### 4. **Secure and Flexible**
- Built with modern cryptographic practices.

---

## Future Expansion

Although the initial implementation focuses on **Android** and **iOS**, the library is designed to allow easy expansion to other platforms (e.g., JVM, Linux) in the future.