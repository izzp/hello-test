# 指定基于的基础镜像
FROM openjdk:11
# 维护者信息
MAINTAINER zhaozhipeng "i@mezzp.com"
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]