package datastax.sharedlib

@GrabResolver(name = 'com.datastax', root = 'https://maven.pkg.github.com/jamesc127/jenkins-dse-build-compare', m2Compatible = true)
@Grab(group = 'com.datastax', module = 'jenkins-dse-build-compare', version = '1.2')

import com.datastax.BuildCompare

def runStDevCheck(startTime,endTime,baseline,tolerance,dseHost,grafanaHost) {
    sh "(java -Dconfig.file=./BuildCheck.json -Djenkins.xmlfilepath=. -Dgrafana.start-time=${startTime} -Dgrafana.end-time=${endTime} -Djenkins.build=${BUILD_ID} -Djenkins.baseline=${baseline} -Djenkins.stdevtolerance=${tolerance} -Ddse.host=${dseHost} -Dgrafana.host=${grafanaHost} -jar ./stdevcheck) || true"
}

def collectJUnit(){
    junit './*.xml'
}

def runBuildCheck(startTime,endTime,baseline,tolerance,dseHost,grafanaHost){
    String buildNumber = BUILD_ID
    BuildCompare.runBuildCompare(startTime,endTime,baseline,tolerance,dseHost,grafanaHost,buildNumber)
}

return this