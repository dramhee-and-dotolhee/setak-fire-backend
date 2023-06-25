package dotolhee.daramhee.setakfire.global.security

class SecurityUrls {
    companion object {
        val CORS_URLS = listOf(
            "http://localhost",
            "http://localhost:8080",
            "http://localhost:9090"
        )

        val NO_AUTH_URLS = arrayOf(
            "/",
            "/swagger-ui/**",
            "register",
            "sign_in",
        )
    }
}
