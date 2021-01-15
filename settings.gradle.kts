import de.fayard.dependencies.bootstrapRefreshVersionsAndDependencies

rootProject.name = "project"

buildscript {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath("de.fayard:dependencies:0.+")
    }
}

bootstrapRefreshVersionsAndDependencies()

include("documentation")

include("kt-subproject")
include("jvm-subproject")
include("js-subproject")

