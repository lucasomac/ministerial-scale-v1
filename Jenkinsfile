pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh './gradlew assemble'
      }
    }

  }
  triggers {
    pollSCM('* * * * *')
  }
}