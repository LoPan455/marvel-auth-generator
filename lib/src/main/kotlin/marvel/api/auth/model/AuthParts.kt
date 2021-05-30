package marvel.api.auth.model

import java.time.Instant

data class AuthParts(
        val ts: Long,
        val publicKey: String,
        val md5Hash: String
)