def call() {
    def svDF = [
        'ipAddress':'192.168.56.120',
        'privateKey':'sshagent-acc'
    ]

    def svProps = [:]
    // require plugin Pipelin ultil
    svProps = readProperties(defaults: svDF, file: 'serverJava.properties')

    env.URL_SERV_VM = "${svProps['ipAddress']}"
    env.PRIVKEY_SERV_VM = "${svProps['privateKey']}"
}