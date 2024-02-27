plugins {
    id("java")
    id("idea")
    id("fabric-loom") version "1.5-SNAPSHOT"
}

val modVersion: String by project
val mavenGroup: String by project

version = modVersion
group = mavenGroup

val archiveBaseName: String by project

base {
    archivesName = archiveBaseName
}

repositories {
    mavenCentral()
}

loom {
    splitEnvironmentSourceSets()

    mods {
        create("invclone") {
            sourceSet(sourceSets["main"])
            sourceSet(sourceSets["client"])
        }
    }
}

val minecraftVersion: String by project
val yarnMappingsVersion: String by project
val fabricLoaderVersion: String by project
val fabricVersion: String by project

dependencies {
     minecraft("com.mojang:minecraft:${minecraftVersion}")
     mappings("net.fabricmc:yarn:${yarnMappingsVersion}:v2")

     modImplementation("net.fabricmc:fabric-loader:${fabricLoaderVersion}")
     modImplementation("net.fabricmc.fabric-api:fabric-api:${fabricVersion}")
}

tasks.test {
    useJUnitPlatform()
}

tasks.processResources {
    inputs.properties("version" to project.version)
    filesMatching("fabric.mod.json") {
        expand("version" to project.version)
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.release = 17
}

java {
    withSourcesJar()

    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.jar {
    from("LICENSE") {
        rename { "${it}_${project.base.archivesName.get()}"}
    }
}