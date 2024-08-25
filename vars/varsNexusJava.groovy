def call () {
    def nexusDF = [
        'nexusUrl':'192.168.56.103:8081',
        'nexusUrlDocker':'192.168.56.103:8082',
        'nexusRepo':'java-repo',
        'nexusGroup':'Product',
        'nexusCred':'nexus-cred',
        'nexusPrjID':'Spring-Web'
    ]

    def nexusProps = [:]
    // require plugin Pipelin ultil
    nexusProps = readProperties(defaults: nexusDF, file: 'nexus.properties')

    env.NEXUS_URL = "${nexusProps['nexusUrl']}"
    env.NEXUS_URL_DOCKER = "${nexusProps['nexusUrlDocker']}"
    env.NEXUS_PRO_REPO = "${nexusProps['nexusRepo']}"
    env.NEXUS_GROUP = "${nexusProps['nexusGroup']}"
    env.NEXUS_CRED = "${nexusProps['nexusCred']}"
    env.NEXUS_ARTIFACT_ID = "${nexusProps['nexusPrjID']}"
}
