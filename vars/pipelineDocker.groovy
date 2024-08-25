def call () {
    node {
        // Get current branch
        def branch = env.BRANCH_NAME
        currentBuild.result = 'SUCCESS'

        // Set variables target server
        varsDockerSV()

        env.VERSION = "${new Date().format('yyMMdd')}"
        // Set variables Nexus Server
        varsNexusJava()

        if (branch == 'release') {
            try {
                checkOutSCM()
                buildSpringboot()
                unitTestJava()
                qualityCheck()
                pushSnapshot()
                buildDockerNexus()
                pushDockerNexus()
                deployDocker()
                healthCheck()
                // tagSCM()
                notiSuccess()
            } catch (err) {
                notiFail(stageLog:"${err}")
                throw err
            }
        }

        if (branch.startsWith('uat')) {
            try {
                checkOutSCM()
                buildSpringboot()
                unitTestJava()
                qualityCheck()
                pushSnapshot()
                buildDockerNexus()
                pushDockerNexus()
                deployDocker()
                healthCheck()
                // tagSCM()
                notiSuccess()
            } catch (err) {
                notiFail(stageLog:"${err}")
                throw err
            }
        }

        if (branch.startsWith('develop') || branch.startsWith('MR-')) {
            try {
                checkOutSCM()
                buildSpringboot()
                unitTestJava()
                qualityCheck()
                // tagSCM()
                notiSuccess()
            } catch (err) {
                notiFail(stageLog:"${err}")
                throw err
            }
        }
    }
}
