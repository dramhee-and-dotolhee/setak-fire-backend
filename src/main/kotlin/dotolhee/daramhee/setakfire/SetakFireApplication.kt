package dotolhee.daramhee.setakfire

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SetakFireApplication

fun main(args: Array<String>) {
	runApplication<SetakFireApplication>(*args) {
		setBannerMode(Banner.Mode.OFF)
	}
}
