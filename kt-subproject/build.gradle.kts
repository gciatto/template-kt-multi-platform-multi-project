import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import org.jlleitschuh.gradle.ktlint.KtlintCheckTask
import org.jlleitschuh.gradle.ktlint.KtlintFormatTask

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                // kt-mpp dependencies, e.g.
                api("io.github.gciatto:kt-math:_")
            }
        }
        val jvmMain by getting {
            dependencies {
                // jvm-only dependencies
            }
        }
        val jsMain by getting {
            dependencies {
                // js-dependencies
            }
        }
    }
}
