package dotolhee.daramhee.setakfire.global.security.token

import io.jsonwebtoken.Jwts
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.sql.Timestamp
import java.time.Instant
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.*

@Component
class JwtTokenUtil(
    @Value("\${jwt.secret-key}")
    private val secretKey: String,
) {

    fun generateToken(userDetails: UserDetails): String {
        val claims = HashMap<String, Any>()
        claims["role"] = userDetails.authorities.map { it.authority }[0]
        return Jwts.builder()
            .setSubject(userDetails.username)
            .setIssuedAt(Timestamp.valueOf(LocalDateTime.now()))
            .setExpiration(Date.from(Instant.now().plus(3, ChronoUnit.HOURS)))
            .compact()
    }

    fun validateToken(token: String, userDetails: UserDetails): Boolean {
        val username = getUserNameByToken(token)
        return (username == userDetails.username) && !isTokenExpired(token)
    }

    private fun getUserNameByToken(token: String): String {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).body.subject
    }

    private fun isTokenExpired(token: String): Boolean {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).body.expiration.before(
            Timestamp.valueOf(
                LocalDateTime.now()
            )
        )
    }
}