def call() {
    sh "docker rmi ${env.DOCKER_IMAGE}:${env.IMAGE_TAG}"
}
