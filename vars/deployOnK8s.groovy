def call(String deploymentFile, String dockerImage, String imageTag) {
    echo "Updating deployment file: ${deploymentFile} with image: ${dockerImage}:${imageTag}"

    sh """
        sed -i 's|image:.*|image: ${dockerImage}:${imageTag}|' ${deploymentFile}
        echo 'Updated deployment file content:'
        cat ${deploymentFile}
    """

    echo "Deploying to Kubernetes..."
    sh "kubectl apply -f ${deploymentFile}"
}
