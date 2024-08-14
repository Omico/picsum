plugins {
    id("me.omico.consensus.root")
    id("picsum.gradm")
    id("picsum.root.git")
    id("picsum.root.spotless")
}

tasks.named<Wrapper>("wrapper") {
    gradleVersion = versions.gradle
    distributionType = Wrapper.DistributionType.BIN
}
