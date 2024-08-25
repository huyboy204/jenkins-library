def call () {
    def slackMessage = "Pipeline result:\n"
        slackMessage += "Jenkins Job: ${env.JOB_NAME} - ${env.BUILD_NUMBER}\n"
        slackMessage += "Status: SUCCESS\n"
        slackMessage += "${BUILD_URL}"
    // Send the Slack message
    slackSend color: 'good', message: slackMessage
    mail to: "huyboy204@gmail.com",
    subject: "${JOB_NAME} - Build # ${BUILD_NUMBER} - SUCCESS!",
    body: "Check console output at ${BUILD_URL} to view the results."
}