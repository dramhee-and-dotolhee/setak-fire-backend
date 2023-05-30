import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.0.1"
	id("io.spring.dependency-management") version "1.1.0"
	id("io.freefair.lombok") version "5.3.0"
	id("org.asciidoctor.convert") version "1.5.8"
	kotlin("jvm") version "1.8.0"
	kotlin("plugin.spring") version "1.8.0"
	kotlin("plugin.jpa") version "1.8.0"
	kotlin("plugin.lombok") version "1.8.0"
	kotlin("kapt") version "1.8.0"
}

group = "dotolhee.daramhee"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	val isMacOS: Boolean = System.getProperty("os.name").startsWith("Mac OS X")
	val architecture = System.getProperty("os.arch").toLowerCase()
	if (isMacOS && architecture == "aarch64") {
		developmentOnly("io.netty:netty-resolver-dns-native-macos:4.1.68.Final:osx-aarch_64")
	}
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-mustache")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-logging")

	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.json:json:20220924")
	implementation("org.hibernate.validator:hibernate-validator:8.0.0.Final")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	developmentOnly("org.springframework.boot:spring-boot-devtools")

	// yaml 암호화
	implementation("com.github.ulisesbocchio:jasypt-spring-boot-starter:3.0.4")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	developmentOnly("org.springframework.boot:spring-boot-devtools")

	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	annotationProcessor("org.projectlombok:lombok:1.18.24")

	implementation("com.google.guava:guava:31.1-jre")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.1")
	implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6:3.1.1.RELEASE")
	implementation("org.bgee.log4jdbc-log4j2:log4jdbc-log4j2-jdbc4.1:1.16")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2") // springboot 3.0 이상에서 springdoc 1.x 버전이 작동하지않아서 2.x로 버전업
	implementation("org.hibernate:hibernate-validator:8.0.0.Final")

	// QueryDSL 설정
	val querydslVersion = "5.0.0"
	implementation(group = "com.querydsl", name = "querydsl-jpa", version = querydslVersion, classifier = "jakarta")
	kapt(group = "com.querydsl", name = "querydsl-apt", version = querydslVersion, classifier = "jakarta")

	compileOnly("org.projectlombok:lombok:1.18.20")
	runtimeOnly("com.mysql:mysql-connector-j:8.0.31")

	// test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
	testImplementation("org.springframework.security:spring-security-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<Jar>() {
	duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

// @Entity 에도 all-open 적용 (스프링 관련 Annotation들은 kotlin-spring 플러그인에서 처리됨)
allOpen {
	annotation("jakarta.persistence.Entity")
}