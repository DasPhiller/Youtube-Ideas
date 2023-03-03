val javaVersion = 17 // Minecraft 1.18 requires Java 17
val extensionsVersion = "4.3"

plugins {
    kotlin("jvm") version "1.7.0"
    id("io.papermc.paperweight.userdev") version "1.4.0"
    id("xyz.jpenilla.run-paper") version "1.1.0"
    id("net.minecrell.plugin-yml.bukkit") version "0.5.2"
}

group = "de.dasphiller"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    // PaperMC Dependency
    paperDevBundle("1.19.2-R0.1-SNAPSHOT")

    // KSpigot dependency
    implementation("net.axay", "kspigot", "1.19.1")
    
    //Extensions dependency
    implementation("de.dasphiller.extensions:extensions:$extensionsVersion")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "$javaVersion"
        }
    }
    compileJava {
        options.encoding = "UTF-8"
        options.release.set(javaVersion)
    }
    assemble {
        dependsOn(reobfJar)
    }
}


bukkit {
    name = "Ideas"
    apiVersion = "1.19"
    authors = listOf(
        "xPhiller",
    )
    main = "$group.ideas.Main"
    version = getVersion().toString()
    libraries = listOf(
        "net.axay:kspigot:1.19.1",
        "de.dasphiller.extensions:extensions:$extensionsVersion"
    )
    prefix = "Ideas"
}
