@file:Suppress("SpellCheckingInspection")

plugins {
    java
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "dev.lone64.scorehub"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://repo.repsy.io/mvn/lone64/snapshots")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
}

dependencies {
    /*------| LIBs |------*/
    implementation("dev.lone64:jcore:2.0.8")
    implementation("org.spongepowered:configurate-yaml:4.1.2")
    /*------| LIBs |------*/

    /*------| APIs |------*/
    compileOnly("me.clip:placeholderapi:2.11.6")
    /*------| APIs |------*/

    /*------| OTHERs |------*/
    compileOnly("net.kyori:adventure-api:4.13.0")
    compileOnly("net.kyori:adventure-text-serializer-legacy:4.13.0")

    compileOnly("org.projectlombok:lombok:1.18.32")
    annotationProcessor("org.projectlombok:lombok:1.18.32")

    compileOnly("commons-io:commons-io:2.16.1")
    compileOnly("org.jetbrains:annotations:20.1.0")
    compileOnly("com.googlecode.json-simple:json-simple:1.1.1")
    /*------| OTHERs |------*/

    /*------| SPIGOTs |------*/
    compileOnly("org.spigotmc:spigot-api:1.20-R0.1-SNAPSHOT")
    /*------| SPIGOTs |------*/
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.shadowJar {
    archiveFileName.set("ScoreHub.jar")
}