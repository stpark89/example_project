![image](https://github.com/user-attachments/assets/8b6c4ff8-c772-4f61-ab47-6b69ec433aeb)

DB - 포스트그리 SQL

- docker-compose 실행
명령어 : docker-compose up -d


1.docker desktop 에 정상적으로 컨테이너가 기동 하는 걸 확인 
2.kotlin 실행 -> 에러없이 정상적으로 실행 되어야 함.

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.4.0)

2024-12-02T14:19:32.517+09:00  INFO 19809 --- [  restartedMain] com.example.demo.DemoApplicationKt       : Starting DemoApplicationKt using Java 17.0.11 with PID 19809 (/Users/ravi/work_space/study/kotlin-study-api/demo/build/classes/kotlin/main started by ravi in /Users/ravi/work_space/study/kotlin-study-api/demo)
2024-12-02T14:19:32.518+09:00  INFO 19809 --- [  restartedMain] com.example.demo.DemoApplicationKt       : No active profile set, falling back to 1 default profile: "default"
2024-12-02T14:19:32.543+09:00  INFO 19809 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
2024-12-02T14:19:32.543+09:00  INFO 19809 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'
2024-12-02T14:19:32.895+09:00  INFO 19809 --- [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data R2DBC repositories in DEFAULT mode.
2024-12-02T14:19:32.901+09:00  INFO 19809 --- [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 2 ms. Found 0 R2DBC repository interfaces.
2024-12-02T14:19:33.136+09:00  INFO 19809 --- [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data R2DBC repositories in DEFAULT mode.
2024-12-02T14:19:33.143+09:00  INFO 19809 --- [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 6 ms. Found 0 R2DBC repository interfaces.
2024-12-02T14:19:33.903+09:00  INFO 19809 --- [  restartedMain] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
2024-12-02T14:19:34.060+09:00  WARN 19809 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : Unable to start LiveReload server
2024-12-02T14:19:34.080+09:00  INFO 19809 --- [  restartedMain] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8080 (http)
2024-12-02T14:19:34.090+09:00  INFO 19809 --- [  restartedMain] com.example.demo.DemoApplicationKt       : Started DemoApplicationKt in 1.86 seconds (process running for 2.159)

port : 8080

3. 브라우저에 http://localhost:8080/api/test  입력

- 화면에 아래처럼 나오면 정상
  
{
  "isSuccess": true,
  "resultCodeValue": 0,
  "payload": "Hello",
  "error": null,
  "errorMessage": null
}


![image](https://github.com/user-attachments/assets/6b1f4418-4184-4d72-939f-394ee75daf90)


![image](https://github.com/user-attachments/assets/921bf6fe-0891-477b-820d-8295dad2eeb4)
