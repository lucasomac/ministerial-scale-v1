pipeline {
  agent {
    node {
      label 'Build'
    }

  }
  stages {
    stage('Build') {
      steps {
        withGradle() {
          sh './gradlew assemble'
        }

      }
    }

    stage('Test') {
      agent any
      steps {
        sh './gradlew test'
      }
    }

  }
}