FROM openjdk:17

WORKDIR /app

COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

RUN chmod +x mvnw

# プロジェクトの依存関係を事前にダウンロードしておく
RUN ./mvnw dependency:go-offline

COPY src/ src/

RUN ./mvnw package -DskipTests

COPY entrypoint.sh entrypoint.sh
RUN chmod +x entrypoint.sh

EXPOSE 8080

ENTRYPOINT ["./entrypoint.sh"]