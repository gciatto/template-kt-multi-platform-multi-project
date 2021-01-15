import io.github.gciatto.kt.mpp.ProjectExtensions.jvmProjects
import io.github.gciatto.kt.mpp.ProjectExtensions.jsProjects
import io.github.gciatto.kt.mpp.ProjectExtensions.ktProjects

plugins {
    id("io.github.gciatto.kt-mpp-pp")
    id("org.danilopianini.git-sensitive-semantic-versioning")
}

group = "it.unibo.tuprolog"

gitSemVer {
    minimumVersion.set("0.1.0")
    developmentIdentifier.set("dev")
    noTagIdentifier.set("archeo")
    developmentCounterLength.set(2) // How many digits after `dev`
    version = computeGitSemVer() // THIS IS MANDATORY, AND MUST BE LAST IN THIS BLOCK!
}

println("${rootProject.name} version: $version")

kotlinMultiplatform {
    preventPublishingOfRootProject.set(true)
    jvmOnlyProjects("jvm-subproject")
    jsOnlyProjects("js-subproject")
    otherProjects("documentation")
    ktProjects(allOtherSubprojects)
    developer("Giovanni Ciatto", "giovanni.ciatto@unibo.it", "http://about.me/gciatto")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            ktProjects.forEach {
                dependencies {
                    api(project(":${it.name}"))
                }
            }
        }
        val jvmMain by getting {
            jvmProjects.forEach {
                dependencies {
                    api(project(":${it.name}"))
                }
            }
        }
        val jsMain by getting {
            jsProjects.forEach {
                dependencies {
                    api(project(":${it.name}"))
                }
            }
        }
    }
}
