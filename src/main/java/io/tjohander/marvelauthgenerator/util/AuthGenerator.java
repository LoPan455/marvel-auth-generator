package io.tjohander.marvelauthgenerator.util;

import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class AuthGenerator {

    /*
    Server-side applications must pass two parameters in addition to the apikey parameter:

    ts - a timestamp (or other long string which can change on a request-by-request basis)
    hash - a md5 digest of the ts parameter, your private key and your public key (e.g. md5(ts+privateKey+publicKey)

    For example, a user with a public key of "1234" and a private key of "abcd" could construct a valid call as follows:
    http://gateway.marvel.com/v1/public/comics?ts=1&apikey=1234&hash=ffd275c5130566a2916217b101f26150
    (the hash value is the md5 digest of 1abcd1234)
     */

    public static String generateAuthHash(Instant instant) {
        return "foo";
    }
}
