
DB - 포스트그리 SQL

- docker-compose 실행
명령어 : docker-compose up -d


1.docker desktop 에 정상적으로 컨테이너가 기동 하는 걸 확인 


![image](https://github.com/user-attachments/assets/921bf6fe-0891-477b-820d-8295dad2eeb4)



2.kotlin 실행 -> 에러없이 정상적으로 실행 되어야 함.
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

