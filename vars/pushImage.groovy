def call() {
    withCredentials([usernamePassword(credentialsId: 'docker', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh """
            docker login -u ${USER} -p ${PASS}
            docker push ${env.DOCKER_IMAGE}:${env.IMAGE_TAG}
        """
    }
}
