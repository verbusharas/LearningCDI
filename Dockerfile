FROM airhacks/glassfish
COPY ./target/LearningCDI.war ${DEPLOYMENT_DIR}
