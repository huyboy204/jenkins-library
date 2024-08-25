def call() {
    def svDF = [
        'ipAddress':'192.168.56.103',
        'privateKey':'ssh-vm-docker'
    ]

    def svProps = [:]
    // require plugin Pipelin ultil
    svProps = readProperties(defaults: svDF, file: 'server.properties')

    env.URL_SERV_VM = "${svProps['ipAddress']}"
    env.PRIVKEY_SERV_VM = "${svProps['privateKey']}"
}