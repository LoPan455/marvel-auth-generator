/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package marvel.api.auth

import marvel.api.auth.config.ConfigFileParser
import marvel.api.auth.model.AuthParts
import org.apache.commons.codec.digest.DigestUtils
import java.time.Instant

/* Server-side applications must pass two parameters in addition to the apikey parameter:

ts - a timestamp (or other long string which can change on a request-by-request basis)
hash - a md5 digest of the ts parameter, your private key and your public key (e.g. md5(ts+privateKey+publicKey)
For example, a user with a public key of "1234" and a private key of "abcd" could construct a valid call as follows: http://gateway.marvel.com/v1/public/comics?ts=1&apikey=1234&hash=ffd275c5130566a2916217b101f26150 (the hash value is the md5 digest of 1abcd1234)

*/
class Library {

    init {
        ConfigFileParser().getPropertiesFromFile()
        System.getProperties().map {
            println("${it.key} : ${it.value}")
        }
    }

    fun buildAuthString(timeStamp: Instant): AuthParts {
        val preHashString = "${timeStamp.toEpochMilli()}${System.getProperty("marvel-api-public-key")}${System.getProperty("marvel-api-private-key")}"
        val hashed: String = DigestUtils.md5Hex(preHashString)
        return AuthParts(
                ts = timeStamp.toEpochMilli(),
                publicKey = System.getProperty("marvel-api-public-key"),
                md5Hash = hashed
        )
    }
}
