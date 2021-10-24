import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.31"
    kotlin("plugin.spring") version "1.5.31"
    id("uk.gov.justice.hmpps.gradle-spring-boot") version "3.3.11"
}

group = "org.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_16

configurations {
    testImplementation { exclude(group = "org.junit.vintage") }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
}

dependencyManagement {
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "16"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

//tasks {
//    test {
//        useJUnitPlatform()
//        testLogging.showExceptions = true
//        testLogging.showStackTraces = true
//        exclude("**/*IntTest*")
//
//        val failedTests = mutableListOf<TestDescriptor>()
//        val skippedTests = mutableListOf<TestDescriptor>()
//
//        // See https://github.com/gradle/kotlin-dsl/issues/836
//        addTestListener(object : TestListener {
//            override fun beforeSuite(suite: TestDescriptor) {}
//            override fun beforeTest(testDescriptor: TestDescriptor) {}
//            override fun afterTest(testDescriptor: TestDescriptor, result: TestResult) {
//                when (result.resultType) {
//                    TestResult.ResultType.FAILURE -> failedTests.add(testDescriptor)
//                    TestResult.ResultType.SKIPPED -> skippedTests.add(testDescriptor)
//                }
//            }
//
//            override fun afterSuite(suite: TestDescriptor, result: TestResult) {
//                if (suite.parent == null) { // root suite
//                    logger.lifecycle("----")
//                    logger.lifecycle("Test result: ${result.resultType}")
//                    logger.lifecycle(
//                        "Test summary: ${result.testCount} tests, " +
//                                "${result.successfulTestCount} succeeded, " +
//                                "${result.failedTestCount} failed, " +
//                                "${result.skippedTestCount} skipped"
//                    )
//                    if (failedTests.isNotEmpty()) {
//                        logger.lifecycle("\tFailed Tests:")
//                        failedTests.forEach {
//                            parent?.let { parent ->
//                                logger.lifecycle("\t\t${parent.name} - ${it.name}")
//                            } ?: logger.lifecycle("\t\t${it.name}")
//                        }
//                    }
//
//                    if (skippedTests.isNotEmpty()) {
//                        logger.lifecycle("\tSkipped Tests:")
//                        skippedTests.forEach {
//                            parent?.let { parent ->
//                                logger.lifecycle("\t\t${parent.name} - ${it.name}")
//                            } ?: logger.lifecycle("\t\t${it.name}")
//                        }
//                    }
//                }
//            }
//        })
//    }
//}
//
//task<Test>("integrationTest") {
//    description = "Runs the integration tests"
//    group = "verification"
//    testLogging.showExceptions = true
//    testLogging.showStackTraces = true
//    include("**/*IntTest*")
//}
