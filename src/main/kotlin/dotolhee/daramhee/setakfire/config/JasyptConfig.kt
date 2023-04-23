package dotolhee.daramhee.setakfire.config

import lombok.extern.slf4j.Slf4j
import org.jasypt.encryption.StringEncryptor
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors


@Configuration
@Slf4j
class JasyptConfig(
    @Value("\${jasypt.encryptor.algorithm}")
    private val algorithm: String,
    @Value("\${jasypt.encryptor.pool-size}")
    private val poolSize: Int,
    @Value("\${jasypt.encryptor.string-output-type}")
    private val stringOutputType: String?,
    @Value("\${jasypt.encryptor.key-obtention-iterations}")
    private val keyObtentionIterations: Int,
    ) {
    @Bean
    fun jasyptStringEncryptor(): StringEncryptor? {
        val encryptor = PooledPBEStringEncryptor()
        encryptor.setPoolSize(poolSize)
        encryptor.setAlgorithm(algorithm)
        encryptor.setPassword(getJasyptEncryptorPassword())
        encryptor.setStringOutputType(stringOutputType)
        encryptor.setKeyObtentionIterations(keyObtentionIterations)

//        val logger: Logger = LoggerFactory.getLogger(HelloController::class.java)
//        val source = "ㅇㅇ"
//        logger.info("plane :: {}, encrypt :: {}", source, encryptor.encrypt(source))
        return encryptor
    }

    private fun getJasyptEncryptorPassword(): String {
        return try {
            val resource = ClassPathResource("classpath:key/jasypt-encryptor-password.txt")
            Files.readAllLines(Paths.get(resource.getURI())).stream()
                .collect(Collectors.joining(""))
        } catch (e: IOException) {
            throw RuntimeException("####Jasypt password file 이 존재하지 않습니다.####")
        }
    }
}