def call (Map config = [:]) {
    def slackMessage = "Pipeline result:\n"
        slackMessage += "Jenkins Job: ${env.JOB_NAME} - ${env.BUILD_NUMBER}\n"
        slackMessage += "Failed Log: ${config.stageLog}\n"
        slackMessage += "${BUILD_URL}"
    // Send the Slack message
    slackSend color: 'danger', message: slackMessage
    mail to: "huyboy204@gmail.com",
    subject: "${JOB_NAME} - Build # ${BUILD_NUMBER} - FAILURE!",
    body: "Failed Log: ${config.stageLog}. Check console output at ${BUILD_URL} to view the results."
}