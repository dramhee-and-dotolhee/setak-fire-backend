package dotolhee.daramhee.setakfire

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableEncryptableProperties
class SetakFireApplication

fun main(args: Array<String>) {
	runApplication<SetakFireApplication>(*args)
}
