FROM openjdk:8
WORKDIR /usr/src/resshare-quiz
COPY target/resshare-quiz-0.0.1-SNAPSHOT.jar /usr/src/resshare-quiz
COPY application.properties /usr/src/resshare-quiz
COPY config.properties /usr/src/resshare-quiz
COPY offsensive.properties /usr/src/resshare-quiz
COPY service-account.json /usr/src/resshare-quiz
COPY uiconfig.properties /usr/src/resshare-quiz
COPY local_config.properties /usr/src/resshare-quiz
CMD ["java", "-cp", "/usr/src/resshare-quiz/resshare-quiz-0.0.1-SNAPSHOT.jar", "com.resshare.quiz.ResshareQuizApp"]

