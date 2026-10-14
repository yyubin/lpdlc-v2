plugins {
    id("java")
    id("antlr")
    id("application")
}

group = "org.yyubin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    antlr("org.antlr:antlr4:4.13.1")
    implementation("org.antlr:antlr4-runtime:4.13.1")

    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("info.picocli:picocli:4.7.5")
    implementation("io.github.cdimascio:dotenv-java:3.0.0")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.generateGrammarSource {
    maxHeapSize = "64m"
    arguments = arguments + listOf("-visitor", "-long-messages", "-package", "org.yyubin.lpdl.parser")
    outputDirectory = file("src/main/java/org/yyubin/lpdl/parser")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("org.yyubin.lpdl.Main")
}

// NaturalLanguageCompiler 실행을 위한 별도 task
tasks.register<JavaExec>("nlcompile") {
    group = "application"
    description = "자연어를 LPDL을 거쳐 SQL로 변환합니다"
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("org.yyubin.lpdl.NaturalLanguageCompiler")

    // 커맨드라인 인자 전달
    if (project.hasProperty("args")) {
        args = (project.property("args") as String).split("\\s+".toRegex())
    }
}