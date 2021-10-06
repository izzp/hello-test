pipeline {
    agent any
    //Docker仓库的项目名称
    def project_name = "hello"
    //构建版本的名称
    def tag = "latest"
    stages {
        stage('拉取代码') {
            checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'fffcb7a6-67ad-44fe-b49d-7ef2a07860ff', url: 'https://git.mezzp.com/izzp/hello.git']]])
        }
        stage('编译，构建镜像') {
            steps {
                //定义镜像名称
                def imageName = "${project_name}:${tag}"
                //编译，构建本地镜像
                sh "mvn -f ${project_name} clean package dockerfile:build"
            }
            post {
                success {
                    //junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}
