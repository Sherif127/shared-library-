def call() {
    sh "trivy image ${env.DOCKER_IMAGE}:${env.IMAGE_TAG}"
}
