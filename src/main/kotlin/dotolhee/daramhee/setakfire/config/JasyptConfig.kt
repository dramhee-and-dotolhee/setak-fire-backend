package dotolhee.daramhee.setakfire.config

import lombok.extern.slf4j.Slf4j
import org.jasypt.encryption.StringEncryptor
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig
import org.jasypt.iv.RandomIvGenerator
import org.jasypt.salt.RandomSaltGenerator
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.util.ResourceUtils
import java.io.File
import java.io.IOException
import java.nio.file.Files


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
        val config = SimpleStringPBEConfig()
        config.password = getJasyptEncryptorPassword() // 암호화 키
        config.algorithm = algorithm // 사용할 알고리즘
        config.keyObtentionIterations = keyObtentionIterations // 해싱 반복 횟수
        config.poolSize = poolSize // Encryptor pool size
        config.saltGenerator = RandomSaltGenerator() // 랜덤 salt 생성기
        config.ivGenerator = RandomIvGenerator() // 랜담 IV 생성기
        config.stringOutputType = stringOutputType //"hexadecimal", "base64" // 인코딩 될 값
        encryptor.setConfig(config)
//        val source = "암호화할값"
//        println("plane :: ${source}, encrypt :: ${encryptor.encrypt(source)}")
        return encryptor
    }

    private fun getJasyptEncryptorPassword(): String {
        return try {
            val resource: File = ResourceUtils.getFile("classpath:key/jasypt-encryptor-password.txt")
            Files.readString(resource.toPath(), Charsets.UTF_8)
        } catch (e: IOException) {
            throw RuntimeException("####Jasypt password file 이 존재하지 않습니다.####")
        }
    }
}