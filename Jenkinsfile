pipeline {
    agent any

    tools {
        jdk 'jdk-17'
        maven 'maven-3.8'
    }

    stages {
        stage('git-pull') {
            steps {
                git branch: 'main', credentialsId: 'gitlab', url: 'http://gitlab.dev.icefery.xyz/icefery/my-app-maven.git'
            }
        }
        stage('maven-package') {
            steps {
                sh 'rm -rf ${MAVEN_HOME}/conf/settings.xml'
                sh 'mvn clean package'
            }
        }
        stage('docker-build') {
            steps {
                sshPublisher(publishers: [sshPublisherDesc(configName: 'dev', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: 'nerdctl build --tag core.harbor.dev.icefery.xyz/icefery/my-app-maven:0.0.1 --platform linux/amd64,linux/arm64 .', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '${BUILD_ID}', remoteDirectorySDF: false, removePrefix: '', sourceFiles: 'Dockerfile,target/*.jar')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
            }
        }
    }
}
