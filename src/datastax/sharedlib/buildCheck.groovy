package datastax.sharedlib

def runStDevCheck(startTime,endTime,baseline,tolerance,dseHost,grafanaHost) {
    def startTimeSeconds = startTime.div(1000).intValue()
    def endTimeSeconds = endTime.div(1000).intValue()
    steps{
        sh 'sudo chmod +x ./run-stdev-check.sh'
        sh "(./run-stdev-check.sh ${startTimeSeconds} ${endTimeSeconds} ${BUILD_ID} ${baseline} ${tolerance} ${dseHost} ${grafanaHost}) || true"
    }
    post{
        always{
            junit './*.xml'
        }
    }
}