pipeline {
    agent any
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }
    stages {
        stage('Build') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'fffcb7a6-67ad-44fe-b49d-7ef2a07860ff', url: 'https://git.mezzp.com/izzp/hello.git']]])
                echo 'Hello World'
            }
        }
        stage('����jar') {
            steps {
                //����jar
                sh "mvn clean package"
                echo 'Hello World'
            }
        }
        stage('Test') {
            steps {
                //���룬�������ؾ���
                sh "docker build"
                echo '�������ؾ���'
            }
        }
        stage('Deploy') {
            steps {
                 //ɾ�����ؾ���
//                 sh "docker rmi -f ${imageName}"
//                 sh "docker rmi -f ${harbor_url}/${harbor_project_name}/${imageName}"
                echo 'Hello World'
            }
        }
    }
}
