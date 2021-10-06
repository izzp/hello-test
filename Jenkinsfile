pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'fffcb7a6-67ad-44fe-b49d-7ef2a07860ff', url: 'https://git.mezzp.com/izzp/hello.git']]])
                echo 'Hello World'
            }
        }
        stage('Test') {
            steps {
                //定义镜像名称
                def imageName = "${project_name}:${tag}"
                //编译，构建本地镜像
                sh "mvn -f ${project_name} clean package dockerfile:build"
                echo 'Hello World'
            }
        }
        stage('Deploy') {
            steps {
                 //删除本地镜像
                sh "docker rmi -f ${imageName}"
                sh "docker rmi -f ${harbor_url}/${harbor_project_name}/${imageName}"
                echo 'Hello World'
            }
        }
    }
}
