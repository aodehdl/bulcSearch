# bulcSearch
책 검색 API 를 이용한 검색 서비스 

> * 검색, 검색 히스토리, 상세 페이지 

> * 기본포트는 8080 을 사용합니다. 

> * DB는 서버를 재시작하면 데이타가 초기화 됩니다. 

### 환경 
1. Java 8 버전을 사용
1. gradle
1. feign api 연동용
1. h2 DB용도
1. sha512.js  < 비밀번호 암호화 용도
1. jquery 1.12.4


### 설치

```
$ git clone https://github.com/aodehdl/bulcSearch.git
$ cd bulcSearch

```

### 실행(로컬)

```
$ gradle bootrun -Dfile.encoding=UTF-8
```