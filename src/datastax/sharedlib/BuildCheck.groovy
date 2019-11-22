package datastax.sharedlib

def runStDevCheck(startTime,endTime,baseline,tolerance,dseHost,grafanaHost) {
    echo 'does this work?'
    sh 'sudo chmod +x ./run-stdev-check.sh'
    sh "(./run-stdev-check.sh ${startTime} ${endTime} ${BUILD_ID} ${baseline} ${tolerance} ${dseHost} ${grafanaHost}) || true"
    echo 'does this still work?'
}

def collectJUnit(){
    junit './*.xml'
}

return this