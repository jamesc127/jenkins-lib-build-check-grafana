package datastax.sharedlib

def runStDevCheck(startTime,endTime,baseline,tolerance,dseHost,grafanaHost) {
    def startTimeSeconds = startTime.div(1000).intValue()
    def endTimeSeconds = endTime.div(1000).intValue()
    echo 'does this work?'
    sh 'sudo chmod +x ./run-stdev-check.sh'
    sh "(./run-stdev-check.sh ${startTimeSeconds} ${endTimeSeconds} ${BUILD_ID} ${baseline} ${tolerance} ${dseHost} ${grafanaHost}) || true"
}

def collectJUnit(){
    junit './*.xml'
}

return this